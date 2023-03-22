package com.example.homeworkstreamaandoption.service;

import com.example.homeworkstreamaandoption.constants.Constants;
import com.example.homeworkstreamaandoption.model.Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DepartmentServiceImpl implements DepartmentService {
    EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getLowestPaidEmployee(int department) {
        return employeeService.printEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new RuntimeException(Constants.ERR_EMPLOYEE_NOT_FOUND));
    }

    @Override
    public Employee getHighestPaidEmployee(int department) {
        return employeeService.printEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new RuntimeException(Constants.ERR_EMPLOYEE_NOT_FOUND));
    }

    @Override
    public List<Employee> printEmployeesForDepartment(int department) {
        return employeeService.printEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> printEmployeesByDepartments() {
        return Collections.unmodifiableList(employeeService.printEmployees().stream()
                .sorted(Comparator.comparingInt(e -> e.getDepartment()))
                .collect(Collectors.toList()));
    }
}