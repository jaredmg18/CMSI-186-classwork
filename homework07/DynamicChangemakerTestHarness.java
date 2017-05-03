/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DynamicChangemakerTestHarness.java
 *  Purpose       :  Provides a class defining methods for the DynamicChangemakerTestHarness class
 *  @author       :  Jared Gencarella
 *  Date written  :  2017-05-04
 *  Description   :  This class provides a bunch of methods which may be useful for the DynamicChangemakerTestHarness class
 *                   for Homework 7.  Includes the following:
 *
 *  Notes         :  Everything should work fine!
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */


 /**
  * This class represents the test harness for DynamicChangemaker.java
  */
public class DynamicChangemakerTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    /**
     * main program section for the test harness
     *
     * @param args arguments inputed by user (for the purpose of this test, these are
                   already inputed by myself)
     */
    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_USA();
        test_Euro();
        test_SwissFrancs();
        test_Jmoney();

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    /**
     * method that will display success if the program got expected results
     *
     * @param value set argument that counts up the tests and tracks successes
     */
    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    /**
     * method that catches if it is a failure and uses the displaySuccessIfTrue() method to display it
     */
    private static void displayFailure() {
        displaySuccessIfTrue(false);
    }

    /**
     * first test method, uses U.S.A. denominations
     */
    public static void test_USA() {
        int[] usaDenominations = new int[] { 25, 10, 5, 1 };

        Tuple result = DynamicChangemaker.makeChangeWithDynamicProgramming(usaDenominations, 99);
        try {
            displaySuccessIfTrue(3 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(4 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    /**
     * Second test method, uses European denominations
     */
    public static void test_Euro() {
        int[] euroDenominations = new int[] { 50, 20, 10, 5, 1 };

        Tuple result = DynamicChangemaker.makeChangeWithDynamicProgramming(euroDenominations, 99);
        try {
            displaySuccessIfTrue(1 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(4 == result.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    /**
     * Third test method, uses Swiss denominations
     */
    public static void test_SwissFrancs() {
        int[] swissDenominations = new int[] { 50, 20, 10, 5,  };

        Tuple result = DynamicChangemaker.makeChangeWithDynamicProgramming(swissDenominations, 95);
        try {
            displaySuccessIfTrue(1 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    /**
     * Fourth test method, uses my own made up "Jmoney" denominations (no 1 coin and out of order)
     */
    public static void test_Jmoney() {
        int[] jmoneyDenominations = new int[] { 7, 3, 29, 15, 53 };

        Tuple result = DynamicChangemaker.makeChangeWithDynamicProgramming(jmoneyDenominations, 97);
        try {
            displaySuccessIfTrue(0 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }
}
