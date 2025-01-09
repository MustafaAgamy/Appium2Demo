package utils;

import io.restassured.path.json.JsonPath;

import java.io.*;

public class JsonReader {
    private final JsonPath jsonPath;

    /**
     * Constructor to load properties from the given relative path.
     *
     * @param relativePath the relative path to the properties file
     * @throws IOException if the file is not found or cannot be read
     */
    public JsonReader(String relativePath) {
        try {
            FileReader fileReader = new FileReader(new File(relativePath).getAbsolutePath());
            jsonPath = JsonPath.from(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the value of a Json by its key.
     *
     * @param jsonPathKey the jsonPath of the value
     * @return the value of the jsonPath, or null if the value does not exist
     */
    public String getJson(String jsonPathKey) {
        return jsonPath.get(jsonPathKey);
    }
}
