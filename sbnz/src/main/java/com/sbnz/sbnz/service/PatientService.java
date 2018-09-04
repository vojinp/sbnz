package com.sbnz.sbnz.service;

import com.sbnz.sbnz.domain.Patient;
import com.sbnz.sbnz.repository.PatientRepository;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final Logger log = LoggerFactory.getLogger(PatientService.class);

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private KieService kieService;

    public Patient save(Patient patient) {
        log.debug("Request to save Patient : {}", patient);
        patient = patientRepository.save(patient);
        return patient;
    }

    @Transactional(readOnly = true)
    public List<Patient> findAll() {
        log.debug("Request to get all Diagnoses");
        return patientRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Patient> findOne(Long id) {
        log.debug("Request to get Patient : {}", id);
        return patientRepository.findById(id);
    }

    public void delete(Long id) {
        log.debug("Request to delete Patient : {}", id);
        patientRepository.deleteById(id);
    }

    public HashSet<Patient> getChronicReport(String token) {
        KieSession kieSession = kieService.kieSessions.get(token);
        if (kieSession == null) return new HashSet<>();
        addPatients(kieSession);

        HashSet<Patient> patients = new HashSet<>();
        QueryResults results = kieSession.getQueryResults("Hronicna oboljenja");
        for (QueryResultsRow r: results) {
            Patient patient = (Patient)r.get("$p");
            patients.add(patient);
        }

        removePatients(kieSession);

        return patients;
    }

    public HashSet<Patient> getAddictReport(String token) {
        KieSession kieSession = kieService.kieSessions.get(token);
        if (kieSession == null) return new HashSet<>();
        addPatients(kieSession);

        HashSet<Patient> patients = new HashSet<>();
        QueryResults results = kieSession.getQueryResults("Zavisnost");
        for (QueryResultsRow r: results) {
            Patient patient = (Patient)r.get("$p");
            patients.add(patient);
        }

        removePatients(kieSession);

        return patients;
    }

    public HashSet<Patient> getImmuneReport(String token) {
        KieSession kieSession = kieService.kieSessions.get(token);
        if (kieSession == null) return new HashSet<>();
        addPatients(kieSession);

        HashSet<Patient> patients = new HashSet<>();
        QueryResults results = kieSession.getQueryResults("Oslabljen imunitet");
        for (QueryResultsRow r: results) {
            Patient patient = (Patient)r.get("$p");
            patients.add(patient);
        }

        removePatients(kieSession);

        return patients;
    }


    private void addPatients(KieSession kieSession) {
        log.info("Adding PATIENTS to kie session");
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(kieSession::insert);
    }

    private void removePatients(KieSession kieSession) {
        log.info("Removing PATIENTS from kie session");
        QueryResults queryResults = kieSession.getQueryResults("Get all patients");
        for (QueryResultsRow queryResult: queryResults) {
            Patient p = (Patient) queryResult.get("$p");
            kieSession.delete(kieSession.getFactHandle(p));
        }
    }



}
