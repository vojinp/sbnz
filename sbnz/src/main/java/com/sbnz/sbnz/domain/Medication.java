package com.sbnz.sbnz.domain;

import com.sbnz.sbnz.domain.enumeration.MedType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "medication")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "type", nullable = false)
    private MedType type;

    @ManyToMany
    @JoinTable(
            name = "medication_ingredient",
            joinColumns = {@JoinColumn(name = "medication_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_id", referencedColumnName = "id")})
    private Set<Ingredient> ingredients = new HashSet<>();


    @ManyToMany(mappedBy = "medications")
    private Set<Diagnosis> diagnoses = new HashSet<>();

    public Set<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public MedType getType() {
        return type;
    }

    public void setType(MedType type) {
        this.type = type;
    }

    public void setDiagnoses(Set<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
