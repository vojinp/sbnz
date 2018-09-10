package com.sbnz.sbnz.service;

import com.sbnz.sbnz.domain.Diagnosis;
import com.sbnz.sbnz.domain.Ingredient;
import com.sbnz.sbnz.domain.Medication;
import com.sbnz.sbnz.repository.*;
import com.sbnz.sbnz.service.dto.DiagnosisCreateDTO;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class DiagnosisService {
    private final Logger log = LoggerFactory.getLogger(DiagnosisService.class);

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private KieService kieService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicationRepository medicationRepository;

    public Diagnosis save(DiagnosisCreateDTO diagnosisCreateDTO) {
        log.debug("Request to save Diagnosis : {}", diagnosisCreateDTO);
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setDate(new Date());
        diagnosis.setDoctor(userRepository.findByUsername(diagnosisCreateDTO.getDoctorsUsername()));
        diagnosis.setDisease(diseaseRepository.findByName(diagnosisCreateDTO.getDiseaseName()));
        diagnosis.setMedications(new HashSet<>());
        for (Medication m : diagnosisCreateDTO.getMedications())
            diagnosis.getMedications().add(medicationRepository.getOne(m.getId()));
        diagnosis.setPatient(patientRepository.getOne(diagnosisCreateDTO.getPatient().getId()));
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

    public Diagnosis update(Diagnosis diagnosis) {
        log.debug("Request to update Diagnosis : {}", diagnosis);
        diagnosis = diagnosisRepository.save(diagnosis);
        return diagnosis;
    }

    public List<Ingredient> validatePrescription(Diagnosis d, String token) {
        KieSession kieSession = kieService.kieSessions.get(token);
        if (kieSession == null) return new ArrayList<>();
        Diagnosis diagnosis = diagnosisRepository.getOne(d.getId());
        kieSession.insert(diagnosis);

        QueryResults results = kieSession.getQueryResults("Diagnosis validator", diagnosis.getId());
        List<Ingredient> ingredients = new ArrayList<>();
        for (QueryResultsRow r : results) {
            ingredients = (ArrayList<Ingredient>) r.get("$criticalIngredients");
        }
//        System.out.println( diagnosis.getMedications().iterator().next().getIngredients().iterator().next());
//        System.out.println(diagnosis.getPatient().getIngredients().iterator().next());
        System.out.println(ingredients);
        kieSession.delete(kieSession.getFactHandle(diagnosis));
        return ingredients;
    }
}
