package org.springframework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.service.AutowiringModes;
import org.springframework.service.DI.ConstructorDI;
import org.springframework.service.DI.SettingDI;
import org.springframework.service.ToDoListService;
import org.springframework.service.UserService;

import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class SpringFramework
{
    static final Logger LOG = Logger.getLogger(SpringFramework.class.getName());

    public static void main( String[] args ) {
        //although has 1 xml picks multiple as import resource is being used
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = (UserService) context.getBean("user");
        LOG.info("Type casting bean creating + resource import="+userService.getUsers());

        ToDoListService toDoListService = (ToDoListService) context.getBean("toDo");
        //no need of casting
        ToDoListService toDoListService1 = context.getBean("toDo",ToDoListService.class);
        LOG.info("Another method of using brean without type casting ="+toDoListService1.getToDo());

        //calling alias
        UserService userService1 = (UserService) context.getBean("userAlias");
        LOG.info("User Alias="+userService1.getUsers());

        ToDoListService toDoListService2 = context.getBean("toDoAlias",ToDoListService.class);
        LOG.info("Todo Alias overrides picks last alias in the same name="+toDoListService2.getToDo());

        LOG.info("*******************Instance Bean types - cons/static factory/insatnce factory*********************");
        ToDoListService toDoListService3 = context.getBean("toDo",ToDoListService.class);
        LOG.info("constructor="+toDoListService3.getToDo());

        UserService staticFactoryUserService = context.getBean("staticFactory",UserService.class);
        LOG.info("static factory="+staticFactoryUserService.getUsers());

        UserService instanceFactoryUserService = context.getBean("instanceFactory",UserService.class);
        LOG.info("instance Factory UserService="+instanceFactoryUserService.getUsers());

        LOG.info("****************** DI ********************");
        LOG.info("Constructor DI");
        LOG.info("Constructor DI"+context.getBean("constructorDI", ConstructorDI.class));
        LOG.info("Constructor DI constructor Type"+context.getBean("constructorType", ConstructorDI.class).toString());
        LOG.info("Constructor DI constructor Index"+context.getBean("constructorIndex", ConstructorDI.class).toString());
        LOG.info("Constructor DI constructor Name"+context.getBean("constructorName", ConstructorDI.class).toString());
        LOG.info("Constructor DI constructor Property"+context.getBean("constructorProperty", ConstructorDI.class).toString());

        LOG.info("Setting DI");
        LOG.info("Setting DI "+context.getBean("setterDI", SettingDI.class).toString());
        LOG.info("Setting DI setterDIStatic"+context.getBean("setterStatic", SettingDI.class).toString());

        LOG.info("****************** Lazy Init ********************");
        LOG.info("Lazy init user="+context.getBean("userLazy",UserService.class).getUsers());

        LOG.info("****************** Autowire Mode ********************");
        LOG.info("No autowire="+context.getBean("autowireNo", AutowiringModes.class).toString());
//        LOG.info("By Type autowire="+context.getBean("autowireType",AutowiringModes.class).toString());
        LOG.info("By Name autowire="+context.getBean("autowireName",AutowiringModes.class).toString());
        LOG.info("Constructor autowire="+context.getBean("autowireCons",AutowiringModes.class).toString());


    }
}
