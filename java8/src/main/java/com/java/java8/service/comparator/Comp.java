package com.java.java8.service.comparator;

import com.java.java8.Java8Application;
import com.java.java8.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class Comp implements Comparator<Integer> {


    private List<Integer> num = Arrays.asList(1,2,10,8);
    private final Logger log = LoggerFactory.getLogger(Comp.class);

    @Override
    public int compare(Integer o1, Integer o2) {
        log.info(o1+"   o2="+o2+"    value="+(o1>o2?-1:o1<o2?1:0));
        return o1>o2?-1:o1<o2?1:0;
    }

    public void sort() {
        Collections.sort(num,new Comp()::compare);
        num.forEach(System.out::println);

        Collections.sort(Java8Application.employees,(e1,e2) -> e1.getSalary()> e2.getSalary()
                ?-1 :e1.getSalary()<e2.getSalary() ? 1: 0);

        Java8Application.employees.forEach(System.out::println);
    }
}
