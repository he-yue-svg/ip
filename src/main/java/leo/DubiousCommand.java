package leo;

public class DubiousCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showError(new UnknownCommand("I cannot understand what you said"));
    }
}
