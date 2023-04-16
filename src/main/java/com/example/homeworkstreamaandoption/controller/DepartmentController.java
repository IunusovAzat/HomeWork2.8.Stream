package com.example.homeworkstreamaandoption.controller;

import com.example.homeworkstreamaandoption.model.Employee;
import com.example.homeworkstreamaandoption.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public String getHighestPaidEmployee(
            @RequestParam(value = "departmentId") Integer departmentId) {
        Employee employee;
        try {
            employee = departmentService.getHighestPaidEmployee(departmentId);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return String.valueOf(employee);
    }

    @GetMapping(path = "/min-salary")
    public String getLowestPaidEmployee(
            @RequestParam(value = "departmentId") Integer departmentId) {
        Employee employee;
        try {
            employee = departmentService.getLowestPaidEmployee(departmentId);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return String.valueOf(employee);
    }

    @GetMapping(path = "/all", params = "departmentId")
    public String printEmployeesForDepartment(
            @RequestParam(value = "departmentId") Integer departmentId) {
        List<Employee> employees;
        try {
            employees = departmentService.printEmployeesForDepartment(departmentId);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return String.valueOf(employees);
    }

    @GetMapping(path = "/all")
    public String printEmployeesByDepartments() {
        List<Employee> employees;
        try {
            employees = departmentService.printEmployeesByDepartments();
        } catch (Throwable e) {
            return e.getMessage();
        }
        return String.valueOf(employees);
    }
}
