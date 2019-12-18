package com.detaildemo.drools;

import com.detaildemo.drools.entity.Applicant;
import org.junit.Assert;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

public class ApplicantTest {
    @Test
    public void testCheckAgeValid(){
        KieServices kieService = KieServices.Factory.get();
        KieContainer kieContainer = kieService.getKieClasspathContainer();
        KieSession kSession = kieContainer.newKieSession("ksession-Sample");
        Applicant applicant = new Applicant( "Mr John Smith", 20 );
        Assert.assertFalse( applicant.isValid() );
        kSession.insert(applicant);
        Assert.assertTrue( applicant.isValid() );
    }
}
