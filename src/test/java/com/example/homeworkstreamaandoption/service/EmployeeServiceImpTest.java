package com.example.homeworkstreamaandoption.service;

import com.example.homeworkstreamaandoption.model.Employee;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class EmployeeServiceImpTest {

    private final EmployeeServiceImp employeeServiceImp = new EmployeeServiceImp( new ValidatorService());

    @ParameterizedTest
    @MethodSource("params")
    public void addNegativeTest(String firstName,
                                String lastName,
                                int department,
                                int salary){
        Employee expected = new Employee(firstName,lastName,department,salary);

        assertThat(employeeServiceImp.addEmployee(firstName,lastName,department,salary)).isEqualTo(expected);

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(()-> {
            employeeServiceImp.addEmployee(firstName, lastName, department, salary);
        });
    }

    public static Stream<Arguments> params(){
        return Stream.of(
                Arguments.of("Юрий", "Петров", 1, 93000),
                Arguments.of("Анатолий", "Гагарин", 2, 6800),
                Arguments.of("Алена", "Витоева", 4, 87000)
        );
    }


}
