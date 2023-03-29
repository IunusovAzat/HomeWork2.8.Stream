package com.example.homeworkstreamaandoption.service;

import com.example.homeworkstreamaandoption.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private final List<Employee> employees;
    private final String ERR_EMPL_ALREADY_ADDED = "Сотрудник уже имеется в массиве";
    private final String ERR_EMPL_NOT_FOUND = "Сотрудник не найден";

    public EmployeeServiceImp(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, Integer department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.contains(employee)) {
            throw new RuntimeException(ERR_EMPL_ALREADY_ADDED);
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        final Optional<Employee> employee = employees.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findAny();
        return employee.orElseThrow(() -> new RuntimeException(ERR_EMPL_NOT_FOUND));
    }

    @Override
    public Employee getLowestPaidEmployee(Integer department) {
        return null;
    }

    @Override
    public Employee getHighestPaidEmployee(Integer department) {
        return null;
    }

    @Override
    public List<Employee> printEmployeesForDepartment(Integer department) {
        return null;
    }

    @Override
    public List<Employee> printEmployeesByDepartments() {
        return null;
    }

    @Override
    public List<Employee> printEmployees() {
        return Collections.unmodifiableList(employees);
    }

    @Override
    public List<Employee> fillEmployeesList() {
        employees.add(new Employee("Maria", "Sharapova", 8_000, 2));
        employees.add(new Employee("Vasya", "Pupkin", 10_000, 1));
        employees.add(new Employee("Oleg", "Ivanov", 20_000, 1));
        employees.add(new Employee("Rafa", "Nadal", 100_000, 2));
        employees.add(new Employee("Roger", "Federer", 120_000, 2));
        employees.add(new Employee("Ivan", "Urgant", 30_000, 1));
        return employees;
    }
}
