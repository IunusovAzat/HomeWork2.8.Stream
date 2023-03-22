package com.example.homeworkstreamaandoption.service;

import com.example.homeworkstreamaandoption.model.Employee;

import java.util.List;

public interface DepartmentService {
    Employee getLowestPaidEmployee(int department);

    Employee getHighestPaidEmployee(int department);

    List<Employee> printEmployeesForDepartment(int department);

    List<Employee> printEmployeesByDepartments();
}
