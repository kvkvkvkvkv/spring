package com.java.java8.service.defaultMethods.hasDiffDefaultMethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface B {
    Logger log = LoggerFactory.getLogger(A.class);

    default void m2(){
        log.info("B m2");
    }
}
