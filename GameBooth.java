public class GameBooth {
    //the 4 individual game classes are subclasses of GameBooth and inherit GameBooth's methods

    private double cost; //game's cost
    private String smallPrize;
    private String largePrize;
    private int smallPrizeNum; //# of small prizes given away
    private int largePrizeNum; //# of large prizes given away
    private String gameName;

    /*
     * each individual game object created calls GameBooth's constructor using the super keyword
     * which stores the game's information in these instance variables
     */
    public GameBooth(double c, String s, String l, String name) {
        cost = c;
        smallPrize = s;
        largePrize = l;
        smallPrizeNum = 0;
        largePrizeNum = 0;
        gameName = name;
    }

    //method to start game is overriden in each game subclass to play the specific game
    public String start() {
        return "";
    }

    public String getGameName() {
        return gameName;
    }

    public double getCost() {
        return cost;
    }

    /* this method is called using super keyword after a game is played using the start() method in the individual game's class
    the prize won is determined and passed into the method */
    public void changePrizeNum(String prize) {
        //update # of prizes given away depending on type of prize won
        if (prize.equals(smallPrize)) {
            smallPrizeNum++; 
        }
        else {
            largePrizeNum++;
        }
    }

    /* displays the number of large prizes and the number of small prizes given away. */
    public void prizesAwarded() {
        System.out.println (smallPrizeNum + " small prizes, " + largePrizeNum + " large prizes");
    }
}
