package org.springframework.models;

import lombok.Data;

import java.util.Set;

@Data
public class ToDoList {
    private String name;
    private Set<User> user;
}