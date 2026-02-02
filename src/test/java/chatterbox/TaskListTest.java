package chatterbox.task;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import chatterbox.exception.ChatterBoxException;
import chatterbox.parser.Parser;
import chatterbox.storage.Storage;
import chatterbox.task.TaskList;
import chatterbox.ui.Ui;

public class TaskListTest {
    @Test
    public void testAddTask() {
        TaskList tasks = new TaskList(new ArrayList<>());
        tasks.addTask(new ToDos("read book"));
        assertEquals(1, tasks.getSize());
    }

    @Test
    public void testRemoveTask() {
        TaskList tasks = new TaskList(new ArrayList<>());
        tasks.addTask(new ToDos("read book"));
        tasks.removeTask(0);
        assertEquals(0, tasks.getSize());
    }
}
