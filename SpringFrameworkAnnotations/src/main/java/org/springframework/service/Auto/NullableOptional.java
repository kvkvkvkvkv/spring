package org.springframework.service.Auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.models.Coach;
import org.springframework.models.Fortune;
import org.springframework.service.Parent1;
import org.springframework.stereotype.Component;

//similar to required
@Component
public class NullableOptional {

    Parent1 parent1;
    Fortune fortune;

//    public NullableOptional(@Qualifier("parentOne") Parent1 parent1, @Nullable Fortune fortune) {
//        this.parent1 = parent1;
//        this.fortune = fortune;
//    }

}
