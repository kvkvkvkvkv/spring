package org.springframework.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.models.Coach;
import org.springframework.models.Fortune;
import org.springframework.service.Auto.Parent;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.logging.Logger;

@Component
@Data
public class Required {

    String name;

    Logger log = Logger.getLogger("Required");

    @org.springframework.beans.factory.annotation.Required
    public void setName(String name) {
        this.name = name;
    }

    Fortune fortune;


//on;y fpr setters not constructors
//    @Autowired No qualifying bean of type 'org.springframework.models.Fortune' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Qualifier(value=requiredFortuneService)}
    @Autowired(required = false) //will not hrow error
    public void setFortune( @Qualifier("requiredFortuneService") Fortune fortune) {
        this.fortune = fortune;
    }

    //other ways
//    @Nullable
//    Optional



}
