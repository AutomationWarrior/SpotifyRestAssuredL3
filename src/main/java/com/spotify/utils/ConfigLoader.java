package com.spotify.utils;

import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;
    private static  ConfigLoader configLoader;

    private ConfigLoader(){
        properties = PropertyUtils.propertyLoader("src/main/resources/config.properties");
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getPropertyName(String key){
        String prop = null;
        prop = properties.getProperty(key);
        return prop;
    }
}
