package chatterbox.task;

public class Task {
    protected String description;
    protected String tag = "";
    protected boolean isDone;

    /**
     * Task constructor.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.tag = "";
        this.isDone = false;
    }

    /**
     * Returns done or not done.
     *
     * @return "[X]" if done, "[ ]" not done.
     */
    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]");
    }

    /**
     * Marks the task as completed.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not yet completed.
     */
    public void markAsNotDone() {
        this.isDone = false;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String toString() {
        if (tag != "") {
            return getStatusIcon() + " " + description + " #" + tag;
        } else {
            return getStatusIcon() + " " + description;
        }
        
    }

    public String toFileString() {
        if (isDone) {
            return "1 | " + description;
        } else {
            return "0 | " + description;
        }
    }
}
