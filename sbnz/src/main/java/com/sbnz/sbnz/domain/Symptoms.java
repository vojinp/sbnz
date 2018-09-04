package com.sbnz.sbnz.domain;

import com.sbnz.sbnz.service.dto.DiseaseProbabilityDTO;

import java.util.ArrayList;
import java.util.List;

public class Symptoms {
    List<Symptom> symptoms = new ArrayList<>();

    Patient patient;

    List<DiseaseProbabilityDTO> diseases = new ArrayList<>();

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public List<DiseaseProbabilityDTO> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<DiseaseProbabilityDTO> diseases) {
        this.diseases = diseases;
    }
}
