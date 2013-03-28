//********************************************************************
// Craps.java Author: Michelle Fernandez (mf2492)
// Game interface for Craps.
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Plays a game of craps.
 * @author mf2492
 *
 */
public class Craps extends JPanel
{
	private JButton play, next;
	private JLabel label_die1, label_die2, total, special, game, roll, roll_next;
	private JPanel buttonPanel;
	private int round;
	private int win;
	int pair_total, first;
	Die myDie1, myDie2;
	PairOfDice pair1;

	//-----------------------------------------------------------------
	// Constructor: Sets up the GUI.
	//-----------------------------------------------------------------
	/**
	 * Constructs GUI.
	 */
	public Craps()
	{

		play = new JButton ("Play Game");
		play.addActionListener (
				new ActionListener() 
				{
					public void actionPerformed ( ActionEvent event )
					{
						playJButtonActionPerformed( event );
					}
				});

		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize (new Dimension(200, 100));
		buttonPanel.setBackground (Color.cyan);

		next = new JButton ("Roll Dice");
		next.addActionListener (
				new ActionListener() 
				{
					public void actionPerformed ( ActionEvent event )
					{
						rollJButtonActionPerformed( event );
					}
				} 
				);
		//Panel of first die.
		JPanel subPanel1 = new JPanel();
		subPanel1.setPreferredSize (new Dimension(150, 100));
		subPanel1.setBackground (Color.white);
		label_die1 = new JLabel();
		subPanel1.add(label_die1);

		//Panel of second die
		JPanel subPanel2 = new JPanel();
		subPanel2.setPreferredSize (new Dimension(150, 100));
		subPanel2.setBackground (Color.white);
		label_die2 = new JLabel();
		subPanel2.add(label_die2);

		//Panel of game information
		JPanel subPanel3 = new JPanel();
		subPanel3.setPreferredSize (new Dimension(150, 100));
		subPanel3.setBackground (Color.white);
		total = new JLabel();
		subPanel3.add(total);
		special = new JLabel();
		subPanel3.add(special);

		//Panel containing play and roll button.
		buttonPanel.add (play);
		buttonPanel.add (next);
		JPanel primary = new JPanel();
		primary.setBackground (Color.cyan);
		primary.add (subPanel1);
		primary.add (subPanel2);
		primary.add (subPanel3);
		primary.add (buttonPanel);
		game = new JLabel();
		buttonPanel.add (game);
		roll = new JLabel();
		buttonPanel.add (roll);
		roll_next = new JLabel();
		buttonPanel.add (roll_next);

		add (primary);

	}
	//-----------------------------------------------------------------
	// Listener for play game state.
	//-----------------------------------------------------------------
	/**
	 * Listener for play game state.
	 * @param event
	 */
	public void playJButtonActionPerformed (ActionEvent event)
	{
		String longTemp;
		int round = 1;
		pair_total = 0;
		myDie1 = new Die();
		myDie2 = new Die();
		PairOfDice pair1 = new PairOfDice(myDie1, myDie2);
		pair_total =  pair_total + pair1.roll();

		int first = pair1.getDie1();
		myDie1.setFaceValue(first);
		int second = pair1.getDie2();
		myDie2.setFaceValue(second);

		longTemp = "<html><pre>" + myDie1.toString() + "</html></pre>";
		label_die1.setText(longTemp);

		longTemp = "<html><pre>" + myDie2.toString() + "</html></pre>";
		label_die2.setText(longTemp);

		total.setText("Total: " + pair_total);
		roll.setText("Round: " + round);


		if (pair1.isSnakeEyes()) {
			special.setText("You rolled snake eyes!");
		} else if (pair1.isSeven()) {
			special.setText("You rolled sevens!");
		} else if(pair1.isBoxCars()) {
			special.setText("You rolled Box Cars!");
		} else {
			special.setText(" ");
		}

		if (pair_total == 7 && round == 1) {
			game.setText("You win!");
			play.setEnabled( true );
			next.setEnabled( false );
		} else {
			game.setText("Roll again.");
			win = pair_total;
			roll_next.setText("Roll " + win + " to win.");
			play.setEnabled( false );
			next.setEnabled( true );
		}

	}	

	//-----------------------------------------------------------------
	// Listener for continue rolling game state.
	//-----------------------------------------------------------------
	/**
	 * Listener for continue rolling game state.
	 * @param event
	 */
	public void rollJButtonActionPerformed (ActionEvent event)
	{ 
		round++;
		pair_total = 0;
		myDie1 = new Die();
		myDie2 = new Die();
		PairOfDice pair1 = new PairOfDice(myDie1, myDie2);
		pair_total =  pair_total + pair1.roll();

		int first = pair1.getDie1();
		myDie1.setFaceValue(first);
		int second = pair1.getDie2();
		myDie2.setFaceValue(second);

		String longTemp = "<html><pre>" + myDie1.toString() + "</html></pre>";
		label_die1.setText(longTemp);

		longTemp = "<html><pre>" + myDie2.toString() + "</html></pre>";
		label_die2.setText(longTemp);

		total.setText("Total: " + pair_total);

		if (pair1.isSnakeEyes()) {
			special.setText("You rolled snake eyes!");
		} else if (pair1.isSeven()) {
			special.setText("You rolled sevens!");
		} else if(pair1.isBoxCars()) {
			special.setText("You rolled Box Cars!");
		} else {
			special.setText(" ");
		}


		roll.setText("Round: " + round);

		if (pair_total == 7 && round > 1) {
			game.setText("You lose.");
			play.setEnabled( true );
			next.setEnabled( false );
			round = 1;
		} else if (pair_total == win) {
			game.setText("You win.");
			play.setEnabled( true );
			next.setEnabled( false );
			round = 1;
		} else {
			game.setText("Roll again.");
			roll_next.setText("Roll " + win + " to win.");
		}
	}
}





