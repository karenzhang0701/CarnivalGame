public class PennyToss extends GameBooth {
    private String [][] arr;
    /*if three pennies cover any three of the poster squares (small prize) the player wins a poster. 
    If three  pennies cover the plush tiger (large prize) squares the player wins the plush tiger.  */

    public PennyToss() {
        super(3.0, "poster", "plush tiger", "Penny Toss");
        arr = new String [4][4];
        arr[0][0] = "poster";
        arr[0][1] = "poster";
        arr[0][2] = "plush tiger";
        arr[1][1] = "plush tiger";
        arr[1][3] = "poster";
        arr[2][0] = "poster";
        arr[2][2] = "poster";
        arr[3][3] = "plush tiger";
    }

    public String start() {
        String prev = "";
        int count = 0;

        System.out.println ("Your penny landed on: ");
        for (int i=0; i<3; i++) {
            int row = (int)(Math.random() * 4);
            int col = (int)(Math.random() * 4);
            String s = arr[row][col];
            boolean same = (prev != null && s != null) && (prev.equals(s));
            
            if (s != null) {
                System.out.println (s);
            }
            else {
                System.out.println ("blank square");
            }

            if (i > 0 && same) {
                count++;
            }
            if (count == 2) {
                super.changePrizeNum(s);
                return "You won a " + s;
            }
        }
        return "";
    }
}
