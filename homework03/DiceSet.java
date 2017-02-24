/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  Jared Gencarella
 *  Date          :  2017-02-14
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public void setIndividual( int i, int jValue );  // Sets the ith die in this set to the value of jValue
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-14  Jared Gencarella  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DiceSet {

  /**
   * private instance data
   */
   private int pips;
   private int dieCount;
   private int dieSides;
   private Die[] dieArrayObject = null;

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {
     if (count >= 1) {
       dieCount = count;
     } else {
       throw new IllegalArgumentException("wrong number of die (must have at least one, can have at most 9)");
     }
     if (sides >= 4) {
       dieSides = sides;
     } else {
       throw new IllegalArgumentException("wrong number of sides (must have at least 4, can have at most 9)");
     }
     dieArrayObject = new Die[count];
     for (int i = 0; i < count; i++) {
      dieArrayObject[i] = new Die(sides);
     }
   }

   /**
    * Randomly rolls all of the dice in this set
    */
    public void roll() {
      for (int i = 0; i < dieArrayObject.length; i++) {
        dieArrayObject[i].roll();
      }
    }

  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() {
        int total = 0;
        for (int i = 0; i < dieArrayObject.length; i++) {
          total = total + dieArrayObject[i].getValue();
        }
     return total;
   }

  /**
   * Randomly rolls a single die of the dice in this set
   * @param  dieIndex int of which die to roll
   */
   public int rollIndividual( int dieIndex ) {
     return dieArrayObject[dieIndex].roll();
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
      return dieArrayObject[dieIndex].getValue();
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
      String dieNum = "";
      for (int i = 0; i < dieArrayObject.length; i++) {
        dieNum =  dieNum + " [" + dieArrayObject[i].getValue() + "] ";
      }
      return dieNum;
   }

   public String toNumString() {
     String dieNum = "";
     for (int i = 0; i < dieArrayObject.length; i++) {
       dieNum =  dieNum + dieArrayObject[i].getValue();
     }
     return dieNum;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) {
     String value = new String (ds.toString());
      return value;
   }

  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet ds ) {
       String value =  ds.toNumString();
       String output = "";
       for (int i = 0; i < value.length(); i++) {
         if (this.toNumString().contains(Character.toString(value.charAt(i)))) {
           output = output.concat(Character.toString(value.charAt(i)));
         }
       }
      return output.equals(value);
   }

  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
     DiceSet ds = new DiceSet(5, 6);
     ds.roll();
     System.out.println(ds.toString());
     System.out.println(ds.toNumString());
     DiceSet ds2 = new DiceSet(5, 6);
     ds2.roll();
     System.out.println(ds2.toString());
     System.out.println(ds2.toNumString());
     System.out.println(ds.isIdentical(ds2));
     ds = new DiceSet (5, 6);
     ds2 = new DiceSet(5, 6);
     System.out.println(ds.toNumString());
     System.out.println(ds2.toNumString());
     ds.isIdentical(ds2);
     System.out.println(ds.isIdentical(ds2));
   }
}
