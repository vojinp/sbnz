package com.sbnz.sbnz.web.rest;

import com.sbnz.sbnz.domain.Patient;
import com.sbnz.sbnz.service.PatientService;
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
@RequestMapping("/api/patient")
public class PatientController {
    private final Logger log = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private PatientService patientService;

    @PostMapping()
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) throws URISyntaxException {
        log.debug("REST request to save Patient : {}", patient);
        if (patient.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        Patient result = patientService.save(patient);
        return ResponseEntity.created(new URI("/api/patient/" + result.getId())).body(result);
    }

    @PutMapping()
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) throws URISyntaxException {
        log.debug("REST request to save Patient : {}", patient);
        if (patient.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        Patient result = patientService.save(patient);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping()
    public List<Patient> getAllPatients() {
        log.debug("REST request to get all Patients");
        return patientService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long id) {
        log.debug("REST request to get Patient : {}", id);
        Optional<Patient> patient = patientService.findOne(id);
        return ResponseEntity.ok().body(patient.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        log.debug("REST request to delete Patient : {}", id);
        patientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
