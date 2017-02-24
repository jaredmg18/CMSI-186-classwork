/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  HighRoll.java
 *  Purpose       :  Demonstrates the use of input from a command line for use with Yahtzee
 *  Author        :  Jared Gencarella
 *  Date          :  2017-02-21
 *  Description   :
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-14  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll {
  private static DiceSet ds = null;
  private static int highScore = 0;

   public static void main( String args[] ) {
      System.out.println( "\n   Welcome to the HighRoll program!\n" );
      System.out.println( "1.   Specify die characteristics [1,number of die,sides]" );
      System.out.println( "     Press the 'q' key to quit the program." );

     // This line uses the two classes to assemble an "input stream" for the user to type
     // text into the program
      BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
      while( true ) {
         System.out.print( ">>" );
         String inputLine = null;
         try {
           inputLine = input.readLine();
            if( 0 == inputLine.length()) {
              System.out.println("enter some text");
            }
            if( 'q' == inputLine.charAt(0) ) {
               break;
            }
            if( '1' == inputLine.charAt(0)) {
              ds = new DiceSet(Character.getNumericValue(inputLine.charAt(2)), Character.getNumericValue(inputLine.charAt(4)));
              System.out.println("");
              System.out.println("die = " + inputLine.charAt(2) + "sides = " + inputLine.charAt(4));
                }
            if ('2' == inputLine.charAt(0)) {
              ds.roll();
              System.out.println("");
              System.out.println("Your die values are: " + ds.toString());
           }
           if ('3' == inputLine.charAt(0)) {
             int dieIndex = Character.getNumericValue(inputLine.charAt(2));
             ds.rollIndividual(dieIndex);
             System.out.println("");
             System.out.println(ds.toString());
             // user picks the dieIndex
             // subtract that die from the total
             // roll that individual die
             // ask user if they would like to use the new value
             // if yes, add new value to the totals
             // if no, use old total
           }
           if ('4' == inputLine.charAt(0)) {
              ds.sum();
              System.out.println("");
              System.out.println("Your score is: " + ds.sum());
          }
          if ('5' == inputLine.charAt(0)) {
              if (ds.sum() > highScore) {
              highScore = ds.sum();
              System.out.println("");
              System.out.println("New High Score is: " + ds.sum());
            } else {
              System.out.println("Score must be larger than current High Score to set new High Score");
            }
          }
            if ('6' == inputLine.charAt(0)) {
             System.out.println("Current High Score is: " + highScore);
           }
           System.out.println("");
           System.out.println("Below is all available options to continue playing:");
           System.out.println( "1.   Specify die characteristics [1,number of die,sides]" );
           System.out.println( "2.   Roll all of the die [2]" );
           System.out.println( "3.   Roll a single die of your choice [3, die index #]" );
           System.out.println( "4.   Calculate score for this roll [4]" );
           System.out.println( "5.   Save score as high score [5]" );
           System.out.println( "6.   Display high score [6]" );
           System.out.println( "7.   type 'q' to quit program [q]" );
        }
         catch( IOException ioe ) {
            System.out.println( "Caught IOException" );
         }
      }
}
}
