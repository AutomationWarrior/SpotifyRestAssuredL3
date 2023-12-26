package com.spotify.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyUtils {

    private static Properties properties;

    private static FileInputStream fileIn;

    public static Properties propertyLoader(String path){
        properties = new Properties();

        try {
            fileIn = new FileInputStream(path);
            properties.load(fileIn);
        }catch (Exception e){
            System.out.println("File not found");
            e.printStackTrace();
        }
        return  properties;
    }

}
