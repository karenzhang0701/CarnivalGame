import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner in1 = new Scanner(System.in);
        System.out.println("Welcome to the Carnival!");

        Player player = new Player();
        ArrayList<GameBooth> arr = new ArrayList<GameBooth>();
        arr.add(new RedorBlack());
        arr.add(new PennyToss());
        arr.add(new OddorEvenDice());
        arr.add(new TicTacToe());
        GameBooth selected = arr.get(0);
        String prize;
        double price;
        String choice = "";
        String game = "";

        while (!choice.toLowerCase().equals("q")) {
            System.out.println();
            System.out.println("Choose one of the options:");
            System.out.println("(G) Play a Game" + '\n' + "(P) See Balance & Prizes" + '\n' + "(Q) Quit");
            System.out.println("Enter your choice: ");
            choice = in1.nextLine().toLowerCase();

            if (player.getSpendingMoney() <= 0) {
                System.out.println("You have run out of money.");
                break;
            }

            if (choice.equals("p")) {
                System.out.println();
                player.printPrizes();;
                System.out.println("\n" + "Prizes given away by booth: ");
                for (GameBooth g : arr) {
                    System.out.print(g.getGameName() + ": ");
                    g.prizesAwarded();
                }
            }

            else if (choice.equals("g")) {
                System.out.println("\n" + "Which game would you like to play?");
                System.out.println("(1) Red or Black ($1.50)" + "\n" + "(2) Penny Throw ($3.00)" + "\n" + "(3) Odd or Even Dice ($1.00)"
                        + "\n" + "(4) Tic Tac Toe ($2.00)");
                game = in.nextLine();
                try {
                    Integer.parseInt(game);
                    int gameNum = Integer.parseInt(game);
                    if (gameNum >= 1 && gameNum <= 4) {
                        selected = arr.get(gameNum - 1);
                        price = selected.getCost();

                        if (player.canPlay(price)) {
                            prize = selected.start();
                            if (prize.length() > 0) {
                                player.addPrize(prize);
                            }
                        } else {
                            System.out.println("You don't have enough money to play this game.");
                        }
                    }
                } 
                catch (NumberFormatException e) {
                    System.out.println("Not a valid game number");
                }
            }

            else {
                System.out.println("That is not a valid command. Try again.");
            }
        }
        System.out.println ("Hope you had fun playing!");
    }
}
