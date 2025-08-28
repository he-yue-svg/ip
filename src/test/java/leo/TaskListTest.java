package leo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {
    @Test
    public void markDone_Undone() throws Exception {
        TaskList list = new TaskList();
        ToDo t = new ToDo("drink vanilla latte");
        list.addTask(t);

        list.markDone(1);
        assertEquals("T | 1 | drink vanilla latte", t.toSaveFormat());

        list.markUndone(1);
        assertEquals("T | 0 | drink vanilla latte", t.toSaveFormat());
    }
}
