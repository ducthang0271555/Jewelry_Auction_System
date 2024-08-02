package com.ourproject.auctionsystem.pojo;

public class User {
    private int userID;
    private String username;
    private String password;
    private String email;
    private String role;
    private String phoneNumber;
    private String name;
    private String department;

    // Getters and Setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setUserId(int userID) {
        this.userID = userID;
    }
    public int getUserId() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Methods
    public void register() {
    }

    public void login() {
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public String getDepartment(){
        return department;
    }
}
