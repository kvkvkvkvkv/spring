package com.java.java8.service.inheritenceFI.FIaddsmethod;

//B extends A no error
//now both have same method

/* ERROR - Multiple non-overriding abstract methods found in
 interface com.java.java8.service.inheritenceFI.FIaddsmethod.B*/

//functional interface has more than 1 method one from
//extended interface and other of it's own i.e def so error

@FunctionalInterface
public interface B extends A {
//    void def();
}
