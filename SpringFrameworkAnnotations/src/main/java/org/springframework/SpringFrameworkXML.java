package org.springframework;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.service.BeanScope;
import org.springframework.service.CoachTypes.TennisCoach;

import java.util.logging.Logger;

public class SpringFrameworkXML
{
    static final Logger LOG = Logger.getLogger(SpringFrameworkXML.class.getName());

    public static void main( String[] args ) {
        annotationBasedConfig();
    }

//    uncomment for annotation based config
    private static void annotationBasedConfig() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
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

        context.close();
    }
}
