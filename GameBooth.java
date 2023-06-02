//store data about cost of playing game and winning prizes
//methods start game and give cost to play

//display # of each prize given away

public class GameBooth {
    private double cost;
    private String smallPrize;
    private String largePrize;
    private int smallPrizeNum;
    private int largePrizeNum;
    private String gameName;

    public GameBooth(double c, String s, String l, String name) {
        cost = c;
        smallPrize = s;
        largePrize = l;
        smallPrizeNum = 0;
        largePrizeNum = 0;
        gameName = name;
    }

    public String start() {
        return "";
    }

    public String getGameName() {
        return gameName;
    }

    public double getCost() {
        return cost;
    }

    public void changePrizeNum(String prize) {
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
