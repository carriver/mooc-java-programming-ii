
import java.util.Scanner;

public class UserInterface {

    private Scanner scan;
    private Container first;
    private Container second;

    public UserInterface(Scanner scan) {
        this.scan = new Scanner(System.in);
        this.first = new Container();
        this.second = new Container();
    }

    public void start() {
        System.out.println("First: " + this.first);
        System.out.println("Second: " + this.second);

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
            System.out.println("First: " + this.first);
            System.out.println("Second: " + this.second);

        }

        this.scan.close();
    }

    public void RunCommand(String command, int amount) {
        if (command.equals("add")) {
            this.first.add(amount);
        }

        if (command.equals("move")) {
            if (amount > this.first.contains()) {
                amount = this.first.contains();
            }
            
            if (amount > 0 && this.first.contains() != 0) {
                this.first.remove(amount);
                this.second.add(amount);
            }
        }

        if (command.equals("remove")) {
            this.second.remove(amount);
        }
    }

}
