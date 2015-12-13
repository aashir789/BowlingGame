package Implementation;

import Interface.IBowlingGame;

public class BowlingGame implements IBowlingGame{

	private int pinsLeftOnFrame;
	private int rollNumber;
	private boolean isNewFrame;
	private int[] rollScores;
	
	
	public BowlingGame(){
		pinsLeftOnFrame = 10;
		rollNumber= 0;
		isNewFrame = true;
		rollScores = new int[21];
	}
	
	@Override
	public void roll(int pinsDropped) {
		
		if(pinsDropped <0 || pinsDropped > 10){
			throw new IllegalArgumentException(
					"Roll should be called with an int between 0 and 10.");
		}
		
		rollScores[rollNumber] = pinsDropped;
		
		if (isNewFrame){
			isNewFrame = false;
		}
		else{
			isNewFrame = true;
		}
		
		this.pinsLeftOnFrame -= pinsDropped;
		
		if (pinsDropped == 10){
			isNewFrame = true;
		}
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
