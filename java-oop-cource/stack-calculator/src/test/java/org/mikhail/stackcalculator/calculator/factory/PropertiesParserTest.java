package org.mikhail.stackcalculator.calculator.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PropertiesParserTest {
    private static final PropertiesParser propertiesParser = new PropertiesParser();
    private static final Properties expectedProperties = new Properties();
    private static Logger LOGGER;

    @BeforeAll
    public static void setLogger() {
        System.setProperty("logback.configurationFile", "logback-test.xml");
        LOGGER = LogManager.getLogger();
    }

    @BeforeAll
    public static void fillExpectedProperties() {
        expectedProperties.setProperty("PUSH", "org.mikhail.stackcalculator.calculator.operators.Push");
        expectedProperties.setProperty("POP", "org.mikhail.stackcalculator.calculator.operators.Pop");

        expectedProperties.setProperty("DEFINE", "org.mikhail.stackcalculator.calculator.operators.Define");

        expectedProperties.setProperty("PRINT", "org.mikhail.stackcalculator.calculator.operators.Print");

        expectedProperties.setProperty("+", "org.mikhail.stackcalculator.calculator.operators.Add");
        expectedProperties.setProperty("-", "org.mikhail.stackcalculator.calculator.operators.Subtract");
        expectedProperties.setProperty("*", "org.mikhail.stackcalculator.calculator.operators.Multiply");
        expectedProperties.setProperty("/", "org.mikhail.stackcalculator.calculator.operators.Divide");
        expectedProperties.setProperty("SQRT", "org.mikhail.stackcalculator.calculator.operators.Sqrt");
    }

    @BeforeAll
    public static void preparePropertiesParser() {
        try {
            propertiesParser.loadProperties();
        } catch (IOException | NullPointerException exception) {
            LOGGER.error("Impossible to load properties", exception);
            fail();
        }
    }

    @Test
    @Order(1)
    @DisplayName("Comparison of properties")
    public void compareProperties() {
        assertEquals(expectedProperties.toString(), propertiesParser.getProperties().toString());
    }

    @Test
    @Order(2)
    @DisplayName("Comparison of property maps")
    public void comparePropertyMaps() {
        Map<String, String> expectedPropertyMap = new TreeMap<>();
        expectedProperties.forEach((key, value) -> expectedPropertyMap.put(key.toString(), value.toString()));

        Map<String, String> actualPropertyMap = new TreeMap<>();
        propertiesParser.saveProperties(actualPropertyMap);

        assertEquals(expectedPropertyMap.toString(), actualPropertyMap.toString());
    }
}