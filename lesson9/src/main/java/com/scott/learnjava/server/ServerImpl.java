package com.scott.learnjava.server;
import com.scott.learnjava.server.controllers.HomeController;
import com.scott.learnjava.server.pathToHandler.PairPathToHandler;
import com.scott.learnjava.server.pathToHandler.PathToHandlerFetcherImpl;
import com.sun.net.httpserver.HttpServer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;

public class ServerImpl implements Server {
    private HttpServer httpServer;
    private List<PairPathToHandler> pairPathToHandlerList;
    private int port;

    public ServerImpl() throws IOException {
        initPort();
        initPairPathToHandlerList();
        initHttpServer();
    }

    @Override
    public void start() {
        System.out.println(String.format("Listening on port %d", port));

        httpServer.start();
    }

    private void initPairPathToHandlerList() throws FileNotFoundException {
        this.pairPathToHandlerList = new PathToHandlerFetcherImpl(List.of(new HomeController())).getPathAndHandlerList();
    }

    private void initPort() {
        this.port = 8000;
    }

    private void initHttpServer() throws IOException {
        this.httpServer = HttpServer.create(new InetSocketAddress(port), 0);

        for(PairPathToHandler pair: pairPathToHandlerList) {
            this.httpServer.createContext(pair.getPath(), pair.getHttpHandler());
        }
    }
}
