package leo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    List<Task> list;

    public TaskList() {
        this.list  = new ArrayList<Task>();
    }

    public TaskList(List<Task> lst) {
        this.list = lst;
    }

    public int size() {
        return this.list.size();
    }

    /**
     * Adds task to the ArrayList wrapped by TaskList
     * @param task Task to be added to the TaskList
     */
    public void addTask(Task task) {
        this.list.add(task);
    }

    /**
     * Deletes the task at the corresponding index of the TaskList
     * @param index position of the task to be deleted
     * @throws IndexOutOfBounds If index not within the size of the TaskList
     */
    public void deleteTask(int index) throws IndexOutOfBounds {
        if (index > this.list.size() || index <= 0) {
            throw new IndexOutOfBounds("Index not present");
        }
        this.list.remove(index-1);
    }

    public void markDone(int index) throws IndexOutOfBounds{
        if (index > this.list.size() || index <= 0) {
            throw new IndexOutOfBounds("Index not present");
        }
        this.list.get(index-1).markAsDone();
    }

    public void markUndone(int index) throws IndexOutOfBounds{
        if (index > this.list.size() || index <= 0) {
            throw new IndexOutOfBounds("Index not present");
        }
        this.list.get(index-1).markAsUndone();
    }

    /**
     * Converts the task to the format to be written into the storage file.
     * Writes the string into the storage file.
     * @param fw The FileWriter that belongs to the storage
     */
    public void saveToStorage(FileWriter fw) throws IOException {
        for (Task task : this.list) {
            fw.write(task.toSaveFormat() + System.lineSeparator());
        }
    }

    /**
     * Returns the string of the task at a specific position
     * @param index Position in the ArrayList
     * @return The string of the task
     * @throws IndexOutOfBounds If index not within the size of the TaskList
     */
    public String elem(int index) throws IndexOutOfBounds {
        if (index > this.list.size() || index <= 0) {
            throw new IndexOutOfBounds("Index not present");
        }
        return this.list.get(index-1).toString();
    }

    /**
     * Converts the TaskList into a string
     * @return The string of all the objects in the TaskList
     */
    public String iterate() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<this.list.size(); i++) {
            sb.append(i+1 + ". ").append(this.list.get(i).toString()).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
