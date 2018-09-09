package com.sbnz.sbnz.service;

import com.sbnz.sbnz.domain.Disease;
import com.sbnz.sbnz.domain.Symptom;
import com.sbnz.sbnz.domain.Symptoms;
import com.sbnz.sbnz.repository.DiseaseRepository;
import com.sbnz.sbnz.service.dto.DiseaseCountDTO;
import com.sbnz.sbnz.service.dto.DiseaseProbabilityDTO;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class DiseaseService {
    private final Logger log = LoggerFactory.getLogger(DiseaseService.class);

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private KieService kieService;

    public Disease save(Disease disease) {
        log.debug("Request to save Disease : {}", disease);
        disease = diseaseRepository.save(disease);
        return disease;
    }

    @Transactional(readOnly = true)
    public List<Disease> findAll() {
        log.debug("Request to get all Diagnoses");
        return diseaseRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Disease> findOne(Long id) {
        log.debug("Request to get Disease : {}", id);
        return diseaseRepository.findById(id);
    }

    public void delete(Long id) {
        log.debug("Request to delete Disease : {}", id);
        diseaseRepository.deleteById(id);
    }

    public List<DiseaseCountDTO> findDiseasesForSymptoms(Symptoms symptoms, String token) {
        KieSession kieSession = kieService.kieSessions.get(token);
        if (kieSession == null) return new ArrayList<>();

        QueryResults results = kieSession.getQueryResults("Diseases for symptoms", symptoms);
        List<DiseaseCountDTO> result = new ArrayList<>();
        for (QueryResultsRow r: results) {
            result.add(new DiseaseCountDTO((Disease)r.get("$d"), (Integer)r.get("$count")));
        }
        Collections.sort(result);
        return result;

    }

    public List<DiseaseProbabilityDTO> findDiseasesWithProbabaility(Symptoms symptoms, String token) {
        KieSession kieSession = kieService.kieSessions.get(token);

        if (kieSession == null) return new ArrayList<>();

        kieSession.setGlobal("diseaseService", this);
        FactHandle factHandle = kieSession.insert(symptoms);

        kieSession.getAgenda().getAgendaGroup("Diseases").setFocus();

        int handler = kieSession.fireAllRules();
        System.out.println(String.format("Rules fired: %s", handler));

        kieSession.delete(factHandle);
        return symptoms.getDiseases();
    }

    public void setProbability(Symptoms symptoms, String diseaseName, int probability) {
        Disease disease = diseaseRepository.findByName(diseaseName);
        symptoms.getDiseases().add(new DiseaseProbabilityDTO(disease, probability));
    }

    public void removeFromSession(Long id) {
        for (String token: kieService.kieSessions.keySet()) {
            KieSession kieSession =  kieService.kieSessions.get(token);
            Symptom s;

            QueryResults results = kieSession.getQueryResults("Get Disease", id);
            for (QueryResultsRow r: results) {
                s = (Symptom)r.get("$d");
                kieSession.delete(kieSession.getFactHandle(s));
            }
        }
    }
}
