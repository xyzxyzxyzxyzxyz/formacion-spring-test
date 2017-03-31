package com.sosuna.formacion.spring.springtest.s03_profiles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
// Launches test with full context
// No active profiles
@SpringBootTest
public class ProfilesTest2 {

    @Autowired
    private ProfileDependantService pdService;

    @Test
    public void withoutProdProfileServiceImplementationMustNotBeProduction() {
        assertFalse(pdService instanceof ProdService);
    }

}
