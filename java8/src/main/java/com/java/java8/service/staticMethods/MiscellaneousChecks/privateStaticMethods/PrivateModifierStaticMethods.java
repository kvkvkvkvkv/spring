package com.java.java8.service.staticMethods.MiscellaneousChecks.privateStaticMethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class PrivateModifierStaticMethods extends B {

    static Logger log = LoggerFactory.getLogger(PrivateModifierStaticMethods.class);

    //private not allowed as class has public access
//    private static void m1(){
//        log.info("SameStaticMethods m2");
//    }

}
