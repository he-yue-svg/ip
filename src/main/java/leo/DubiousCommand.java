package leo;

public class DubiousCommand extends Command {

    /**
     * Signals Ui to print the message
     * @param tasks
     * @param ui
     * @param storage
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showError(new UnknownCommand("I cannot understand what you said"));
    }
}
