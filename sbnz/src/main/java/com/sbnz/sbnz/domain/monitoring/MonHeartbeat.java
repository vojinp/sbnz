package com.sbnz.sbnz.domain.monitoring;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("1m")
public class MonHeartbeat {

    private int patientId;

    public MonHeartbeat() {}

    public MonHeartbeat(int patientId) {
        this.patientId = patientId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}