package org.springframework.service.DI;

import lombok.Data;
import org.springframework.service.ToDoListService;
import org.springframework.service.UserService;

import java.beans.ConstructorProperties;
import java.util.logging.Logger;

@Data
public class ConstructorDI {

    static final Logger LOG = Logger.getLogger(ConstructorDI.class.getName());

    private int age;
    private int number;
    private ToDoListService toDoListService;
    private UserService userService;

    public ConstructorDI(int age, ToDoListService toDoListService, UserService userService) {
        LOG.info("inside constructor");
        this.age = age;
        this.toDoListService = toDoListService;
        this.userService = userService;
    }

    public ConstructorDI(int age, int number) {
        LOG.info("inside constructor");

        this.age = age;
        this.number = number;
    }

    //no need to define the property name
    @ConstructorProperties({"test"})
    public ConstructorDI(int test) {
        LOG.info("inside constructor");
        this.age = age;
    }
}
