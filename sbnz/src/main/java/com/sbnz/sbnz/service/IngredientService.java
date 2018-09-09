package com.sbnz.sbnz.service;

import com.sbnz.sbnz.domain.Ingredient;
import com.sbnz.sbnz.domain.Symptom;
import com.sbnz.sbnz.repository.IngredientRepository;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    private final Logger log = LoggerFactory.getLogger(IngredientService.class);

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private KieService kieService;

    public Ingredient save(Ingredient ingredient) {
        log.debug("Request to save Ingredient : {}", ingredient);
        ingredient = ingredientRepository.save(ingredient);
        return ingredient;
    }

    @Transactional(readOnly = true)
    public List<Ingredient> findAll() {
        log.debug("Request to get all Diagnoses");
        return ingredientRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Ingredient> findOne(Long id) {
        log.debug("Request to get Ingredient : {}", id);
        return ingredientRepository.findById(id);
    }

    public void delete(Long id) {
        log.debug("Request to delete Ingredient : {}", id);
        ingredientRepository.deleteById(id);
    }

    public void removeFromSession(Long id) {
        for (String token: kieService.kieSessions.keySet()) {
            KieSession kieSession =  kieService.kieSessions.get(token);
            Symptom s;

            QueryResults results = kieSession.getQueryResults("Get Ingredient", id);
            for (QueryResultsRow r: results) {
                s = (Symptom)r.get("$i");
                kieSession.delete(kieSession.getFactHandle(s));
            }
        }
    }

}
