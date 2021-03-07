package com.java.java8.service.objectFI;

import com.java.java8.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    public Predicate<Employee> female = employee -> employee.getGender().equalsIgnoreCase("F");
    public Predicate<Employee> age = employee -> employee.getAge() >= 25;
    public Predicate<Employee> project = employee -> employee.getProject().getName().equals("Project 3");
    public Predicate<Employee> proj1 = employee -> employee.getProject().getName().equals("Project 1");
    public Predicate<Long> salary = Predicate.isEqual((long)2000);
    public Predicate<Employee> minSalary = employee -> employee.getSalary()>1000;


    //predicate
    public List<Employee> getFemaleEmployees(List<Employee> employees){
        return employees.stream().filter(employee -> female.test(employee)).collect(Collectors.toList());
    }

    //predicate
    public List<Employee> getEmployeesAbove25Age(List<Employee> employees){
        return employees.stream().filter(employee -> age.test(employee)).collect(Collectors.toList());
    }

    //predicate pairing - negate
    public List<Employee> getMaleEmployees(List<Employee> employees){
        return employees.stream().filter(employee -> female.negate().test(employee)).collect(Collectors.toList());
    }

    // predicate pairing - or
    public List<Employee> getEmployeesAbove25OrWorkingInProject3(List<Employee> employees){
        return employees.stream().filter(employee -> project.or(age).test(employee)).collect(Collectors.toList());
    }

    //function
    // predicate pairing - and
    public List<Employee> getFemaleEmpAbove25(List<Employee> employees){
        Function<List<Employee>,List<Employee>> getFemaleEmpAbove25 = employee -> employee.stream()
                .filter(emp -> female.and(age).test(emp))
                .collect(Collectors.toList());
        return getFemaleEmpAbove25.apply(employees);
    }

    //predicate pairing - isEqual()
    public  List<Employee> getEqualPayEmployees(List<Employee> employees){
        return employees.stream().filter(employee -> salary.test(employee.getSalary())).collect(Collectors.toList());
    }

    //function chaining - andThen()
    public List<Employee> salaryHikeForProject1orSalaryAbove1000(List<Employee> employees){
        Long hike = (long)1000;
        Function<List<Employee>,List<Employee>> project1 = employee -> employee.stream()
                .filter(proj1)
                .collect(Collectors.toList());

        Function<List<Employee>,List<Employee>> salary = employee -> employee.stream()
                .filter(minSalary)
                .collect(Collectors.toList());

        List<Employee> eligibleEmployees = project1.andThen(salary).apply(employees);

        eligibleEmployees.forEach(employee -> employee.setSalary(employee.getSalary()+hike));

        return eligibleEmployees;
    }

    //function chaining- compose
    public List<Employee> salaryHikeForProject1orSalaryAbove2000(List<Employee> employees){
        Long hike = (long)1000;
        Function<List<Employee>,List<Employee>> project1 = employee -> employee.stream()
                .filter(proj1)
                .collect(Collectors.toList());

        Function<List<Employee>,List<Employee>> salary = employee -> {
            List<Employee> list = new ArrayList<>();
            Predicate<Employee> employeePredicate = minSalary;
            for (Employee employee1 : employee) {
                if (employeePredicate.test(employee1)) {
                    list.add(employee1);
                }
            }
            return list;
        };

        List<Employee> eligibleEmployees = project1.compose(salary).apply(employees);

        eligibleEmployees.forEach(employee -> employee.setSalary(employee.getSalary()+hike));

        return eligibleEmployees;
    }

    //function - identity
    public List<Employee> getEmployeeNames(List<Employee> employees){
        Function<List<Employee>,List<Employee>> employee = Function.identity();
        return employee.apply(employees);
    }

    //consumer - accept
    //consumer chaining - andThen()
    public List<Employee> incrementAgeAndSalary(List<Employee> employees){
        Consumer<Employee> incrementAge = employee -> employee.setAge(employee.getAge()+1);
        Consumer<Employee> incrementSalary = employee -> employee.setSalary(employee.getSalary()+1000);

        employees.forEach(employee -> incrementAge.andThen(incrementSalary).accept(employee));

        return employees;
    }
}

