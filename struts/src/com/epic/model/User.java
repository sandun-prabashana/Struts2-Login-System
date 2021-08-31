package com.epic.model;

public class User {
    private int id;
    private String user_name;
    private String email_address;
    private String password;

    public User() {
    }

    public User(int id, String user_name, String email_address, String password) {
        this.id = id;
        this.user_name = user_name;
        this.email_address = email_address;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
