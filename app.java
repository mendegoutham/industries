package com.example;

import java.io.InputStream;
import java.util.Properties;

public class YourApp {
    public static void main(String[] args) {
        System.out.println("Hello, Maven!");

        // Load configuration from application.properties
        try (InputStream input = YourApp.class.getClassLoader().getResourceAsStream("config/application.properties")) {
            Properties properties = new Properties();
            if (input != null) {
                properties.load(input);
                System.out.println("App Name: " + properties.getProperty("app.name"));
                System.out.println("App Version: " + properties.getProperty("app.version"));
            } else {
                System.out.println("Unable to load configuration. Check the file path.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
