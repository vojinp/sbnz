package com.sbnz.sbnz.web.rest;

import com.sbnz.sbnz.domain.Diagnosis;
import com.sbnz.sbnz.service.DiagnosisService;
import com.sbnz.sbnz.service.KieService;
import com.sbnz.sbnz.service.dto.DiagnosisCreateDTO;
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
@RequestMapping("/api/diagnosis")
public class DiagnosisController {
    private final Logger log = LoggerFactory.getLogger(DiagnosisController.class);

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private DiagnosisService diagnosisService;

    @Autowired
    private KieService kieService;

    @PostMapping()
    public ResponseEntity<Diagnosis> createDiagnosis(@RequestHeader("Authorization") String token,
                                                     @RequestBody DiagnosisCreateDTO diagnosis) throws URISyntaxException {
        log.debug("REST request to save Diagnosis : {}", diagnosis);
        Diagnosis result = diagnosisService.save(diagnosis);
        if (diagnosisService.validatePrescription(result, token).size() > 0) {
            diagnosisService.delete(result.getId());
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.created(new URI("/api/diagnosis/" + result.getId())).body(result);
    }

    @PutMapping()
    public ResponseEntity<Diagnosis> updateDiagnosis(@RequestBody Diagnosis diagnosis) throws URISyntaxException {
        log.debug("REST request to save Diagnosis : {}", diagnosis);
        if (diagnosis.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        Diagnosis result = diagnosisService.update(diagnosis);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping()
    public List<Diagnosis> getAllDiagnoses() {
        log.debug("REST request to get all Diagnoses");
        return diagnosisService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diagnosis> getDiagnosis(@PathVariable Long id) {
        log.debug("REST request to get Diagnosis : {}", id);
        Optional<Diagnosis> diagnosis = diagnosisService.findOne(id);
        return ResponseEntity.ok().body(diagnosis.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiagnosis(@PathVariable Long id) {
        log.debug("REST request to delete Diagnosis : {}", id);
        diagnosisService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/simulation")
    public void simulation() {
        kieService.startMonitoringSimulation();
    }
}
