package org.springframework.service.Auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.models.Fortune;
import org.springframework.service.Parent1;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class ListArrayAuto {

    Logger log = Logger.getLogger("ListArrayAuto");

    @Autowired
    Parent1[] parents;

    @Autowired
    List<Parent1> parent1List;

    @Autowired
    Map<String,Parent1> parentMap;

    Map<String,String> stringMap;

    @Autowired
    public void setStringMap(Map<String, String> stringMap) {
        this.stringMap = stringMap;
    }

    @Autowired
    List<Fortune> fortune;

    public void getArrayList(){
        log.info("array"+parents.toString());
        log.info("arraylist"+parent1List.toString());
        fortune.stream().forEach(e -> log.info(e.toString()));
        log.info("maapppp string-string"+stringMap.toString());
        log.info("maapppp string-parent1"+parentMap.toString());
    }
}
