package com.example.spring_testing_demo;

import com.example.spring_testing_demo.controller.EmployeeController;
import com.example.spring_testing_demo.models.Employee;
import com.example.spring_testing_demo.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTests {

    @MockBean
    private EmployeeService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getEmployees_ShouldReturnListOfEmployees ()throws Exception{

         when(service.getAllEmployees()).thenReturn(getMockEmployees());

         mockMvc.perform(MockMvcRequestBuilders.get("/api/employees"))
                         .andExpect(status().isOk())
                         .andExpect(jsonPath("$", hasSize(5)))


         ;

    }

    public Iterable<Employee> getMockEmployees() {
        Employee[] employeesArray = {
                new Employee("Chris", 3000),
                new Employee("Kalle", 2000),
                new Employee("Brian", 2000),
                new Employee("Sefukko", 2600),
                new Employee("Marko", 2600)
        };

        return Arrays.stream(employeesArray).toList();
    }
}
