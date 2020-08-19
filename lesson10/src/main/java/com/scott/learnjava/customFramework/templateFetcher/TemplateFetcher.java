package com.scott.learnjava.customFramework.templateFetcher;

import com.scott.learnjava.customFramework.configPropertyFetcher.ConfigPropertyFetcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TemplateFetcher {

    public String getTemplate(String templateName) {
        try {
            Scanner scanner = new Scanner(new File(getFilePath(templateName)));
            StringBuilder stringBuilder = new StringBuilder();

            while(scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine() + '\n');
            }

            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return "";
    }

    private String getFilePath(String templateName) {
        String language = ConfigPropertyFetcher.getConfigProperty("language");

        return String.format(
            "./src/main/java/com/scott/learnjava/app/templates/language/%s/%s",
            language,
            templateName
        );
    }

}
