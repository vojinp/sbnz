package com.sbnz.sbnz.service;

import com.sbnz.sbnz.domain.Medication;
import com.sbnz.sbnz.repository.MedicationRepository;
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

}
