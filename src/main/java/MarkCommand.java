public class MarkCommand extends Command {
    private int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    // need an instance of an object to run this
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            tasks.markDone(index);
            ui.showMarked(tasks.elem(index));
            storage.save(tasks);
        } catch (Exception err) {
            ui.showError(err);
        }
    }
}
