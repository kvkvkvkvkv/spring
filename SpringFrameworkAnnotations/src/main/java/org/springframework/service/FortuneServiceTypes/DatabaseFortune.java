package org.springframework.service.FortuneServiceTypes;

import org.springframework.models.Fortune;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Logger;

@Component
public class DatabaseFortune implements Fortune {

   Logger log = Logger.getLogger("DatabaseFortune");

    @Override
    public String getDailyFortune() {
        return "Database Fortune called";
    }

    @PostConstruct
    public void init(){
        log.info("iniiitttt");
    }

    @PreDestroy
    public void destroy(){
        log.info("destroy...scope is singleton so called automatically");
    }
}
