package org.springframework.service.Auto.AutoTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.models.Fortune;
import org.springframework.service.Auto.Parent;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

//all autowired
//can only mark one constructor with autowired
//or mark all as false the one wirh greatest satisfying dependecy chosen
//if one is true others false get error
@Component
public class AutoAll {

    Parent parent;
    Fortune fortune;
    String name;

    Logger log = Logger.getLogger("AutoAll");

    @Autowired(required = false)
    public AutoAll(Parent parent, String name, Fortune fortune) {
        this.parent = parent;
        this.name = name;
        this.fortune = fortune;
        log.info("in AutoAll(Parent parent, String name, Fortune fortune)");
    }

    @Autowired(required = false)
    public AutoAll(Parent parent) {

        log.info("in AutoAll(Parent parent)");
        this.parent = parent;
    }

    @Autowired(required = false)
    public AutoAll(Fortune fortune, String name) {
        this.fortune = fortune;
        this.name = name;
        log.info("in AutoAll(Fortune fortune, String name");
    }

    @Autowired(required = false)
    public AutoAll(Parent parent,Fortune fortune) {
        this.parent = parent;
        this.fortune = fortune;
        log.info("in AutoAll(Parent parent, Fortune fortune)");
    }

    @Autowired(required = false)
    public AutoAll() {
        log.info(" in AutoAll");
    }
}
