package com.ecommerce.utils;

import com.ecommerce.exception.FileHandleException;
import com.ecommerce.helpers.CatalogEntry;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileHandleUtils {

    public static void writeEntriesToFile(File file, Object catalogEntries) {
        JsonFactory jsonFactory = new JsonFactory(new ObjectMapper());

        try (JsonGenerator jsonGenerator = jsonFactory.createGenerator(file, JsonEncoding.UTF8)) {
            jsonFactory.setCodec(new ObjectMapper().setSerializationInclusion(JsonInclude
                    .Include.NON_NULL));
            jsonGenerator.writeObject(catalogEntries);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveBytesToCSV(byte[] bytes, String fileDest) {
        try (FileOutputStream fileOuputStream = new FileOutputStream(fileDest)) {
            fileOuputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes the Ticket number to the given file path.
     *
     * @param contentToWrite Jira ticket to write
     * @param filePath       writes to this file path location
     */
    public static void writeStringToFilePath(String contentToWrite, String filePath) {

        File file = new File(filePath);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(contentToWrite);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
    }

    @SuppressWarnings("unchecked")
    public static List<List<CatalogEntry>> parseEntriesFromFile(File file) {
        if (Files.notExists(file.toPath())) {
            throw new IllegalArgumentException("The following file does not exist: "
                    + file.getAbsolutePath());
        }

        JsonFactory jsonFactory = new JsonFactory();

        try {
            JsonParser jsonParser = jsonFactory.createParser(file);
            jsonParser.setCodec(new ObjectMapper());
            return jsonParser.readValueAs(new TypeReference<List<List<CatalogEntry>>>() {
            });
        } catch (IOException e) {
            throw new FileHandleException("Could not parse file successfully!", e);
        }
    }

    public static File getSearchTermFile(String pathToFiles,
                                         String desiredSearchListFile,
                                         String defaultSearchListFile) {
        File[] files = new File(pathToFiles).listFiles();

        if (files == null) {
            throw new NullPointerException("No files exist in " + pathToFiles);
        }

        return Arrays.stream(files).filter(file -> file.getName()
                .equalsIgnoreCase(desiredSearchListFile))
                .findFirst().orElseGet(() -> new File(defaultSearchListFile));
    }
}
