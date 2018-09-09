package com.sbnz.sbnz.web.rest;

import com.sbnz.sbnz.domain.Symptom;
import com.sbnz.sbnz.service.KieService;
import com.sbnz.sbnz.service.SymptomService;
import org.kie.api.runtime.KieContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import static org.hibernate.id.IdentifierGenerator.ENTITY_NAME;


@RestController
@RequestMapping("/api/symptom")
public class SymptomController {
    private final Logger log = LoggerFactory.getLogger(SymptomController.class);

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private SymptomService symptomService;

    @Autowired
    private KieService kieService;
    @PostMapping()
    public ResponseEntity<Symptom> createSymptom(@RequestBody Symptom symptom) throws URISyntaxException {
        log.debug("REST request to save Symptom : {}", symptom);
        if (symptom.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        Symptom result = symptomService.save(symptom);

        for (String token: kieService.kieSessions.keySet()) {
            kieService.kieSessions.get(token).insert(result);
        }

        return ResponseEntity.created(new URI("/api/symptom/" + result.getId())).body(result);
    }

    @PutMapping()
    public ResponseEntity<Symptom> updateSymptom(@RequestBody Symptom symptom) throws URISyntaxException {
        log.debug("REST request to save Symptom : {}", symptom);
        if (symptom.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        Symptom result = symptomService.save(symptom);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping()
    public List<Symptom> getAllSymptoms() {
        log.debug("REST request to get all Symptoms");
        return symptomService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Symptom> getSymptom(@PathVariable Long id) {
        log.debug("REST request to get Symptom : {}", id);
        Optional<Symptom> symptom = symptomService.findOne(id);
        return ResponseEntity.ok().body(symptom.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSymptom(@PathVariable Long id) {
        log.debug("REST request to delete Symptom : {}", id);
        symptomService.delete(id);
        symptomService.removeFromSession(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/for-disease/{disease-name}")
    public List<Symptom> findSymptomsForDisease(@RequestHeader("Authorization") String token,
                                                @PathVariable("disease-name") String diseaseName) {
        log.debug("REST request to find symptoms for medical condition");
        return symptomService.findSymptomsForDisease(diseaseName, token);
    }
}
