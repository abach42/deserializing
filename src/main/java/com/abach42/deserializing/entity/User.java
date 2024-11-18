package com.abach42.deserializing.entity;

import com.abach42.deserializing.projection.UserProjection;

public class User implements UserProjection {
    private Long id;
    private String username;

    @Override
    public Long getId() {
        return id;    
    }

    @Override
    public String getUsername() {
      return username;
    }

    @Override
    public String getDisplyName() {
        return "foo";
    }
    
}
