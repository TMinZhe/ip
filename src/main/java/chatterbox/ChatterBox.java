package chatterbox;

import java.util.ArrayList;
import java.util.Scanner;

import chatterbox.exception.ChatterBoxException;
import chatterbox.parser.Parser;
import chatterbox.storage.Storage;
import chatterbox.task.Task;
import chatterbox.task.TaskList;
import chatterbox.ui.Ui;

/**
 * Represents the main method for the ChatterBox task management
 * application.
 * It initializes the user interface, seeding data, and task list.
 */

public class ChatterBox {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Constructs an instance with the specified file path for database.
     *
     * @param filePath The filepath where the chat is stored.
     */

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

    /**
     * Starts the application loop, reading user input and passing it to the parser
     * until the user terminates the session.
     */
    public void run() {
        ui.showWelcome();
        Scanner sc = new Scanner(System.in);
        boolean isChatting = true;
        while (isChatting) {
            try {
                if (sc.hasNextLine()) {
                    String userInput = sc.nextLine();
                    Parser.parse(userInput, tasks, ui, storage);
                } else {
                    isChatting = false;
                }
            } catch (ChatterBoxException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public String getResponse(String input) {
        try {
            // You may need to refactor Parser.parse to return a String
            // instead of taking 'ui' as a parameter to print things.
            return Parser.parse(input, tasks, ui, storage);
        } catch (ChatterBoxException e) {
            return e.getMessage();
        }
    }

    /**
     * Main method to start the ChatterBox application.
     */
    public static void main(String[] args) {
        ChatterBox chatterBox = new ChatterBox("./data/chatterBox.txt");
        chatterBox.run();
    }
}
