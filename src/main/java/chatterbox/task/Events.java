package chatterbox.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Events extends Task {
    protected LocalDateTime at;
    protected LocalDateTime to;

    public Events(String description, LocalDateTime at, LocalDateTime to) {
        super(description);
        this.at = at;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + at.format(DateTimeFormatter.ofPattern("MMM d yyyy HH:mm"))
                + " to: " + to
                        .format(DateTimeFormatter.ofPattern("MMM d yyyy HH:mm"))
                + ")";
    }

    @Override
    public String toFileString() {
        if (isDone) {
            return "E | 1 | " + description + " | " + at + " | " + to;
        } else {
            return "E | 0 | " + description + " | " + at + " | " + to;
        }
    }
}
