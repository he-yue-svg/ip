import java.util.Scanner;

public class Leo {
    private static Task[] array = new Task[100];
    private static int index = 0;
    private static String line = "----------------------------------------";
    public static void main(String[] args) {
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
                    for (int i = 0; i < index; i++) {
                        System.out.println(i + 1 + "." + array[i].toString());
                    }
                    System.out.println(line);
                } else if (trimmed.startsWith("mark")) {
                    String[] parts = input.split(" ");
                    int value = Integer.parseInt(parts[parts.length - 1]);
                    array[value - 1].markAsDone();
                    System.out.println(line);
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(array[value - 1].toString());
                    System.out.println(line);
                } else if (trimmed.startsWith("unmark")) {
                    String[] parts = input.split(" ");
                    int value = Integer.parseInt(parts[parts.length - 1]);
                    array[value - 1].markAsUndone();
                    System.out.println(line);
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println(array[value - 1].toString());
                    System.out.println(line);
                } else if (trimmed.startsWith("todo")) {
                    String description = trimmed.replaceFirst("^\\s*todo\\b", "").trim();
                    if (description.isEmpty()) {
                        throw new NoTask("Description of a todo cannot be empty");
                    }
                    ToDo task = new ToDo(description);
                    Leo.addTask(task);
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
                } else if (!trimmed.isEmpty()) {
                    throw new UnknownCommand("I'm sorry, I cannot understand what you are saying");
                }
            } catch (NoTask | UnknownCommand err) {
                System.out.println(err.getMessage());
            }
        }

        sc.close();

    }

    private static void addTask(Task task) {
        array[index] = task;
        index++;
        System.out.println(line);
        System.out.println("Got it. I've added this task:");
        System.out.println(task.toString());
        System.out.println("Now you have " + index + " tasks in the list.");
        System.out.println(line);
    }


}
