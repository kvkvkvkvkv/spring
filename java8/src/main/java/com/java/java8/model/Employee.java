package com.java.java8.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

public class Employee {

    private String name;
    private Long salary;
    private String department;
    private Integer age;
    private String gender;
    private LocalDate startDate;
    private Project project;

    public Employee(String name, Long salary, String department, Integer age, String gender,LocalDate startDate, Project project) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.age = age;
        this.gender = gender;
        this.startDate = startDate;
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", startDate=" + startDate +
                ", project=" + project +
                '}';
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
