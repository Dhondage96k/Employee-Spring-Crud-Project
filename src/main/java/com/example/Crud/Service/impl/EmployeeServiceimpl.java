package com.example.Crud.Service.impl;

import com.example.Crud.Exception.ResourceNotfound;
import com.example.Crud.Model.Employee;
import com.example.Crud.Repository.EmployeeRepository;
import com.example.Crud.Service.interfce.EmployeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeServiceimpl implements EmployeService {


    public EmployeeServiceimpl(EmployeeRepository repository) {
        super();
        this.repository = repository;
    }

    EmployeeRepository repository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }


    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> emp = repository.findById(id);

        return emp.orElseThrow(() ->
                new ResourceNotfound("firstname","surname",id)
        );
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
         // check emp with id is present
        Employee emp = repository.findById(id).orElseThrow(()-> new ResourceNotfound("firstname","surname",id));

        emp.setFirstname(employee.getFirstname());
        emp.setLastname(employee.getLastname());
        emp.setEmail(employee.getEmail());
        return repository.save(emp);
    }

    @Override
    public void deleteEmployee(long id) {
         Employee employee = repository.findById(id).orElseThrow(()-> new ResourceNotfound("firstname","surname",id));

          repository.deleteById(id);
    }

}
