package org.springframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.models.Fortune;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Logger;

@Component
@Scope("prototype")
public class BeanScope {

    Logger log = Logger.getLogger("BeanScope");

    @Autowired
    @Qualifier("randomFortune")
    Fortune fortune;

    @PostConstruct
    public void init(){
        log.info("iniiitttt");
    }

    @PreDestroy
    public void destroy(){
        log.info("destroy...scope is protoype so never called");
    }
}
