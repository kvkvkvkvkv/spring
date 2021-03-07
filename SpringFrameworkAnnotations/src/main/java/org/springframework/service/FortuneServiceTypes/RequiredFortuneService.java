package org.springframework.service.FortuneServiceTypes;

import org.springframework.models.Fortune;

public class RequiredFortuneService implements Fortune {

    @Override
    public String getDailyFortune() {
        return "Required not injected.......";
    }
}
