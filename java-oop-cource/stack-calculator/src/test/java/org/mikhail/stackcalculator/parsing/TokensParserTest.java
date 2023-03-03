package org.mikhail.stackcalculator.parsing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mikhail.stackcalculator.calculator.common.CalculatorToken;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TokensParserTest {
    private static Logger LOGGER;

    @BeforeAll
    public static void setLogger() {
        System.setProperty("logback.configurationFile", "logback-test.xml");
        LOGGER = LogManager.getLogger();
    }

    @Test
    @DisplayName("Checking null line")
    public void checkNullLine() {
        assertDoesNotThrow(() -> TokensParser.getTokens(null));
    }

    @Test
    @DisplayName("Checking return of null line")
    public void checkReturnOfNullLine() {
        assertDoesNotThrow(() -> assertNull(TokensParser.getTokens(null)));
    }

    @Test
    @DisplayName("Checking comment line")
    public void checkCommentLine() {
        assertDoesNotThrow(() -> assertNull(TokensParser.getTokens("# comment line 1")));
        assertDoesNotThrow(() -> assertNull(TokensParser.getTokens("#comment line 1")));
    }

    @Test
    @DisplayName("Checking correct line")
    public void checkCorrectLine() {
        assertDoesNotThrow(() -> TokensParser.getTokens("DEFINE x 1"));
    }

    @Test
    @DisplayName("Checking result of correct line")
    public void checkResultOfCorrectLine() {
        String testingLine = "DEFINE x 1";
        List<CalculatorToken> calculatorTokens;
        try {
            calculatorTokens = TokensParser.getTokens(testingLine);

            assertAll(
                    () -> assertEquals("DEFINE", calculatorTokens.get(0).toString()),
                    () -> assertEquals("x", calculatorTokens.get(1).toString()),
                    () -> assertEquals(1.0, calculatorTokens.get(2).toDouble())
            );
        } catch (IOException exception) {
            LOGGER.error("Impossible to parse tokens from line \"" + testingLine + "\"", exception);
            fail();
        }
    }
}