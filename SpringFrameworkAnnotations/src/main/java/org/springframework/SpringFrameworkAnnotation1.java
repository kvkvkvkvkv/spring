package org.springframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.service.CoachTypes.SwimCoach;
import org.springframework.service.Configs.BeanConfig;

import java.util.logging.Logger;

public class SpringFrameworkAnnotation1
{
    static final Logger LOG = Logger.getLogger(SpringFrameworkAnnotation1.class.getName());

    public static void main( String[] args ) {
//        annotationBasedConfig();
        javaConfig();
    }

    private static void javaConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
//        Coach coach = context.getBean("tennis", Coach.class);
        SwimCoach coach = context.getBean("coach",SwimCoach.class); //got from manually doing no component scan
        LOG.info("@component coach workout ="+coach.getDailyWorkout());
        LOG.info("@autowire @component constructor fortune ="+coach.getDailyFortune());
        LOG.info("@autowire setter fortune ="+coach.getDailyFortune());
        LOG.info("@Value name ="+coach.getName());
        context.close();
    }
}
