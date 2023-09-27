package com.example.homeworkstreamaandoption.controller;

import com.example.homeworkstreamaandoption.model.Employee;
import com.example.homeworkstreamaandoption.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeesController {
    private final EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Object addEmployee(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName,
            @RequestParam(value = "salary") int salary,
            @RequestParam(value = "department") int department) {
        Employee employee = null;
        try {
            employee = employeeService.addEmployee(firstName, lastName, salary, department);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName) {
        Employee employee = null;
        try {
            employee = employeeService.removeEmployee(firstName, lastName);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return String.valueOf(employee);
    }

    @GetMapping(path = "/find")
    public String findEmployee(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName) {
        Employee employee = null;
        try {
            employee = employeeService.findEmployee(firstName, lastName);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return String.valueOf(employee);
    }

    @GetMapping(path = "/print")
    public Object printEmployees() {
        List<Employee> employees = null;
        try {
            employees = employeeService.printEmployees();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employees;
    }

    @GetMapping(path = "/fill")
    public Object fillEmployeesList() {
        List<Employee> employees = null;
        try {
            employees = employeeService.fillEmployeesList();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return employees;
    }

}
