package leo;

public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        assert this.index > 0 : "Index needs to be positive";
        try {
            tasks.markUndone(index);
            storage.save(tasks);
            return ui.showUnmarked(tasks.elem(index));
        } catch (Exception err) {
            return ui.showError(err);
        }
    }
}

