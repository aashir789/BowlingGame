package Implementation;

/**
 * Created by aashir on 12/12/15.
 */
public class main {

    public static void main(String[] args) {
        BowlingGame game = new BowlingGame();
        System.out.println(game.getScore());
        System.out.println(game.isFinished());
        for (int i = 0; i < 20; i++) {
            game.roll(4);
        }
        System.out.println(game.getScore());
        System.out.println(game.isFinished());
    }

}
