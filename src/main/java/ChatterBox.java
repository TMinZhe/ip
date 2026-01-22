public class ChatterBox {
    public static void main(String[] args) {
        String botName = "ChatterBox";
        boolean chatting = true;
        System.out.println("        Hello! I'm " + botName);
        System.out.println("        What can I do for you?");
        while (chatting) {
            String userInput = System.console().readLine();
            if (userInput.equalsIgnoreCase("bye")) {
                chatting = false;
                break;
            } else {
                System.out.println("        " + userInput);
            }
        }
        System.out.println("        Bye. Hope to see you again soon!");
    }
}
