package org.springframework.service.FortuneServiceTypes;

import org.springframework.models.Fortune;
import org.springframework.service.customQualifier.Winner;
import org.springframework.service.customQualifier.Won;


@Winner(Won.SILVER)
public class HappyFortuneService implements Fortune {

    @Override
    public String getDailyFortune() {
        return "Happy day.......";
    }
}
