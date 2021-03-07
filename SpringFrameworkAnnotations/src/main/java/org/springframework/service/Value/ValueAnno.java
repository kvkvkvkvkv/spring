package org.springframework.service.Value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Component
@PropertySource("classpath:sport.properties")
public class ValueAnno {

    Logger log = Logger.getLogger("ValueAnno");

    //give default vales
    @Value("Yo")
    String DefaultName;

    //give default name and pick cal from prop file
    //set spring env
    @Value("${name:Yo}")
    String name;

    //set system env variables
    @Value("${java.home}")
    String javaHome;

    //reading system prop using spel
    @Value("#{systemProperties['java.home']}")
    String spelJavaHome;

    //value over method
    String methodName;
    @Value("YoLO")
    public void setMethodName(String nameMethod) {
        this.methodName = nameMethod;
    }

    //list split
    @Value("#{'${list}'.split(',')}")
    List<String> list;

    //array
    @Value("${list}")
    String[] array;

    //map
    @Value("#{${map}}")
    Map<String,String> map;

    //value for key
    @Value("#{${map}.a}")
    String value;

    //no key
    @Value("#{${map}['unknownKey']}")
    String unknownKey;

    //no existing prop
    @Value("#{${noMap : {k:'1',k1:'2'}}}")
    Map<String,Integer> noMap;

    @Value("#{${map}['unknownKey']?:6}")
    Integer defaultValue;

    public void printAll(){
        log.info("@ value deafult="+DefaultName);
        log.info("@ value spring prop="+name);
        log.info("@ value system prop="+javaHome);
        log.info("@ value spel system prop="+spelJavaHome);
        log.info("@value mathodname="+methodName);
        log.info("@value list="+list);
        Arrays.stream(array).forEach(e -> log.info("array ="+e));
        log.info("@value map="+map);
        log.info("@value value="+value);
        log.info("@value unknown key="+unknownKey);
        log.info("@value unknown prop default val="+noMap);
        log.info("@value default val="+defaultValue);
    }
}
