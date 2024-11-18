package com.abach42.deserializing.entity;

import com.abach42.deserializing.projection.UserProjection;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements UserProjection {
    private Long id;
    private String username;
    private Display display;

    public User() {
        this.display = new Display();
    }

    @Override
    public Long getId() {
        return id;    
    }

    @Override
    public String getUsername() {
      return username;
    }

    @Override
    public String getDisplayName() {
        return display.getDisplayName(username);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }
}
