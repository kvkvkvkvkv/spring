package org.springframework.service.Auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.models.Fortune;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class NoPrimaryNoQualifier {

    //does not throw error as does name matching
    //find directly
    //without having to use qualifier/autowired/primary
    //chekcs by name but resource is better to do this than autowired
    // though will work with autowired resouse does a betetr job to find by name
    //auto wired - const/setter/field/,method
//    resource - field/setter
//    hence use qualifier/primary/auto when required


//    @Autowired
    @Resource
    Fortune fortuneService;


    //qualifier can be used to choose which ref is used in collection
//    autowired can do self reference which is least precedence
//    bean referring another in config too is self reference
}
