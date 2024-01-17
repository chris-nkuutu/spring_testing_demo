package com.example.spring_testing_demo.controller;

import com.example.spring_testing_demo.models.Employee;
import com.example.spring_testing_demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    /**
     * Get all employees

     *  GET:  localhost:8080/employees
     */

    @GetMapping()
    public Iterable<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }
    /**
     * Get one employee

     *  GET:  localhost:8080/4
     */
    @GetMapping("/{id}")
    public Optional<Employee> getOneEmployeeById(@PathVariable Long id){
        return service.getEmployeeById(id);
    }
    /**
     * Get all employees

     *  POST:  localhost:8080/employee
     */
    @PostMapping()
    public Employee postEmployee(@RequestBody Employee employee) {
        return service.createEmployee(employee);
    }
    /**
     * Update employee details by ID

     *  PUT:  localhost:8080/employee/6
     */
    @PutMapping("/{id}")
    public boolean putEmployee(@PathVariable long id,@RequestBody Employee employee){
        return service.updateEmployeeById(id,employee);
    }
    /**
     * Delete one employee by id

     *  DELETE:  localhost:8080/employees/5
     */
    @DeleteMapping("/{id}")
    public boolean deleteOneEmployee(@PathVariable Long id) {
        return service.deleteEmployeeById(id);
    }
    @PostMapping("/seed")
    public Iterable<Employee> postSeedEmployees(){
        return service.seedEmployees();
    }

}
