package com.scott.learnjava.customFramework.pathToHandler;

import com.scott.learnjava.customFramework.annotations.RestRequest;
import com.scott.learnjava.customFramework.annotations.UseTemplate;
import com.scott.learnjava.customFramework.templateFetcher.TemplateFetcher;
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
    private TemplateFetcher templateFetcher;

    public MethodHandler(Method method, String controllerPath, Object originalObject) {
        initControllerPath(controllerPath);
        initMethod(method);
        initOriginalObject(originalObject);
        initList();
        initTemplateFetcher();
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

    private void initTemplateFetcher() {
        this.templateFetcher = new TemplateFetcher();
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
                String response = getResponse(method);
                OutputStream outputStream = exchange.getResponseBody();

                exchange.sendResponseHeaders(200, response.getBytes().length);

                outputStream.write(response.getBytes());
                outputStream.close();

            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        };
    }

    private String getResponse(Method method) throws InvocationTargetException, IllegalAccessException {
        String methodOutput = (String) method.invoke(originalObject);

        return hasUseTemplateAnnotation(method)
            ? templateFetcher.getTemplate(methodOutput)
            : methodOutput;
    }

    private boolean hasUseTemplateAnnotation(Method method) {
        for(Annotation annotation: method.getAnnotations()) {
            if (annotation instanceof UseTemplate) {
                return true;
            }
        }

        return false;
    }


    private String getPath(RestRequest annotation) {
        String path = getPathFromAnnotation(annotation);

        return isRemoveTrailingSlash(path) ? path.substring(0, path.length() - 1) : path;

    }

    private String getPathFromAnnotation(RestRequest annotation) {
        return (controllerPath + annotation.path()).replaceAll("//", "/");
    }

    private boolean isRemoveTrailingSlash(String path) {
        return path.length() > 1 && path.charAt(path.length() - 1) == '/';
    }
}
