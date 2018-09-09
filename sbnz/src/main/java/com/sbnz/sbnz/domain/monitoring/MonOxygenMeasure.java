package com.sbnz.sbnz.domain.monitoring;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import java.io.Serializable;

@Role(Role.Type.EVENT)
@Expires("16m")
public class MonOxygenMeasure implements Serializable {

    private static int generator = 0;

    private int id;
    public int patientId;
    private int level;

    public MonOxygenMeasure() {}

    public MonOxygenMeasure(int level, int patientId) {
        this.id = ++generator;
        this.patientId = patientId;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
