
public class BowlingGame {

	private String name;
	private int[][] scores = new int[10][3];
	private int strikes;
	private int spares;
	private int frame;
	private int shot;
	private int gutterBalls;
	private int score;
	// private int prevShotPins;
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
		scores[frame][shot] = p;
		// thirdShot = (scores[9][0] == 10);
		// System.out.println("frame: "+ frame + " shot: "+ shot + " scores: " +
		// scores[frame][shot]);
		/*
		 * Rules: If the frame is 1-9, then a Strike will increment the frame. If frame
		 * is 10, then a strike enables two additional shots
		 * 
		 * 
		 * Scoring rules:
		 * 
		 * Strikes: 10 points in the current frame plus score from next two rolls
		 * 
		 * Spares: 10 points in the current frame plus score from next roll only
		 * 
		 * For Example: If a strike is bowled in frame 1, 10 points are awarded. Then,
		 * if the next two rolls are 2 and 5, 7 points are added to frame 1, and 7
		 * points are added to the resulting score from frame 1 for a total score of 24
		 * points after frame 2.
		 * 
		 * If a spare is bowled in frame 1, 10 points are awarded. Then, if the next
		 * roll is a 2, 2 points are added to frame 1, and 2 points are added to the
		 * resulting score from frame 1 for a total score of 14 points after frame 2.
		 */

		if (p == 10) {
			if (shot == 0) {
				// System.out.println("in main if, shot 0 - frame is " + frame + " shot " + shot
				// + " pins " + p);
				strikes++;
				if (frame == 9) {
					nextShot = true;
					thirdShot = true;
				}
			}
			if (shot == 1) {
				// System.out.println("in main if, shot 0 - frame is " + frame + " shot " + shot
				// + " pins " + p);

				if (frame == 9) {
					strikes++;
					nextShot = true;
					thirdShot = true;
				} else {
					spares++;
				}
			}
			if (shot == 2) {
				// System.out.println("in main if, shot 0 - frame is " + frame + " shot " + shot
				// + " pins " + p);
				strikes++;
				nextShot = false;
				thirdShot = false;
			}
		} else {
			if (p == 0) {
				gutterBalls++;
			}
			if (shot == 0) {
				// System.out.println("in else, shot 0 - frame is " + frame + " shot " + shot +
				// " pins " + p);
				nextShot = true;
			}
			if (shot == 1) {
				// System.out.println("in else, shot 1 - frame is " + frame + " shot " + shot +
				// " pins " + p);

				if ((scores[frame][shot - 1] != 10) && scores[frame][shot - 1] + p == 10) {// if scores[frame][shot-1]
																							// !=10 prevShotPins
					spares++;
				}

				if (frame == 9 && scores[9][0] == 10) {// thirdShot
					nextShot = true;
				} else {
					nextShot = false;
				}
			}
			if (shot == 2) {
				// System.out.println("in else, shot 2 - frame is " + frame + " shot " + shot +
				// " pins " + p);
				nextShot = false;
				thirdShot = false;
			}

		}
		if (nextShot || thirdShot) {
			shot++;
		} else {
			frame++;
			shot = 0;
		}
		// prevShotPins = p;
		// System.out.println(prevShotPins);
		// System.out.println(nextShot || thirdShot);

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
		/*
		 * Strikes: 10 points in the current frame plus score from next two rolls
		 * 
		 * Spares: 10 points in the current frame plus score from next roll only
		 */
		int f = getFrame() - 1;
		if (f >= 2) { // look two frames back
			// your algorithm for the bonus points goes here.
			// need to account for frame 10
			if (scores[f - 1][0] == 10 && scores[f - 2][0] == 10) {
				System.out.println("previous frame had a strike");
				score += ((scores[f][0] * 2 + scores[f][1]) + (scores[f][0] + scores[f][1]));

			} else if (scores[f - 1][0] == 10) {
				System.out.println("previous frame had a strike");
				score += ((scores[f][0] + scores[f][1]) * 2);
			} else if (scores[f - 1][0] + scores[f - 1][1] == 10) {
				System.out.println("previous frame had a spare");
				// System.out.println("score: "+score);
				// System.out.println("scores[f][0]: "+scores[f][0]);
				score += (scores[f][0] * 2) + scores[f][1];
			} else {
				score += scores[f][0] + scores[f][1];
			}
		} else if (f == 1) { // look one frame back
			// your algorithm for the bonus points goes here.
			if (scores[f - 1][0] == 10) {
				System.out.println("previous frame had a strike");
				score += ((scores[f][0] + scores[f][1]) * 2);
			} else if (scores[f - 1][0] + scores[f - 1][1] == 10) {
				System.out.println("previous frame had a spare");
				// System.out.println("score: "+score);
				// System.out.println("scores[f][0]: "+scores[f][0]);
				score += (scores[f][0] * 2) + scores[f][1];
			}
		} else { // first frame
			score += scores[f][0] + scores[f][1];
		}
		// System.out.println("f: " + f +" scores[f][0]: "+ scores[f][0]+" scores[f][1]:
		// " + scores[f][1] +" score: " + score);
	}

	public void computeScore() {
		// loop through scores array and calculate
	}

	public int getScore() {
		return score;
	}
}
