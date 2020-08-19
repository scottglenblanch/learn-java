public class ArgsMessageGenerator {

    private String[] args;
    public ArgsMessageGenerator(String[] args) {
        this.args = args;
    }

    public String getMessageFromArgs() {
        StringBuilder stringBuilder = new StringBuilder();

        for(String argument: args) {
            stringBuilder.append(argument).append(" ");
        }

        return stringBuilder.toString();
    }
}
