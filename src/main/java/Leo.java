import java.util.Scanner;

public class Leo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = "----------------------------------------";
        System.out.println(line+ "\n" + "Hello I'm Leo\n" +
                "What can I do for you?\n" + line);

        while (true) {
            String input = sc.nextLine(); // reads input

            if (input.equals("bye")) {
                System.out.println(line + "\n" + "Bye. Hope to see you again soon!\n" + line);
                break;
            } else {
                System.out.println(line + "\n" + input + "\n" + line);
            }
        }

        sc.close();
    }
}
