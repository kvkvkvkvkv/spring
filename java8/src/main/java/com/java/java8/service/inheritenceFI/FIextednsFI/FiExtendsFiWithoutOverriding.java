package com.java.java8.service.inheritenceFI.FIextednsFI;

import com.java.java8.service.inheritenceFI.FIaddsmethod.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FiExtendsFiWithoutOverriding implements B{

    private final Logger log = LoggerFactory.getLogger(FiExtendsFiWithoutOverriding.class);

    @Override
    public void abc() {
        log.info("In fi Extends Fi Without Overriding");
    }

    public void callMethod() {
        A a = new FiExtendsFiWithoutOverriding()::abc;
        a.abc();
    }
}
