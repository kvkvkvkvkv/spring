package org.springframework.service.CoachTypes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.models.Coach;
import org.springframework.models.Fortune;
import org.springframework.stereotype.Component;


public class SwimCoach implements Coach {

    Fortune fortune;

    @Value("${name}")
    private String name;

    public String getName() {
        return name;
    }

    public SwimCoach(Fortune fortune) {
        this.fortune = fortune;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim daily";
    }

    @Override
    public String getDailyFortune() {
        return fortune.getDailyFortune();
    }


}
