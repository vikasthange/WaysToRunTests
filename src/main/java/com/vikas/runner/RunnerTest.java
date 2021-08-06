package com.vikas.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {
                "html:target/html_report.html",
                "json:target/cucumber.json",
                "junit:target/junit_report.xml"
        },
        tags = "@pass",
        features = "src/main/resources/sample.feature",
        glue = "com.vikas.steps",
        dryRun = false,
        publish = false

)

public class RunnerTest extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios(){ return super.scenarios();}



}
