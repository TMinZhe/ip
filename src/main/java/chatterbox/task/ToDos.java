package chatterbox.task;

public class ToDos extends Task {
    /**
     * Constructs a ToDos task with the specified description.
     *
     * @param description The description of the todo task.
     */
    public ToDos(String description) {
        super(description);
    }

    /**
     * Returns a string representation of the Todo task.
     * Includes the task type identifier [T], the completion status, and the
     * description.
     *
     * @return A formatted string representing the todo task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Returns a string formatted for saving the Todo task to a data file.
     * The format used is: T | isDone | description.
     *
     * @return A machine-readable string representation of the todo for storage.
     */
    @Override
    public String toFileString() {
        if (isDone) {
            return "T | 1 | " + description;
        } else {
            return "T | 0 | " + description;
        }
    }
}
