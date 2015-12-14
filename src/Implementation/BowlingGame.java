package Implementation;

import Interface.IBowlingGame;

public class BowlingGame implements IBowlingGame{

    public int MAX_FRAMES = 12;
	private Frame[] gameFrames;
	private Frame currentFrame;
    private Frame previousFrame;
    private Frame previousPreviousFrame;
    private int totalScore;
    private int currentFrameIndex;

	public BowlingGame(){
        gameFrames = new Frame[MAX_FRAMES];
        currentFrame = new Frame();
        previousFrame = null;
        previousPreviousFrame = null;
        currentFrameIndex = 0;
        totalScore = 0;
	}
	
	@Override
	public void roll(int pinsDropped) {
		
		if(pinsDropped <0 || pinsDropped > 10){
			throw new IllegalArgumentException(
					"Roll should be called with an int between 0 and 10.");
		}

        if (isFinished()){
            throw new IllegalArgumentException(
                    "The game is finished, roll cannot be called.");
        }

        // Update spare or strike score of previous frame
        if (currentFrameIndex > 0 && currentFrameIndex <11 ){
             previousFrame = gameFrames[currentFrameIndex-1];
            if (previousFrame.isStrike || (previousFrame.isSpare && currentFrame.isFrameNew)){
                previousFrame.updateScore(pinsDropped);
                totalScore += pinsDropped;
            }
        }

        // Update strike score of previous' previous frame
        if (currentFrameIndex > 1 && currentFrameIndex<12){
            previousPreviousFrame = gameFrames[currentFrameIndex-2];
            if (previousPreviousFrame.isStrike && previousFrame.isStrike){
                previousPreviousFrame.updateScore(pinsDropped);
                totalScore += pinsDropped;
            }
        }

        currentFrame.roll(pinsDropped);
        if (currentFrameIndex < 10) {
            totalScore += currentFrame.getFrameScore();
        }
        if (currentFrame.isFrameClosed){
            gameFrames[currentFrameIndex] = currentFrame;
            currentFrame = new Frame();
            currentFrameIndex ++;
        }
	}

	@Override
	public int getScore() {
		return totalScore;
	}

	@Override
	public boolean isFinished() {

        if (currentFrameIndex >9){
            if (currentFrameIndex == 10 && (previousFrame.isStrike || previousFrame.isSpare)) {
                return false;
            }
            if (currentFrameIndex == 11 && (previousFrame.isStrike && previousPreviousFrame.isStrike)){
                return false;
            }
            return true;
        }
        return false;
	}
}
