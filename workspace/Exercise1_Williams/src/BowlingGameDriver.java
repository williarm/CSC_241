/**
 * Purpose: The BowlingGameDriver program is a driver class to execute
 * the BowlingGame program. This class contains the main method for the
 * program. Driver class provided by Ivan Temesvari.
 * 
 * Constructors: None
 * 
 * Methods: main
 * 
 * @author Ivan Temesvari, Robert Williams
 * @since 2018-01-27
 * 
 */

import javax.swing.JOptionPane;

public class BowlingGameDriver{
	/**
	 * Purpose: The main method is the driver method for the BowlingGame program.
	 * It creates a BowlingGame object, provides an option for user input for scores, 
	 * and loops through the scores to calculate the score of the BowlingGame.
	 * 
	 * @param standard array of String args
	 * @return nothing
	 * 
	 */
	
	public static void main(String[] args) {
		String n = JOptionPane.showInputDialog("Please enter a name for a bowler: ");
		BowlingGame g = new BowlingGame(n);
		int scores1[][] = { {5, 5}, {3, 7}, {0, 0}, {4, 6}, {10, 0}, {1, 9}, {10, 0},
							{8, 1}, {0, 10}, {10, 0, 10} //151 --151
						  };
		int scores2[][] = { {5, 5}, {3, 7}, {0, 0}, {4, 6}, {10, 0}, {1, 9}, {10, 0},
							{8, 1}, {0, 10}, {0, 10, 10} //141 --141
			  			  };
		int scores3[][] = { {2, 6}, {10, 0}, {10, 0}, {5, 5}, {2, 0}, {7, 1}, {10, 0}, 
						    {10, 0}, {5, 5}, {10, 3, 5} //total 158 --158
		};
		int scores4[][] = {{10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 10, 10}}; //300
		int scores5[][] = {{10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {5, 3}}; //261 -
		int scores6[][] = {{10, 0}, {7, 3}, {7, 2}, {9, 1}, {10, 0}, {10, 0}, {10, 0}, {2, 3}, {6, 4}, {7, 3, 0}}; //165 -
		int pins, i = 0, j;
		while(g.getFrame() < 10){
			j = 0;
			do{
				//pins = Integer.parseInt(JOptionPane.showInputDialog("Enter the pins knocked over for frame " + (g.getFrame()+1) + " :"));
				
				pins = scores2[i][j];
				j++;
			}while(g.shot(pins));
			i++;
			g.computeScoreFrame();
			JOptionPane.showMessageDialog(null, g);	
		}
		g.computeScore();
		JOptionPane.showMessageDialog(null, "The bowler's score is: " + g.getScore());	
	}
}
