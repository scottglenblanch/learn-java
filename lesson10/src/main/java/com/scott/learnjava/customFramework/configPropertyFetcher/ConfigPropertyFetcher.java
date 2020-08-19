package com.scott.learnjava.customFramework.configPropertyFetcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ConfigPropertyFetcher {

    private static File file = new File("./src/config/config.txt");

    private static Map<String, String> keyValueMap;

    public static String getConfigProperty(String configPropertyKey) {
        boolean isInitMap = keyValueMap == null;

        if (isInitMap) {
            initMap();
        }

        return keyValueMap.get(configPropertyKey);
    }

    private static void initMap() {
        keyValueMap = new HashMap<>();

       for(String line: getLinesFromFile()) {
           keyValueMap.put(getKey(line), getValue(line));
       }
    }

    private static List<String> getLinesFromFile() {
        List<String> linesList = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(file);

            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                linesList.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return linesList;
    }

    private static String getKey(String line) {
        return line.substring(0, getIndexOfDelimiter(line));
    }

    private static String getValue(String line) {
        return line.substring(getIndexOfDelimiter(line) + 1);
    }

    private static int getIndexOfDelimiter(String line) {
        return line.indexOf("=");
    }

}
