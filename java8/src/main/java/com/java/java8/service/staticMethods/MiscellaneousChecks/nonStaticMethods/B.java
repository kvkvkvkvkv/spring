package com.java.java8.service.staticMethods.MiscellaneousChecks.nonStaticMethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class B extends A {

    static Logger log = LoggerFactory.getLogger(A.class);

    public static void m1(){
        log.info("B m2");
    }
}
