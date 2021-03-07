package org.springframework.service.Auto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Parent {

    String name;
//
//    public Parent(String name) {
//        this.name = name;
//    }

    public String getParentName(){
        return name;
    }
}
