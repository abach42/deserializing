package com.abach42.deserializing.projection;

import org.springframework.beans.factory.annotation.Value;

import com.abach42.deserializing.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = User.class, name = "basic")
})
public interface UserProjection {
    @JsonProperty("id")
    Long getId();

    @JsonProperty("username")
    String getUsername();

    @Value("#{target.username}")
    String getDisplyName();
}
