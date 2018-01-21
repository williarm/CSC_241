
public class BowlingGame {

	private String name;
	private int[][] scores = new int[10][3];
	private int strikes;
	private int spares;
	private int frame;
	private int shot;
	private int gutterBalls;
	private int score;
	private boolean thirdShot = false;
	private static final char tempScoreValue = 'N';
	private static final int maxNumFrames = 10;
	private static final int maxNumShots = 3;

	public BowlingGame(String n) {
		name = n;
		for (int i = 0; i < maxNumFrames; i++) {
			for (int j = 0; j < maxNumShots; j++) {
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

	public boolean shot(int p) { // return false if the frame is over.
		boolean nextShot = false;
		//boolean thirdShot = false;
		if (p == 10) {
			if (shot == 0) {
				System.out.println("in main if, shot 0 - frame is " + frame + " shot " + shot + " pins " + p);
				strikes++;
				if (frame == 9) {
					nextShot = true;
					thirdShot = true;
				}
			}
			if (shot == 1) {
				System.out.println("in main if, shot 0 - frame is " + frame + " shot " + shot + " pins " + p);
				spares++;
				if (frame == 9) {
					nextShot = true;
					thirdShot = true;
				}
			}
			if (shot == 2) {
				System.out.println("in main if, shot 0 - frame is " + frame + " shot " + shot + " pins " + p);
				strikes++;
				nextShot = false;
				thirdShot = false;
			}
		} else {
			if (p == 0) {
				gutterBalls++;
			}
			if (shot == 0) {
				System.out.println("in else, shot 0 - frame is " + frame + " shot " + shot + " pins " + p);
				nextShot = true;
			}
			if (shot == 1) {
				System.out.println("in else, shot 1 - frame is " + frame + " shot " + shot + " pins " + p);
				if (frame == 9 && thirdShot) {
					nextShot = true;
				} else {
					nextShot = false;
				}
			}
			if (shot == 2) {
				System.out.println("in else, shot 2 - frame is " + frame + " shot " + shot + " pins " + p);
				nextShot = false;
				thirdShot = false;
			}

		}
		if (nextShot||thirdShot) {
			shot++;
		} else {
			frame++;
			shot = 0;
		}
		System.out.println(nextShot || thirdShot);
		return nextShot || thirdShot;
	}

	public int getFrame() {
		return frame;
	}

	public String toString() {
		return name + "'s game after frame " + frame + ": Strikes " + strikes + ", Spares " + spares + ", Gutter Balls "
				+ gutterBalls + ", Score " + score;
	}

	public void computeScoreFrame() {
		int f = getFrame() - 1;
		if (f >= 2) { // look two frames back
			// your algorithm for the bonus points goes here.
		} else if (f == 1) { // look one frame back
			// your algorithm for the bonus points goes here.
		} else { // first frame
			score += scores[f][0] + scores[f][1];
		}
	}

	public int getScore() {
		return score;
	}
}
