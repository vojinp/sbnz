package com.sbnz.sbnz.service;

import com.sbnz.sbnz.domain.Symptom;
import com.sbnz.sbnz.repository.SymptomRepository;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SymptomService {
    private final Logger log = LoggerFactory.getLogger(SymptomService.class);

    @Autowired
    private SymptomRepository symptomRepository;

    @Autowired
    private KieService kieService;

    public Symptom save(Symptom symptom) {
        log.debug("Request to save Symptom : {}", symptom);
        symptom = symptomRepository.save(symptom);
        return symptom;
    }

    @Transactional(readOnly = true)
    public List<Symptom> findAll() {
        log.debug("Request to get all Diagnoses");
        return symptomRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Symptom> findOne(Long id) {
        log.debug("Request to get Symptom : {}", id);
        return symptomRepository.findById(id);
    }

    public void delete(Long id) {
        log.debug("Request to delete Symptom : {}", id);
        symptomRepository.deleteById(id);
    }

    public List<Symptom> findSymptomsForDisease(String diseaseName, String token) {
        KieSession kieSession = kieService.kieSessions.get(token);
        if (kieSession == null) return new ArrayList<>();

        QueryResults results = kieSession.getQueryResults("Symptoms for disease", diseaseName);
        List<Symptom> symptoms = new ArrayList<>();
        for (QueryResultsRow r: results) {
            symptoms = (ArrayList<Symptom>)r.get("$allSymptoms");
        }

        return symptoms;
    }

    public void removeFromSession(Long id) {
        for (String token: kieService.kieSessions.keySet()) {
            KieSession kieSession =  kieService.kieSessions.get(token);
            Symptom s;

            QueryResults results = kieSession.getQueryResults("Get Symptom", id);
            for (QueryResultsRow r: results) {
                s = (Symptom)r.get("$s");
                kieSession.delete(kieSession.getFactHandle(s));
            }
        }
    }
}
