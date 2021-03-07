package com.java.java8.service.primitiveFI;

import com.java.java8.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

@Service
public class PrimitivePredicates {

    //DoublePredicate LongPredicate
    //input is fixed autoboxing and unboxing reduces
    //improves performance
    //no isequal only default and/or/negate

    IntPredicate ageGreaterThan20 = age -> age >20;
    IntPredicate age25 = age -> age < 25;

    public List<Employee> greaterThan20(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> ageGreaterThan20.test(employee.getAge()))
                .collect(Collectors.toList());
    }

    public List<Employee> greaterThan20AndLess25(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> ageGreaterThan20.and(age25).test(employee.getAge()))
                .collect(Collectors.toList());
    }

    public List<Employee> greaterThan20OrLess25(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> ageGreaterThan20.or(age25).test(employee.getAge()))
                .collect(Collectors.toList());
    }
}
