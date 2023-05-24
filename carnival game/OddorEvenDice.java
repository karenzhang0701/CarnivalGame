import java.util.*;

public class OddorEvenDice extends GameBooth {
    Scanner in = new Scanner(System.in);

    public OddorEvenDice() {
        super(1.0, "teddy bear", "lollipop", "Odd or Even Dice");
    }

    public String start() {
        int player = 0;
        String prize = "";
        String choice = "";
        System.out.println ("In Odd or Even Dice, you choose either odd or even. Two dice are thrown and the sum of the numbers is recorded." + "\n"
        + "If the sum is the type of number you chose, you get a point." + "\n" + "2 points wins a lollipop, 3 points wins a teddy bear." + "\n");
        
        while (!choice.equals("even") && !choice.equals("odd")) {
            System.out.println("Type odd or even to choose");
            choice = in.nextLine().toLowerCase();
        }

        for (int i = 0; i < 3; i++) {
            int num1 = (int) (Math.random() * 10) + 1;
            int num2 = (int) (Math.random() * 10) + 1;
            System.out.println("You threw: " + num1 + " and " + num2 + " (sum = " + (num1 + num2) + ")");

            if ((num1 + num2) % 2 == 0 && choice.equals("even")) {
                player++;
            } else if ((num1 + num2) % 2 != 0 && choice.equals("odd")) {
                player++;
            }
            if (player == 2) {
                prize = "lollipop";
            }
            if (player == 3) {
                prize = "teddy bear";
            }
        }
        super.changePrizeNum(prize);
        if (prize.length() > 0) {
            System.out.println("You won a " + prize + "!");
        }
        return prize;
    }
}
