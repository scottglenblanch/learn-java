public class MessageGenerator {

    private String defaultMessage;
    private String messageFromArgs;

    private EuphemismGenerator euphemismGenerator;

    public MessageGenerator(String[] args) {
        initDefaultMessage();
        initMessageFromArgs(args);
        initEuphemismGenerator();
    }

    public String getMessage() {
        String censored = euphemismGenerator.getMessageWithEuphemisms();

        return hasMessageFromArgs() ? censored : defaultMessage;
    }


    public boolean hasMessageFromArgs() {
        return messageFromArgs.length() > 0;
    }

    private void initDefaultMessage() {
        defaultMessage = "add arguments to see what happens :) ";
    }

    private void initEuphemismGenerator() {
        this.euphemismGenerator = new EuphemismGenerator(messageFromArgs);
    }

    private void initMessageFromArgs(String[] args) {
        ArgsMessageGenerator argsMessageGenerator = new ArgsMessageGenerator(args);
        this.messageFromArgs = argsMessageGenerator.getMessageFromArgs();

    }

}
