package chatterbox.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task with a specific deadline.
 * A <code>Deadline</code> object contains a description and a date by which
 * the task must be completed.
 */
public class Deadline extends Task {
    protected LocalDate by;

    /**
     * Constructs a Deadline task with a description and a due date.
     *
     * @param description The description of the task.
     * @param by          The LocalDate representing the deadline.
     */
    public Deadline(String description, LocalDate by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns a string representation of the Deadline task.
     * Includes the task type identifier [D], the completion status,
     * the description, and the formatted deadline date.
     *
     * @return A formatted string representing the deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    /**
     * Returns a string formatted for saving the Deadline task to a data file.
     * The format used is: D | isDone | description | by.
     *
     * @return A machine-readable string representation of the task.
     */
    @Override
    public String toFileString() {
        if (isDone) {
            return "D | 1 | " + description + " | " + by;
        } else {
            return "D | 0 | " + description + " | " + by;
        }
    }
}
