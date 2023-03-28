package com.example.homeworkstreamaandoption.service;

import com.example.homeworkstreamaandoption.constants.Constants;
import com.example.homeworkstreamaandoption.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public abstract class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getLowestPaidEmployee(Integer department) {
        return employeeService.printEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new RuntimeException(Constants.ERR_EMPLOYEE_NOT_FOUND));
    }

    @Override
    public Employee getHighestPaidEmployee(Integer department) {
        return employeeService.printEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException(Constants.ERR_EMPLOYEE_NOT_FOUND));
    }

    @Override
    public List<Employee> printEmployeesForDepartment(Integer department) {
        return employeeService.printEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> printEmployeesByDepartments() {
        return Collections.unmodifiableList(employeeService.printEmployees().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .collect(Collectors.toList()));
    }
}