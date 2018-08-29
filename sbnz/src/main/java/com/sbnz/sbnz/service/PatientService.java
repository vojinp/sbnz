package com.sbnz.sbnz.service;

import com.sbnz.sbnz.domain.Patient;
import com.sbnz.sbnz.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final Logger log = LoggerFactory.getLogger(PatientService.class);

    @Autowired
    private PatientRepository patientRepository;

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

}
