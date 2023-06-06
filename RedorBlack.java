import java.util.Scanner;

public class RedorBlack extends GameBooth {
    Scanner in = new Scanner(System.in);

    public RedorBlack() {
        //call gamebooth constructor
        super(1.50, "keychain", "plush fish", "Red or Black");
    }

    //plays game and returns prize won
    @Override
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
            num = (int) (Math.random() * 10) + 1; //random # from 1-10
            boolean same = (prev <= 5 && num <= 5) || (prev > 5 && num > 5); /* determine if previous number generated and current one are both between
            1-5 (red) or 6-10 (black) */
            if (num <= 5) {
                System.out.println ("red");
            }
            else {
                System.out.println ("black");
            }
            if (i > 0 && same) { //compares 2nd and 1st numbers, 3rd and 2nd numbers
                count++;
            }
            if (count == 2) { //all 3 numbers are in the same range
                super.changePrizeNum("plush fish");
                System.out.println ("You won a plush fish!");
                return "plush fish";
            }
            prev = num; //update value to the last number generated
        }
        super.changePrizeNum("keychain"); //update booth's prize number
        System.out.println ("You won a keychain!");
        return "keychain";
    }
}
