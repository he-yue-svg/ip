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

    public void addTask(Task task) {
        this.list.add(task);
    }

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

    public void saveToStorage(FileWriter fw) throws IOException {
        for (Task task : this.list) {
            fw.write(task.toSaveFormat() + System.lineSeparator());
        }
    }

    public String elem(int index) throws IndexOutOfBounds {
        if (index > this.list.size() || index <= 0) {
            throw new IndexOutOfBounds("Index not present");
        }
        return this.list.get(index-1).toString();
    }

    public String iterate() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<this.list.size(); i++) {
            sb.append(i+1 + ". ").append(this.list.get(i).toString()).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
