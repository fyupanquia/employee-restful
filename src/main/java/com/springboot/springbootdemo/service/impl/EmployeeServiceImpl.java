package com.springboot.springbootdemo.service.impl;

import com.springboot.springbootdemo.exception.ResourceNotFoundException;
import com.springboot.springbootdemo.model.Employee;
import com.springboot.springbootdemo.repository.EmployeeRepository;
import com.springboot.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        /*
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            return employee.get();
        } else {
          throw new ResourceNotFoundException("Employee", "Id", id);
        }
        */
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        Employee existingEmployee = this.getEmployeeById(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        Employee existingEmployee = this.getEmployeeById(id);
        employeeRepository.deleteById(id);
    }
}
