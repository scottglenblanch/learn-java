import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, String> mapTabooToEuphemism;

    public static void main(String[] args) {
        initTabooToEuphemism();
        logOutMessage(args);
    }

    private static void logOutMessage(String[] args) {
        System.out.println(getMessage(args));
    }

    private static String getMessage(String[] args) {
        String argsMessage = getArgsMessage(args);
        String defaultMessage = "add arguments to see what happens :) ";

        return isUseMessageFromArgs(argsMessage) ?  getMessageWithEuphemisms(argsMessage) : defaultMessage;
    }

    private static boolean isUseMessageFromArgs(String message) {
        return message.length() > 0;
    }

    private static void initTabooToEuphemism() {
        mapTabooToEuphemism = new HashMap<>();

        mapTabooToEuphemism.put("Voldemort", "He who must not be named");
        mapTabooToEuphemism.put("fireworks", "those banned glittery explosive items");
        mapTabooToEuphemism.put("Spiders", "those 8 legged things we don't talk about");
    }

    private static String getArgsMessage(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String word : args) {
            stringBuilder.append(word).append(" ");
        }

        return stringBuilder.toString();
    }

    private static String getMessageWithEuphemisms(String message) {
        String newMessage = message;

        for (String key : mapTabooToEuphemism.keySet()) {
            String value = mapTabooToEuphemism.get(key);
            newMessage = newMessage.replaceAll(key, value);
        }

        return newMessage;
    }
}

