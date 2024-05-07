package com.CucumberBDD.Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    Properties p = new Properties();

    /**
     * To read the config.properties file and return reference variable of Properties class
     * @return p Properties
     */
    public Properties getConfigProperties(){
        try {
            FileReader reader = new FileReader("./src/main/resources/configuration/config.properties");
            p.load(reader);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return  p;
    }
}
