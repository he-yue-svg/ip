public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            tasks.markUndone(index);
            ui.showUnmarked(tasks.elem(index));
            storage.save(tasks);
        } catch (Exception err) {
            ui.showError(err);
        }
    }
}

