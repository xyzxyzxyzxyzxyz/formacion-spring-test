package com.sosuna.formacion.spring.springtest.s01_isolated;

import org.junit.Test;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


/**
 * Does not require the SpringRunner to work
 */
public class IsolatedTest {

    @Test
    public void shouldGenerateCorrectOutput() {
        // Prepare mock environment
        MockEnvironment env = new MockEnvironment();    // Use Spring-provided mock Environment implementation
        env.setProperty(Level1Service.PREFIX_PROPERTY_NAME, "level1-mock-value");

        // Create bean. Inject dependencies through constructor
        Level1Service level1Service = new Level1Service(env);

        // Mock dependency
        Level2Service level2Service = mock(Level2Service.class);
        when(level2Service.processLevel2()).thenReturn("level2-mock-value");

        // Injection through private field
        ReflectionTestUtils.setField(level1Service, "l2serv", level2Service);

        // Execute action
        String result = level1Service.processLevel1();

        // Assert result
        assertEquals(result, "level1-mock-value" + "_" + "level2-mock-value");
    }

}
