import java.util.*;
//store data about spending money of player and prizes won
//methods play game and show list of prizes won

public class Player {
    private double spendingMoney;
    private ArrayList<String> prizesWon;

    public Player() {
        spendingMoney = 10.0;
        prizesWon = new ArrayList<String>();
    }

    public boolean canPlay(double cost) {
        boolean p = spendingMoney - cost >= 0;
        if (p) {
            spendingMoney -= cost;
        }
        return p;
    }

    public double getSpendingMoney() {
        return spendingMoney;
    }

    public void printPrizes() {
        System.out.println ("Prizes won: ");
        for (String s : prizesWon) {
            System.out.print (s + ", ");
        }
        System.out.println ("\n" +"You have $" + spendingMoney + " remaining");
    }

    public void addPrize(String prize) {
        prizesWon.add(prize);
    }
}
