package org.springframework.models;

import lombok.Data;
import java.util.Set;

@Data
public class User {
    private String name;
    private Set<ToDoList> toDoList;
}
