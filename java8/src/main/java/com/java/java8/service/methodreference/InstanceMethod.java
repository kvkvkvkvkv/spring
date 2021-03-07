package com.java.java8.service.methodreference;

import com.java.java8.Java8Application;
import com.java.java8.model.Employee;
import com.java.java8.service.customFI.Emp;
import com.java.java8.service.customFI.EmpWithParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.UnaryOperator;

@Service
public class InstanceMethod {

    static Logger log = LoggerFactory.getLogger(StaticMethodReference.class);

    //return type of FI and static method needs to be the same

    //custom FI
    //no parameter method
    //FI has no parameter
    public Employee emp(){
        return Java8Application.employees.get(0);
    }

    public Employee staticTest() {
        Emp emp = new InstanceMethod()::emp;
        return emp.getEmployee();
    }

    //custom FI
    //fi has parameter

    public Employee empWithParams(Employee emp){
        return emp;
    }

    public Employee staticTestWithParams() {
        EmpWithParam empWithParams = new InstanceMethod()::empWithParams;
        return empWithParams.getEmployee(Java8Application.employees.get(0));
    }

    //predefined FI
    public void empWithPredefinedFI(){
        log.info("Thread Runnnin instance.....");
    }

    public void staticTestWithPredefinedFI() {
        Runnable thread = new InstanceMethod()::empWithPredefinedFI;
        new Thread(thread).start();
    }

    //predefined FI
    //int binary operator
    public Integer sum(int a , int b) {
        return a+b;
    }

    public Integer staticTestWithPredefinedFIBinaryOperator() {
        IntBinaryOperator add = new InstanceMethod()::sum;
        return add.applyAsInt(2,4);
    }

    //overloading static methods

    public static Employee getEmp(Employee emp){
        return emp;
    }

    public static Employee getEmp(List<Employee> employees){
        return employees.stream()
                .filter(employee -> employee.getSalary()>3000)
                .findFirst().get();
    }

    public void staticTestWithOverloading() {
        IntBinaryOperator add = StaticMethodReference::sum;
        UnaryOperator<Employee> emp = StaticMethodReference::getEmp;
        log.info(emp.apply(Java8Application.employees.get(0)).toString());

        Function<List<Employee>,Employee> emp1 = StaticMethodReference::getEmp;
        emp1.apply(Java8Application.employees);
        log.info(emp1.apply(Java8Application.employees).toString());
    }
}
