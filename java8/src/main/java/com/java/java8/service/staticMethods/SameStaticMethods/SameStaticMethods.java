package com.java.java8.service.staticMethods.SameStaticMethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

//case 1 - allowed as no overriding for static
//case 2 - class can have method as static has no overriding

//if parent class was static and child wasn't throws error
//not in case of interface

@Service
public class SameStaticMethods implements A, B {

    static Logger log = LoggerFactory.getLogger(SameStaticMethods.class);

    static void m1(){
        log.info("SameStaticMethods m2");
    }

    public void call(){
        A.m1();
        B.m1();
        m1();
    }
}
