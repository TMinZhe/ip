public class Events extends Task {
    protected String at;
    protected String to;

    public Events(String description, String at, String to) {
        super(description);
        this.at = at;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + at + " to: " + to + ")";
    }
}
