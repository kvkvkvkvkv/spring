package org.springframework.service.DI;

import lombok.Data;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.service.ToDoListService;
import org.springframework.service.UserService;

@Data
public class SettingDI {


    Log log = LogFactory.getLog(SettingDI.class);

    private int age;
    private int number;
    private ToDoListService toDoListService;
    private UserService userService;

    public static SettingDI createSettingInstance(int age){
        SettingDI settingDI = new SettingDI();
        settingDI.setAge(age);
        return settingDI;
    }
}
