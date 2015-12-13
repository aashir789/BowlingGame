package Interface;

/**
 * Created by aashir on 12/13/15.
 */
public interface IBowlingGame {

    public void roll(int pinsDropped);

    public int getScore();

    public boolean isFinished();

}
