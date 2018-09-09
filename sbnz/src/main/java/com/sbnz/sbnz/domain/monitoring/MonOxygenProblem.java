package com.sbnz.sbnz.domain.monitoring;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Expires("1h")
@Role(Role.Type.EVENT)
public class MonOxygenProblem {

    private int patientId;

    public MonOxygenProblem(int patientId) {
        this.patientId = patientId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}