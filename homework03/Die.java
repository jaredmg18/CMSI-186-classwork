/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Dice-Games.java
 *  Purpose       :  A file full of stuff to do with the Java String class
 *  Author        :  B.J. Johnson
 *  Date          :  2017-02-09
 *  Student       :  Jared Gencarella
 *  Date          :  2017-02-14
 *  Description   :  This file presents a bunch of Dice-style helper methods. These methods can be used to play
                     the game Yahtzee through the command line of a computer's terminal.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-19  B.J. Johnson  Initial writing and release
 *  @version 1.1.0  2017-01-22  B.J. Johnson  Fill in methods to make the program actually work
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Die {

  /**
  * private instance data
  */
  private int sides;
  private int pips;
  private final int MINIMUM_SIDES = 4;
  private int nRoll;

  public Die(int nSides) {
    if (nSides < 4) {
    System.out.println("Must have at least 4 sides");
    } else {
      sides = nSides;
    }
  }

  public int roll() {
    int nRoll = (int) ((Math.random() * sides) + 1);
    return nRoll;
  }

  public int getValue() {
    return nRoll;
  }

  public void setValue(int kValue) {
    kValue = nRoll;
  }

  public int setSides(int sides) {
    return sides;
  }

  public static void main( String[] args) {
    System.out.println("Hello from the Die class main method");
    Die d = new Die(4);
    System.out.println("You rolled a: " + d.roll());
  }
}
