package com.sbnz.sbnz.service;

import com.sbnz.sbnz.domain.Symptom;
import com.sbnz.sbnz.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SymptomService {
    private final Logger log = LoggerFactory.getLogger(SymptomService.class);

    @Autowired
    private SymptomRepository symptomRepository;

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

}
