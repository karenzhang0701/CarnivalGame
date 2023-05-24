public class RedorBlack extends GameBooth {
    public RedorBlack() {
        super(1.50, "keychain", "plush fish", "Red or Black");
    }

    public String start() {
        System.out.println ("You drew: ");
        int prev = 0;
        int num = 0;
        int count = 0;

        for (int i = 0; i < 3; i++) {
            num = (int) (Math.random() * 10) + 1;
            //System.out.println (num);
            boolean same = (prev <= 5 && num <= 5) || (prev > 5 && num > 5);
            if (num <= 5) {
                System.out.println ("red");
            }
            else {
                System.out.println ("black");
            }
            if (i > 0 && same) {
                count++;
            }
            if (count == 2) {
                super.changePrizeNum("plush fish");
                System.out.println ("You won a plush fish!");
                return "plush fish";
            }
            prev = num;
        }
        super.changePrizeNum("keychain");
        System.out.println ("You won a keychain!");
        return "keychain";
    }
}
