package Implementation;

import Interface.IFrame;

/**
 * Created by aashir on 12/12/15.
 */
public class Frame implements IFrame{

    private int numberOfStandingPins;
    private int score;
    public boolean isStrike;
    public boolean isSpare;
    public int firstRollScore;
    public int secondRollScore;
    public boolean isFrameNew;
    public boolean isFrameClosed;

    public Frame(){
        score = 0;
        isFrameNew = true;
        isFrameClosed = false;
        isSpare = false;
        isStrike = false;
        numberOfStandingPins = 10;
        firstRollScore = -1;
        secondRollScore = -1;
    }

    @Override
    public int getFrameScore() {
        return score;
    }

    @Override
    public void updateScore(int pointsToAdd) {
        score += pointsToAdd;
    }

    @Override
    public void roll(int pinsDropped){

        if (pinsDropped > numberOfStandingPins) {
            throw new IllegalArgumentException(
                    "Number of pins standing in the frame are less than argument passed in roll");
        }

        if (isFrameNew){
            firstRollScore = pinsDropped;
            numberOfStandingPins -= pinsDropped;
            isFrameNew = false;
            if (numberOfStandingPins == 0){
                isStrike = true;
                secondRollScore = 0;
                isFrameClosed = true;
            }
        }else{
            secondRollScore = pinsDropped;
            numberOfStandingPins -= pinsDropped;
            if (numberOfStandingPins == 0){
                isSpare = true;
            }
            isFrameClosed = true;
        }
        score += pinsDropped;
    }
}
