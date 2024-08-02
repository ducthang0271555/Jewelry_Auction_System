package com.ourproject.auctionsystem.pojo;

public class Employee extends User {
    private int employeeID;
    private String employeeName;
    private String department;
    private String position;
    private String role;

    // Getters and Setters
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    // Methods
    public void evaluateJewelry() {
    }

    public void confirmReceipt() {
    }

    public void finalizeValuation() {
    }
    public void setRole(String role){
        this.role = role;
    }

}
