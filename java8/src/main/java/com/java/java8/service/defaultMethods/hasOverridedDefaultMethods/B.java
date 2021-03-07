package com.java.java8.service.defaultMethods.hasOverridedDefaultMethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface B {
    Logger log = LoggerFactory.getLogger(B.class);

    default void m2(){
        log.info("super B m2");
    }
}
