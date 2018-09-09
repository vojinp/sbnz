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
    public void testCEPConfigThroughKModuleXML() throws ParseException {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        kieSession = kContainer.newKieSession("monitoring-pseudo-session");
    }

    @Test
    public void runPseudoClockExample() throws ParseException {
        SessionPseudoClock clock = kieSession.getSessionClock();
        MonPatient patient = new MonPatient();

        MonOxygenMeasure oxygen;
        int ruleCount = 0;

        oxygen = new MonOxygenMeasure(65, patient.getId());
        System.out.println("Inserted: " + oxygen);
        kieSession.insert(oxygen);
        clock.advanceTime(5, TimeUnit.SECONDS);
        ruleCount = kieSession.fireAllRules();
        System.out.println(ruleCount);

        oxygen = new MonOxygenMeasure(65, patient.getId());
        System.out.println("Inserted: " + oxygen);
        kieSession.insert(oxygen);
        clock.advanceTime(5, TimeUnit.SECONDS);
        ruleCount = kieSession.fireAllRules();
        System.out.println(ruleCount);

        oxygen = new MonOxygenMeasure(75, patient.getId());
        System.out.println("Inserted: " + oxygen);
        kieSession.insert(oxygen);
        clock.advanceTime(5, TimeUnit.SECONDS);
        ruleCount = kieSession.fireAllRules();
        System.out.println(ruleCount);

        oxygen = new MonOxygenMeasure(67, patient.getId());
        System.out.println("Inserted: " + oxygen);
        kieSession.insert(oxygen);
        clock.advanceTime(5, TimeUnit.SECONDS);
        ruleCount = kieSession.fireAllRules();
        System.out.println(ruleCount);

        clock.advanceTime(10, TimeUnit.MINUTES);
        kieSession.fireAllRules();

        oxygen = new MonOxygenMeasure(67, patient.getId());
        System.out.println("Inserted: " + oxygen);
        kieSession.insert(oxygen);
        clock.advanceTime(5, TimeUnit.SECONDS);
        ruleCount = kieSession.fireAllRules();
        System.out.println(ruleCount);

        oxygen = new MonOxygenMeasure(67, patient.getId());
        System.out.println("Inserted: " + oxygen);
        kieSession.insert(oxygen);
        clock.advanceTime(5, TimeUnit.SECONDS);
        ruleCount = kieSession.fireAllRules();
        System.out.println(ruleCount);

        clock.advanceTime(7, TimeUnit.MINUTES);
        kieSession.fireAllRules();
    }
}

