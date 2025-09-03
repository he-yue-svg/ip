package leo;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Deletes the task from the ArrayList wrapped around the TaskList
     * Call methods of the Ui to print relevant messages
     * Saves the updated TaskList in the file by calling methods in storage
     * @param tasks TaskList object of Leo.java, contain tasks
     * @param ui Ui object of Leo.java
     * @param storage Storage object of Leo.java, linked to a file where data will be written and stored
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            tasks.deleteTask(index);
            int size = tasks.size();
            ui.taskDeleted(tasks.elem(size - 1), size);
            storage.save(tasks);
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }
}
