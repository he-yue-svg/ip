public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            tasks.deleteTask(index);
            int size = tasks.size();
            ui.taskDeleted(tasks.elem(size-1), size);
            storage.save(tasks);
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }
}
