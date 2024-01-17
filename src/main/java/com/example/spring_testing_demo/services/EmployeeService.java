package com.example.spring_testing_demo.services;

import com.example.spring_testing_demo.models.Employee;
import com.example.spring_testing_demo.reposiyory.EmployeeRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    /**
     * Get all employees
     *
     * @return All Employees
     */
    public Iterable<Employee> getAllEmployees() {
        return repository.findAll();
    }

    /**
     * Get one employee by ID
     *
     * @return One Employee
     */
    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    /**
     * Get one employee by ID
     *
     * @return One Employee
     */
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    /**
     * Get one employee by ID
     *
     * @return One Employee
     */
    public boolean updateEmployeeById(Long id, Employee employee) {
        if (repository.existsById(id)) {
            employee.setId(id);
            repository.save(employee);

            //Remove and return true if it exists.
            return true;
        }

        //Otherwise return false.
        return false;
    }

    public boolean deleteEmployeeById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        //Check if employee already exists
        //Remove and return true if it exists.
        return true;
        //Otherwise return false.
    }

    public Iterable<Employee> seedEmployees() {
        Employee[] employeesArray = {
                new Employee("Chris", 3000000),
                new Employee("Kalle", 200000),
                new Employee("Brian", 20000)
        };
        var employeesList = Arrays.stream((employeesArray)).toList();


        return repository.saveAll(employeesList);
    }
}
