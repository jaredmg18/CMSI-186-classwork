/**
 *  File name     :  CountTheDays.java
 *  Purpose       :  Provides a class with supporting methods for CountTheDays.java program
 *  Author        :  B.J. Johnson (prototype)
 *  Date          :  2017-01-02 (prototype)
 *  Author        :  Jared Gencarella
 *  Date          :  2017-01-24
 *  Description   :  This file provides the supporting methods for the CountTheDays program which will
 *                   calculate the number of days between two dates.  It shows the use of modularization
 *                   when writing Java code, and how the Java compiler can "figure things out" on its
 *                   own at "compile time".  It also provides examples of proper documentation, and uses
 *                   the source file header template as specified in the "Greeter.java" template program
 *                   file for use in CMSI 186, Spring 2017.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-02  B.J. Johnson  Initial writing and release
 */
public class CountTheDays {
  public static void main (String args[]) {
    System.out.println("args.lenght =" + args.length);
    if (args.length != 6) {
       System.out.println("Not enough args");
       System.exit(1);
    }
    CalendarStuff cs = new CalendarStuff();
    long month1 = Long.parseLong(args[0]);
    long month2 = Long.parseLong(args[3]);
    long day1 = Long.parseLong(args[1]);
    long day2 = Long.parseLong(args[4]);
    long year1 = Long.parseLong(args[2]);
    long year2 = Long.parseLong(args[5]);
    if (cs.isValidDate(month1,day1,year1) && (cs.isValidDate(month2,day2,year2))) {
       long dayCount = cs.daysBetween(month1,day1,year1,month2,day2,year2);
       System.out.println("dayCount = " + dayCount);
    } else {
       System.out.println("badYear");
    }
  }
}
