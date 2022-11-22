package com.swaglabs.helpers;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ResourceBundle;

public class EnvironmentUtils {
    private static Logger logger = LogManager.getLogger(EnvironmentUtils.class);
    public static String getEnvironment() {

        String environment = System.getProperty("ENVIRONMENT");
        if (StringUtils.isBlank(environment)) {
            environment = Constants.DEFAULT_ENVIRONMENT;
            logger.warn("Test runtime environment was not set, running on default environment: {}", environment);
        }
        logger.info("Running on: {}", environment);
        return environment;
    }

    public static String getEnvironmentProperties(String propertyName) {
        String environment = getEnvironment();
        ResourceBundle resourceBundle = ResourceBundle.getBundle(environment);
        return resourceBundle.getString(propertyName);
    }
}

