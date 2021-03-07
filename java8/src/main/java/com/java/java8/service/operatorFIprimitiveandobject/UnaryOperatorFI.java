package com.java.java8.service.operatorFIprimitiveandobject;

import com.java.java8.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

@Service
public class UnaryOperatorFI {

    //i/p and o/p are the ssame
    //like function

    public UnaryOperator<List<Employee>> emp = employees -> employees.stream()
            .filter(e -> e.getSalary()<3000)
            .collect(Collectors.toList());

    //compose
    //andThen
    //identity
    //apply
    public IntUnaryOperator sum = value -> value + value;

}
