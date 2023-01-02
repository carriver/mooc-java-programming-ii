
import java.util.Scanner;

public class UserInterface {

    private Scanner scan;
    private int first;
    private int second;

    public UserInterface(Scanner scan) {
        this.scan = new Scanner(System.in);
        this.first = 0;
        this.second = 0;
    }

    public void start() {
        System.out.println("First: " + this.first + "/100");
        System.out.println("Second: " + this.second + "/100");

        while (true) {
            String input = scan.nextLine();

            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            if (parts[1].isEmpty() || !(parts[1].matches("-?\\d+(\\.\\d+)?"))) {
                System.out.println("Not a valid number!");
                continue;
            }

            RunCommand(command, amount);

            System.out.println();
            System.out.println("First: " + this.first + "/100");
            System.out.println("Second: " + this.second + "/100");

        }

        this.scan.close();
    }

    public void RunCommand(String command, int amount) {
        if (command.equals("add")) {
            if (amount > 0) {
                this.first += amount;
            }

            if (this.first > 100) {
                this.first = 100;
            }
        }

        if (command.equals("move")) {
            if (amount > this.first) {
                amount = this.first;
            }

            if (amount > 0 && this.first != 0) {
                this.first -= amount;
                this.second += amount;
            }

            if (this.first > 100) {
                this.first = 100;
            } else if (this.first < 0) {
                this.first = 0;
            }

            if (this.second > 100) {
                this.second = 100;
            }

        }

        if (command.equals("remove")) {
            if (amount > 0) {
                this.second -= amount;
            }

            if (this.second > 100) {
                this.second = 100;
            } else if (this.second < 0) {
                this.second = 0;
            }
        }
    }

}
