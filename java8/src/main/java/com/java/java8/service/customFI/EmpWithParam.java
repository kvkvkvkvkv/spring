package com.java.java8.service.customFI;

import com.java.java8.model.Employee;

@FunctionalInterface
public interface EmpWithParam {

    Employee getEmployee(Employee emp);
}
