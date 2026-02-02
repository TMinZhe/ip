package storage;

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

    public Storage(String filePath) {
        this.txtPath = Paths.get(filePath);
    }

    public ArrayList<Task> loadChat() throws Exception {
        ArrayList<Task> tasks = new ArrayList<Task>();
        if (!Files.exists(txtPath)) {
            try {
                Files.createFile(txtPath);
                System.out.println("File created: " + txtPath.getFileName());
            } catch (Exception e) {
                System.out.println("Error creating file:");
                e.printStackTrace();
            }
            return tasks;
        } else {
            try {
                List<String> lines = Files.readAllLines(txtPath);
                for (String line : lines) {
                    String[] parts = line.split(" \\| ");
                    String description = parts[2];

                    if (line.startsWith("T |")) {
                        String task = description;
                        ToDos newToDo = new ToDos(task);
                        tasks.add(newToDo);
                    } else if (line.startsWith("D |")) {
                        Deadline newDeadline = new Deadline(description, LocalDate.parse(parts[3]));
                        tasks.add(newDeadline);
                    } else if (line.startsWith("E |")) {
                        Events newEvent = new Events(description, LocalDateTime.parse(parts[3]),
                                LocalDateTime.parse(parts[4]));
                        tasks.add(newEvent);
                    } else {
                        Task newTask = new Task(description);
                        tasks.add(newTask);
                    }
                }

            } catch (Exception e) {
                System.out.println("Error reading file:");
                e.printStackTrace();
            }
            return tasks;

        }
    }

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
