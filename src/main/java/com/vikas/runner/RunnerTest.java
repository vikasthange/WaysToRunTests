package com.vikas.runner;
import com.vikas.util.RunnerHelper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

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

        @BeforeSuite
        public void beforeSuite() throws Exception {

                RunnerHelper.setCucumberOptions();
        }


}
