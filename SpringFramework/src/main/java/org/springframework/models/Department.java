package org.springframework.models;

import lombok.Data;

import java.util.Set;

@Data
public class Department {

    String name;
    Set<Employee> employees;
}
