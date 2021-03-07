package com.java.java8.service.defaultMethods.UnrealtedInterfaceDefaultMethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

// throws error as unrelated interface have same method m1
//so conflict occurs

//Solutions
//1) Override the method in child
//2) Override + Specify implemtation
@Service
public class UnrelatedDefaultMethods implements A, B {

    Logger log = LoggerFactory.getLogger(UnrelatedDefaultMethods.class);

    //Solution 1
    @Override
    public void m1() {

        //solution 2
        A.super.m1();
    }

    public void call(){

    }
}

