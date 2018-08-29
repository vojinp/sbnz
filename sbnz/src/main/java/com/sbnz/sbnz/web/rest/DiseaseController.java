package com.sbnz.sbnz.web.rest;

import com.sbnz.sbnz.domain.Disease;
import com.sbnz.sbnz.service.DiseaseService;
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
@RequestMapping("/api/disease")
public class DiseaseController {
    private final Logger log = LoggerFactory.getLogger(DiseaseController.class);

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private DiseaseService diseaseService;

    @PostMapping()
    public ResponseEntity<Disease> createDisease(@RequestBody Disease disease) throws URISyntaxException {
        log.debug("REST request to save Disease : {}", disease);
        if (disease.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        Disease result = diseaseService.save(disease);
        return ResponseEntity.created(new URI("/api/disease/" + result.getId())).body(result);
    }

    @PutMapping()
    public ResponseEntity<Disease> updateDisease(@RequestBody Disease disease) throws URISyntaxException {
        log.debug("REST request to save Disease : {}", disease);
        if (disease.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        Disease result = diseaseService.save(disease);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping()
    public List<Disease> getAllDiseases() {
        log.debug("REST request to get all Diseases");
        return diseaseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disease> getDisease(@PathVariable Long id) {
        log.debug("REST request to get Disease : {}", id);
        Optional<Disease> disease = diseaseService.findOne(id);
        return ResponseEntity.ok().body(disease.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisease(@PathVariable Long id) {
        log.debug("REST request to delete Disease : {}", id);
        diseaseService.delete(id);
        return ResponseEntity.ok().build();
    }
}
