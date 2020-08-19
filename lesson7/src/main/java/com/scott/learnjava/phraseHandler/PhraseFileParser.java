package com.scott.learnjava.phraseHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PhraseFileParser {
    private String language;
    private String filePath;

    public PhraseFileParser(String language) {
       initLanguage(language);
        initFilePath();
    }

    public Map<String, String> getPhraseKeyValueMap() {
        Map<String, String> map = new HashMap<>();

        for (PhraseKeyValue pair: getConfigKeyValueList()) {
            map.put(pair.getKey(), pair.getValue());
        }

        return map;
    }

    private void initFilePath() {
        this.filePath = String.format("./phrases/%s.txt", language);
    }

    private void initLanguage(String language) {
        this.language = language;
    }

    private List<PhraseKeyValue> getConfigKeyValueList() {
        List<PhraseKeyValue> list = new ArrayList<>();

        try {
            Scanner scanner = getScannerForParsing();

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                list.add(getPhraseKeyValue(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    private Scanner getScannerForParsing() throws FileNotFoundException {
        return new Scanner(getPhraseFileBasedOnLanguage());
    }

    private File getPhraseFileBasedOnLanguage() {
        return new File(filePath);
    }

    private PhraseKeyValue getPhraseKeyValue(String line) {
        int index = getFirstEqualIndex(line);
        String key = line.substring(0, index);
        String value = line.substring(index+1);

        return new PhraseKeyValue(key, value);
    }

    private int getFirstEqualIndex(String line) {
        for (int i = 0; i < line.length(); i++) {
            char cur = line.charAt(i);
            boolean isFirstEqual = cur == '=';

            if(isFirstEqual) {
                return i;
            }
        }

        return line.length();
    }
}