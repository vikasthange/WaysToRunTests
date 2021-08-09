package com.vikas.util;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class RunnerHelper {
    public static void setCucumberOptions() throws Exception {
        for (CukeOptions option : CukeOptions.values()){
            String value = System.getProperty(option.getParameterName());
            if(value!=null){
                Object v= null;
                if(option==CukeOptions.TAGS){
                    v= value;
                }
                else{
                    v= option.isBoolean()? Boolean.parseBoolean(value):value.split(",");
                }
                Reflection.changeCucumberAnnotation(option.getCucumberOptionParamName(),v);
            }
        }
    }
}
