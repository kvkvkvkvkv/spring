package org.springframework.service.Auto.AutoTypes;

import org.springframework.service.Auto.Parent;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AutowiredTypes {

    Logger log = Logger.getLogger("AutowiredTypes");

    Parent parent;

    //get's called even though no autowire is there
    //and multiple constructors
    public AutowiredTypes() {
        log.info("called default on own even though multiple constructors are present");
    }

    public AutowiredTypes(Parent parent) {
        log.info("called parameter");
        this.parent = parent;
    }
}
