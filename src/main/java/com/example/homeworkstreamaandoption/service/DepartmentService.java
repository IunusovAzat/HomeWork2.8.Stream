package com.example.homeworkstreamaandoption.service;

import com.example.homeworkstreamaandoption.model.Employee;

import java.util.List;

public interface DepartmentService {
    Employee getLowestPaidEmployee(Integer department);

    Employee getHighestPaidEmployee(Integer department);

    List<Employee> printEmployeesForDepartment(Integer department);

    List<Employee> printEmployeesByDepartments();
}
