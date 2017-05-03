/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DynamicChangemaker.java
 *  Purpose       :  Provides a class defining methods for the DynamicChangemaker class
 *  @author       :  Jared Gencarella
 *  Date written  :  2017-05-04
 *  Description   :  This class provides methods that help break down the steps to creating a Program
 *                   that can take in a set of coins and a desired numeric value, and find how to make
 *                   that value using the fewest coins, if possible.
 *                   Includes the following:
 *
 *  Notes         :  Everything works, instructions on how to run are presented in terminal with inputs
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */


 /**
  * This class sets up the DynamicChangemaker program
  */
public class DynamicChangemaker {

    /**
     * constructs the part of the program that handles the inputs
     *
     * @param args input that the user sets for the program to solve
     *
     * @return return the printUsage() lines filled in with updates after methods use inputs
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        try {

            String[] denominationStrings = args[0].split(",");
            int[] denominations = new int[denominationStrings.length];

            for (int i = 0; i < denominations.length; i++) {
                denominations[i] = Integer.parseInt(denominationStrings[i]);
                if (denominations[i] <= 0) {
                    System.out.println("Denominations must all be greater than zero.\n");
                    printUsage();
                    return;
                }

                for (int j = 0; j < i; j++) {
                    if (denominations[j] == denominations[i]) {
                        System.out.println("Duplicate denominations are not allowed.\n");
                        printUsage();
                        return;
                    }
                }
            }

            int amount = Integer.parseInt(args[1]);
            if (amount < 0) {
                System.out.println("Change cannot be made for negative amounts.\n");
                printUsage();
                return;
            }

            Tuple change = makeChangeWithDynamicProgramming(denominations, amount);
            if (change.isImpossible()) {
                System.out.println("It is impossible to make " + amount + " cents with those denominations.");
            } else {
                int coinTotal = change.total();
                System.out.println(amount + " cents can be made with " + coinTotal + " coin" +
                        getSimplePluralSuffix(coinTotal) + " as follows:");

                for (int i = 0; i < denominations.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("- "  + coinCount + " " + denominations[i] + "-cent coin" +
                            getSimplePluralSuffix(coinCount));
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Denominations and amount must all be integers.\n");
            printUsage();
        }
    }


    /**
     * main method that creates a table for the integer i to run through and check for correct answer
     *
     * @param denominations an int array of all coin denominations that were given by the user (not necessarily in order)
     *
     * @param amount the amount that is desired by the user
     *
     * @return the tuple table which will be used for the program to run through
     */
    public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int amount) {
      int l = denominations.length;
      Tuple[][] table = new Tuple[l][amount + 1];
      for (int i = 0; i < l; i++) {
        for (int j = 0; j < (amount + 1); j++) {
          if (j == 0) {
            table[i][0] = new Tuple(l);
          } else
          if (denominations[i] > j) {
            table[i][j] = Tuple.IMPOSSIBLE;
          } else
          if (denominations[i] <= j) {
            table[i][j] = new Tuple(l);
            table[i][j].setElement(i,1);
            table[i][j] = addTuples(table[i][j],table[i][j-denominations[i]]);
          }
          if (i > 0) {
            table[i][j] = isAnswer(table[i-1][j],table[i][j]);
          }
        }
      }
        return table[l-1][amount];
    }

    /**
     * method to add tuples together
     *
     * @param first creates name "first" for the first tuple to be added
     *
     * @param second creates name "second" for the tuple to be added to the first
     *
     * @return the added tuple of the two
     */
    public static Tuple addTuples(Tuple first, Tuple second) {
      if(first.isImpossible() || second.isImpossible()) {
        return Tuple.IMPOSSIBLE;
      }
      return first.add(second);
    }

    /**
     * method that checks which of the two tuples is the correct answer to display
     *
     * @param first the first tuple, same as in addTuples()
     *
     * @param second same as above
     *
     * @return the correct answer
     */
    public static Tuple isAnswer(Tuple first, Tuple second) {
      if (first.isImpossible()) {
        return second;
      }
      if (second.isImpossible()) {
        return first;
      } else {
        return (first.total() < second.total()) ? first : second;
      }
    }

    /**
     * method referenced to display instructions for users on the terminal
     */
    private static void printUsage() {
        System.out.println("Usage: java DynamicChangemaker <denominations> <amount>");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
        System.out.println("  - <amount> is the amount for which to make change");
    }

    /**
     * method that recognizes whether it is one coin or plural
     *
     * @param count counts how many coins there are
     *
     * @return if only one coin, return coin with no s, otherwise add the s
     */
    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }
}
