import java.util.Scanner;

public class Leo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] array = new String[100];
        int index = 0;
        String line = "----------------------------------------";
        System.out.println(line+ "\n" + "Hello I'm Leo\n" +
                "What can I do for you?\n" + line);

        while (true) {
            String input = sc.nextLine(); // reads input

            if (input.equals("bye")) {
                System.out.println(line + "\n" + "Bye. Hope to see you again soon!\n" + line);
                break;
            } else if (input.equals("list")) {
                for (int i=0; i<index; i++) {
                    System.out.println(i+1 + ". " + array[i]);
                }
                System.out.println(line);
            } else {
                array[index] = input;
                index++;
                System.out.println(line + "\n" + "added: " +  input + "\n" + line);
            }
        }

        sc.close();
    }
}
