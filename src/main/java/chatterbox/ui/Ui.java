package chatterbox.ui;

public class Ui {
    private final String botName = "ChatterBox";

    public String showWelcome() {
        StringBuilder sb = new StringBuilder();
        sb.append("        Hello! I'm " + botName + "\n");
        sb.append("        What can I do for you?\n");
        return sb.toString();
    }

    public String showMessage(String message) {
        // System.out.println(" " + message);
        return "        " + message + "\n";
    }

    public String showBye() {
        StringBuilder sb = new StringBuilder();
        sb.append("        Bye. Hope to see you again soon!\n");
        return sb.toString();
    }

    public String showError(String message) {
        return "        " + message + "\n";
    }
}
