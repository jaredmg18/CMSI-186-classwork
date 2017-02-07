/**
 *  File name     :  StringStuffTester.java
 *  Purpose       :  Provides a tester class to test the methods in the StringStuff class
 *  Author        :  B.J. Johnson (prototype)
 *  Date          :  2017-01-02 (prototype)
 *  Author        :  Jared Gencarella
 *  Date          :  2017-01-31
 *  Description   :  This file provides the "test harness" for checking out the methods which are part of
 *                   the homework02 assignment.  It also provides examples of proper documentation, and
 *                   uses the source file header template as specified in the "Greeter.java" template file
 *                   for use in CMSI 186, Spring 2017.
 *  Notes         :  Successful (unsuccessful) tests
 *                   output an appropriate message for pass/fail.  If an exception is thrown, the test
 *                   simply outputs "false".  Tests for main() are not included; your professor and the
 *                   lab assistants can test that separately, using the daysBetween() tests, below.
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-13  B.J. Johnson  Initial writing and release
 */

public class StringStuffTester {

  /**
   * the main method which calls all of the test methods in the class
   * @param args String[] array containing command line parameters
   * @return void
   */
   public static void main ( String [] args) {
     test_containsVowel();  // 4 tests
     test_isPalindrome();   // 6 tests
     test_evensOnly();      // 4 tests
     test_oddsOnly();      // 7 tests
     test_evensOnlyNoDupes();   // 5 tests
     test_oddsOnlyNoDupes();  //7 tests
     test_reverse();  // 9 tests
   }

   /**
   * method to test "containsVowel()" method in the StringStuff class
   * @return void
   */
  static void test_containsVowel() {
    System.out.println("\nFour Tests for containsVowel():");

    System.out.print( " I like pizza: ");
    try { System.out.println( StringStuff.containsVowel("I like pizza") ? "true" : "false");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print( " bfd: ");
    try { System.out.println( StringStuff.containsVowel("bfd") ? "true" : "false");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" a: ");
    try { System.out.println( StringStuff.containsVowel("a") ? "true" : "false");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" : ");
    try { System.out.println( StringStuff.containsVowel("") ? "true" : "false");}
    catch( Exception e ) { System.out.println(false); }
  }

  /**
  * method to test "isPalindrome()" method in the StringStuff class
  * @return void
  */
  static void test_isPalindrome() {
    System.out.println("\nSeven Tests for isPalindrome():");

    System.out.print(" mom: ");
    try { System.out.println( StringStuff.isPalindrome("mom") ? "true" : "false");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" racecar: ");
    try { System.out.println( StringStuff.isPalindrome("racecar") ? "true" : "false");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" park: ");
    try { System.out.println( StringStuff.isPalindrome("park") ? "true" : "false");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" a: ");
    try { System.out.println( StringStuff.isPalindrome("a") ? "true" : "false");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" bb: ");
    try { System.out.println( StringStuff.isPalindrome("bb") ? "true" : "false");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" madam im adam: ");
    try { System.out.println( StringStuff.isPalindrome("madam im adam") ? "true" : "false");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" amanaplanacanalpanama: ");
    try { System.out.println( StringStuff.isPalindrome("amanaplanacanalpanama") ? "true" : "false");}
    catch( Exception e ) { System.out.println(false); }
  }

  /**
  * method to test "evensOnly()" method in the StringStuff class
  * @return void
  */
  static void test_evensOnly() {
    System.out.println("\nFive Tests for evensOnly():");

    System.out.print(" A: ");
    try {System.out.println( "" == StringStuff.evensOnly("A") ? "" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" B: ");
    try {System.out.println( "B" == StringStuff.evensOnly("B") ? "B" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" Go Sharks: ");
    try {System.out.println( "hr" == StringStuff.evensOnly("Go Sharks") ? "hr" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" Bld blk: ");
    try {System.out.println( "Bld blk " == StringStuff.evensOnly("Bld blk") ? "Bld blk" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" Aca: ");
    try {System.out.println( "" == StringStuff.evensOnly("Aca") ? "" : "bad test");}
    catch( Exception e ) { System.out.println(false); }
  }

  /**
  * method to test "oddsOnly()" method in the StringStuff class
  * @return void
  */
  static void test_oddsOnly() {
    System.out.println("\nFive tests for oddsOnly():");

    System.out.print(" A: ");
    try {System.out.println( "A" == StringStuff.evensOnly("A") ? "" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" B: ");
    try {System.out.println( "" == StringStuff.evensOnly("B") ? "B" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" Go Sharks: ");
    try {System.out.println( "Go Saks" == StringStuff.evensOnly("Go Sharks") ? "Go Saks" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" Bld blk: ");
    try {System.out.println( "" == StringStuff.evensOnly("Bld blk") ? "" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" Aca: ");
    try {System.out.println( "Aca" == StringStuff.evensOnly("Aca") ? "Aca" : "bad test");}
    catch( Exception e ) { System.out.println(false); }
  }

  /**
  * method to test "oddsOnlyNoDupes()" method in the StringStuff class
  * @return void
  */
  static void test_oddsOnlyNoDupes() {
    System.out.println("\nFour tests for oddsOnlyNoDupes():");

    System.out.print(" aca: ");
    try {System.out.println( "ac" == StringStuff.evensOnly("aca") ? "ac" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" bdb: ");
    try {System.out.println( "" == StringStuff.evensOnly("bdb") ? "" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" JaredJared: ");
    try {System.out.println( "ae" == StringStuff.evensOnly("Jared") ? "ae" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" bbbccc: ");
    try {System.out.println( "c" == StringStuff.evensOnly("bbbccc") ? "c" : "bad test");}
    catch( Exception e ) { System.out.println(false); }
   }

   /**
   * method to test "evensOnlyNoDupes()" method in the StringStuff class
   * @return void
   */
   static void test_evensOnlyNoDupes() {
     System.out.println("\nFour tests for evensOnlyNoDupes():");

     System.out.print(" aca: ");
     try {System.out.println( "" == StringStuff.evensOnly("aca") ? "" : "bad test");}
     catch( Exception e ) { System.out.println(false); }

     System.out.print(" bdb: ");
     try {System.out.println( "bd" == StringStuff.evensOnly("bdb") ? "bd" : "bad test");}
     catch( Exception e ) { System.out.println(false); }

     System.out.print(" JaredJared: ");
     try {System.out.println( "Jrd" == StringStuff.evensOnly("Jared") ? "Jrd" : "bad test");}
     catch( Exception e ) { System.out.println(false); }

     System.out.print(" bbbccc: ");
     try {System.out.println( "b" == StringStuff.evensOnly("bbbccc") ? "b" : "bad test");}
     catch( Exception e ) { System.out.println(false); }
   }

   /**
   * method to test "reverse()" method in the StringStuff class
   * @return void
   */
   static void test_reverse() {
     System.out.println("\nThree tests for reverse():");

     System.out.print(" what the cluck: ");
     try {System.out.println( "kculc eht tahw" == StringStuff.evensOnly("what the cluck") ? "kculc eht tahw" : "bad test");}
     catch( Exception e ) { System.out.println(false); }

     System.out.print(" bdb: ");
     try {System.out.println( "bdb" == StringStuff.evensOnly("bdb") ? "bdb" : "bad test");}
     catch( Exception e ) { System.out.println(false); }

     System.out.print(" jaredjared: ");
     try {System.out.println( "derajderaj" == StringStuff.evensOnly("jaredjared") ? "derajderaj" : "bad test");}
     catch( Exception e ) { System.out.println(false); }
   }
}
