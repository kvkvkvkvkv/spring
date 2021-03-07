package org.springframework.service.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.models.Department;
import org.springframework.models.Employee;
import org.springframework.models.ToDoList;
import org.springframework.service.ToDoListService;
import org.springframework.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public class EmployeeService {

    private ToDoList toDoList;

    private ToDoListService toDoListService;

    private Employee employee;
    private ProjectService projectService;

    @Autowired
    UserService userService;

    @Autowired //array of userservices
    ProjectService[] projectServices;

    @Autowired //use on typed collections
    List<ProjectService> projectServicesList;

    @Autowired
    Map<String,ProjectService> map;

    //deprecated
    //use required with autowired
    //if not present throws exception
    //do not use
    @Required
    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    //autowired on property
    //constructor
    //setter
    //@Inject is used more
    //can be used on multiple parameter conatructors/methods/setter

    //not required if only one constructor is present
    //if multiple are present and none have qualifier/primary then atleast one should be annotated with autowired
    //default required is true
    //mark as false will not throw error
    @Autowired //used on constructor
    public EmployeeService(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @Autowired //used on constructor
    public EmployeeService(ToDoListService toDoListService, UserService userService) {
        this.toDoListService = toDoListService;
        this.userService = userService;
    }

    @Autowired //used on constructor
    public EmployeeService(ToDoListService toDoListService, Employee employee) {
        this.toDoListService = toDoListService;
        this.employee = employee;
    }

    @Autowired //used on constructor
    public EmployeeService(ToDoListService toDoListService,ProjectService projectService, Employee employee) {
        this.toDoListService = toDoListService;
        this.projectService = projectService;
        this.employee = employee;
    }

    @Autowired //on setter
    public void setToDoListService(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @Autowired //multiple parameter autowired method setter
    public void prepare(Employee employee, ProjectService projectService) {
        this.employee = employee;
        this.projectService = projectService;
    }




}
