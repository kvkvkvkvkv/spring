package com.java.java8.service.AnonymousVsLambda.AnonymousImplementsInterface;

//Anonymous class can extend interface with multiple methods
//lambda cannot

public class Test {

    Anonymous abc = new Anonymous() {

        @Override
        public void abc() {

        }

        @Override
        public void def() {

        }
    };

    // Anonymous ano = new Test()::abc; - lambda does not allow
    //Multiple non-overriding abstract methods found in interface
    // com.java.java8.service.AnonymousVsLambda.AnonymousImplementsInterface.Anonymous

    public void test() {
//        Anonymous ano = () -> System.out.println("Lambda works");
//        ano.abc();
    }
}
