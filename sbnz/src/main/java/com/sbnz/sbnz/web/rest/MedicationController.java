package com.sbnz.sbnz.web.rest;

import com.sbnz.sbnz.domain.Medication;
import com.sbnz.sbnz.service.MedicationService;
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
@RequestMapping("/api/medication")
public class MedicationController {
    private final Logger log = LoggerFactory.getLogger(MedicationController.class);

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private MedicationService medicationService;

    @PostMapping()
    public ResponseEntity<Medication> createMedication(@RequestBody Medication medication) throws URISyntaxException {
        log.debug("REST request to save Medication : {}", medication);
        if (medication.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        Medication result = medicationService.save(medication);
        return ResponseEntity.created(new URI("/api/medication/" + result.getId())).body(result);
    }

    @PutMapping()
    public ResponseEntity<Medication> updateMedication(@RequestBody Medication medication) throws URISyntaxException {
        log.debug("REST request to save Medication : {}", medication);
        if (medication.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        Medication result = medicationService.save(medication);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping()
    public List<Medication> getAllMedications() {
        log.debug("REST request to get all Medications");
        return medicationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedication(@PathVariable Long id) {
        log.debug("REST request to get Medication : {}", id);
        Optional<Medication> medication = medicationService.findOne(id);
        return ResponseEntity.ok().body(medication.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedication(@PathVariable Long id) {
        log.debug("REST request to delete Medication : {}", id);
        medicationService.delete(id);
        return ResponseEntity.ok().build();
    }
}
