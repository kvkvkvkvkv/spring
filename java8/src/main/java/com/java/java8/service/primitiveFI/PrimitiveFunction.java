package com.java.java8.service.primitiveFI;

import com.java.java8.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.*;

@Service
public class PrimitiveFunction {

    //Long Double
    //Input fixed output your choice
    // only apply

    private static Logger log = LoggerFactory.getLogger(PrimitiveFunction.class);
    LongFunction<Integer> salary = sal -> (int)sal;

    public List<Employee> salary(List<Employee> employees) {
        employees.forEach(employee -> employee.setSalary(Long.valueOf(salary.apply(employee.getSalary()))));

        return employees;
    }

    //toIntFunction toDoubleFunction toLongFunction
    //Output fixed
    // only applyAsInt/Double/Long

    public int year() {
        ToIntFunction<Long> sal = Math::toIntExact;
        return sal.applyAsInt((long)2000.00);
    }


    //output and input specified
    //IntToDoubleFunction
    //IntToLongFunction
    //LongToIntFunction
    //LongToDoubleFunction
    //DoubleToIntFunction
    //DoubleToLongFunction
    //applyAsint/Double/long

    IntToDoubleFunction piMulti = number -> number*3.14;

    public double number(){
        return piMulti.applyAsDouble(10);
    }
}
