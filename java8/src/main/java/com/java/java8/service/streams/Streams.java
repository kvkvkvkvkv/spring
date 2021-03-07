package com.java.java8.service.streams;

import com.java.java8.Java8Application;
import com.java.java8.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/*
source
0-more intermediate
1 terminal
without terminal the streams do not get executed
*/


/*
stateless - o/p does not depend on state that might chnage pipeline
non interfering - source shouldl not get modified

*/

@Service
public class Streams {

    private Logger log = LoggerFactory.getLogger(Streams.class);

    //stream creation - empty
    //zero elements rather than null
    Stream s = Stream.empty();

    //stream on collection
    List<Employee> employees = Java8Application.employees;

    public void run(){
        streamCollection();
        infifniteStream();
        infifniteStreamIterate();
        lazyEvalluvation();
        verticalExe();
        primitiveStreams();
        map();
        sort();
        limit();
        skip();
        collect();
    }

    //stream()
    //parallelStream()
    public void streamCollection() {

        log.info("*****Strean and Parallel stream init*********");
        log.info("Sequential Stream");
        Employee emp = employees.stream()
                .findAny()
                .orElseGet(() -> employees.get(1));

        log.info(emp.toString());

        log.info("||el Stream");

        List<Integer> age = employees.parallelStream()
                .map(Employee::getAge)
                .collect(Collectors.toList());

        age.forEach(a -> log.info(String.valueOf(a)));
    }


    //array to stream
    Stream<Integer> array = Stream.of(1,2,3,4);


    //generate() created infinite stream
    Stream<Integer> gen = Stream.generate(() -> 2).limit(5);
    Stream<Double> gen1 = Stream.generate(Math::random).limit(5);

    public void infifniteStream() {
        log.info("*****Infinite stream generate*********");
        log.info("Infinite stream generate - constant 2");
        gen.forEach(ele -> log.info(String.valueOf(ele)));
        log.info("Infinite stream generate - random");
        gen1.forEach(ele -> log.info(String.valueOf(ele)));
    }

    //iterate()
    //generate infininte streams
    Stream<Integer> it = Stream.iterate(2,n -> n+1).limit(5);
    Stream<Integer> it1 = Stream.iterate(8,n -> n*2).limit(4);

    public void infifniteStreamIterate() {
        log.info("*****Infinite stream iterate*********");
        log.info("Infinite stream iterate - constant 2");
        it.forEach(ele -> log.info(String.valueOf(ele)));
        log.info("Infinite stream iterate - constant multiple of 2");
        it1.forEach(ele -> log.info(String.valueOf(ele)));
    }


    //lazy eveluvation
    //streams are lazy do not execute intermediate till it encounted terminal operation
    //intermediate operation creates a new stream
    //once terminal is encountered stream pipeline executes
    //intermediate operations are then executed one by one
    public void lazyEvalluvation() {
        log.info("*****Lazy Evaluvation*********");

        Stream<Integer> lazy = array.map(e -> e* e)
                .peek(e -> log.info("Intermediate operation elements = "+e))
                .filter(e -> e > 20);

        log.info("Executing Terminal op");
        lazy.forEach(ele -> log.info(String.valueOf(ele)));
    }

    //verical execution of streams
    //soorted only does horizontal execution
    //as there maybe ele depending on it
    public void verticalExe() {

        log.info("*****Vertical Execution of streams*********");

        Java8Application.employees
                .stream()
                .peek(emp -> log.info("Current emp"+emp.toString()))
                .filter(employee -> employee.getAge()>20)
                .peek(emp -> log.info("filtered emp"+emp.toString()))
                .anyMatch(employee -> employee.getAge()<25);
    }


    //primitive streams
    //long/int/doublestreams
    //autoboxing and unboxing perfromance solved
    //sum and average methods

    int[] numbers = {1,2,3,4};
    public void primitiveStreams(){

        log.info("*****Primitive streams*********");
        //stream to InstStream
        Integer sum = Arrays.stream(numbers)
                .sum();
        log.info("Array Int stream stream "+String.valueOf(sum));

        //collection of Intstream done using boxed and you cannot collect int in list
        //can collect wrapper class only
        log.info("boxing int stream to  stream<integers> then collecting to list<integers>");

        List<Integer> nums = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());
        nums.forEach(num -> log.info(String.valueOf(num)));

        //stream to intstream/longstrea/doublestream
        //mapToInt/mapToDouble/long
        String[] strings = new String[]{"1", "2", "3"};
        Arrays.stream(strings)
                .mapToInt(Integer::parseInt)
                .sum();


