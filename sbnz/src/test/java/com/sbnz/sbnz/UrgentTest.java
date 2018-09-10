package com.sbnz.sbnz;

import com.sbnz.sbnz.domain.monitoring.MonHeartbeat;
import com.sbnz.sbnz.domain.monitoring.MonPatient;
import com.sbnz.sbnz.domain.monitoring.MonUrgentDialysis;
import com.sbnz.sbnz.domain.monitoring.MonUrination;
import org.drools.core.ClassObjectFilter;
import org.drools.core.time.SessionPseudoClock;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.text.ParseException;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class UrgentTest {

    private KieSession kieSession;

    @Before
    public void createSession() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        kieSession = kContainer.newKieSession("monitoring-pseudo-session");
    }

    @Test
    public void urgentTest() {
        SessionPseudoClock pseudoClock = kieSession.getSessionClock();

        MonPatient patient = new MonPatient();
        patient.getDiseases().add("Prehlada");
        patient.getDiseases().add("Hronicna bubrezna bolest");
        patient.getDiseases().add("Hipertenzija");

        kieSession.insert(patient);

        int ruleCount = kieSession.fireAllRules();
        assertThat(ruleCount, equalTo(0));

        MonUrination urinationEvent;
        for (int i = 0; i < 20; i++) {
            urinationEvent = new MonUrination(patient.getId(), 3);
            kieSession.insert(urinationEvent);
            pseudoClock.advanceTime(1, TimeUnit.HOURS);
        }

        MonHeartbeat beat;
        for (int i = 0; i < 10; i++) {
            beat = new MonHeartbeat(patient.getId());
            kieSession.insert(beat);

            beat = new MonHeartbeat(patient.getId());
            kieSession.insert(beat);
            pseudoClock.advanceTime(1, TimeUnit.SECONDS);
        }

        kieSession.fireAllRules();

        Collection<?> urgentDialysisEvents = kieSession.getObjects(new ClassObjectFilter(MonUrgentDialysis.class));
        assertThat(urgentDialysisEvents.size(), Matchers.equalTo(1));
    }

}

