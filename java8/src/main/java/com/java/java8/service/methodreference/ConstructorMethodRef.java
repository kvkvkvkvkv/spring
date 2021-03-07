package com.java.java8.service.methodreference;

import com.java.java8.service.customFI.ConstructorFI;
import com.java.java8.service.customFI.ConstructorWithPAram;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class ConstructorMethodRef {

    private Logger log = LoggerFactory.getLogger(ConstructorMethodRef.class);
    private String name;

    // without params
    //custom FI
    ConstructorMethodRef() {
        log.info("in Constructor method ref");
    }

    public void constructorTestFI() {
        ConstructorFI<ConstructorMethodRef> ref = ConstructorMethodRef::new;
        ConstructorMethodRef obj = ref.constructor();
    }

    //with Param
    //custom FI
    public ConstructorMethodRef(String name) {
        this.name = name;
    }

    public void constructorTestFIWithParam() {
        ConstructorWithPAram<ConstructorMethodRef,String> ref = ConstructorMethodRef::new;
        ConstructorMethodRef obj = ref.constructor("Krishna");
        log.info("Name ="+obj.name);
    }

    //inbuilt FI
    public void constructorTestInbuiltFI() {
        Supplier<ConstructorMethodRef> obj = ConstructorMethodRef::new;
        obj.get();

        Function<String,ConstructorMethodRef> ref = ConstructorMethodRef::new;
        ConstructorMethodRef obj2 = ref.apply("Rob");
        log.info("Name ="+obj2.name);
    }
}
