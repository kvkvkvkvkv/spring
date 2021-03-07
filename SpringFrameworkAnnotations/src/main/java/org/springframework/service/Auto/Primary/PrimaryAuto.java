package org.springframework.service.Auto.Primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.models.Coach;
import org.springframework.models.Medalist;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class PrimaryAuto {

    Logger log = Logger.getLogger("PrimaryAuto");

    @Autowired
    Medalist medalist;

    public String getMetal(){
        return this.medalist.medal();
    }
}
