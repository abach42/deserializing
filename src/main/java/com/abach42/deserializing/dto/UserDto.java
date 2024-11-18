package com.abach42.deserializing.dto;

public record UserDto(
    Long id,
    String username,
    String displayName
) {}
