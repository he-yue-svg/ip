public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsUndone() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        return ("[" + this.getStatusIcon() + "] " + this.description);
    }

    public abstract String toSaveFormat();

    public static Task fromSaveFormat(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length < 3) return null;

        // check if it is a todo, deadline or event
        String type = parts[0];
        boolean done = "1".equals(parts[1]);

        switch (type) {
            case "T": {
                // T | 0 | read book
                ToDo t = new ToDo(parts[2]);
                if (done) t.markAsDone();
                return t;
            }
            case "D": {
                // D | 1 | return book | by=Sunday
                if (parts.length < 4) return null;
                String desc = parts[2];
                String by = parts[3].replaceFirst("^by=", "");
                Deadline d = new Deadline(desc, by);
                if (done) d.markAsDone();
                return d;
            }
            case "E": {
                // E | 0 | project meeting | from=Mon 2pm | to=4pm
                if (parts.length < 5) return null;
                String desc = parts[2];
                String from = parts[3].replaceFirst("^from=", "");
                String to = parts[4].replaceFirst("to=", "");
                Event e = new Event(desc, from, to);
                if (done) e.markAsDone();
                return e;
            }
            default:
                return null;
        }
    }
}
