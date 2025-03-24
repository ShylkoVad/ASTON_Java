package ru.aston.utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.String.valueOf;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class ValueWriter {
    private final String intToString;

    public ValueWriter(int i){
        this.intToString = valueOf(i);
    }

    public void writer() throws IOException {
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("src/main/java/resources/findResults.txt"), CREATE, APPEND)){
            String appendingString = intToString + ", ";
            bufferedWriter.append(appendingString);
        }
    }
}
