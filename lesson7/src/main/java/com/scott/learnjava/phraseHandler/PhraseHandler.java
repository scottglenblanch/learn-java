package com.scott.learnjava.phraseHandler;

import java.util.Map;

public class PhraseHandler {
    private Map<String, String> handlerMap;

    public PhraseHandler(String language) {
        initHandlerMap(language);
    }

    public String getPhraseValue(String key) {
        return handlerMap.get(key);
    }

    public void initHandlerMap(String language) {
        PhraseFileParser parser = new PhraseFileParser(language);
        handlerMap = parser.getPhraseKeyValueMap();
    }
}
