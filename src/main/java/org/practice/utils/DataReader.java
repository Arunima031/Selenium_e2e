package org.practice.utils;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

public class DataReader {

    public static List<HashMap<String, String>> getJsonToMap(String filepath) throws IOException {
        String jsonContent = Files.readString(Path.of(filepath), StandardCharsets.UTF_8);

        ObjectMapper mapper= new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }
}
