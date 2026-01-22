import java.util.ArrayList;

public class ChatterBox {
    public static void main(String[] args) {
        String botName = "ChatterBox";
        boolean chatting = true;

        ArrayList<String> chats = new ArrayList<String>();

        System.out.println("        Hello! I'm " + botName);
        System.out.println("        What can I do for you?");

        while (chatting) {
            String userInput = System.console().readLine();
            if (userInput.equalsIgnoreCase("bye")) {
                chatting = false;
                break;
            } else if (userInput.equalsIgnoreCase("list")) {
                for (String chat : chats) {
                    int index = chats.indexOf(chat) + 1;
                    System.out.println("        " + index + ". " + chat);
                }
            } else {
                chats.add(userInput);
                System.out.println("        added: " + userInput);
            }
        }
        System.out.println("        Bye. Hope to see you again soon!");
    }
}
