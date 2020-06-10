package com.example.mailServer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private String fullName;
    private String email;

    public User(@JsonProperty("name") String fullName,@JsonProperty("email") String email) {
        this.fullName = fullName;
        this.email = email;
    }



    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
