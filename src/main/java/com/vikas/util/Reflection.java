package com.vikas.util;

import com.vikas.runner.RunnerTest;
import io.cucumber.testng.CucumberOptions;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

public class Reflection {
    public static void changeCucumberAnnotation(String key,Object value) throws Exception {
        Annotation annotation = RunnerTest.class.getAnnotation(CucumberOptions.class);
        InvocationHandler proxyHandler = Proxy.getInvocationHandler(annotation);
        Field f = proxyHandler.getClass().getDeclaredField("memberValues");
        f.setAccessible(true);
        Map<String, Object> memberValues = (Map<String, Object>) f.get(proxyHandler);
        memberValues.remove(key);
        System.out.println("Setting key["+key+"] : value["+value+"]");
        memberValues.put(key, value);
    }
}
