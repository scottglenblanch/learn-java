package com.scott.learnjava.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PhraseAnnotation {
    String phraseKey();
}
