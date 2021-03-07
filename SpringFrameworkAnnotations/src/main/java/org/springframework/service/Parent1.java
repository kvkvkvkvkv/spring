package org.springframework.service;

import org.springframework.stereotype.Component;

public class Parent1 {

    String name;

    public Parent1(String name) {
        this.name = name;
    }

    public String getParentName(){
        return name;
    }

    @Override
    public String toString() {
        return "Parent1{" +
                "name='" + name + '\'' +
                '}';
    }
}
