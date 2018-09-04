package com.sbnz.sbnz.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "symptom")
public class Symptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "specific")
    private boolean specific;

    @ManyToMany
    @JsonIgnore
    private Set<Disease> diseases = new HashSet<>();

    public Symptom(@NotNull String name) {
        this.name = name;
        specific = false;
    }

    public Symptom() {
        specific = false;
    }

    public boolean isSpecific() {
        return specific;
    }

    public void setSpecific(boolean specific) {
        this.specific = specific;
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

    public Set<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(Set<Disease> diseases) {
        this.diseases = diseases;
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((Symptom) obj).getName());
    }
}
