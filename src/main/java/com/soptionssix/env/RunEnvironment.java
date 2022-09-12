package com.soptionssix.env;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class RunEnvironment {

    private final Environment environment;
    public static final String ENV_PRODUCT = "product";
    public static final String ENV_DEVELOPMENT = "development";

    @Autowired
    public RunEnvironment(Environment environment) {
        this.environment = environment;
    }

    public boolean isProduct() {
        String[] activeProfiles = this.environment.getActiveProfiles();
        return Arrays.stream(activeProfiles)
                .anyMatch(profile -> profile.equalsIgnoreCase(ENV_PRODUCT));
    }

    public boolean isDevelopment() {
        String[] activeProfiles = this.environment.getActiveProfiles();
        return Arrays.stream(activeProfiles)
                .anyMatch(profile -> profile.equalsIgnoreCase(ENV_DEVELOPMENT));
    }
}
