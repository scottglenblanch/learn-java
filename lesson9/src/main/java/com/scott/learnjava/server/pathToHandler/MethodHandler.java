package com.scott.learnjava.server.pathToHandler;

import com.scott.learnjava.server.annotations.RestRequest;
import com.sun.net.httpserver.HttpHandler;

import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MethodHandler {

    private List<PairPathToHandler> list;
    private Method method;
    private String controllerPath;
    private Object originalObject;

    public MethodHandler(Method method, String controllerPath, Object originalObject) {
        initControllerPath(controllerPath);
        initMethod(method);
        initOriginalObject(originalObject);
        initList();
    }

    public List<PairPathToHandler> getPairToPathList() {
        return this.list;
    }

    private void initControllerPath(String controllerPath) {
        this.controllerPath = controllerPath;
    }

    private void initMethod(Method method) {
        this.method = method;
    }

    private void initOriginalObject(Object originalObject) {
        this.originalObject = originalObject;
    }

    private void initList() {
        list = new ArrayList<>();

        for (Annotation methodAnnotation : method.getDeclaredAnnotations()) {
            if (isRestRequestAnnotation(methodAnnotation)) {
                RestRequest restRequestAnnotation = (RestRequest) methodAnnotation;
                handleRestRequestAnnotation(restRequestAnnotation);
            }

        }
    }

    private boolean isRestRequestAnnotation(Annotation annotation) {
        return annotation instanceof RestRequest;
    }

    private void handleRestRequestAnnotation(RestRequest annotation) {
        PairPathToHandler pairPathToHandler = new PairPathToHandler();

        pairPathToHandler.setHttpHandler(getHandler());
        pairPathToHandler.setPath(getPath(annotation));

        list.add(pairPathToHandler);
    }

    private HttpHandler getHandler() {
        return exchange -> {
            try {
                String response = (String) method.invoke(originalObject);
                OutputStream outputStream = exchange.getResponseBody();

                exchange.sendResponseHeaders(200, response.getBytes().length);

                outputStream.write(response.getBytes());
                outputStream.close();

            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        };
    }

    private String getPath(RestRequest annotation) {
        return (controllerPath + annotation.path()).replaceAll("//", "/");
    }
}
