package com.java.java8.service.defaultMethods.hasOverridedDefaultMethods;

import com.java.java8.service.defaultMethods.hasDiffDefaultMethods.A;
import com.java.java8.service.defaultMethods.hasDiffDefaultMethods.B;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HasOverriddenDefaultMethods implements A, B {

    Logger log = LoggerFactory.getLogger(HasOverriddenDefaultMethods.class);

    @Override
    public void m2(){
        log.info("HasOverriddenDefaultMethods m2");
    }

    @Override
    public void m1(){
        log.info("HasOverriddenDefaultMethods m1");
    }

    public void call(){
        HasOverriddenDefaultMethods obj = new HasOverriddenDefaultMethods();
        obj.m1();
        obj.m2();
        A.super.m1();
        B.super.m2();
    }
}
