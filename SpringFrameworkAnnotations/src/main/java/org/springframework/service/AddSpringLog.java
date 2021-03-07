package org.springframework.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Configuration
@PropertySource("classpath:logger.properties")
public class AddSpringLog {

    @Value("${root.logger.level}")
    private String rootLevelLogger;

    @Value("${printed.logger.level}")
    private String printedLevelLogger;

    @PostConstruct
    public void initLogger() {

        Level root = Level.parse(rootLevelLogger);
        Level printed = Level.parse(printedLevelLogger);

        Logger appContext = Logger.getLogger("AnnotationConfigApplicationContext");

        Logger parentLogger = appContext.getParent();

        parentLogger.setLevel(root);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(printed);
        consoleHandler.setFormatter(new SimpleFormatter());

        parentLogger.addHandler(consoleHandler);
    }
}
