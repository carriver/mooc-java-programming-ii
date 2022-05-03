
import java.util.Scanner;

public class UserInterface {

    private Scanner scan;
    private int num;

    public UserInterface(Scanner scan) {
        this.scan = new Scanner(System.in);
        this.num = 0;
    }

    public void start() {

        while (true) {
            String input = scan.nextLine();

            if (input.equals("end")) {
                break;
            }

            if (input.isEmpty() || !(input.matches("-?\\d+(\\.\\d+)?"))) {
                System.out.println("Not a valid number!");
                continue;
            }

            this.print(input);
        }

        this.scan.close();
    }

    public void print(String input) {
        this.num = Integer.valueOf(input);

        System.out.println(this.num * this.num * this.num);
    }

}
