import java.util.Scanner;

public class RedorBlack extends GameBooth {
    Scanner in = new Scanner(System.in);

    public RedorBlack() {
        super(1.50, "keychain", "plush fish", "Red or Black");
    }

    public String start() {
        System.out.println ("\n" + "You will draw 3 tokens from a bag of red and black tokens." + "\n" 
        + "If they are all the same colour, you win a plush fish. Otherwise, you win a keychain.");
        System.out.println ("Press Enter to draw: ");
        in.nextLine();
        System.out.println ("You drew: ");
        int prev = 0;
        int num = 0;
        int count = 0;

        for (int i = 0; i < 3; i++) {
            num = (int) (Math.random() * 10) + 1;
            boolean same = (prev <= 5 && num <= 5) || (prev > 5 && num > 5);
            if (num <= 5) {
                System.out.println ("red");
            }
            else {
                System.out.println ("black");
            }
            if (i > 0 && same) {
                count++;
            }
            if (count == 2) {
                super.changePrizeNum("plush fish");
                System.out.println ("You won a plush fish!");
                return "plush fish";
            }
            prev = num;
        }
        super.changePrizeNum("keychain");
        System.out.println ("You won a keychain!");
        return "keychain";
    }
}