        //convert intstream to stream mapToObj
        IntStream ints = Arrays.stream(numbers);
        List<Double> doubles = ints
                .mapToObj(ele -> Double.parseDouble(String.valueOf(ele)))
                .collect(Collectors.toList());
    }


    //map
    //map from Stream<T> to Stream<R>
    public void map() {
        log.info("*****map age double*******");

        //illegal state expression as stream has already been used and closed
//        array.map(ele -> ele * ele)
//                .peek(ele -> log.info(ele.toString()))
//                .collect(Collectors.toList());

        List<Integer> arr = Arrays.asList(2,3,4,1);
        arr.stream().map(ele -> ele * ele)
                .peek(ele -> log.info(ele.toString()))
                .collect(Collectors.toList());

    }

    //filter takes a predicate filters stream

    //sorted
    //sorts elements takes natural order if no paramenters
    //takes a comparator
    public void sort() {
        log.info("*****sort*******");


        List<Integer> beforeSort = Arrays.asList(2,4,1,8,4);
        log.info("Natural sort");

        beforeSort = beforeSort.stream()
                .sorted()
                .collect(Collectors.toList());
        beforeSort.forEach(ele -> log.info(ele.toString()));

        log.info("Natural sort");
        beforeSort = beforeSort.stream()
                .sorted((e1,e2) -> e1.compareTo(e2))
                .collect(Collectors.toList());
        beforeSort.forEach(ele -> log.info(ele.toString()));

        log.info("Descending sort");
        beforeSort = beforeSort.stream()
                .sorted((e1,e2) -> -(e1.compareTo(e2)))
                .collect(Collectors.toList());
        beforeSort.forEach(ele -> log.info(ele.toString()));

        log.info("Natural sort");
        List<Employee> emps = Java8Application.employees
                .stream()
                .sorted((e1,e2) -> e1.getAge().compareTo(e2.getAge()))
                .collect(Collectors.toList());
        emps.forEach(e -> log.info(e.toString()));


        log.info("descending sort");
        emps = Java8Application.employees
                .stream()
                .sorted((e1,e2) -> -(e1.getAge().compareTo(e2.getAge())))
                .collect(Collectors.toList());
        emps.forEach(e -> log.info(e.toString()));

    }

    //limit
    //only allows first n elements
    public void limit(){
        log.info("*********Limit*******");
        log.info("limit within range");
        Java8Application.employees
                .stream()
                .limit(3)
                .forEach(ele -> log.info(ele.toString()));

        log.info("limit out of  range");
        Java8Application.employees
                .stream()
                .limit(20)
                .forEach(ele -> log.info(ele.toString()));

        List<Employee> emps = new ArrayList();
        log.info("limit below range");
                emps.stream()
                .limit(20)
                .forEach(ele -> log.info(ele.toString()));

    }

    //skip
    //skips first n eleemnts
    public void skip(){
        log.info("*********Skip*******");
        log.info("skip within range");
        Java8Application.employees
                .stream()
                .skip(3)
                .forEach(ele -> log.info(ele.toString()));

        log.info("skip out of  range");
        Java8Application.employees
                .stream()
                .skip(10)
                .forEach(ele -> log.info(ele.toString()));

        log.info("skip below range");
        List<Employee> emps = new ArrayList();
        emps.stream()
                .skip(10)
                .forEach(ele -> log.info(ele.toString()));
    }

    //collect
    public void collect(){
        log.info("*********Collect*******");
        log.info("to list");
        List<Employee> empList = Java8Application.employees
                .stream()
                .skip(3)
                .collect(Collectors.toList());
        empList.forEach(ele -> log.info(ele.toString()));

        log.info("to set");
        Set<Employee> empSet = Java8Application.employees
                .stream()
                .collect(Collectors.toSet());
        empSet.forEach(ele -> log.info(ele.toString()));

        Function<Employee,Integer> age = Employee::getAge;

        log.info("to Map");
        Map<Integer,Employee> empMap = Java8Application.employees
                .stream()
                .collect(Collectors.toMap(age,Function.identity(),(value1,value2)->value1));
        empMap.forEach((k,v) -> log.info(String.valueOf(k)+" = "+v.toString()));

        log.info("joining");
        String empJoin = Java8Application.employees
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        log.info(empJoin);

        log.info("joining with delimiter");
        String empJoinDelimiter = Java8Application.employees
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining("  ,"));
        log.info(empJoinDelimiter);

        log.info("joining with delimiter");
        String empJoinDelimiterPrefixSuffix = Java8Application.employees
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining("  ,","{ "," }"));
        log.info(empJoinDelimiterPrefixSuffix);

        log.info("collecting and then");
        //collectionAndThen is used to collect and transform
        //can transform list to another list
        //can transform optional and then get value
        Set<Employee> empCOllectionAndThen= Java8Application.employees
                .stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),Collections::<Employee>unmodifiableSet));
        log.info(empJoinDelimiterPrefixSuffix);

        log.info("counting");
        //counts no of elements
        //if no element then 0
        Long count = Java8Application.employees
                .stream()
                .collect(Collectors.counting());
        log.info("count ="+count);

        log.info("summarizing double/long/int");
        Integer ageSum = Java8Application.employees
                .stream()
                .limit(2)
                .peek(ele -> log.info(ele.toString()))
                .collect(Collectors.summingInt(Employee::getAge));
        log.info("age sum ="+ageSum);
    }


}
