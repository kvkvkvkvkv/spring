package org.springframework.service.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.service.Parent1;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("org.springframework.")
public class ListArrayConfig {

    @Bean
    public Parent1 parentOne(){
        return new Parent1("Yo");
    }

    @Bean
    public Parent1 parentTwo(){
        return new Parent1("Lo");
    }

    @Bean
    public Map<String,String> stringMap(){
        Map<String,String> map = new HashMap<>();
        map.put("1","One");
        return map;
    }
}
