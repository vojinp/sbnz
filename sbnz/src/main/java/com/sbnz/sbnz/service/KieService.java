package com.sbnz.sbnz.service;

import com.sbnz.sbnz.domain.Disease;
import com.sbnz.sbnz.domain.Ingredient;
import com.sbnz.sbnz.domain.Medication;
import com.sbnz.sbnz.domain.Symptom;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class KieService {
    public  KieServices ks = KieServices.Factory.get();
    public  KieContainer kieContainer = ks.getKieClasspathContainer();

    public HashMap<String, KieSession> kieSessions = new HashMap<>();

    @Autowired
    DiseaseService diseaseService;

    @Autowired
    SymptomService symptomService;

    @Autowired
    MedicationService medicationService;

    @Autowired
    IngredientService ingredientService;


    public void fillKieSession(KieSession kieSession) {
        List<Disease> diseases = diseaseService.findAll();
        diseases.forEach(kieSession::insert);

        List<Symptom> symptoms = symptomService.findAll();
        symptoms.forEach(kieSession::insert);

        List<Medication> medication = medicationService.findAll();
        medication.forEach(kieSession::insert);

        List<Ingredient> ingredients = ingredientService.findAll();
        ingredients.forEach(kieSession::insert);
    }

}
