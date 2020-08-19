package com.scott.learnjava.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RandomAnnotation {
    String value() default "hello world!";
}
