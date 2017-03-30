package com.sosuna.formacion.spring.springtest.isolated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class Level1Service {

    public static final String PREFIX_PROPERTY_NAME = "services.level1.prefix";

    @Autowired
    private Level2Service l2serv;       // Private field property

    private Environment env;    // Injected through constructor

    @Autowired
    public Level1Service(Environment env) {
        this.env = env;
    }

    public String processLevel1() {
        String prefix = env.getProperty(PREFIX_PROPERTY_NAME);

        String result = "";

        result += prefix;
        result += "_";
        result += l2serv.processLevel2();

        return result;
    }

}
