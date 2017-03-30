package com.sosuna.formacion.spring.springtest.s02_config_properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

// Runs test with a Spring-provided JUnit test runner
@RunWith(SpringRunner.class)
// Loads context according to SpringBoot application configuration defaults.
// Loads properties from SpringBoot default locations.
@SpringBootTest
@TestPropertySource(
        properties = {
            "s02_config_properties.property1 = MOCK_VALUE_1",
            "s02_config_properties.property2 = MOCK_VALUE_2"
})
public class ConfigPropertiesTest {

    @Autowired
    private ApplicationContext ctxt;

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
