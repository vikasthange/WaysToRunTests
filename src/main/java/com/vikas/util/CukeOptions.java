package com.vikas.util;

import java.util.Arrays;

public enum CukeOptions {
    TAGS("tags"),
    FEATURES_PATHS("features"),
    PLUGINS("plugin"),
    GLUE("glue"),
    STRICT("strict"),
    DRY_RUN("dryRun"),
    MONOCHROME("monochrome"),
    PUBLISH("publish");
    String optionName;
    CukeOptions(String optionName) {
        this.optionName=optionName;
    }
    public String getParameterName(){
        return "cuke_"+optionName;
    }
    public String getCucumberOptionParamName(){
        return optionName;
    }
    public boolean isBoolean(){
        return Arrays.asList(new String[]{"monochrome","dryRun","strict","publish"}).contains(this.optionName);
    }
}
