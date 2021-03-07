package org.springframework.service.CoachTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.models.Coach;
import org.springframework.models.Fortune;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Logger;

//@Component("tennis") explicitly
@Component //default
public class TennisCoach implements Coach {

    @Autowired //error nounique bean found so use qualifirer
    @Qualifier("randomFortune")
    private Fortune fortune;

    @Autowired //error nounique bean found so use qualifirer
    @Qualifier("databaseFortune")
    private Fortune fortune1;

    private Fortune fortune2;

    private Fortune fortune3;

    @Value("${name}")
    private String name;

    @Autowired
    @Qualifier("happyFortune")
    @Required //not used
    public void setFortune3(Fortune fortune3) {
        this.fortune3 = fortune3;
    }

    Logger log = Logger.getLogger("TennisCoach");

    @Autowired //qualifier inside constructor
    public TennisCoach(@Qualifier("fortuneService") Fortune fortune) {
        this.fortune2 = fortune;
    }

    @Override
    public String getDailyWorkout() {
        return "Tennis coach";
    }

    @Override
    public String getDailyFortune() {
        log.info("Can add multiple qualifiers by autowiring="+fortune1.getDailyFortune());
        log.info("Can add qualifiers in parameter by autowiring in constructor="+fortune2.getDailyFortune());
        return fortune.getDailyFortune();
    }
//
//    @Autowired //not req as only single constructor is present
//    public TennisCoach(Fortune fortune) {
//        log.info("Constructor");
//        this.fortune = fortune;
//    }
//
//    @Autowired
//    public void setFortune(Fortune fortune) {
//        log.info("Setter");
//        this.fortune = fortune;
//    }
//
//    @Autowired
//    public void methodInjection(Fortune fortune){
//        log.info("Method");
//        this.fortune = fortune;
//    }
//
//    @Autowired
//    public Fortune mathodInjection(Fortune fortune){
//        log.info("Method with return type");
//        this.fortune = fortune;
//        return fortune;
//    }


    public String getNameProperty(){
        return this.name;
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
