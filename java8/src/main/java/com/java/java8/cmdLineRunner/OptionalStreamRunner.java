package com.java.java8.cmdLineRunner;

import com.java.java8.service.optionals.Optionals;
import com.java.java8.service.streams.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionalStreamRunner {

    @Autowired
    Optionals optionals;

    @Autowired
    Streams streams;

    public void run() {
        optionals.optionalTest();
        streams.run();
    }
}
