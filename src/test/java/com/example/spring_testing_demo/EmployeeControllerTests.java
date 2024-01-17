package com.example.spring_testing_demo;

import com.example.spring_testing_demo.controller.EmployeeController;
import com.example.spring_testing_demo.models.Employee;
import com.example.spring_testing_demo.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import static org.mockito.Mockito.when;


@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTests {

    @MockBean
    private EmployeeService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getEmployees_ShouldReturnListOfEmployees ()throws Exception{
         when(service.getAllEmployees()).thenReturn(getMockEmployees());

         mockMvc.perform(MockMvcRequestBuilders.get("/api/employees")).
                 andExpect(status().isOk());

    }

    public Iterable<Employee> getMockEmployees() {
        Employee[] employeesArray = {
                new Employee("Chris", 3000),
                new Employee("Kalle", 2000),
                new Employee("Brian", 2000)
        };

        return Arrays.stream(employeesArray).toList();
    }
}