package com.sosuna.formacion.spring.springtest.s03_profiles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
// Sets as active the profile "prod"
@ActiveProfiles("prod")
// Launches test with full context
@SpringBootTest
public class ProfilesTest1 {

    @Autowired
    private ProfileDependantService pdService;

    @Test
    public void withProdProfileServiceImplementationMustBeProductionReady() {
        assertTrue(pdService instanceof ProdService);
    }
}
