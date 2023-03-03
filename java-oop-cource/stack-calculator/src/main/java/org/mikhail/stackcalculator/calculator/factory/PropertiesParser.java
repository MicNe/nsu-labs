package org.mikhail.stackcalculator.calculator.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class PropertiesParser {
    private static final Logger LOGGER = LogManager.getLogger();

    private final Properties properties = new Properties();

    public void loadProperties() throws IOException, NullPointerException {
        String configurationFileName = "configuration.properties";
        InputStream inputStream = PropertiesParser.class.getResourceAsStream(configurationFileName);
        properties.load(inputStream);
        LOGGER.debug("Properties loaded from " + configurationFileName + ": " + properties);
    }

    public void saveProperties(Map<String, String> destinationMap) {
        properties.forEach((key, value) -> destinationMap.put(key.toString(), value.toString()));
        LOGGER.debug("Properties saved to the map");
    }

    public Properties getProperties() {
        return properties;
    }
}