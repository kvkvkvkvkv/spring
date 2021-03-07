package org.springframework.service.Auto.Primary;

import org.springframework.models.Medalist;
import org.springframework.service.customQualifier.Winner;
import org.springframework.service.customQualifier.Won;
import org.springframework.stereotype.Component;

@Component
@Winner(Won.SILVER)
public class Silver implements Medalist {

    @Override
    public String medal() {
        return "Silver in da house";
    }
}
