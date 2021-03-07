package com.java.java8.service.staticMethods.SameStaticMethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface A {

    Logger log = LoggerFactory.getLogger(A.class);

    static void m1(){
        log.info("A m1");
    }
}
