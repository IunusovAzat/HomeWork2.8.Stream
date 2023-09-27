package com.example.homeworkstreamaandoption.service;

import com.example.homeworkstreamaandoption.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int salary, Integer department);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Employee getLowestPaidEmployee(Integer department);
    Employee getHighestPaidEmployee(Integer department);
    List<Employee> printEmployeesForDepartment(Integer department);
    List<Employee> printEmployeesByDepartments();
    List<Employee> printEmployees();
    List<Employee> fillEmployeesList();
}
