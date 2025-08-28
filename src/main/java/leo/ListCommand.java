package leo;

public class ListCommand extends Command {

    @Override
    public void execute (TaskList tasks, Ui ui, Storage storage) {
        try {
            TaskList lst = new TaskList(storage.load());
            ui.iterate(lst.iterate());
        } catch (Exception e) {
            ui.showError(e);
        }
    }
}
