//********************************************************************
// PairOfDice.java Author: Michelle Fernandez (mf2492)
// Represents one die (singular of dice) with faces showing values
// between 1 and 6.
//********************************************************************
/**
 * Represents one die (singular of dice) with faces showing values 
 * between 1 and 6.
 * @author Michelle Fernandez (mf2492)
 *
 */
public class PairOfDice {
	
	Die d1;
	Die d2;
	private int value1;
	private int value2;
	int total;
	
	
	//-----------------------------------------------------------------
	// Constructor: Sets the initial face value.
	//-----------------------------------------------------------------
	/**
	 * Constructor: sets the initial face values.
	 * @param myDie1 creates object from Die class
	 * @param myDie2 creates object from Die class
	 */
	public PairOfDice(Die myDie1, Die myDie2){
		d1 = myDie1;
		d2 = myDie2;
	}
	
	
	//-----------------------------------------------------------------
	// Rolls the die and returns the result.
	//-----------------------------------------------------------------
	/**
	 * Rolls the die and returns the result.
	 * @return sum of the face values.
	 */
	public int roll()
	{
		value1 = d1.roll();
		value2 = d2.roll();  
		total = value1 + value2;
		return total;
	}

	
	//-----------------------------------------------------------------
	// Returns value of the first die.
	//-----------------------------------------------------------------
	/**
	 * Face value accessor.
	 * @return face value of the first die.
	 */
	public int getDie1(){
		return d1.getFaceValue();
	}
	
	
	//-----------------------------------------------------------------
	// Returns value of the second die.
	//-----------------------------------------------------------------
	/**
	 * Face value accessor.
	 * @return face value of the second die.
	 */
	public int getDie2(){
		return d2.getFaceValue();
	}
	
	//-----------------------------------------------------------------
	// Determines whether Snake Eyes were rolled (sum of 2)
	//-----------------------------------------------------------------
	/**
	 * Determines whether Snake Eyes were rolled (sum of 2)
	 * @return boolean value
	 */
	public boolean isSnakeEyes() {
		int sum = d1.getFaceValue() + d2.getFaceValue();
		return (sum == 2);
	}
	
	
	//-----------------------------------------------------------------
	// Determines whether Box Cars were rolled (sum of 12)
	//-----------------------------------------------------------------
	/**
	 * Determines whether Box Cars were rolled (sum of 12)
	 * @return boolean value
	 */
	public boolean isBoxCars() {
		int sum = d1.getFaceValue() + d2.getFaceValue();
		return (sum == 12);
	}
	
	
	//-----------------------------------------------------------------
	// Determines whether Sevens were rolled (sum of 7)
	//-----------------------------------------------------------------
	/**
	 * Determines whether Sevens were rolled (sum of 7)
	 * @return boolean value
	 */
	public boolean isSeven() {
		int sum = d1.getFaceValue() + d2.getFaceValue();
		return (sum == 7);
	}

	
	//-----------------------------------------------------------------
	// Returns a string representation of this die.
	//-----------------------------------------------------------------	
	/**
	 * 
	 */
	public String toString() {
		String value1 = d1.toString();
		String value2 = d2.toString();
		return value1 + "\t" + value2;
	}

}

