import java.util.Scanner;

public class Leo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task[] array = new Task[100];
        int index = 0;
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
                    System.out.println(i+1 + ".[" + array[i].getStatusIcon()
                            + "] " + array[i].getDescription());
                }
                System.out.println(line);
            } else if (input.startsWith("mark")) {
                String[] parts = input.split(" ");
                int value = Integer.parseInt(parts[parts.length-1]);
                array[value-1].markAsDone();
                System.out.println("Nice, I've marked this task as done:");
                System.out.println("[" + array[value-1].getStatusIcon()
                        + "] " + array[value-1].getDescription());
                System.out.println(line);
            } else if (input.startsWith("unmark")) {
                String[] parts = input.split(" ");
                int value = Integer.parseInt(parts[parts.length-1]);
                array[value-1].markAsUndone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("[" + array[value-1].getStatusIcon()
                        + "] " + array[value-1].getDescription());
                System.out.println(line);
            } else {
                Task task = new Task(input);
                array[index] = task;
                index++;
                System.out.println(line);
                System.out.println("added: " +  input + "\n" + line);
            }
        }

        sc.close();
    }

}
