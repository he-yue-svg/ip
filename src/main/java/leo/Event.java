package leo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected String start;
    protected String end;
    protected LocalDate startDate;
    protected LocalDate endDate;

    public Event(String description, String start, String end) {
        super(description);
        this.start = start;
        this.end = end;
        this.startDate = LocalDate.parse(start);
        this.endDate = LocalDate.parse(end);
    }

    @Override
    public String toString() {
        return ("[E]" + super.toString() + " (from: "
                 + this.startDate.format(DateTimeFormatter.ofPattern("MMM d yyyy")) +
                " to: " +
                this.endDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"))
                + ")");
    }

    // convert the task into the form written into the file
    @Override
    public String toSaveFormat() {
        return String.join(" | ", "E", (isDone ? "1" : "0"), description,
                "from=" + start, "to=" + end);
    }


}
