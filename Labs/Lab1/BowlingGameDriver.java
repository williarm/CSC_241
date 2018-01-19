

import javax.swing.JOptionPane;

public class BowlingGameDriver{
	public static void main(String[] args) {
		String n = JOptionPane.showInputDialog("Please enter a name for a bowler: ");
		BowlingGame g = new BowlingGame(n);
		int scores1[][] = { {5, 5}, {3, 7}, {0, 0}, {4, 6}, {10, 0}, {1, 9}, {10, 0},
							{8, 1}, {0, 10}, {10, 0, 10}
						  };
		int scores2[][] = { {5, 5}, {3, 7}, {0, 0}, {4, 6}, {10, 0}, {1, 9}, {10, 0},
							{8, 1}, {0, 10}, {0, 10, 10}
			  			  };
		int scores3[][] = { {2, 6}, {10, 0}, {10, 0}, {5, 5}, {2, 0}, {7, 1}, {10, 0}, 
						    {10, 0}, {5, 5}, {10, 3, 5}
						  };
		int pins, i = 0, j;
		while(g.getFrame() < 10){
			j = 0;
			do{
				//pins = Integer.parseInt(JOptionPane.showInputDialog("Enter the pins knocked over for frame " + (g.getFrame()+1) + " :"));
				pins = scores1[i][j];
				j++;
			}while(g.shot(pins));
			i++;
			//g.computeScoreFrame();
			JOptionPane.showMessageDialog(null, g);	
		}
		JOptionPane.showMessageDialog(null, "The bowler's score is: " + g.getScore());	
	}
}
