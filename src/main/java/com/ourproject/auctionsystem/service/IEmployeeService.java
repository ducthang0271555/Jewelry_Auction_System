package com.ourproject.auctionsystem.service;

import java.util.List;
import com.ourproject.auctionsystem.pojo.Employee;

public interface IEmployeeService {
    void evaluateJewelry(Employee employee);
    void confirmReceipt(Employee employee);
    void finalizeValuation(Employee employee);
    Employee getEmployeeById(int employeeId);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);
}