import javax.swing.JOptionPane;

/**
 * Purpose: The BowlingGame program is designed to compute the score of a
 * player's Bowling Game.
 * 
 * Constructors: BowlingGame
 * 
 * Methods: shot, getFrame, toString, computeScoreFrame, computScore, getScore
 * 
 * @author Robert Williams
 * @since 2018-01-27
 * 
 */

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

	/**
	 * Purpose: The BowlingGame constructor creates a BowlingGame object and
	 * initializes the name, strikes, spares, gutterBalles, score, frame, and shot
	 * variables.
	 * 
	 * @param n
	 *            The name of the bowler.
	 * @return nothing
	 * 
	 */
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

	/**
	 * Purpose: The shot method determines if the bowler has another shot left in
	 * the frame.
	 * 
	 * Rules: If the frame is 1-9, then a Strike will increment the frame and the
	 * bowler will not have another shot in the frame. If frame is 10, then a strike
	 * on the first shot enables two additional shots. In frame 10, a spare on the
	 * second shot will allow a third shot.
	 * 
	 * @param p
	 *            The number of pins knocked down on the shot.
	 * @return A boolean if the bowler has another shot.
	 * 
	 */

	public boolean shot(int p) { // return false if the frame is over.
		boolean nextShot = false;
		scores[frame][shot] = p;

		if (p == 10) {
			if (shot == 0) {
				strikes++;
				if (frame == 9) {
					nextShot = true;
					thirdShot = true;
				}
			}
			if (shot == 1) {

				if (frame == 9) {
					strikes++;
					nextShot = true;
					thirdShot = true;
				} else {
					spares++;
				}
			}
			if (shot == 2) {
				strikes++;
				nextShot = false;
				thirdShot = false;
			}
		} else {
			if (p == 0) {
				gutterBalls++;
			}
			if (shot == 0) {
				nextShot = true;
			}
			if (shot == 1) {

				if ((scores[frame][shot - 1] != 10) && scores[frame][shot - 1] + p == 10) {
					spares++;
				}

				if (frame == 9 && scores[9][0] == 10) {// thirdShot
					nextShot = true;
				} else {
					nextShot = false;
				}
			}
			if (shot == 2) {
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

		return nextShot || thirdShot;
	}

	/**
	 * Purpose: The getFrame method is the getter method for the frame variable.
	 * 
	 * @param nothing
	 * @return an int representing the value of the current frame
	 * 
	 */
	public int getFrame() {
		return frame;
	}

	/**
	 * Purpose: The toString method returns a String message containing the bowler's
	 * name, frame, strikes, spares, gutterBalls, and score after each frame.
	 * 
	 * @param nothing
	 * @return a String message with attributes about the bowler's game
	 * 
	 */
	public String toString() {
		return name + "'s game after frame " + frame + ": Strikes " + strikes + ", Spares " + spares + ", Gutter Balls "
				+ gutterBalls + ", Score " + score;
	}

	/**
	 * Purpose: The computeScoreFrame method computes the bowler's score after each
	 * frame.
	 * 
	 * Scoring Rules:
	 * 
	 * Strikes: 10 points in the current frame plus score from next two shots
	 * 
	 * Spares: 10 points in the current frame plus score from next shot only
	 * 
	 * For Example: If a strike is bowled in frame 1, 10 points are awarded. Then,
	 * if the next two shots are 2 and 5, 7 points are added to frame 1, and 7
	 * points are added to the resulting score from frame 1 for a total score of 24
	 * points after frame 2.
	 * 
	 * If a spare is bowled in frame 1, 10 points are awarded. Then, if the next
	 * shot is a 2, 2 points are added to frame 1, and 2 points are added to the
	 * resulting score from frame 1 for a total score of 14 points after frame 2.
	 * 
	 * @param nothing
	 * @return nothing
	 * 
	 */
	public void computeScoreFrame() {
		/*
		 * Strikes: 10 points in the current frame plus score from next two rolls 10 +
		 * ((score[f+1][0]+score[f+1][1])*2)
		 * 
		 * Spares: 10 points in the current frame plus score from next roll only 10 +
		 * (score[f+1][0]*2)
		 */
		int f = getFrame() - 1;
		// System.out.println("frame: " + f);

		if (f >= 2) { // look two frames back

			// strike last 2 frames
			if (scores[f - 2][0] == 10 && scores[f - 1][0] == 10) {
				// score + (throw1*2 + throw2) + (throw1 + throw2)
				// System.out.println("1 - Score in the frame: " + (((scores[f][0] * 2 +
				// scores[f][1]) + (scores[f][0] + scores[f][1]))));
				score += ((scores[f][0] * 2 + scores[f][1]) + (scores[f][0] + scores[f][1]));
				if (f == 9 && ((scores[f][0] == 10) || (scores[f][0] + scores[f][1] == 10))) {
					score += scores[f][2];
				}

			}
			// strike last 1 frame
			else if (scores[f - 1][0] == 10) {
				// score + (throw1 + throw2) * 2

				score += ((scores[f][0] + scores[f][1]) * 2);
				if (f == 9) {
					score += scores[f][2];
				}
				// System.out.println("2 - Score in the frame: " + (((scores[f][0] +
				// scores[f][1]) * 2)));
			}
			// spare last frame
			else if ((scores[f - 1][0] != 10) && ((scores[f - 1][0] + scores[f - 1][1] == 10))) {// spare last frame
				// score + throw1 * 2 + throw 2

				score += (scores[f][0] * 2) + scores[f][1];
				if (f == 9) {
					score += scores[f][2];
				}
				// System.out.println("3 - Score in the frame: " + ((scores[f][0] * 2) +
				// scores[f][1]));

			}
			// regular score tracking
			else {
				// System.out.println("4 - Score in the frame: " + ((scores[f][0] +
				// scores[f][1])));
				score += scores[f][0] + scores[f][1];
			}

		}

		else if (f == 1) // look one frame back

		{

			if (scores[f - 1][0] == 10) { // strike last frame
				// score + (throw1 + throw2) * 2
				// System.out.println("5 - Score in the frame: " + (((scores[f][0] +
				// scores[f][1]) * 2)));
				score += ((scores[f][0] + scores[f][1]) * 2);
			}

			else if ((scores[f - 1][0] != 10) && (scores[f - 1][0] + scores[f - 1][1] == 10)) {// spare last frame
				// score + throw1 * 2 + throw 2
				// System.out.println("6 - Score in the frame: " + ((scores[f][0] * 2) +
				// scores[f][1]));
				score += (scores[f][0] * 2) + scores[f][1];

			} else {
				// System.out.println("7 - Score in the frame: " + ((scores[f][0] +
				// scores[f][1])));
				score += scores[f][0] + scores[f][1];
			}

		}

		else { // first frame
				// System.out.println("8 - Score in the frame: " + ((scores[f][0] +
				// scores[f][1])));
			score += scores[f][0] + scores[f][1];
		}
	}

	/**
	 * Purpose: The computeScore method computes the bowler's score after each the
	 * game has finished. It is similar to the computeScoreFrame method except it
	 * computes the score once all of the frames have been finished.
	 * 
	 * Scoring Rules:
	 * 
	 * Strikes: 10 points in the current frame plus score from next two shots
	 * 
	 * Spares: 10 points in the current frame plus score from next shot only
	 * 
	 * For Example: If a strike is bowled in frame 1, 10 points are awarded. Then,
	 * if the next two shots are 2 and 5, 7 points are added to frame 1, and 7
	 * points are added to the resulting score from frame 1 for a total score of 24
	 * points after frame 2.
	 * 
	 * If a spare is bowled in frame 1, 10 points are awarded. Then, if the next
	 * shot is a 2, 2 points are added to frame 1, and 2 points are added to the
	 * resulting score from frame 1 for a total score of 14 points after frame 2.
	 * 
	 * @param nothing
	 * @return nothing
	 * 
	 */
	public void computeScore() {
		int scoreCheck = 0;

		for (int i = 0; i < maxNumFrames; i++) {

			if (i < 9) {
				if (scores[i][0] == 10) { // strike this frame

					scoreCheck += 10;
					if (scores[i + 1][0] == 10) {// because of strike, check 1 of 2 roll for another strike

						scoreCheck += 10;
						if (i == 8 && scores[i + 1][1] == 10) {
							// frame 9, check roll 2 of frame 10

							scoreCheck += 10;
						} else {
							if (scores[i + 2][0] == 10) {// because of strike, check 2 of 2 roll for another strike

								scoreCheck += 10;
							} else {

								scoreCheck += scores[i + 2][0]; // no strike on roll 2 of 2, just add the pins
							}

						}

					} // need else here for adding regular score
					else {

						scoreCheck += (scores[i + 1][0] + scores[i + 1][1]);
					}
				} else if ((scores[i][0] != 10) && (scores[i][0] + scores[i][1] == 10)) { // spare this frame

					scoreCheck += (scores[i][0] + scores[i][1] + scores[i + 1][0]); // add score from next 1 roll
				} else {

					scoreCheck += (scores[i][0] + scores[i][1]);
				}
			} else if (i == 9) {

				scoreCheck += (scores[i][0] + scores[i][1] + scores[i][2]);
			}
		}

		JOptionPane.showMessageDialog(null, "The bowler's verified score is: " + scoreCheck);

	}

	/**
	 * Purpose: The getScore method is the getter method for the score variable.
	 * 
	 * @param nothing
	 * @return an int representing the bowler's current score;
	 * 
	 */
	public int getScore() {
		return score;
	}
}
