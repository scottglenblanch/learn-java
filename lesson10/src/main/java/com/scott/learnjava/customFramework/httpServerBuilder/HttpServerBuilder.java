package com.scott.learnjava.customFramework.httpServerBuilder;

import com.scott.learnjava.customFramework.pathToHandler.PairPathToHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;

public class HttpServerBuilder {

    private int port;
    private List<PairPathToHandler> pairPathToHandlerList;

    public HttpServer build() {
        HttpServer httpServer = null;
        try {
            httpServer = HttpServer.create(new InetSocketAddress(port), 0);

            for(PairPathToHandler pair: pairPathToHandlerList) {
                httpServer.createContext(pair.getPath(), pair.getHttpHandler());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return httpServer;
    }


    public HttpServerBuilder addPort(int port) {
        this.port = port;
        return this;
    }

    public HttpServerBuilder addPairPathToHandlerList(List<PairPathToHandler> pairPathToHandlerList) {
        this.pairPathToHandlerList = pairPathToHandlerList;

        return this;
    }
}
