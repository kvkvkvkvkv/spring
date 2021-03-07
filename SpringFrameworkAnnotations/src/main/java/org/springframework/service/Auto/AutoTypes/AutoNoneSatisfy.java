package org.springframework.service.Auto.AutoTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.models.Fortune;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

//all autowired
//none of the dependencies are satisfied if no default contructor present
//then error is thrown else default/primary is called
@Component
public class AutoNoneSatisfy {

    Fortune fortune;
    String name;

    Logger log = Logger.getLogger("AutoNoneSatisfy");

    @Autowired(required = false)
    public AutoNoneSatisfy(String name, Fortune fortune) {
        this.name = name;
        this.fortune = fortune;
        log.info("in AutoNoneSatisfy(String name, Fortune fortune)");
    }

    @Autowired(required = false)
    public AutoNoneSatisfy(Fortune fortune) {
        this.fortune = fortune;
        log.info("in AutoNoneSatisfy( Fortune fortune)");
    }

    @Autowired(required = false)
    public AutoNoneSatisfy(String name) {
        this.name = name;
        log.info("in AutoNoneSatisfy(String name)");
    }

        @Autowired(required = false)
    public AutoNoneSatisfy() {
        log.info(" in AutoNoneSatisfy");
    }

}
