package leo;

public class Leo {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Retrieves all the tasks stored in the hard disk
     * @param filePath location of the text file to store the tasks
     */
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

    /**
     * Starts the chatbot, parse and execute line by line
     * Terminates when c.isExit()
     * @throws Exception if execution of commands throw errors
     */
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

    public String getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            String response = c.execute(tasks, ui, storage);
            return response;
        } catch (Exception e) {
            return ui.showError(e);
        }
    }


    public static void main(String[] args) {
        new Leo("./data/leo.Leo.txt").run();
    }

}
