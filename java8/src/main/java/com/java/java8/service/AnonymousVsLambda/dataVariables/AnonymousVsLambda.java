package com.java.java8.service.AnonymousVsLambda.dataVariables;

//Anonymous class can extend interface with single methods
//lambda can be implemented only in this case

// one the variables declared within the method where lambda
//is present is effectively final
//global variables and local within the lambda are NOT final
//cannot change the effectively final variable in any point in the method

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AnonymousVsLambda {

    Logger log = LoggerFactory.getLogger(AnonymousVsLambda.class);

    public int x = 100;
    public int z = 200;
    public static int w = 10;

    Anonymous abc = new Anonymous() {
        int x = 10;

        @Override
        public void abc() {
            log.info("This.x = "+this.x);
            log.info("Test class x = "+AnonymousVsLambda.this.x);
        }
    };

    public void test() {
        log.info("......Anonymous class......");
        abc.abc();
        int y = 10; // effectively final
        y = y+1;
        log.info("......Lambda......");
        int finalY = y;
        Anonymous ano = () -> {
            log.info("Lambda works");
            int x = 20;
            //int y = 90; cannot redeclare variable
            log.info("This.x ="+this.x);
            log.info("x ="+x);
            x= x+20;
            this.x = this.x+30;
            log.info("x changes ="+x);
            log.info("This.x changes="+this.x);

            z = z+80;
            log.info("z ="+z);
            log.info("This.z ="+this.z);

            System.out.println(finalY);
            w = w+30;

//            y = y+30; - Variable used in lambda expression should be final or effectively final
        };
        ano.abc();

        y = y+5;
    }

}
