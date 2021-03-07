package com.java.java8.service.optionals;

import com.java.java8.Java8Application;
import com.java.java8.model.Employee;
import com.java.java8.model.Project;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


//used fo rhandling null pointer exception
//null is referencr type
//used when we don't know what to initialise it to
//problem is solved using optinaal as it forces to either get the value or empty not null
@Service
public class Optionals {

    Logger log = LoggerFactory.getLogger(Optionals.class);
    //optional - of/empty/ofNullable

    //optional - of
    Optional<Employee> emp = Optional.of(Java8Application.employees.get(0));


    //Optional<Employee> emp1 = Optional.of(null); //throws Null pointer exception

    //optional - ofNullable
    Optional<Employee> emp2 = Optional.ofNullable(null); //return empty optional
    Optional<Employee> emp3 = Optional.ofNullable(Java8Application.employees.get(0));
    Optional<List<Employee>> emp5 = Optional.ofNullable(Java8Application.employees);

    //optional - empty
    Optional<Employee> emp4 = Optional.empty();//returns  empty

    public void optionalTest() {
        log.info("*************************** Optionals ********************");

        log.info("OPtional of ="+emp.get().toString());
        //log.info(emp1.get().toString());
        log.info("OPtional empty of NUllable ="+emp2.toString());
        log.info("OPtional of NUllable ="+emp3.get().toString());
        log.info("OPtional empty="+emp4.toString());

        log.info("Emp Greater than 8000 is Present="+getGreater8000Salary());
        log.info("Emp Greater than 3000 if Present=");
        getGreater3000Salary();

        log.info("Filtered age emp=");
        getFilterEmp();

        log.info("********Map emp*******");
        getMapEmp();

        log.info("********Flat Map emp*******");
        flatMap();

        log.info("********Or Else *******");
        orElse();

        log.info("********Or Else Get*******");
        orElseGet();

        log.info("********Or Else Throw*******");
        orElseThrow();

        log.info("********Equal*******");
        equal();

    }

    //isPresent
    //returns boolean
    public Boolean getGreater8000Salary(){
            return Java8Application.employees
                .stream()
                .filter(employee -> employee.getSalary()>8000)
                .findAny().isPresent();
    }

    //ifPresent if consumer is null NPE
    //does some work
    public void getGreater3000Salary(){
        Java8Application.employees
                .stream()
                .filter(employee -> employee.getSalary()>3000)
                .findAny().ifPresent(employee -> log.info(employee.toString()));

        //null pointer exception
//        Java8Application.employees
//                .stream()
//                .filter(employee -> employee.getSalary()>3000)
//                .findAny().ifPresent(null);
    }

    //filter
    public void getFilterEmp(){
        //true value - return value
        Optional<Employee> e = emp.filter(employee -> employee.getAge()>20);
        e.ifPresent(employee -> log.info(employee.toString()));

        //false value - empty
        Optional<Employee> e1 = emp.filter(employee -> employee.getAge()<20);
        log.info(e1.toString()); //empty
        e1.ifPresent(employee -> log.info(employee.toString()));

        //null value - NPE
//        Optional<Employee> e2 = emp.filter(null);
//        e2.ifPresent(employee -> log.info(employee.toString()));
    }

    //map
    //takes function and then
    // null function hen npe
    //return value if statisfied
    //empty if not satisfied
    public void getMapEmp(){
        //true value - return value
        Optional<Employee> e = emp.map(employee -> {
            employee.setSalary((long) 8000);
            return employee;
        });
        log.info(e.toString());

        //null value - NPE
//        Optional<Employee> e2 = emp.filter(null);
//        e2.ifPresent(employee -> log.info(employee.toString()));
    }


    //flat map
    //similar to map
    // null function hen npe
    //return value if statisfied
    //empty if not satisfied
    //does not wrap with optional if already optional exists
    public void flatMap(){
        Optional<Optional<Employee>> e= Optional.of(emp);
        Optional<Employee> op = e.flatMap(employee -> employee.map(e1 -> {
            e1.setSalary((long)9000);
            return e1;
        }));

        log.info(String.valueOf(op));

        //npe for null value
        //Optional<Optional<Employee>> e1= Optional.of(emp);
        //e1.flatMap(null);
    }

    //orelse
    //returns value else default value if optioanl empty/null
    //enters default value always even if not satisfied
    public void orElse(){
        //original value
        Employee e = emp.orElse(Java8Application.employees.get(1));
        log.info(String.valueOf(e));

        //default value
        e = emp4.orElse(Java8Application.employees.get(4));
        log.info(String.valueOf(e));
    }

    //orelseGet
    //returns value else default value if optioanl empty/null
    //uses supplier
    //npe for null supplier
    //enters default value only if not satisfied
    public void orElseGet(){
        //original value
        Employee e = emp.orElseGet(() -> Java8Application.employees.get(2));
        log.info(String.valueOf(e));

        //default value
        e = emp4.orElseGet(() -> Java8Application.employees.get(4));
        log.info(String.valueOf(e));

        //npe if null supplier
//        e = emp4.orElseGet(null);
//        log.info(String.valueOf(e));
    }

    //orElseThrow()
    //returns value else exception if optioanl empty/null
    //supplier
    public void orElseThrow(){
        //original value
        Employee e = emp.orElseThrow(() -> new RuntimeException("Errrror"));
        log.info(String.valueOf(e));

        //error value
//        e = emp4.orElseThrow(() -> new RuntimeException("Errrror"));
//        log.info(String.valueOf(e));

        //npe if null supplier
//        e = emp4.orElseThrow(null);
//        log.info(String.valueOf(e));
    }

    //equal
    //if optinal, null or if not null same value
    public void equal(){
        log.info(String.valueOf(emp.equals(emp4)));
    }

}
