package com.java.java8.service.defaultMethods.hasOverridedDefaultMethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface A {

    Logger log = LoggerFactory.getLogger(A.class);

    default void m1(){

        log.info("super A m1");
    }
}
