public class Ui {
    private final String botName = "ChatterBox";

    public void showWelcome() {
        System.out.println("        Hello! I'm " + botName);
        System.out.println("        What can I do for you?");
    }

    public void showMessage(String message) {
        System.out.println("        " + message);
    }

    public void showBye() {
        System.out.println("        Bye. Hope to see you again soon!");
    }

    public void showError(String message) {
        System.out.println(message);
    }
}
