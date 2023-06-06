import java.util.*;
public class PennyToss extends GameBooth {
    private String [][] arr;

    public PennyToss() {
        //call gamebooth constructor
        super(3.0, "poster", "plush tiger", "Penny Toss");
        arr = new String [4][4]; //initialize array values
        arr[0][0] = "poster";
        arr[0][1] = "poster";
        arr[0][2] = "plush tiger";
        arr[1][1] = "plush tiger";
        arr[1][3] = "poster";
        arr[2][0] = "poster";
        arr[2][2] = "poster";
        arr[3][3] = "plush tiger";
    }

    public void printBoard() {
        for (String [] i : arr) {
            for (String j : i) {
                if (j == null) {
                    System.out.print ("[empty]  ");
                }
                else {
                    System.out.print ("[" + j + "]  ");
                }
            }
            System.out.println();
        }
    }

    //plays game and returns prize won
    @Override
    public String start() {
        Scanner in = new Scanner(System.in);
        String prev = "";
        int count = 0;

        System.out.println ("\n" + "You will toss 3 pennies onto the board below. If all 3 land on the same prize (poster or plush tiger), you win that prize.");
        printBoard();
        System.out.println ("Press Enter to throw: ");
        in.nextLine();
        System.out.println ("Your penny landed on: ");
        
        for (int i=0; i<3; i++) {
            int row = (int)(Math.random() * 4);
            int col = (int)(Math.random() * 4);
            String s = arr[row][col]; //generate random square
            boolean same = (prev != null && s != null) && (prev.equals(s)); /* determine if previous square and current square landed on
            are both not empty and they landed on the same prize*/
            if (s != null) {
                System.out.println (s);
            }
            else {
                System.out.println ("empty square");
            }

            if (i > 0 && same) { //compares 2nd and 1st squares, 3rd and 2nd squares landed on
                count++;
            }
            if (count == 2) { //all 3 landed on the same prizes
                super.changePrizeNum(s); //update booth's prize number
                System.out.println ("You won a " + s + "!");
                return s;
            }
            prev = s; //update value to the previous square landed on
        }
        System.out.println ("You didn't win anything :(");
        return ""; //returns empty string because no prize was won
    }
}
