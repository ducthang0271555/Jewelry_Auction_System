package com.ourproject.auctionsystem.service;

import java.util.ArrayList;
import java.util.List;
import com.ourproject.auctionsystem.pojo.Employee;

public class EmployeeService implements IEmployeeService {
    private List<Employee> employees = new ArrayList<>();

    @Override
    public void evaluateJewelry(Employee employee) {

    }

    @Override
    public void confirmReceipt(Employee employee) {

    }

    @Override
    public void finalizeValuation(Employee employee) {

    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return employees.stream()
                .filter(employee -> employee.getEmployeeID() == employeeId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    @Override
    public void updateEmployee(Employee employee) {
        int index = employees.indexOf(getEmployeeById(employee.getEmployeeID()));
        if (index != -1) {
            employees.set(index, employee);
        }
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employees.removeIf(employee -> employee.getEmployeeID() == employeeId);
    }
}
