package org.springframework.service;

//beans are lazy
//if a lazy bean is dependency of non lazy one then the lazy bean is initialised in start

import lombok.Data;

@Data
public class AutowiringModes {

    private UserService userService;

    public AutowiringModes() {

    }

    public AutowiringModes(UserService userService) {
        this.userService = userService;
    }
}
