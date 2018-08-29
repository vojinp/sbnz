package com.sbnz.sbnz.service;

import com.sbnz.sbnz.domain.Disease;
import com.sbnz.sbnz.repository.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DiseaseService {
    private final Logger log = LoggerFactory.getLogger(DiseaseService.class);

    @Autowired
    private DiseaseRepository diseaseRepository;

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

}
