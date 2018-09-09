package com.sbnz.sbnz.service.dto;

import com.sbnz.sbnz.domain.Disease;
import com.sbnz.sbnz.domain.Medication;
import com.sbnz.sbnz.domain.Patient;
import com.sbnz.sbnz.domain.User;

import java.util.*;

public class DiagnosisCreateDTO {
    private String diseaseName;
    private String doctorsUsername;
    private Patient patient;
    private List<Medication> medications = new ArrayList<>();

    public DiagnosisCreateDTO() {
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDoctorsUsername() {
        return doctorsUsername;
    }

    public void setDoctorsUsername(String doctorsUsername) {
        this.doctorsUsername = doctorsUsername;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }
}
