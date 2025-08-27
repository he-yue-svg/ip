import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leo {
    private static List<Task> array;
    private static Storage storage;
    private static String line = "----------------------------------------";
    public static void main(String[] args) {
        storage = new Storage("./data/Leo.txt");

        try {
            array = storage.load();
        } catch (Exception e){
            array = new ArrayList<>();
        }

        Scanner sc = new Scanner(System.in);
        String line = "----------------------------------------";
        System.out.println(line+ "\n" + "Hello I'm Leo\n" +
                "What can I do for you?\n" + line);

        while (sc.hasNextLine()) {
            String input = sc.nextLine();// reads input

            String trimmed = input.trim();

            try {
                if (trimmed.equals("bye")) {
                    System.out.println(line);
                    System.out.println("Bye. Hope to see you again soon!\n" + line);
                    break;
                } else if (trimmed.equals("list")) {
                    System.out.println(line);
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < array.size(); i++) {
                        System.out.println(i + 1 + "." + array.get(i).toString());
                    }
                    System.out.println(line);
                } else if (trimmed.startsWith("mark")) {
                    String[] parts = trimmed.split(" ");
                    int value = Integer.parseInt(parts[parts.length - 1]);
                    if (value > array.size()) {
                        throw new IndexOutOfBounds("Index does not exist");
                    }
                    array.get(value - 1).markAsDone();
                    System.out.println(line);
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(array.get(value-1).toString());
                    System.out.println(line);
                    storage.save(array);

                } else if (trimmed.startsWith("unmark")) {
                    String[] parts = trimmed.split(" ");
                    int value = Integer.parseInt(parts[parts.length - 1]);
                    if (value > array.size()) {
                        throw new IndexOutOfBounds("Index does not exist");
                    }
                    array.get(value-1).markAsUndone();
                    System.out.println(line);
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println(array.get(value-1).toString());
                    System.out.println(line);
                    storage.save(array);

                } else if (trimmed.startsWith("delete")) {
                    String[] parts = trimmed.split(" ");
                    int value = Integer.parseInt(parts[parts.length-1]);
                    if (value > array.size()) {
                        throw new IndexOutOfBounds("Index does not exist");
                    }
                    System.out.println(line);
                    System.out.println("Noted. I've removed this task:");
                    System.out.println(array.get(value-1).toString());
                    array.remove(value-1);
                    System.out.println("Now you have " + array.size() + " tasks in the list.");
                    System.out.println(line);
                    storage.save(array);

                } else if (trimmed.startsWith("todo")) {
                    String description = trimmed.replaceFirst("^\\s*todo\\b", "").trim();
                    if (description.isEmpty()) {
                        throw new NoTask("Description of a todo cannot be empty");
                    }
                    ToDo task = new ToDo(description);
                    Leo.addTask(task);
                    storage.save(array);

                } else if (trimmed.startsWith("deadline")) {
                    String[] parts = trimmed.split("/by", 2);
                    if (parts.length < 2) {
                        throw new NoTask("Deadline is written in the wrong format");
                    }
                    String type = parts[0].trim();
                    String description = type.replaceFirst("^\\s*deadline\\b", "").trim();
                    String date = parts[1].trim();
                    if (date.isEmpty()) {
                        throw new NoTask("Date of deadline cannot be empty");
                    }
                    Deadline task = new Deadline(description, date);
                    Leo.addTask(task);
                    storage.save(array);

                } else if (trimmed.startsWith("event")) {
                    String[] firstSplit = trimmed.split("/from", 2);
                    if (firstSplit.length < 2) {
                        throw new NoTask("Event is written in the wrong format");
                    }
                    String description = firstSplit[0].replaceFirst("^\\s*event\\b", "").trim();
                    String[] secondSplit = firstSplit[1].split("/to", 2);
                    if (secondSplit.length < 2) {
                        throw new NoTask("Event is written in the wrong format");
                    }
                    String start = secondSplit[0].trim();
                    String to = secondSplit[1].trim();
                    Event task = new Event(description, start, to);
                    Leo.addTask(task);
                    storage.save(array);

                } else if (!trimmed.isEmpty()) {
                    throw new UnknownCommand("I'm sorry, I cannot understand what you are saying");
                }

            } catch (Exception err) {
                System.out.println(line);
                System.out.println(err.getMessage());
                System.out.println(line);
            }
        }

        sc.close();

    }

    private static void addTask(Task task) {
        array.add(task);
        System.out.println(line);
        System.out.println("Got it. I've added this task:");
        System.out.println(task.toString());
        System.out.println("Now you have " + array.size() + " tasks in the list.");
        System.out.println(line);
    }


}
