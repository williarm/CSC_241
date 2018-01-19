
public class BowlingGame {

	private String name;
	private int[][] scores = new int[10][3];
	private int strikes;
	private int spares;
	private int frame;
	private int shot;
	private int gutterBalls;
	private int score;
	private static final char tempScoreValue = 'N';
	private static final int maxNumFrames = 10;
	private static final int maxNumShots = 3;
	
	public BowlingGame(String n){
		name = n;
		for(int i = 0; i < maxNumFrames; i++){
			for(int j = 0; j < maxNumShots; j++){
				scores[i][j] = 0;
			}
		}
		strikes = 0;
		spares = 0;
		gutterBalls = 0;
		score = 0;
		frame = 0;
		shot = 0;
	}
	
	public boolean shot(int p){  //return false if the frame is over.
		/*
		 * Rules: If the frame is 1-9, then a Strike will increment the frame.
		 * If frame is 10, then a strike enables two additional shots
		 * 
		 * 
		Scoring rules:
		
		Strikes: 10 points in the current frame plus score from next two rolls
		
		Spares: 10 points in the current frame plus score from next roll only
		
		For Example:
		If a strike is bowled in frame 1, 10 points are awarded. Then, if the next two rolls are 2 
		and 5, 7 points are added to frame 1, and 7 points are added to the resulting score from frame 1
		for a total score of 24 points after frame 2.
		
		If a spare is bowled in frame 1, 10 points are awarded. Then, if the next roll is a 2,
		2 points are added to frame 1, and 2 points are added to the resulting score from frame 1
		for a total score of 14 points after frame 2.
		 */
		boolean nextShot = false;
		if(p == 10){
			if(shot == 0)
				strikes++;
			//your code goes here!
			if(shot == 1)
				spares++;
		}
		else{
			//your code goes here!
		}
		frame++;
		return nextShot;
	}
	public int getFrame(){
		return frame;
	}

	public String toString(){
		return name + "'s game after frame " + frame + ": Strikes " + strikes 
				+ ", Spares " + spares + ", Gutter Balls " + gutterBalls + ", Score " + score;
	}
	
	public void computeScoreFrame(){
		int f = getFrame()-1;
		if(f >=2){ //look two frames back
			//your algorithm for the bonus points goes here.
		}
		else if(f == 1){ //look one frame back
			//your algorithm for the bonus points goes here.
		}
		else{  //first frame
			score += scores[f][0] + scores[f][1];
		}
	}
	
	public int getScore(){
		return score;
	}
}

