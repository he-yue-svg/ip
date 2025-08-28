package leo;

public class AddCommand extends Command {
    Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            tasks.addTask(task);
            int size = tasks.size();
            ui.taskAdded(tasks.elem(size), size);
            storage.save(tasks);
        } catch (Exception e) {
            ui.showError(e);
        }

    }
}
