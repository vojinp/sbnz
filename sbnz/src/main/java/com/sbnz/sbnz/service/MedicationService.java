package com.sbnz.sbnz.service;

import com.sbnz.sbnz.domain.Medication;
import com.sbnz.sbnz.domain.Symptom;
import com.sbnz.sbnz.repository.MedicationRepository;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicationService {
    private final Logger log = LoggerFactory.getLogger(MedicationService.class);

    @Autowired
    private MedicationRepository medicationRepository;

    @Autowired
    private KieService kieService;

    public Medication save(Medication medication) {
        log.debug("Request to save Medication : {}", medication);
        medication = medicationRepository.save(medication);
        return medication;
    }

    @Transactional(readOnly = true)
    public List<Medication> findAll() {
        log.debug("Request to get all Diagnoses");
        return medicationRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Medication> findOne(Long id) {
        log.debug("Request to get Medication : {}", id);
        return medicationRepository.findById(id);
    }

    public void delete(Long id) {
        log.debug("Request to delete Medication : {}", id);
        medicationRepository.deleteById(id);
    }

    public void removeFromSession(Long id) {
        for (String token: kieService.kieSessions.keySet()) {
            KieSession kieSession =  kieService.kieSessions.get(token);
            Symptom s;

            QueryResults results = kieSession.getQueryResults("Get Medication", id);
            for (QueryResultsRow r: results) {
                s = (Symptom)r.get("$m");
                kieSession.delete(kieSession.getFactHandle(s));
            }
        }
    }

}
