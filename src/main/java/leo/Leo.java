package leo;

public class Leo {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Leo(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (Exception e) {
            ui.showError(e);
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (Exception e) {
                ui.showError(e);
            }
        }
    }

    public static void main(String[] args) {
        new Leo("./data/leo.Leo.txt").run();
    }

}
