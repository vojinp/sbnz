package com.sbnz.sbnz.domain.monitoring;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Expires("30m")
@Role(Role.Type.EVENT)
public class MonTachycardia {

    private int patientId;

    public MonTachycardia(int patientId) {
        this.patientId = patientId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}