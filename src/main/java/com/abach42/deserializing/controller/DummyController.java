package com.abach42.deserializing.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abach42.deserializing.dto.UserDto;
import com.abach42.deserializing.projection.UserProjection;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1")
public class DummyController {
    
    @GetMapping("/foo")
    public ResponseEntity<UserProjection> foo() throws JsonMappingException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String basicJson = "{\"type\": \"basic\", \"id\": 1, \"username\": \"johndoe\", \"displayName\": \"name\"}";

        UserProjection basicUser = objectMapper.readValue(basicJson, UserProjection.class);


        return ResponseEntity.ok().body(basicUser);
    }    
    
    @GetMapping("/bar")
    public ResponseEntity<UserDto> bar() throws JsonMappingException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String basicJson = "{\"id\": 1, \"username\": \"johndoe\", \"displayName\": \"name\"}";

        UserDto basicUser = objectMapper.readValue(basicJson, UserDto.class);


        return ResponseEntity.ok().body(basicUser);
    }
}
