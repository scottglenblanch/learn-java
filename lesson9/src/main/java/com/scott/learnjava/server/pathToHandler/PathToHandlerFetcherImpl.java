package com.scott.learnjava.server.pathToHandler;

import java.util.ArrayList;
import java.util.List;

public class PathToHandlerFetcherImpl implements PathToHandlerFetcher {

    private List<PairPathToHandler> list;

    public PathToHandlerFetcherImpl(List<Object> objectList) {
        initList(objectList);
    }

    @Override
    public List<PairPathToHandler> getPathAndHandlerList() {
        return this.list;
    }

    private void initList(List<Object> objectList) {
        this.list = new ArrayList<>();

        for(Object o: objectList) {
            List<PairPathToHandler> subList = new ObjectHandler(o)
                .getPairPathToHandlerList();

            list.addAll(subList);
        }
    }



}
