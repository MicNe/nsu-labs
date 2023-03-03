package org.mikhail.stackcalculator.parsing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LinesTest {
    private static final List<String> linesList = new ArrayList<>();
    private static Lines lines;

    @BeforeAll
    public static void initialize() {
        linesList.add("# PUSH 1");
        linesList.add("PUSH 1");
        linesList.add("# PUSH 2");
        linesList.add("PUSH 2");
        linesList.add("# +");
        linesList.add("+");

        String linesString = String.join("\n", linesList);
        StringReader stringReader = new StringReader(linesString);

        lines = new Lines(stringReader);
    }

    @Test
    @Order(1)
    @DisplayName("Test read()")
    public void testRead() {
        assertDoesNotThrow(lines::read);
    }

    @Test
    @Order(2)
    @DisplayName("Checking lines")
    public void checkLines() {
        List<String> returnedLines = new ArrayList<>();
        while (!lines.isEmpty()) {
            returnedLines.add(lines.getNextLine());
        }

        assertArrayEquals(linesList.toArray(), returnedLines.toArray());
    }
}