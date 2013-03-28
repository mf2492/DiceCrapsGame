//********************************************************************
// Die.java Author: Lewis/Loftus
// Modified by Michelle Fernandez (mf2492)
// Represents one die (singular of dice) with faces showing values
// between 1 and 6.
//********************************************************************
import java.util.Scanner;
/**
 * Represents one die (singular of dice) with faces showing values
 * between 1 and 6.
 * @author Lewis/Loftus; Modified by Michelle Fernandez (mf2492)
 *
 */
public class Die
{
	private final int MAX = 6; // maximum face value
	private int faceValue; // current value showing on the die
	
	//-----------------------------------------------------------------
	// Constructor: Sets the initial face value.
	//-----------------------------------------------------------------
	/**
	 * Constructor: Sets the initial face value.
	 */
	public Die()
	{
		faceValue = 1;
	}
	
	
	//-----------------------------------------------------------------
	// Constructor: Sets the initial face value to a specified value.
	//-----------------------------------------------------------------
	/**
	 * Constructor: Sets the initial face value to a specified value.
	 * Legal values are checked for the die. User is prompted to reenter
	 * value if an illal value is entered.
	 * @param initial - specified face value.
	 */
	public Die(int initial)
	{
		faceValue = initial;
		while (faceValue <=0 || faceValue > MAX) {
			System.out.println("Illegal die value. Please enter a " +
					"number between 1 and " + MAX + ":" );
			Scanner input = new Scanner(System.in);
			int x = input.nextInt();
			faceValue = x;
		}	
	}
	
	//-----------------------------------------------------------------
	// Constructor: Sets the initial face value to an existing value.
	//-----------------------------------------------------------------
	/**
	 * Constructor: Sets the initial face value to an existing value.
	 * @param existing- gets value of an existing die.
	 */
	public Die(Die existing) {
		faceValue = existing.getFaceValue();
	}
	
	//-----------------------------------------------------------------
	// Rolls the die and returns the result.
	//-----------------------------------------------------------------
	/**
	 * Rolls the die and returns the result.
	 * @return random faceValue number
	 */
	public int roll()
	{
		faceValue = (int)(Math.random() * MAX) + 1;
		return faceValue;
	}
	
	
	//-----------------------------------------------------------------
	// Face value mutator.
	//-----------------------------------------------------------------
	/**
	 * Face value mutator.
	 * @param value - sets face value
	 */
	public void setFaceValue (int value)
	{
		faceValue = value;
		while (faceValue <=0 || faceValue > 6) {
			System.out.println("Illegal die value. Please enter a " +
					"number between 1 and 6: ");
			Scanner input = new Scanner(System.in);
			int x = input.nextInt();
			faceValue = x;
		}
	}
	
	
	//-----------------------------------------------------------------
	// Face value accessor.
	//-----------------------------------------------------------------
	/**
	 * Face value accessor.
	 * @return faceValue of the die.
	 */
	public int getFaceValue()
	{
		return faceValue;
	}
	
	
	//-----------------------------------------------------------------
	// Returns a string representation of this die.
	//-----------------------------------------------------------------
	/**
	 * 
	 */
	public String toString()
	{
		String smallTemp = null;
		switch (faceValue) 
		{
		case 1:
			smallTemp = " \n  x\n";
			break;
		case 2:
			smallTemp = "x\n\n    x";
			break;
		case 3:
			smallTemp = "x\n  x\n    x";
			break;
		case 4:
			smallTemp = "x   x\n\nx   x";
			break;
		case 5:
			smallTemp = "x   x\n  x\nx   x";
			break;
		case 6:
			smallTemp = "x   x\nx   x \nx   x";
			break;
		default:
			System.out.println("Invalid input.");
		}
		
		System.out.println("");
		
		String result = Integer.toString(faceValue);

		
		return smallTemp + "\n" + result;
	}
}