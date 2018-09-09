package com.sbnz.sbnz.web.rest;

import com.sbnz.sbnz.domain.*;
import com.sbnz.sbnz.repository.MedicationRepository;
import com.sbnz.sbnz.repository.PatientRepository;
import com.sbnz.sbnz.repository.UserRepository;
import com.sbnz.sbnz.service.DiagnosisService;
import com.sbnz.sbnz.service.DiseaseService;
import com.sbnz.sbnz.service.dto.DiseaseProbabilityDTO;
import org.joda.time.DateTime;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api/symptoms")
public class SymptomsController {
    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private DiagnosisService diagnosisService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    MedicationRepository medicationRepository;
    @GetMapping()
    public void getAllSymptoms(@RequestHeader("Authorization") String token) {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setPatient(patientRepository.getOne(0L));
        diagnosis.setMedications(new HashSet<>());
        diagnosis.getMedications().add(medicationRepository.getOne(0L));
        List<Ingredient> ingredients = diagnosisService.validatePrescription(diagnosis, token);
        System.out.println(ingredients.size());

    }


}
