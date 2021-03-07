package com.java.java8.service.staticMethods.MiscellaneousChecks.nonStaticMethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

//Instance method 'm1()' in 'com.java.java8.service.staticMethods.MiscellaneousChecks.nonStaticMethods.nonStaticMethods'
//cannot override static method 'm1()' in 'com.java.java8.service.staticMethods.MiscellaneousChecks.nonStaticMethods.B'

@Service
public class nonStaticMethods extends B {

    static Logger log = LoggerFactory.getLogger(nonStaticMethods.class);

    //non static overriding not allowed when parent has static method defined
//     public void m1(){
//        log.info("SameStaticMethods m2");
//    }

}
