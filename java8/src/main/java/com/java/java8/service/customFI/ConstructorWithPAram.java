package com.java.java8.service.customFI;

@FunctionalInterface
public interface ConstructorWithPAram<T,U> {

    T constructor(U param);
}
