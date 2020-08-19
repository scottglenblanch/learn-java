import java.util.HashMap;
import java.util.Map;

public class EuphemismGenerator {

    private Map<String, String> mapTabooToEuphemism;
    private String originalMessage;

    public EuphemismGenerator(String originalMessage) {
        this.initOriginalMessage(originalMessage);
        this.initTabooToEuphemism();
    }

    public String getMessageWithEuphemisms() {
        String newMessage = originalMessage;

        for (String key: mapTabooToEuphemism.keySet()) {
            String value = mapTabooToEuphemism.get(key);
            newMessage = newMessage.replaceAll(key, value);
        }

        return newMessage;
    }

    private void initOriginalMessage(String originalString) {
        this.originalMessage = originalString;
    }

    private void initTabooToEuphemism() {
        mapTabooToEuphemism = new HashMap<>();

        mapTabooToEuphemism.put("Voldemort", "He who must not be named");
        mapTabooToEuphemism.put("fireworks", "those banned glittery explosive items");
        mapTabooToEuphemism.put("Spiders", "those 8 legged things we don't talk about");
    }
}