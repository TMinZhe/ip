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
        tasks.addTask(new ToDos("read books"));
        assertEquals(1, tasks.getSize());
    }

    @Test
    public void testRemoveTask() {
        TaskList tasks = new TaskList(new ArrayList<>());
        tasks.addTask(new ToDos("read books"));
        tasks.removeTask(0);
        assertEquals(0, tasks.getSize());
    }

    @Test
    public void testGetTask_invalidIndex_throwsIndexOutOfBoundsException() {
        TaskList tasks = new TaskList(new ArrayList<>());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            tasks.getTask(0);
        });
    }
}
