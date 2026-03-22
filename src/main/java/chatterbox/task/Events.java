package chatterbox.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an event task that occurs within a specific time range.
 * An <code>Events</code> object contains a description, a start time, and an
 * end time.
 */
public class Events extends Task {
    protected LocalDateTime at;
    protected LocalDateTime to;

    /**
     * Constructs an Events task with a description, start time, and end time.
     *
     * @param description The description of the event.
     * @param at          The LocalDateTime representing the start of the event.
     * @param to          The LocalDateTime representing the end of the event.
     */
    public Events(String description, LocalDateTime at, LocalDateTime to) {
        super(description);
        this.at = at;
        this.to = to;
    }

    /**
     * Returns a string representation of the Event task.
     * Includes the task type identifier [E], the completion status, the
     * description,
     * and the formatted start and end times.
     *
     * @return A formatted string representing the event.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + at.format(DateTimeFormatter.ofPattern("MMM d yyyy HH:mm"))
                + " to: " + to
                        .format(DateTimeFormatter.ofPattern("MMM d yyyy HH:mm"))
                + ")";
    }

    /**
     * Returns a string formatted for saving the Event task to a data file.
     * The format used is: E | isDone | description | at | to.
     *
     * @return A machine-readable string representation of the event for storage.
     */
    @Override
    public String toFileString() {
        if (isDone) {
            return "E | 1 | " + description + " | " + at + " | " + to;
        } else {
            return "E | 0 | " + description + " | " + at + " | " + to;
        }
    }
}
