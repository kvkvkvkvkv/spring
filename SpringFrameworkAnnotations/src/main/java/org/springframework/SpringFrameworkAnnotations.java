package org.springframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.service.Auto.Primary.PrimaryAuto;
import org.springframework.service.Configs.AnnotationConfig;
import org.springframework.service.Auto.ListArrayAuto;
import org.springframework.service.Configs.ListArrayConfig;
import org.springframework.service.BeanScope;
import org.springframework.service.Configs.ValueConfig;
import org.springframework.service.Required;
import org.springframework.service.CoachTypes.TennisCoach;
import org.springframework.service.Value.ValueAnno;
import org.springframework.service.customQualifier.CustomQualifier;

import java.util.logging.Logger;

public class SpringFrameworkAnnotations
{
    static final Logger LOG = Logger.getLogger(SpringFrameworkAnnotations.class.getName());

    public static void main( String[] args ) {
//        annotationBasedConfig();
        javaConfig();
    }

    private static void javaConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class, ListArrayConfig.class, ValueConfig.class);
//        Coach coach = context.getBean("tennis", Coach.class);
        TennisCoach coach = context.getBean("tennisCoach",TennisCoach.class); //default
        TennisCoach coach1 = context.getBean("tennisCoach",TennisCoach.class); //default
        LOG.info("@component coach workout ="+coach.getDailyWorkout());
        LOG.info("@autowire @component constructor fortune ="+coach.getDailyFortune());
        LOG.info("@autowire setter fortune ="+coach.getDailyFortune());
        LOG.info("@value  ="+coach.getNameProperty());

        BeanScope scope = context.getBean("beanScope",BeanScope.class);
        BeanScope scope1 = context.getBean("beanScope",BeanScope.class);
        LOG.info("diff instance as prototype scope 1="+scope.toString()+" 2="+scope1.toString());
        LOG.info("diff instance as singleton scope 1="+coach.toString()+" 2="+coach1.toString());

        ListArrayAuto listArrayAuto = context.getBean("listArrayAuto", ListArrayAuto.class);
        listArrayAuto.getArrayList();

        Required required = context.getBean("required",Required.class);
        LOG.info("required = false"+required.toString());

        PrimaryAuto primaryAuto = context.getBean("primaryAuto",PrimaryAuto.class);
        LOG.info("medal ="+primaryAuto.getMetal());

        CustomQualifier customQualifier = context.getBean("customQualifier",CustomQualifier.class);
        LOG.info("customQualifier is = "+customQualifier.getMedal());
        LOG.info("customQualifier is medal= "+customQualifier.getMedalist());
        LOG.info("customQualifier is medal= "+customQualifier.getMedalistWon().getDailyFortune());

        ValueAnno valueAnno = context.getBean("valueAnno",ValueAnno.class);
        valueAnno.printAll();

        context.close();
    }

//    uncomment for annotation based config
//    private static void annotationBasedConfig() {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
////        Coach coach = context.getBean("tennis", Coach.class);
//        TennisCoach coach = context.getBean("tennisCoach",TennisCoach.class); //default
//        TennisCoach coach1 = context.getBean("tennisCoach",TennisCoach.class); //default
//        LOG.info("@component coach workout ="+coach.getDailyWorkout());
//        LOG.info("@autowire @component constructor fortune ="+coach.getDailyFortune());
//        LOG.info("@autowire setter fortune ="+coach.getDailyFortune());
//        LOG.info("@value  ="+coach.getNameProperty());
//
//        BeanScope scope = context.getBean("beanScope",BeanScope.class);
//        BeanScope scope1 = context.getBean("beanScope",BeanScope.class);
//        LOG.info("diff instance as prototype scope 1="+scope.toString()+" 2="+scope1.toString());
//        LOG.info("diff instance as singleton scope 1="+coach.toString()+" 2="+coach1.toString());
//
//        context.close();
//    }
}
