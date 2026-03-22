package chatterbox.task;

import java.util.ArrayList;

/**
 * Represents a list of tasks in the ChatterBox application.
 * This class provides methods to manipulate the internal list of tasks,
 * including adding, removing, and retrieving tasks, as well as managing tags.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructs a TaskList with an existing list of tasks.
     *
     * @param tasks An ArrayList of tasks to initialize the list.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Retrieves a task at a specific index from the list.
     *
     * @param index The zero-based index of the task to retrieve.
     * @return The Task at the specified index.
     * @throws AssertionError If the index is out of the valid range.
     */
    public Task getTasks(int index) {
        assert index >= 0 && index < tasks.size() : "index out of the limit";
        return tasks.get(index);
    }

    /**
     * Returns the entire list of tasks.
     *
     * @return An ArrayList containing all current tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Adds a new task to the list.
     *
     * @param task The Task object to be added to the list.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Assigns a tag to a specific task in the list.
     *
     * @param index The zero-based index of the task to tag.
     * @param tag   The string tag to be applied to the task.
     */
    public void addTag(int index, String tag) {
        tasks.get(index).setTag(tag);

    }

    /**
     * Removes a task from the list based on its index.
     *
     * @param index The zero-based index of the task to be removed.
     * @throws AssertionError If the index is out of the valid range.
     */
    public void removeTask(int index) {
        assert index >= 0 && index < tasks.size() : "index out of the limit";
        tasks.remove(index);
    }

    /**
     * Returns the number of tasks currently in the list.
     *
     * @return The size of the task list.
     */
    public int getSize() {
        return tasks.size();
    }

}
