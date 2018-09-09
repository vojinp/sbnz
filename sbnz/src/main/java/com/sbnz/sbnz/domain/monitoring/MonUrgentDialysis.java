package com.sbnz.sbnz.domain.monitoring;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Expires("24h")
@Role(Role.Type.EVENT)
public class MonUrgentDialysis {

    private int patientId;

    public MonUrgentDialysis(int patientId) {
        this.patientId = patientId;
    }
}