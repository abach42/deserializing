package com.abach42.deserializing.projection;

import org.springframework.beans.factory.annotation.Value;

import com.abach42.deserializing.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = User.class),
})
public interface UserProjection {
    @JsonProperty("id")
    Long getId();

    @JsonProperty("username")
    String getUsername();

    @JsonProperty("displayname")
    @Value("#{target.username}")
    default String getDisplayName() {
        return "foobar";
    }
}
