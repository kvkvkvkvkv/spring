package com.java.java8.service.operatorFIprimitiveandobject;

import com.java.java8.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

@Service
public class BinaryOperatorFI {

    //used when T,U,R all are same
    //minBy maxBy
    //apply

    public Integer ageAdd(List<Employee> employees){
        BinaryOperator<Integer> age = Integer::sum;
        return age.apply(10,20);
    }

    //minBy
    public Employee sortSalary(List<Employee> employees){
        BinaryOperator<Employee> minEmp = BinaryOperator.minBy(Comparator.comparing(Employee::getSalary));
        return minEmp.apply(employees.get(0),employees.get(1));
    }

    //primitive operator
    //DoubleBinaryOperator
    //LongBinaryOperator
    //applyAsInt/Double/Long
    public Integer addAge(List<Employee> employees){
        IntBinaryOperator age = Integer::sum;
        return age.applyAsInt(10,20);
    }

}
