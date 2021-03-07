package org.springframework.service;
//can be created in 3 types
// constructor, static factory, instance factory

public class InstanceBean {

    //constructor done via bean def in xml
    //static factory
    private static UserService userService = new UserService();

    //instance factory
    private UserService userService1 = new UserService();

    public UserService createInstance() {
        return userService1;
    }

    public static UserService createStaticInstance() {
        return userService;
    }


}
