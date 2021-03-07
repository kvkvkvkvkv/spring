package org.springframework.service.Auto.AutoTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.service.Auto.Parent;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AutoMultipleAnnotation {

    Logger log = Logger.getLogger("AutoMultipleAnnotation");

    Parent parent;

    public AutoMultipleAnnotation() {
        log.info("called deafult ");
    }

    //only this will get called as autowired
    @Autowired
    public AutoMultipleAnnotation(Parent parent) {
        log.info("called paramenter as autowired");
        this.parent = parent;
    }
}
