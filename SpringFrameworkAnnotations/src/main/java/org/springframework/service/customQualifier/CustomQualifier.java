package org.springframework.service.customQualifier;

import com.sun.org.apache.xpath.internal.axes.WalkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.models.Fortune;
import org.springframework.models.Medalist;
import org.springframework.stereotype.Component;

@Component
public class CustomQualifier {

    @Autowired
    @Genre("silver")
    Medalist medalist;

    @Autowired
    @Medal
    Medalist medalist1;

    @Autowired
    @Winner(Won.SILVER)
    Fortune fortune;

    public String getMedal() {
        return medalist.medal();
    }

    public String getMedalist() {
        return medalist1.medal();
    }

    public Fortune getMedalistWon() {
        return fortune;
    }
}
