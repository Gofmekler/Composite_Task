package by.maiseichyk.task4.reader.impl;

import by.maiseichyk.task4.reader.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReaderImpl implements FileReader {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public String readFile(String fileName) {
        StringBuilder text = new StringBuilder();
        try (java.io.FileReader reader = new java.io.FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            while (bufferedReader.ready()) {
                text.append(bufferedReader.readLine());
            }
        } catch (IOException e) {
            LOGGER.warn("Reader can't get file " + e);
        }
        return text.toString();
    }
}
