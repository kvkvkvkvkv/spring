package com.java.java8.service.AnonymousVsLambda.AnonymousImplementsMultipleMethoInterface;

//Anonymous class can extend interface with single methods
//lambda can be implemented only in this case

public class Test {

    Anonymous abc = new Anonymous() {

        @Override
        public void abc() {

        }
    };

    public void test() {
        Anonymous ano = () -> System.out.println("Lambda works");
        ano.abc();
    }

}
