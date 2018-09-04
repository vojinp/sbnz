package com.sbnz.sbnz.service.dto;

import com.sbnz.sbnz.domain.Disease;

public class DiseaseCountDTO  implements Comparable<DiseaseCountDTO>  {
    private Disease disease;
    private Integer count;

    public DiseaseCountDTO(Disease disease, Integer count) {
        this.disease = disease;
        this.count = count;
    }

    public DiseaseCountDTO() {
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public int compareTo(DiseaseCountDTO o) {
        return o.count - count;
    }
}
