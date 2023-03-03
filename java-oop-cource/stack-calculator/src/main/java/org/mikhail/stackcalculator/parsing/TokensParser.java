package org.mikhail.stackcalculator.parsing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mikhail.stackcalculator.calculator.common.CalculatorToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class TokensParser {
    private static final Logger LOGGER = LogManager.getLogger();

    public static List<CalculatorToken> getTokens(String line) throws IOException {
        if (line == null) {
            return null;
        }

        List<CalculatorToken> tokens = new ArrayList<>();

        Reader reader = new BufferedReader(new StringReader(line));
        StreamTokenizer streamTokenizer = new StreamTokenizer(reader);
        streamTokenizer.wordChars('*', '/');
        streamTokenizer.commentChar('#');

        int newToken = streamTokenizer.nextToken();
        LOGGER.debug("New token received (ttype: " + newToken + ")");
        while (newToken != StreamTokenizer.TT_EOF) {
            if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                tokens.add(new CalculatorToken(streamTokenizer.nval));
                LOGGER.debug("New token added to the list (nval: " + streamTokenizer.nval + ")");
            } else if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                tokens.add(new CalculatorToken(streamTokenizer.sval));
                LOGGER.debug("New token added to the list (sval: " + streamTokenizer.sval + ")");
            }

            newToken = streamTokenizer.nextToken();
            LOGGER.debug("New token received (ttype: " + newToken + ")");
        }

        if (tokens.isEmpty()) {
            LOGGER.debug("The list of tokens is empty");
            return null;
        }

        return tokens;
    }
}
