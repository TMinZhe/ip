import java.util.ArrayList;
import java.util.Scanner;

public class ChatterBox {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public ChatterBox(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            ArrayList<Task> loadedTasks = storage.loadChat();
            tasks = new TaskList(loadedTasks);
        } catch (Exception e) {
            ui.showError("     OOPS!!! There was an error loading your tasks.");
            tasks = new TaskList(new ArrayList<Task>());
        }
    }

    public void run() {
        ui.showWelcome();
        Scanner scanner = new Scanner(System.in);
        boolean isChatting = true;
        while (isChatting) {
            try {
                if (scanner.hasNextLine()) {
                    String userInput = scanner.nextLine();
                    Parser.parse(userInput, tasks, ui, storage);
                } else {
                    isChatting = false;
                }
            } catch (ChatterBoxException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        ChatterBox chatterBox = new ChatterBox("./data/chatterBox.txt");
        chatterBox.run();
    }
}
