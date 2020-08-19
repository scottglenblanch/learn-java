package com.scott.learnjava.server.pathToHandler;

import com.scott.learnjava.server.annotations.RestController;
import com.scott.learnjava.server.annotations.RestRequest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ObjectHandler {

    private List<PairPathToHandler> list;
    private Object originalObject;


    public ObjectHandler(Object o) {
        initOriginalObject(o);
        initPairPathToHandlerList(o);
    }

    public List<PairPathToHandler> getPairPathToHandlerList() {
        return this.list;
    }

    private void initOriginalObject(Object o) {
        this.originalObject = o;
    }

    private void initPairPathToHandlerList(Object o) {
        list = new ArrayList<>();
        Class clazz = o.getClass();

        for(Annotation annotation: clazz.getDeclaredAnnotations()) {
            if (isRestControllerAnnotation(annotation)) {
                RestController restControllerAnnotation = (RestController) annotation;

                handleRestControllerAnnotation(restControllerAnnotation, clazz);
            }

        }
    }

    private void handleRestControllerAnnotation(RestController annotation, Class clazz) {
        String controllerPath = annotation.path();

        for(Method method: clazz.getMethods()) {
            List<PairPathToHandler> subList = new MethodHandler(method, controllerPath, originalObject).getPairToPathList();
            list.addAll(subList);
        }
    }

    private boolean isRestControllerAnnotation(Annotation annotation) {
        return annotation instanceof RestController;
    }


}
