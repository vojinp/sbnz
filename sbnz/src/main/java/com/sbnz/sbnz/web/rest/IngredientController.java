package com.sbnz.sbnz.web.rest;

import com.sbnz.sbnz.domain.Ingredient;
import com.sbnz.sbnz.service.IngredientService;
import com.sbnz.sbnz.service.KieService;
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
@RequestMapping("/api/ingredient")
public class IngredientController {
    private final Logger log = LoggerFactory.getLogger(IngredientController.class);

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private KieService kieService;

    @PostMapping()
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) throws URISyntaxException {
        log.debug("REST request to save Ingredient : {}", ingredient);
        if (ingredient.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        Ingredient result = ingredientService.save(ingredient);

        for (String token: kieService.kieSessions.keySet()) {
            kieService.kieSessions.get(token).insert(result);
        }

        return ResponseEntity.created(new URI("/api/ingredient/" + result.getId())).body(result);
    }

    @PutMapping()
    public ResponseEntity<Ingredient> updateIngredient(@RequestBody Ingredient ingredient) throws URISyntaxException {
        log.debug("REST request to save Ingredient : {}", ingredient);
        if (ingredient.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        Ingredient result = ingredientService.save(ingredient);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping()
    public List<Ingredient> getAllIngredients() {
        log.debug("REST request to get all Ingredients");
        return ingredientService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable Long id) {
        log.debug("REST request to get Ingredient : {}", id);
        Optional<Ingredient> ingredient = ingredientService.findOne(id);
        return ResponseEntity.ok().body(ingredient.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id) {
        log.debug("REST request to delete Ingredient : {}", id);
        ingredientService.delete(id);
        ingredientService.removeFromSession(id);
        return ResponseEntity.ok().build();
    }
}
