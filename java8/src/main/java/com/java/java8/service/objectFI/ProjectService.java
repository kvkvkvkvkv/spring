package com.java.java8.service.objectFI;

import com.java.java8.Java8Application;
import com.java.java8.model.Employee;
import com.java.java8.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    EmployeeService employeeService;

    Predicate<Project> periodGreaterThan5 = project -> project.getPeriod().getYears() >= 5;

    Function<List<Project>,List<Project>> getProjectsPeriodGreaterThan5Years = projects -> projects.stream()
            .filter(proj -> periodGreaterThan5.test(proj))
            .collect(Collectors.toList());

    BiPredicate<Employee,Project> hrInProject2 = (employee, project) -> project.getName().equals("Project 2") && employee.getDepartment().equalsIgnoreCase("HR");
    BiPredicate<Employee,Project> hrInProject1 = (emp,proj) -> emp.getDepartment().equals("HR") && proj.getName().equals("Project 1");
    BiPredicate<Employee,Project> salaryAbove3000 = (emp,proj) -> emp.getSalary()>3000 && proj.getTeamSize()>5;
    BiFunction<Employee,Project, Period> getEmpPeriodDiff = (employee, project) -> Period.between(project.getStartDate(),employee.getStartDate());
    BiConsumer<Employee,Project> salAndPeriod = (employee, project) -> {
        employee.setSalary(employee.getSalary()+1000);
        project.setPeriod(project.getPeriod().plusDays(5));
    };

    public List<Project> getAllProjects() {
        return Java8Application.projects;
    }

    //function
    //predicate
    public List<Project> getProjectsPeriodGreaterThan5Years (List<Project> project){
        return getProjectsPeriodGreaterThan5Years.apply(project);
    }

    //Function chaining
    public List<Employee> getMalesInProject1AndProject2 (List<Project> project){
        //male emp
        Function<List<Employee>,List<Employee>> male = employees -> employees.stream().
                filter(employee -> !employeeService.female.test(employee))
                .collect(Collectors.toList());

        //proj > 5 years and male
        Function<List<Employee>,List<Employee>> proj = employees -> employees.stream().
                filter(employee -> employee.getProject().getName().equalsIgnoreCase("Project 1")||employee.getProject().getName().equalsIgnoreCase("Project 2"))
                .collect(Collectors.toList());

        return male.andThen(proj).apply(Java8Application.employees);
    }

    //Supplier - get
    public List<Project> addNewProject(List<Project> project){
        Supplier<LocalDate> startDate = () -> LocalDate.of(2020,1,20);
        Supplier<Period> period = () -> Period.between(startDate.get(),LocalDate.now());
        Supplier<Project> proj4 = () -> new Project("Project 4",startDate.get(),period.get(),20);
        project.add(proj4.get());

        return project;
    }

    //bipredicate - test
    public List<Employee> getHrinProject1(List<Employee> employees){
        return employees.stream()
                .filter(emp -> hrInProject1.test(emp,emp.getProject()))
                .collect(Collectors.toList());
    }

    //bipredicate - or
    public List<Employee> getHrinProjec1orProject2(List<Employee> employees){
        return employees.stream()
                .filter(emp -> hrInProject1.or(hrInProject2).test(emp,emp.getProject()))
                .collect(Collectors.toList());
    }

    //bipredicate - negate
    public List<Employee> getnotHrInProject1(List<Employee> employees){
        return employees.stream()
                .filter(emp -> hrInProject1.negate().test(emp,emp.getProject()))
                .collect(Collectors.toList());
    }

    //bipredicate - and
    public List<Employee> getHrInProject1AndSalaryAbove3000(List<Employee> employees){
        return employees.stream()
                .filter(emp -> hrInProject1.and(salaryAbove3000).test(emp,emp.getProject()))
                .collect(Collectors.toList());
    }

    //bifunction - apply
    public List<Employee> getPeriodMoreThan5(List<Employee> employees){
        return employees.stream()
                .filter(emp -> getEmpPeriodDiff.apply(emp,emp.getProject()).getYears()>5)
                .collect(Collectors.toList());
    }

    //bifunction - andThen
    public List<Employee> getAllInProject1AndNameStartsWithS(List<Employee> employees){
        BiFunction<List<Employee>,List<Project>,List<Employee>> empInProject1 = (employee, project) -> employee.stream()
                .filter(emp -> emp.getName().startsWith("S"))
                .collect(Collectors.toList());

        BiFunction<Employee,Project,Employee> empInProject = (employee, project) -> {
            if (employee.getName().startsWith("S") && project.getName().equalsIgnoreCase("Project 2")) {
                employee.setSalary(employee.getSalary() + 1000);
            }
            return employee;
        };

        Function<Employee,Employee> employee = Function.identity();

        return employees.stream()
                .filter(emp -> empInProject.andThen(employee).apply(emp,emp.getProject()).getSalary()>3000)
                .collect(Collectors.toList());
    }

    //biConsumer - accept
    public void updateSalandPeriod(List<Employee> employees){
        employees.forEach(employee -> salAndPeriod.accept(employee,employee.getProject()));
    }

    //biConsumer - andThen
    public void updateAgeAndSize(List<Employee> employees){
        BiConsumer<Employee,Project> ageAndSize = (employee, project) -> {
            employee.setAge(employee.getAge()+1);
            project.setTeamSize(project.getTeamSize()+1);
        };

        employees.forEach(emp -> salAndPeriod.andThen(ageAndSize).accept(emp,emp.getProject()));
    }
}