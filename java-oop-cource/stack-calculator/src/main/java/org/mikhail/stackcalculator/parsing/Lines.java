package org.mikhail.stackcalculator.parsing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.Queue;

public class Lines {
    private static final Logger LOGGER = LogManager.getLogger();

    private final Reader reader;
    private final Queue<String> lines = new LinkedList<>();

    public Lines(Reader reader) {
        this.reader = reader;
    }

    public void read() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);

        String newLine = bufferedReader.readLine();
        LOGGER.debug("Line \"" + newLine + "\" read");
        while (newLine != null) {
            lines.add(newLine);
            LOGGER.debug("Line \"" + newLine + "\" added to the list");

            newLine = bufferedReader.readLine();
            LOGGER.debug("Line \"" + newLine + "\" read");
        }

        bufferedReader.close();
    }

    public boolean isEmpty() {
        return lines.isEmpty();
    }

    public String getNextLine() {
        return isEmpty() ? null : lines.remove();
    }
}
