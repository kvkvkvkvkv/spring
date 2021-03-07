package com.java.java8.service.primitiveFI;

import com.java.java8.model.Employee;
import com.java.java8.model.Project;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.List;
import java.util.function.ToDoubleBiFunction;
import java.util.stream.Collectors;

@Service
public class PrimitiveBiFunction {

    //Output is fixed
    //Input is not known
    //applyAsInt/Double/Long
    //toIntBiFunction
    //toDoubleBiFunction
    //toLongBiFunction

    ToDoubleBiFunction<Employee, Project> sumSalary = (employee, project) -> Period.between(project.getStartDate(),employee.getStartDate()).getMonths()* employee.getSalary();

    public List<Employee> salary(List<Employee> employees){
        return employees.stream()
                .filter(employee -> sumSalary.applyAsDouble(employee,employee.getProject())>10000)
                .collect(Collectors.toList());
    }
}
