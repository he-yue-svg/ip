package leo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.file.Files;


public class Storage {
    String filePath;

    public Storage(String filepath) {
        this.filePath = filepath;
    }

    private void ensureParentDir() {
        File f = new File(filePath).getParentFile();
        if (f != null && !f.exists()) {
            f.mkdirs();   // create ./data/ if missing
        }
    }

    public void save(TaskList lst) throws IOException {
        ensureParentDir();
        FileWriter fw  = new FileWriter(this.filePath, false);
        lst.saveToStorage(fw);
        fw.close();
    }

    public ArrayList<Task> load() throws IOException {
        ArrayList<Task> tasks = new ArrayList<>();
        if (!Files.exists(Paths.get(filePath))) {
            return tasks;
        }

        for (String line : Files.readAllLines(Paths.get(filePath))) {
            // reads every line and takes in each line as the argument
            // parses the line
            Task t = Parser.fromSaveFormat(line);
            if (t != null) {
                tasks.add(t);
            }
        }

        return tasks;
    }
}
