package leo;

import java.util.Scanner;

public class Ui {
    private static String line = "----------------------------------------";
    protected Scanner sc;

    public Ui() {
        this.sc = new Scanner(System.in);
    }

    public String showWelcome() {
        System.out.println(line + "\n" + "Hello I'm leo.Leo\n"
                + "What can I do for you?\n" + line);
        return "Hello I'm leo.Leo, what can I do for you?";
    }

    public String goodBye() {
        System.out.println(line);
        System.out.println("Bye. Hope to see you again soon!\n" + line);
        sc.close();
        return "Bye. Hope to see you again soon!";
    }

    public String showMarked(String str) {
        System.out.println(line);
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(str);
        System.out.println(line);
        return ("Nice! I've marked this task as done:" + "\n" + str);
    }

    public String showUnmarked(String str) {
        System.out.println(line);
        System.out.println("Nice! I've marked this task as not done:");
        System.out.println(str);
        System.out.println(line);
        return ("Nice! I've marked this task as not done:" + "\n" + str);
    }

    public String readCommand() {
        String input = sc.nextLine();
        String trimmed = input.trim();
        return trimmed;
    }

    public String taskAdded(String str, int size) {
        System.out.println(line);
        System.out.println("Got it. I've added this task:");
        System.out.println(str);
        System.out.println("Now you have " + size + " tasks in the list.");
        System.out.println(line);
        return ("Got it. I've added this task:" + "\n" + str + "\n" + "Now you have " + size + " tasks in the list.");
    }

    public String taskDeleted(String str, int size) {
        System.out.println(line);
        System.out.println("Noted. I've removed this task:");
        System.out.println(str);
        System.out.println("Now you have " + size + " tasks in the list.");
        System.out.println(line);
        return ("Noted. I've removed this task:" + "\n" + str + "\n" + "Now you have " + size + " tasks in the list.");
    }

    public String iterate(String str) {
        System.out.println(line);
        System.out.println("Here are the tasks in your list");
        System.out.println(str);
        System.out.println(line);
        return ("Here are the tasks in your list" + "\n" + str);
    }

    public String find(String str) {
        System.out.println(line);
        System.out.println("Here are the tasks in your list");
        System.out.println(str);
        System.out.println(line);
        return ("Here are the tasks in your list" + "\n" + str);
    }

    public String showError(Exception e) {
        System.out.println(line);
        System.out.println(e.getMessage());
        System.out.println(line);
        return e.getMessage();
    }
}
