package com.example.Crud.Service.interfce;

import com.example.Crud.Model.Employee;

import java.util.List;


public interface EmployeService {
// save employee
Employee saveEmployee(Employee employee);

// get all employees
List<Employee> getAllEmployees();

// get emp by id
    Employee getEmployeeById(long id);

// update
    Employee updateEmployee(Employee employee , long id);

    // delet
    void deleteEmployee(long id);
}
