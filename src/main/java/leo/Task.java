package leo;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the status whether the string is done
     * @return String indicating if task is done
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Marks the task as done
     */
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

}
