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

        while (true) {
            String input = sc.nextLine(); // reads input

            if (input.equals("bye")) {
                System.out.println(line);
                System.out.println("Bye. Hope to see you again soon!\n" + line);
                break;
            } else if (input.equals("list")) {
                System.out.println("Here are the tasks in your list");
                for (int i=0; i<index; i++) {
                    System.out.println(i+1 + "." + array[i].toString());
                }
                System.out.println(line);
            } else if (input.startsWith("mark")) {
                String[] parts = input.split(" ");
                int value = Integer.parseInt(parts[parts.length-1]);
                array[value-1].markAsDone();
                System.out.println("Nice, I've marked this task as done:");
                System.out.println(array[value-1].toString());
                System.out.println(line);
            } else if (input.startsWith("unmark")) {
                String[] parts = input.split(" ");
                int value = Integer.parseInt(parts[parts.length-1]);
                array[value-1].markAsUndone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println(array[value-1].toString());
                System.out.println(line);
            } else if (input.startsWith("todo")) {
                String description = input.replaceFirst("^todo\\s+", "");
                ToDo task = new ToDo(description);
                Leo.addTask(task);
            } else if (input.startsWith("deadline")) {
                String[] parts = input.split("/by", 2);
                String type = parts[0].trim();
                String description = type.replaceFirst("^deadline\\s+", "");
                String date = parts[1].trim();
                Deadline task = new Deadline(description, date);
                Leo.addTask(task);
            } else if (input.startsWith("event")) {
                String[] firstSplit = input.split("/from", 2);
                String description = firstSplit[0].replaceFirst("^event\\s+", "").trim();
                String[] secondSplit = firstSplit[1].split("/to", 2);

                String start = secondSplit[0].trim();
                String to = secondSplit[1].trim();
                Event task = new Event(description, start, to);
                Leo.addTask(task);
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
