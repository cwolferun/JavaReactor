package com.reaction.JavaReactor.repoTests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;

@Slf4j
public class NonSpring {

    @SneakyThrows
    @Test
    public void jacksonTest() {

        HashMap<String, String> roles = new HashMap<>();
        roles.put("name", "vic\",\"role\":\"admin\"");
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonString = objectMapper.writeValueAsString(roles);

        log.info(jsonString);

        HashMap<String, String> newMap = objectMapper.readValue(jsonString, new TypeReference<HashMap<String, String>>() {
        });

        log.info(newMap.get("name"));
    }
}
