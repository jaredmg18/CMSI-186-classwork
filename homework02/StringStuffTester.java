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
     test_containsVowel();  // 9 tests
     test_isPalindrome();   // 9 tests
     test_evensOnly();      // 6 tests
     test_oddsOnly();      // 6 tests
     test_evensOnlyNoDupes();   // 7 tests
     test_oddsOnlyNoDupes();  // 8 tests
     test_reverse();  // 7 tests
   }

   /**
   * method to test "containsVowel()" method in the StringStuff class
   * @return void
   */
  static void test_containsVowel() {
    System.out.println("\nNine Tests for containsVowel():");

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

    System.out.print(" E: ");
    try { System.out.println( StringStuff.containsVowel("e") ? "true" : "false");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" i: ");
    try { System.out.println( StringStuff.containsVowel("i") ? "true" : "false");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" o: ");
    try { System.out.println( StringStuff.containsVowel("o") ? "true" : "false");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" U: ");
    try { System.out.println( StringStuff.containsVowel("u") ? "true" : "false");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" y: ");
    try { System.out.println( StringStuff.containsVowel("y") ? "true" : "false");}
    catch( Exception e ) { System.out.println(false); }

  }

  /**
  * method to test "isPalindrome()" method in the StringStuff class
  * @return void
  */
  static void test_isPalindrome() {
    System.out.println("\nNine Tests for isPalindrome():");

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

    System.out.print(" abcdefghihgfedcb: ");
    try { System.out.println( StringStuff.isPalindrome("abcdefghihgfedcb") ? "true" : "false");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" abcdefgh hgfedcb: ");
    try { System.out.println( StringStuff.isPalindrome("abcdefghihgfedcb") ? "true" : "false");}
    catch( Exception e ) { System.out.println(false); }
  }

  /**
  * method to test "evensOnly()" method in the StringStuff class
  * @return void
  */
  static void test_evensOnly() {
    System.out.println("\nSix Tests for evensOnly():");

    System.out.print("A:");
    try {System.out.println( "".equals(StringStuff.evensOnly("A")) ? "" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print("B:");
    try {System.out.println( "B".equals(StringStuff.evensOnly("B")) ? "B" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print("Bldbl:");
    try {System.out.println( "Bldbl".equals(StringStuff.evensOnly("Bldbl")) ? "Bldbl" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print("Aca:");
    try {System.out.println( "".equals(StringStuff.evensOnly("Aca")) ? "" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print("REhearSALsz:");
    try {System.out.println( "RhrLz".equals(StringStuff.evensOnly("REhearSALsz")) ? "RhrLz" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print("REHEARSALSZ:");
    try {System.out.println( "RHRLZ".equals(StringStuff.evensOnly("REHEARSALSZ")) ? "RHRLZ" : "bad test");}
    catch( Exception e ) { System.out.println(false); }
  }

  /**
  * method to test "oddsOnly()" method in the StringStuff class
  * @return void
  */
  static void test_oddsOnly() {
    System.out.println("\nSix tests for oddsOnly():");

    System.out.print(" A: ");
    try {System.out.println( "A".equals(StringStuff.oddsOnly("A")) ? "A" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" B: ");
    try {System.out.println( "".equals(StringStuff.oddsOnly("B")) ? "" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" Bldblk: ");
    try {System.out.println( "k".equals(StringStuff.oddsOnly("Bldblk")) ? "k" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" Aca: ");
    try {System.out.println( "Aca".equals(StringStuff.oddsOnly("Aca")) ? "Aca" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" xylophones: ");
    try {System.out.println( "yooes".equals(StringStuff.oddsOnly("xylophones")) ? "yooes" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" XYloPHonES: ");
    try {System.out.println( "YooES".equals(StringStuff.oddsOnly("XYloPHonES")) ? "YooES" : "bad test");}
    catch( Exception e ) { System.out.println(false); }
  }

  /**
  * method to test "oddsOnlyNoDupes()" method in the StringStuff class
  * @return void
  */
  static void test_oddsOnlyNoDupes() {
    System.out.println("\nEight tests for oddsOnlyNoDupes():");

    System.out.print(" a: ");
    try {System.out.println( "a".equals(StringStuff.oddsOnlyNoDupes("a")) ? "a" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" aca: ");
    try {System.out.println( "ac".equals(StringStuff.oddsOnlyNoDupes("aca")) ? "ac" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" bdb: ");
    try {System.out.println( "".equals(StringStuff.oddsOnlyNoDupes("bdb")) ? "" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" JaredJared: ");
    try {System.out.println( "ae".equals(StringStuff.oddsOnlyNoDupes("JaredJared")) ? "ae" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" bbbccc: ");
    try {System.out.println( "c".equals(StringStuff.oddsOnlyNoDupes("bbbccc")) ? "c" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" xylophones: ");
    try {System.out.println( "yoes".equals(StringStuff.oddsOnlyNoDupes("xylophones")) ? "yoes" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" XYloPHonES: ");
    try {System.out.println( "YoES".equals(StringStuff.oddsOnlyNoDupes("XYloPHonES")) ? "YoES" : "bad test");}
    catch( Exception e ) { System.out.println(false); }

    System.out.print(" bbbbbbbbbbb ccccccccccc: ");
    try {System.out.println( "c".equals(StringStuff.oddsOnlyNoDupes("bbbbbbbbbbb ccccccccccc")) ? "c" : "bad test");}
    catch( Exception e ) { System.out.println(false); }
   }

   /**
   * method to test "evensOnlyNoDupes()" method in the StringStuff class
   * @return void
   */
   static void test_evensOnlyNoDupes() {
     System.out.println("\nSeven tests for evensOnlyNoDupes():");

     System.out.print(" b: ");
     try {System.out.println( "b".equals(StringStuff.evensOnlyNoDupes("b")) ? "b" : "bad test");}
     catch( Exception e ) { System.out.println(false); }

     System.out.print(" aca: ");
     try {System.out.println( "".equals(StringStuff.evensOnlyNoDupes("aca")) ? "" : "bad test");}
     catch( Exception e ) { System.out.println(false); }

     System.out.print(" bdb: ");
     try {System.out.println( "bd".equals(StringStuff.evensOnlyNoDupes("bdb")) ? "bd" : "bad test");}
     catch( Exception e ) { System.out.println(false); }

     System.out.print(" JaredJared: ");
     try {System.out.println( "Jrd".equals(StringStuff.evensOnlyNoDupes("JaredJared")) ? "Jrd" : "bad test");}
     catch( Exception e ) { System.out.println(false); }

     System.out.print(" bbbccc: ");
     try {System.out.println( "b".equals(StringStuff.evensOnlyNoDupes("bbbccc")) ? "b" : "bad test");}
     catch( Exception e ) { System.out.println(false); }

     System.out.print(" REhearSALsz: ");
     try {System.out.println( "RhrLz".equals(StringStuff.evensOnlyNoDupes("REhearSALsz")) ? "RhrLz" : "bad test");}
     catch( Exception e ) { System.out.println(false); }

     System.out.print(" bbbbbbbbbbb ccccccccccc: ");
     try {System.out.println( "b".equals(StringStuff.evensOnlyNoDupes("bbbbbbbbbbb ccccccccccc")) ? "b" : "bad test");}
     catch( Exception e ) { System.out.println(false); }
   }

   /**
   * method to test "reverse()" method in the StringStuff class
   * @return void
   */
   static void test_reverse() {
     System.out.println("\nSeven tests for reverse():");

     System.out.print(" what the cluck: ");
     try {System.out.println( "kculc eht tahw".equals(StringStuff.reverse("what the cluck")) ? "kculc eht tahw" : "bad test");}
     catch( Exception e ) { System.out.println(false); }

     System.out.print(" bdb: ");
     try {System.out.println( "bdb".equals(StringStuff.reverse("bdb")) ? "bdb" : "bad test");}
     catch( Exception e ) { System.out.println(false); }

     System.out.print(" jaredjared: ");
     try {System.out.println( "derajderaj".equals(StringStuff.reverse("jaredjared")) ? "derajderaj" : "bad test");}
     catch( Exception e ) { System.out.println(false); }

     System.out.print(" REHEARSALSZ: ");
     try {System.out.println( "ZSLASRAEHER".equals(StringStuff.reverse("REHEARSALSZ")) ? "ZSLASRAEHER" : "bad test");}
     catch( Exception e ) { System.out.println(false); }

     System.out.print(" madamimadam: ");
     try {System.out.println( "madamimadam".equals(StringStuff.reverse("madamimadam")) ? "madamimadam" : "bad test");}
     catch( Exception e ) { System.out.println(false); }

     System.out.print(" amanaplanacanalpanama: ");
     try {System.out.println( "amanaplanacanalpanama".equals(StringStuff.reverse("amanaplanacanalpanama")) ? "amanaplanacanalpanama" : "bad test");}
     catch( Exception e ) { System.out.println(false); }

     System.out.print(" backwards: ");
     try {System.out.println( "sdrawkcab".equals(StringStuff.reverse("backwards")) ? "sdrawkcab" : "bad test");}
     catch( Exception e ) { System.out.println(false); }
   }
}
