package com.sbnz.sbnz.service;

import com.sbnz.sbnz.domain.Diagnosis;
import com.sbnz.sbnz.repository.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DiagnosisService {
    private final Logger log = LoggerFactory.getLogger(DiagnosisService.class);

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    public Diagnosis save(Diagnosis diagnosis) {
        log.debug("Request to save Diagnosis : {}", diagnosis);
        diagnosis = diagnosisRepository.save(diagnosis);
        return diagnosis;
    }

    @Transactional(readOnly = true)
    public List<Diagnosis> findAll() {
        log.debug("Request to get all Diagnoses");
        return diagnosisRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Diagnosis> findOne(Long id) {
        log.debug("Request to get Diagnosis : {}", id);
        return diagnosisRepository.findById(id);
    }

    public void delete(Long id) {
        log.debug("Request to delete Diagnosis : {}", id);
        diagnosisRepository.deleteById(id);
    }

}
