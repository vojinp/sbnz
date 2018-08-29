package com.sbnz.sbnz.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sbnz.sbnz.domain.enumeration.Group;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "disease")
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "disease", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Diagnosis> diagnoses = new HashSet<>();

    public Set<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    @Column(name = "d_group")
    private Group group;

    @ManyToMany
    @JoinTable(
            name = "disease_symptom",
            joinColumns = {@JoinColumn(name = "disease_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "symptom_id", referencedColumnName = "id")})
    private Set<Symptom> symptoms = new HashSet<>();

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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
/*
    public Set<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Set<Symptom> symptoms) {
        this.symptoms = symptoms;
    }
    */
}
