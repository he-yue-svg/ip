package leo;

import java.util.Scanner;

public class Ui {
    private static String line = "----------------------------------------";
    protected Scanner sc;

    public Ui() {
        this.sc = new Scanner(System.in);
    }

    public void showWelcome() {
        System.out.println(line + "\n" + "Hello I'm leo.Leo\n"
                + "What can I do for you?\n" + line);
    }

    public void goodBye() {
        System.out.println(line);
        System.out.println("Bye. Hope to see you again soon!\n" + line);
        sc.close();
    }

    public void showMarked(String str) {
        System.out.println(line);
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(str);
        System.out.println(line);
    }

    public void showUnmarked(String str) {
        System.out.println(line);
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(str);
        System.out.println(line);
    }

    public String readCommand() {
        String input = sc.nextLine();
        String trimmed = input.trim();
        return trimmed;
    }

    public void taskAdded(String str, int size) {
        System.out.println(line);
        System.out.println("Got it. I've added this task:");
        System.out.println(str);
        System.out.println("Now you have " + size + " tasks in the list.");
        System.out.println(line);
    }

    public void taskDeleted(String str, int size) {
        System.out.println(line);
        System.out.println("Noted. I've removed this task:");
        System.out.println(str);
        System.out.println("Now you have " + size + " tasks in the list.");
        System.out.println(line);
    }

    public void iterate(String str) {
        System.out.println(line);
        System.out.println("Here are the tasks in your list");
        System.out.println(str);
        System.out.println(line);
    }

    public void find(String str) {
        System.out.println(line);
        System.out.println("Here are the tasks in your list");
        System.out.println(str);
        System.out.println(line);
    }

    public void showError(Exception e) {
        System.out.println(line);
        System.out.println(e.getMessage());
        System.out.println(line);
    }
}
