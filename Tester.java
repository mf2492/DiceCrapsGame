//********************************************************************
// Tester.java Author: Michelle Fernandez (mf2492)
// Runs Craps simulation. Craps.java is called to run the Craps
// simulation. PairOfDice.java is used to construct a new pair of 
// dice to play the game. Die.java is also used to construct and 
// access information about each die.
//********************************************************************

import javax.swing.*;

 /**
 *Runs Craps simulation. Craps.java is called to run the Craps
 * simulation. PairOfDice.java is used to construct a new pair of 
 * dice to play the game. Die.java is also used to construct and 
 * access information about each die.
 * @author Michelle Fernandez (mf2492)
 *
 */

public class Tester extends JPanel
{
	public static void main(String[] args) {
		
		JFrame frame = new JFrame ("Pair of Dice");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Craps());	
		frame.pack();
		frame.setVisible(true);
	}
}
		




	