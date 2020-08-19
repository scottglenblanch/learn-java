public class App {
     public static void main(String[] args) {
     	MessageGenerator messageGenerator = new MessageGenerator(args);
     	String message = messageGenerator.getMessage();

	 	System.out.println(message);
     }
}

