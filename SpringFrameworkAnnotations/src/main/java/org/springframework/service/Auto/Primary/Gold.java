package org.springframework.service.Auto.Primary;

import org.springframework.context.annotation.Primary;
import org.springframework.models.Medalist;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Gold implements Medalist {

    @Override
    public String medal() {
        return "Gold in da house";
    }
}
