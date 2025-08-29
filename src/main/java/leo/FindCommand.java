package leo;

public class FindCommand extends Command {
    private String str;

    public FindCommand(String str) {
        this.str = str;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.find(tasks.find(this.str));
    }
}
