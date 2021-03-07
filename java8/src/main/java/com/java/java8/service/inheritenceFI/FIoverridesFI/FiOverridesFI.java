package com.java.java8.service.inheritenceFI.FIoverridesFI;

import com.java.java8.service.inheritenceFI.FIaddsmethod.A;
import com.java.java8.service.inheritenceFI.FIextednsFI.FiExtendsFiWithoutOverriding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FiOverridesFI implements B{

    private final Logger log = LoggerFactory.getLogger(FiOverridesFI.class);

    @Override
    public void abc() {
        log.info("In..FiOverridesFI");
    }

    public void callMethod() {
        A a = new FiOverridesFI()::abc;
        a.abc();

        B b = new FiOverridesFI();
        b.abc();
    }
}
