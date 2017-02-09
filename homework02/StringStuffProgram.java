/**
 *  File name     :  StringStuffProgram.java
 *  Purpose       :  Provides a class with supporting methods for StringStuffProgram.java program
 *  Author        :  B.J. Johnson (prototype)
 *  Date          :  2017-01-02 (prototype)
 *  Author        :  Jared Gencarella
 *  Date          :  2017-01-24
 *  Description   :  This file provides the supporting methods for the StringStuffProgram program which will
 *                   allow a user to find any information about a specific string they insert. It uses integer identifiers
 *                   to check each individual letter, and shows how the Java compiler can "figure things out" on its
 *                   own at "compile time".  It also provides examples of proper documentation, and uses
 *                   the source file header template as specified in the "Greeter.java" template program
 *                   file for use in CMSI 186, Spring 2017.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:        Reason for change/modification
 *           -----  ----------  ------------      -------------------------------------------------------
 *  @version 1.0.0  2017-01-29  Jared Gencarella    Initial writing and release
 */
public class StringStuffProgram {
  public static void main (String [] args) {
    StringStuff ss = new StringStuff();
    String s = String[input];
    if (ss.containsVowel(s)) {
      System.out.println("This string contains vowels");
    } else {
      System.out.println("This string contains no vowels");
    }
    if (ss.isPalindrome(s)) {
      System.out.println("This string is a palindrome");
    } else {
      System.out.println("This string is not a palindrome");
    }
    String t = new String (ss.evensOnly(s));
    System.out.println("The even letters in this string are: " + t);
    String u = new String (ss.oddsOnly(s));
    System.out.println("The odd letters in this string are: " + u);
    String v = new String (ss.evensOnlyNoDupes(s));
    System.out.println("The even letters in this string (not duplicated) are: " + u);
    String w = new String (ss.oddsOnlyNoDupes(s));
    System.out.println("The odd letters in this string (not duplicated) are: " + v);
    String x = new String (ss.reverse(s));
    System.out.println("The reverse of this string is: " + x);
  }
}
