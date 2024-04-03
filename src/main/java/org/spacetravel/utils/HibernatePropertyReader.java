package org.spacetravel.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HibernatePropertyReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernatePropertyReader.class.getCanonicalName());
    public static String getConnectionUrlForH2() {
        LOGGER.info("Reading database properties [hibernate.properties]...");
        try (InputStream input = HibernatePropertyReader.class.getClassLoader()
                .getResourceAsStream("hibernate.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                LOGGER.error("Sorry, unable to find hibernate.properties");
                return null;
            }
            prop.load(input);
            return prop.getProperty("hibernate.connection.url");

        } catch (IOException ex) {
            LOGGER.error("Exception: {}", ex.getMessage());
            return null;
        }
    }
}
