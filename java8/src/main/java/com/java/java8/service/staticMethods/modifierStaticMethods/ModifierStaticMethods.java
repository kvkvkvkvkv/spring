package com.java.java8.service.staticMethods.modifierStaticMethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

// modifier of ModifierStaticMethods class is smaller
// allowed only for static of interface
// otherwise throws error

@Service
public class ModifierStaticMethods implements A, B {

    static Logger log = LoggerFactory.getLogger(ModifierStaticMethods.class);

    //private but allowed
    private static void m1(){
        log.info("SameStaticMethods m2");
    }

    public void call(){
        A.m1();
        B.m1();
        m1();
    }
}
