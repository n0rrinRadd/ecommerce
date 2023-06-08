package com.ecommerce.parser;

import com.ecommerce.exception.FileHandleException;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileParser implements CsvParser {

    private final File file;

    public CsvFileParser(File file) {
        this.file = file;
    }

    @Override
    public List<String> getContents() {
        try (InputStream inputStream = new FileInputStream(file);
             BufferedReader bufferedReader = new BufferedReader(
                     new InputStreamReader(inputStream))) {
            return bufferedReader.lines().map(String::trim).collect(Collectors.toList());
        } catch (IOException e) {
            throw new FileHandleException("Could not parse search terms!", e);
        }
    }
}
