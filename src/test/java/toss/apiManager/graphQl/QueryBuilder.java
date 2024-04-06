package toss.apiManager.graphQl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import toss.constants.Schema;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class QueryBuilder {

    static ObjectMapper objectMapper = new ObjectMapper();

    private static String readGraphQlSchema(Schema schema) {
        try {
            return new String(Files.readAllBytes(Paths.get(schema.getSchema())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getQuery(Schema schema) {
        return getQuery(schema, new QueryVariables());
    }

    public static String getQuery(Schema schema, QueryVariables variables) {
        QueryBody body = new QueryBody()
                .withQuery(readGraphQlSchema(schema))
                .withVariables(variables);
        try {
            return objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
