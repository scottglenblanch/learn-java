package com.scott.learnjava.customFramework.server;

import com.scott.learnjava.app.controllers.*;
import com.scott.learnjava.customFramework.configPropertyFetcher.ConfigPropertyFetcher;
import com.scott.learnjava.customFramework.httpServerBuilder.HttpServerBuilder;
import com.scott.learnjava.customFramework.pathToHandler.PairPathToHandler;
import com.scott.learnjava.customFramework.pathToHandler.PathToHandlerFetcherImpl;
import com.sun.net.httpserver.HttpServer;

import java.util.Arrays;
import java.util.List;

public class ServerImpl implements Server {

    public static void main(String[] args) {
        new ServerImpl().start();
    }

    private int port;
    private String language;
    private List<Object> controllerList;
    private List<PairPathToHandler> pairPathToHandlerList;
    private HttpServer httpServer;

    public ServerImpl() {
        initLanguage();
        initPort();

        initControllerList();
        initPairPathToHandler();

        initHttpServer();
    }

    public void start() {
        logOutMessage();
        httpServer.start();
    }


    private void initControllerList() {
        controllerList = Arrays.asList(
            new AboutMeController(),
            new HomeController()
        );
    }

    private void initHttpServer() {
        this.httpServer = new HttpServerBuilder()
            .addPairPathToHandlerList(pairPathToHandlerList)
            .addPort(port)
            .build();
    }

    private void initLanguage() {
        language = ConfigPropertyFetcher.getConfigProperty("language");
    }

    private void initPairPathToHandler() {
        this.pairPathToHandlerList = new PathToHandlerFetcherImpl(controllerList)
            .getPathAndHandlerList();

        this.pairPathToHandlerList.stream().forEach(x -> System.out.println(x.getPath()));
    }

    private void initPort() {
        port = Integer.parseInt(ConfigPropertyFetcher.getConfigProperty("port"));
    }

    private void logOutMessage() {
        int port = httpServer.getAddress().getPort();
        String message = String.format("Listening on port %d", port);

        System.out.println(message);
    }
}
