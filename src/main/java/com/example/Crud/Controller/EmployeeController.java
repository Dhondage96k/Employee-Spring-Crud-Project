package com.example.Crud.Controller;

import com.example.Crud.Model.Employee;
import com.example.Crud.Service.interfce.EmployeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private EmployeService empService;
    public EmployeeController(EmployeService empService) {
        super();
        this.empService = empService;
    }

    // buile create employee REST API
    @PostMapping
    public ResponseEntity<Employee> saveemployee(@RequestBody Employee employee) {

return new ResponseEntity< >(empService.saveEmployee(employee), HttpStatus.CREATED);
    }


    // build get all employees REST API
@GetMapping
    public List<Employee> getAllEmployees() {
        return empService.getAllEmployees();
}

// get emp by id
    @GetMapping("{id}")
public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
        return new ResponseEntity<Employee>(empService.getEmployeeById(id), HttpStatus.OK);
}
@PutMapping("{id}")
public ResponseEntity<Employee> updateEmployeeById(@PathVariable("id") long id, @RequestBody Employee employee) {
        return new ResponseEntity<>(empService.updateEmployee(employee , id),HttpStatus.OK);

}

@DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") long id) {
    empService.deleteEmployee(id);
        return  new ResponseEntity<>( "Employee deleted sucessfully",HttpStatus.OK);
}
}

