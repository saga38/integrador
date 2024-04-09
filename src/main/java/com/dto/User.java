package com.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private String id;
    private String name;

    private String password;

    private String email;

    public User(){}


    public String getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = (String) id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
