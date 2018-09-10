package com.sbnz.sbnz;

import com.sbnz.sbnz.domain.monitoring.MonHeartbeat;
import com.sbnz.sbnz.domain.monitoring.MonPatient;
import com.sbnz.sbnz.domain.monitoring.MonTachycardia;
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

public class HeartTest {

    private KieSession kieSession;

    @Before
    public void createSession() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        kieSession = kContainer.newKieSession("monitoring-pseudo-session");
    }

    @Test
    public void normalHeartBeatTest() {
        SessionPseudoClock pseudoClock = kieSession.getSessionClock();
        MonPatient patient = new MonPatient();

        for (int index = 0; index < 10; index++) {
            MonHeartbeat beat = new MonHeartbeat(patient.getId());
            kieSession.insert(beat);

            beat = new MonHeartbeat(patient.getId());
            kieSession.insert(beat);
            pseudoClock.advanceTime(1, TimeUnit.SECONDS);
            int ruleCount = kieSession.fireAllRules();

            assertThat(ruleCount, equalTo(0));
        }

        Collection<?> newEvents = kieSession.getObjects(new ClassObjectFilter(MonTachycardia.class));
        assertThat(newEvents.size(), Matchers.equalTo(0));
    }

    @Test
    public void rapidHeartBeatTest() {
        SessionPseudoClock pseudoClock = kieSession.getSessionClock();
        MonPatient patient = new MonPatient();
        MonHeartbeat beat;

        kieSession.insert(patient);

        for (int index = 0; index < 15; index++) {
            beat = new MonHeartbeat(patient.getId());
            kieSession.insert(beat);

            beat = new MonHeartbeat(patient.getId());
            kieSession.insert(beat);

            beat = new MonHeartbeat(patient.getId());
            kieSession.insert(beat);

            pseudoClock.advanceTime(1, TimeUnit.SECONDS);
        }

        Collection<?> heartbeatEvents = kieSession.getObjects(new ClassObjectFilter(MonHeartbeat.class));
        assertThat(heartbeatEvents.size(), Matchers.equalTo(45));

        int ruleCount = kieSession.fireAllRules();

        assertThat(ruleCount, equalTo(1));

        Collection<?> tachycardiaEvents = kieSession.getObjects(new ClassObjectFilter(MonTachycardia.class));
        assertThat(tachycardiaEvents.size(), Matchers.equalTo(1));
    }
}
