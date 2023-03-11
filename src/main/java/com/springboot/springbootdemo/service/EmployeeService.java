package com.springboot.springbootdemo.service;

import com.springboot.springbootdemo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(long id, Employee employee);
    void deleteEmployee(long id);
}
