import java.util.*;

public class Player {
    private double spendingMoney;
    private ArrayList<String> prizesWon; //stores prizes won by player

    public Player() {
        spendingMoney = 20.0;
        prizesWon = new ArrayList<String>();
    }

    //takes in cost parameter: cost of playing a selected game
    public boolean canPlay(double cost) {
        boolean p = spendingMoney - cost >= 0;
        if (p) {
            spendingMoney -= cost; //update spendingmoney
        }
        return p;
    }

    public double getSpendingMoney() {
        return spendingMoney;
    }

    public void printPrizes() {
        System.out.println ("Prizes won: ");
        //loop through arraylist and print elements
        for (String s : prizesWon) {
            System.out.print (s + ", ");
        }
        System.out.println ("\n" +"You have $" + spendingMoney + " remaining");
    }

    //adds prize parameter to prizes arraylist
    public void addPrize(String prize) {
        prizesWon.add(prize);
    }
}
