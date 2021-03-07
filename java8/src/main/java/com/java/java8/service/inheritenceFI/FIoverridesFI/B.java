package com.java.java8.service.inheritenceFI.FIoverridesFI;

//B overrides A
// no errors as it is same method

@FunctionalInterface
public interface B extends A {
    void abc();
}
