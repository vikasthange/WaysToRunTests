package com.vikas.main;

import com.vikas.runner.RunnerTest;
import org.testng.TestNG;

public class MainClass {
    public static void main(String[] args) {
        TestNG testSuite = new TestNG();
        testSuite.setTestClasses(new Class[] { RunnerTest.class });
        //testSuite.addListener(new XX());
        testSuite.setDefaultSuiteName("My Test Suite");
        testSuite.setDefaultTestName("My Test");
        //testSuite.setOutputDirectory("/Users/pankaj/temp/testng-output");
        testSuite.run();
    }
}
