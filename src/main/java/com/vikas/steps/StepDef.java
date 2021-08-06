package com.vikas.steps;

import io.cucumber.java.en.And;
import org.testng.Assert;

public class StepDef {

    @And("pass this step")
    public void passThisSTep(){
        System.out.println("Passed!!");
    }
    @And("fail this step")
    public void failThisSTep(){
        System.out.println("Failed!!");
        Assert.fail("..Failing test case..");
    }
}
