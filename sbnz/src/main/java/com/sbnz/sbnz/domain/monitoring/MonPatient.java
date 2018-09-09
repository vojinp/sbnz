package com.sbnz.sbnz.domain.monitoring;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import java.util.HashSet;
import java.util.Set;

@Expires("168h")
@Role(Role.Type.EVENT)
public class MonPatient {

    private static int idGenerator = 0;

    public int id;
    private Set<String> diseases;

    public MonPatient() {
        this.id = ++idGenerator;
        this.diseases = new HashSet<>();
    }

    public MonPatient(Set<String> diagnosedConditions) {
        this.diseases = diagnosedConditions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<String> getDiseases() {
        return diseases;
    }

    public void setDiseases(Set<String> diseases) {
        this.diseases = diseases;
    }
}