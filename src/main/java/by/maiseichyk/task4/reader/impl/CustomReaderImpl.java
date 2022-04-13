package by.maiseichyk.task4.reader.impl;

import by.maiseichyk.task4.reader.CustomReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomReaderImpl implements CustomReader {

    @Override
    public String readFile(String fileName) {
        String text = "";
        try (FileReader reader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            while (bufferedReader.ready()) {
                text = text.concat(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
