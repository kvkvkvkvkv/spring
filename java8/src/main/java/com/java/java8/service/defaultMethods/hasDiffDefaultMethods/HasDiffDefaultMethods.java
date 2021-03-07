package com.java.java8.service.defaultMethods.hasDiffDefaultMethods;

import org.springframework.stereotype.Service;

@Service
public class HasDiffDefaultMethods implements A,B{

    public void call(){
        HasDiffDefaultMethods obj = new HasDiffDefaultMethods();
        obj.m1();
        obj.m2();
        m2();
        m1();
    }
}
