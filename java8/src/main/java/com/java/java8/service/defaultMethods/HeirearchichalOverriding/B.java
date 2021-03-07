package com.java.java8.service.defaultMethods.HeirearchichalOverriding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface B extends A{
    Logger log = LoggerFactory.getLogger(A.class);

    @Override
    default void m1(){
        log.info("B m1");
    }
    default void m2(){
        log.info("B m2");
    }
}
