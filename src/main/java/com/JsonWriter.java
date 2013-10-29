package com;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.node.ObjectNode;

import java.io.IOException;

public class JsonWriter {

    private final ObjectMapper objectMapper;

    private final ObjectWriter writer;

    public JsonWriter() {
        this.objectMapper = new ObjectMapper();
        this.writer = objectMapper.writerWithDefaultPrettyPrinter();
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void writeJson( String key, String value, int statusCode) throws IOException {
        ObjectNode result = createObjectNode();
        result.put(key, value);
        writeJson(result, statusCode);
    }

    public ObjectNode createObjectNode() {
        return objectMapper.createObjectNode();
    }

    public void writeJson(ObjectNode value, int statusCode) throws IOException {
        String json = writer.writeValueAsString(value);

        System.out.println(json);
    }

}
