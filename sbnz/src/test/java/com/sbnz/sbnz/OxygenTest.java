package com.sbnz.sbnz;

import com.sbnz.sbnz.domain.monitoring.MonOxygenMeasure;
import com.sbnz.sbnz.domain.monitoring.MonPatient;
import org.drools.core.time.SessionPseudoClock;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class OxygenTest {

    private KieSession kieSession;

    @Before
    public void createSession() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        kieSession = kContainer.newKieSession("monitoring-pseudo-session");
    }

    @Test
    public void oxygenTest() {
        SessionPseudoClock pseudoClock = kieSession.getSessionClock();
        MonPatient patient = new MonPatient();

        MonOxygenMeasure oxygen;
        int ruleCount = 0;

        oxygen = new MonOxygenMeasure(65, patient.getId());
        System.out.println("Inserted: " + oxygen);
        kieSession.insert(oxygen);
        pseudoClock.advanceTime(5, TimeUnit.SECONDS);
        ruleCount = kieSession.fireAllRules();
        System.out.println(ruleCount);

        oxygen = new MonOxygenMeasure(65, patient.getId());
        System.out.println("Inserted: " + oxygen);
        kieSession.insert(oxygen);
        pseudoClock.advanceTime(5, TimeUnit.SECONDS);
        ruleCount = kieSession.fireAllRules();
        System.out.println(ruleCount);

        oxygen = new MonOxygenMeasure(75, patient.getId());
        System.out.println("Inserted: " + oxygen);
        kieSession.insert(oxygen);
        pseudoClock.advanceTime(5, TimeUnit.SECONDS);
        ruleCount = kieSession.fireAllRules();
        System.out.println(ruleCount);

        oxygen = new MonOxygenMeasure(67, patient.getId());
        System.out.println("Inserted: " + oxygen);
        kieSession.insert(oxygen);
        pseudoClock.advanceTime(5, TimeUnit.SECONDS);
        ruleCount = kieSession.fireAllRules();
        System.out.println(ruleCount);

        pseudoClock.advanceTime(10, TimeUnit.MINUTES);
        kieSession.fireAllRules();

        oxygen = new MonOxygenMeasure(67, patient.getId());
        System.out.println("Inserted: " + oxygen);
        kieSession.insert(oxygen);
        pseudoClock.advanceTime(5, TimeUnit.SECONDS);
        ruleCount = kieSession.fireAllRules();
        System.out.println(ruleCount);

        oxygen = new MonOxygenMeasure(67, patient.getId());
        System.out.println("Inserted: " + oxygen);
        kieSession.insert(oxygen);
        pseudoClock.advanceTime(5, TimeUnit.SECONDS);
        ruleCount = kieSession.fireAllRules();
        System.out.println(ruleCount);

        pseudoClock.advanceTime(7, TimeUnit.MINUTES);
        kieSession.fireAllRules();
    }
}

