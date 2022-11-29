package com.swaglabs.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

    @CucumberOptions(
            features = "classpath:features",
            glue = {"com.swaglabs.steps"},
            plugin = {"pretty", "html:target/cucumber-reports"}
    )
    public class RegressionTestRunner extends AbstractTestNGCucumberTests{

}
