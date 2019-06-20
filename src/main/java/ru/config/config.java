package ru.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class config {
    private static final String PROPERTIES_FILE = "properties";
    //private static final String PROPERTIES_FILE = "/home/ura/bin/properties";

    public static int PORT;
    public static int START;
    public static int STOP;
    public static int INTERVAL;
    public static int INTERVAL_L;
    public static String LOGIN;
    public static String PASSWORD;
    public static String FIREFOX;


    static {
        Properties properties = new Properties();
        FileInputStream propertiesFile = null;

        try {
            propertiesFile = new FileInputStream(PROPERTIES_FILE);
            properties.load(propertiesFile);
            START       = Integer.parseInt(properties.getProperty("START"));
            STOP        = Integer.parseInt(properties.getProperty("STOP"));
            PORT        = Integer.parseInt(properties.getProperty("PORT"));
            INTERVAL    = Integer.parseInt (properties.getProperty("INTERVAL"));
            INTERVAL_L  = Integer.parseInt (properties.getProperty("INTERVAL_L"));
            LOGIN       = properties.getProperty("LOGIN");
            PASSWORD    = properties.getProperty("PASSWORD");
            FIREFOX     = properties.getProperty("FIREFOX");

            System.out.println( LOGIN + PORT + PASSWORD + " " + START + "!" + STOP + " " + INTERVAL + INTERVAL_L );

        } catch (FileNotFoundException ex) {
            System.err.println("Не найден файл " + PROPERTIES_FILE);
        } catch (IOException ex) {
            System.err.println("Error while reading file");
        } finally {
            try {
                if (propertiesFile != null) {
                    propertiesFile.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
