package org.springframework.service.FortuneServiceTypes;

import org.springframework.models.Fortune;
import org.springframework.stereotype.Component;

@Component
public class FortuneService implements Fortune {

    @Override
    public String getDailyFortune() {
        return "1% improvement";
    }
}
