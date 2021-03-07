package com.java.java8.service.staticMethods.modifierStaticMethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface B extends A {
    Logger log = LoggerFactory.getLogger(A.class);

    public static void m1(){
        log.info("B m2");
    }
}
