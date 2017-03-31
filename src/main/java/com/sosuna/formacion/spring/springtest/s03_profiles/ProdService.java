package com.sosuna.formacion.spring.springtest.s03_profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdService implements ProfileDependantService {
}
