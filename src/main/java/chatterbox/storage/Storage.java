package chatterbox.storage;

import java.util.ArrayList;
import java.util.List;

import chatterbox.task.Deadline;
import chatterbox.task.Events;
import chatterbox.task.Task;
import chatterbox.task.ToDos;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Storage {
    private Path txtPath;

    /**
     * Initializes the storage with a specific file path.
     *
     * @param filePath filepath to where the data is stored.
     */
    public Storage(String filePath) {
        assert filePath != null && !filePath.isEmpty() : "Filepath is empty";
        this.txtPath = Paths.get(filePath);
    }

    /**
     * Loads the task list from the local storage file.
     * If the file does not exist, it creates one.
     *
     * @return An ArrayList of tasks loaded from the file.
     * @throws Exception If there is an error during file reading or parsing.
     */
    public ArrayList<Task> loadChat() throws Exception {
        if (!Files.exists(txtPath)) {
            try {
                Files.createFile(txtPath);
                System.out.println("File created: " + txtPath.getFileName());
            } catch (Exception e) {
                System.out.println("Error creating file:");
                e.printStackTrace();
            }
            return new ArrayList<>();
        }
        return loadTasksFromFile();
    }

    private ArrayList<Task> loadTasksFromFile() throws Exception {
        ArrayList<Task> tasks = new ArrayList<>();
        List<String> lines = Files.readAllLines(txtPath);
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                tasks.add(parseLineToTask(line));
            }
        }
        return tasks;
    }

    private Task parseLineToTask(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length < 2) {
            return new Task(line);
        }

        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String description = parts[2];

        Task task;
        try {
            switch (type) {
            case "T":
                task = new ToDos(description);
                break;
            case "D":
                task = new Deadline(description, LocalDate.parse(parts[3]));
                break;
            case "E":
                task = new Events(description, LocalDateTime.parse(parts[3]), LocalDateTime.parse(parts[4]));
                break;
            default:
                
                task = new Task(parts.length > 1 ? parts[1] : type);
                break;
            }
        } catch (Exception e) {
            return new Task("Corrupted Entry: " + line);
        }

        if (isDone) {
            task.markAsDone(); // Actually apply the loaded status
        }
        return task;
    }

    /**
     * Saves the current list of tasks to the txt file.
     *
     * @param tasks The list of current tasks to save in the file.
     */
    public void saveTasks(ArrayList<Task> tasks) {
        try (BufferedWriter writer = Files.newBufferedWriter(
                txtPath,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING)) {

            for (int i = 0; i < tasks.size(); i++) {
                writer.write(tasks.get(i).toFileString());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error saving tasks:");
            e.printStackTrace();
        }

    }
}
