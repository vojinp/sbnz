package com.sbnz.sbnz.domain.monitoring;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("16m")
public class MonOxygenRaised {

    public int patientId;

    public MonOxygenRaised(int patientId) {
        this.patientId = patientId;
    }
}