package com.sosuna.formacion.spring.springtest.s02_config_properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

// Runs test with a Spring-provided JUnit test runner
@RunWith(SpringRunner.class)
// Loads context according to SpringBoot application configuration defaults.
// Loads properties from SpringBoot default locations.
// The problem is that you cannot avoid loading the complete application context
@SpringBootTest
// Gets properties from the class companion file (ConfigProperties3.properties) in the same package
@TestPropertySource
public class ConfigPropertiesTest3 {

    @Value("${s02_config_properties.property1}")
    private String property1;
    @Value("${s02_config_properties.property2}")
    private String property2;



    @Test
    public void shouldHaveCorrectPropertyValue() {
        assertEquals(property1, "MOCK_VALUE_1");
        assertEquals(property2, "MOCK_VALUE_2");
    }

}
