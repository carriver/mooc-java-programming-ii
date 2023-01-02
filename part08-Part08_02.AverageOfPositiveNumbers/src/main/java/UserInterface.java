
import java.util.Scanner;

public class UserInterface {

    private Scanner scan;
    private int sum;
    private int count;

    public UserInterface(Scanner scan) {
        this.scan = new Scanner(System.in);
        this.sum = 0;
        this.count = 0;
    }

    public void start() {

        while (true) {
            String input = scan.nextLine();

            if (input.equals("0")) {
                break;
            }

            if (input.isEmpty() || !(input.matches("-?\\d+(\\.\\d+)?"))) {
                System.out.println("Not a valid number!");
                continue;
            }

            if (Integer.valueOf(input) > 0) {
                this.sum += Integer.valueOf(input);
                this.count++;
            }
        }

        if (this.sum <= 0) {
            System.out.println("Cannot calculate the average");
        } else {
            System.out.println(this.sum * 1.0 / this.count);

        }

        this.scan.close();
    }

}
