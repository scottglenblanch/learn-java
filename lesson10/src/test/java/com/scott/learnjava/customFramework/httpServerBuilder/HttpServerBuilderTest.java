package com.scott.learnjava.customFramework.httpServerBuilder;

import com.scott.learnjava.customFramework.pathToHandler.PairPathToHandler;
import com.sun.net.httpserver.HttpServer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HttpServerBuilderTest {

    @Test
    public void build_test() {
        HttpServerBuilder httpServerBuilder = new HttpServerBuilder();
        int port = 3000;
        List<PairPathToHandler> list = new ArrayList<>();
        HttpServer server;

        httpServerBuilder.addPort(port);
        httpServerBuilder.addPairPathToHandlerList(list);

        server = httpServerBuilder.build();

        assertEquals(server.getAddress().getPort(), port);

    }
}
