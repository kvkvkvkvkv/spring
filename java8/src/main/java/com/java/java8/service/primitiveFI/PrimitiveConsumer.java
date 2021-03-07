package com.java.java8.service.primitiveFI;

import com.java.java8.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.LongConsumer;
import java.util.function.ObjIntConsumer;

@Service
public class PrimitiveConsumer {

    //IntConsumer/Double/Long
    //accept
    //andThen

    LongConsumer salary = System.out::println;

    public void salary(List<Employee> employees) {
        employees.forEach(employee -> salary.accept(employee.getSalary()));
    }

    //biconsumer
    //ObjLongConsumer
    //ObjDoubleConsumer
    //accept

    public ObjIntConsumer<Double> multiplication = (num1,num2) -> System.out.println(num1*num2);
}
