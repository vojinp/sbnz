package com.sbnz.sbnz.domain;

import java.util.ArrayList;
import java.util.List;

public class Symptoms {
    List<Symptom> symptoms = new ArrayList<>();

    Patient patient;

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
}
