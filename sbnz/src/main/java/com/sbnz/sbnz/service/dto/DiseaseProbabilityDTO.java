package com.sbnz.sbnz.service.dto;

import com.sbnz.sbnz.domain.Disease;

public class DiseaseProbabilityDTO {
    private Disease disease;
    private int probability;

    public DiseaseProbabilityDTO() {
    }

    public DiseaseProbabilityDTO(Disease disease, int probability) {
        this.disease = disease;
        this.probability = probability;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }
}
