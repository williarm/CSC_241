package ch06.apps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import support.cards.Card;
import support.cards.CardDeck;

public class HigherLowerGUI {
	static final int HANDSIZE = 2;
	static int handCount = 0;
	static Card nextCard;
	static CardDeck deck = new CardDeck();
	static Card[] hand = new Card[HANDSIZE];
	static JLabel[] table = new JLabel[HANDSIZE];
	static JLabel winnerLoser;
	static JButton higher, lower, deal;
	static ButtonGroup higherLowerGroup;

	public static void main (String[] args){
		deck.shuffle();
		table[0] = new JLabel("");
		table[1] = new JLabel("");
		
		JFrame frame = new JFrame ("Higher Lower GUI");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		//frame.setSize(600, 600);
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground (Color.green);
		mainPanel.setPreferredSize (new Dimension (180 * HANDSIZE, 450));
		mainPanel.setLayout(new BorderLayout());
		
		// north panel
		JPanel north = new JPanel();
		north.setBackground (Color.white);
		north.setLayout(new FlowLayout());
		winnerLoser = new JLabel("");
		north.add(winnerLoser);
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1,2));
		center.add(table[0]);
		center.add(table[1]);
		 
		ButtonListener listener = new ButtonListener();
		higher = new JButton("Higher");
		lower = new JButton("Lower");
		deal = new JButton("Deal");
		higher.setEnabled(false);
		lower.setEnabled(false);
		deal.setEnabled(true);
		deal = new JButton("Deal");
		higherLowerGroup = new ButtonGroup();
		higherLowerGroup.add(higher);
		higherLowerGroup.add(lower);
		higherLowerGroup.add(deal);
		higher.addActionListener(listener);
		lower.addActionListener(listener);
		deal.addActionListener(listener);
		
		JPanel south = new JPanel();
		south.setLayout(new BorderLayout());
		JPanel highlow = new JPanel();
		highlow.setLayout(new FlowLayout());
		highlow.add(higher);
		highlow.add(lower);
		south.add(highlow, BorderLayout.NORTH);
		south.add(deal, BorderLayout.SOUTH);
		
		mainPanel.add(north, BorderLayout.NORTH);
		mainPanel.add(center, BorderLayout.CENTER);
		mainPanel.add(south, BorderLayout.SOUTH);
		
		
		frame.getContentPane().add(mainPanel, "Center");
		frame.pack();
		frame.setVisible(true);
	}
	 
	private static class ButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			if(event.getActionCommand().equals("Deal")){
				winnerLoser.setText("");
				hand[0] = deck.nextCard();
				System.out.println(hand[0]);
				hand[1] = null;
				handCount = 1;
				table[0].setIcon(hand[0].getImage());
				table[0].setVisible(true);
				table[1].setIcon(null);
				deal.setEnabled(false);
				higher.setEnabled(true);
				lower.setEnabled(true);
			}
			
			if(event.getActionCommand().equals("Higher")){
				nextCard = deck.nextCard();
				hand[1] = nextCard;
				System.out.println(hand[1]);
				table[1].setIcon(hand[1].getImage());
				table[0].setVisible(true);
				handCount = 2;
				deal.setEnabled(true);
				higher.setEnabled(false);
				lower.setEnabled(false);
				 // Determine and display results
				if (hand[0].compareTo(hand[1]) < 0){
					winnerLoser.setText("Winner!");
				}
				else if (hand[0].compareTo(hand[1]) > 0){
					winnerLoser.setText("Loser!");
				}
				else{
					winnerLoser.setText("Loser!");
				}
			}
	
			if(event.getActionCommand().equals("Lower")){
				nextCard = deck.nextCard();
				hand[1] = nextCard;
				System.out.println(hand[1]);
				table[1].setIcon(hand[1].getImage());
				handCount = 2;
				deal.setEnabled(true);
				higher.setEnabled(false);
				lower.setEnabled(false);
				// Determine and display results
				if (hand[0].compareTo(hand[1]) > 0){
					winnerLoser.setText("Winner!");
				}
				else if (hand[0].compareTo(hand[1]) < 0){
					winnerLoser.setText("Loser!");
				}
				else{
					winnerLoser.setText("Loser!");
				}
			}
		}
	}
}
