package com.java.java8.service.defaultMethods.HeirearchichalOverriding;

import com.java.java8.service.defaultMethods.hasOverridedDefaultMethods.HasOverriddenDefaultMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HeirarchicalOverridingDefaultMethods implements A, B {

    Logger log = LoggerFactory.getLogger(HeirarchicalOverridingDefaultMethods.class);

    @Override
    public void m1(){
        log.info("HeirarchicalOverridingDefaultMethods m1");
    }

    public void call(){
        HeirarchicalOverridingDefaultMethods obj = new HeirarchicalOverridingDefaultMethods();
        obj.m1();
        //calls B method as m2 is not overridden in this class
        obj.m2();
        m2();
        m1();

        //A.super.m1(); - error as only allowed to access immediate super inteface
        B.super.m1();
        B.super.m2();
    }
}
