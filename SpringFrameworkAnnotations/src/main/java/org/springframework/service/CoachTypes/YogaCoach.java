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

@Component //default
public class YogaCoach implements Coach {

    @Autowired
    @Qualifier("randomFortune")
    private Fortune fortune;

    Logger log = Logger.getLogger("YogaCoach");

    @Override
    public String getDailyWorkout() {
        return "Yoga coach";
    }

    @Override
    public String getDailyFortune() {
        return fortune.getDailyFortune();
    }

}
