package com.scott.learnjava.server.pathToHandler;

import com.sun.net.httpserver.HttpHandler;

public class PairPathToHandler {
    private String path;
    private HttpHandler httpHandler;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public HttpHandler getHttpHandler() {
        return httpHandler;
    }

    public void setHttpHandler(HttpHandler httpHandler) {
        this.httpHandler = httpHandler;
    }
}
