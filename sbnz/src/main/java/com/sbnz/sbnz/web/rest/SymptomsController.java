package com.sbnz.sbnz.web.rest;

import com.sbnz.sbnz.domain.Diagnosis;
import com.sbnz.sbnz.domain.Disease;
import com.sbnz.sbnz.domain.Symptom;
import com.sbnz.sbnz.domain.Symptoms;
import org.joda.time.DateTime;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/symptoms")
public class SymptomsController {
    @Autowired
    private KieContainer kieContainer;


    @GetMapping()
    public void getAllSymptoms() {

        Symptoms s = new Symptoms();
        Symptom s1 = new Symptom();
        s1.setId(0L);
        s1.setName("Kasalj");
        Symptom s2 = new Symptom();
        s2.setId(1L);
        s2.setName("Zamor");
        Symptom s3 = new Symptom();
        s3.setId(2L);
        s3.setName("Gusenje");
        s.getSymptoms().add(s1);
        s.getSymptoms().add(s2);
        s.getSymptoms().add(s3);

        KieSession kieSession = kieContainer.newKieSession();
        FactHandle factHandle = kieSession.insert(s);

        kieSession.getAgenda().getAgendaGroup("Diseases").setFocus();

        int handler = kieSession.fireAllRules();
        System.out.println(String.format("Rules fired: %s", handler));

        kieSession.delete(factHandle);


    }
}
