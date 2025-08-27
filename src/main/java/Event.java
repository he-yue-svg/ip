public class Event extends Task {
    protected String start;
    protected String end;

    public Event(String description, String start, String end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return ("[E]" + super.toString() + " (from: " + this.start +
                " to: " + this.end + ")");
    }

    @Override
    public String toSaveFormat() {
        return String.join(" | ", "E", (isDone ? "1" : "0"), description,
                "from=" + start, "to=" + end);
    }


}
