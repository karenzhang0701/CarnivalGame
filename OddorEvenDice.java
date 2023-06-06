import java.util.*;

public class OddorEvenDice extends GameBooth {
    Scanner in = new Scanner(System.in);

    public OddorEvenDice() {
        //call gamebooth constructor
        super(1.0, "lollipop", "teddy bear", "Odd or Even Dice");
    }

    //plays game and returns prize won
    @Override
    public String start() {
        int player = 0; //tracks # of points won
        String prize = "";
        String choice = "";
        System.out.println ("\n" + "You choose either odd or even. Two dice are thrown." + "\n"
        + "If the sum is the type of number you chose, you get a point." + "\n" + "2 points wins a lollipop, 3 points wins a teddy bear." + "\n");
        
        //loop until user input is valid
        while (!choice.equals("even") && !choice.equals("odd")) {
            System.out.println("Type odd or even to choose");
            choice = in.nextLine().toLowerCase();
        }

        for (int i = 0; i < 3; i++) {
            //generate 2 random numbers and compute the sum
            int num1 = (int) (Math.random() * 10) + 1;
            int num2 = (int) (Math.random() * 10) + 1;
            System.out.println("You threw: " + num1 + " and " + num2 + " (sum = " + (num1 + num2) + ")");

            //increase points won if the sum corresponds to the type of number chosen
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
        System.out.println (player + " of the sums were " + choice);
        
        //a prize has been won if it's not an empty string
        if (prize.length() > 0) {
            super.changePrizeNum(prize); //update booth's prize number
            System.out.println("You won a " + prize + "!");
        }
        else {
            System.out.println ("You didn't win anything :(");
        }
        return prize;
    }
}
