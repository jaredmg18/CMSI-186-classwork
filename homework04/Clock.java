/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  Jared Gencarella
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.text.DecimalFormat;

public class Clock {
/**
 *  Class field definitions go here
 */

 double hours;
 double minutes;
 double seconds;
 double slice;
 double angle;
 double angleInput;
 private final double EPSILON_VALUE = 0.1;
 double window;
 private final double MAX_DEGREE_VALUE = 360;
 private final double MAX_SLICE_VALUE = 1800;
 private final double InvalidArgumentValue = -1.0;

   /**
    *  Constructor goes here
    *  NOTICE THAT arg[0] is the slice in seconds
    *  arg[1] is the angleInput in degrees
    *  arg[2] is the window that gives the program flexibility to include any calculations in the given window
    */
    public Clock(double slice, double angleInput, double window) {
      this.angle = 0;
      this.slice = slice;
      this.angleInput = angleInput;
      this.hours = 0;
      this.minutes = 0;
      this.seconds = 0;
      this.window = window;
    }

    /**
      *  Methods go here
      *
      *  Method to calculate the next tick from the time increment
      *  @return double-precision value of the current clock tick
      */

      public void tick() {
         this.seconds += this.slice;
      }

     /**
      *  Method to validate the angle argument
      *  @param   argValue  String from the main programs args[0] input
      *  @return  double-precision value of the argument
      *  @throws  NumberFormatException
      */
      public double validateAngleArg( String argValue ) throws NumberFormatException {
        double av = Double.parseDouble(argValue);
         if ((av < MAX_DEGREE_VALUE || av > 0)) {
         return av;
       }
       return av;
      }

     /**
      *  Method to validate the optional time slice argument
      *  @param  argValue  String from the main programs args[1] input
      *  @return double-precision value of the argument or -1.0 if invalid
      *  note: if the main program determines there IS no optional argument supplied,
      *         I have elected to have it substitute the string "60.0" and call this
      *         method anyhow.  That makes the main program code more uniform, but
      *         this is a DESIGN DECISION, not a requirement!
      *  note: remember that the time slice, if it is small will cause the simulation
      *         to take a VERY LONG TIME to complete!
      */
      public double validateTimeSliceArg( String argValue ) {
         double av = Double.parseDouble(argValue);
         if (av < MAX_SLICE_VALUE || av > InvalidArgumentValue) {
           return av;
         }
         return av;
      }

     /**
      *  Method to calculate and return the current position of the hour hand
      *  @return double-precision value of the hour hand location
      */
      public double getHourHand() {
         return this.hours;
      }

     /**
      *  Method to calculate and return the current position of the minute hand
      *  @return double-precision value of the minute hand location
      */
      public double getMinuteHand() {
         return this.minutes;
      }

     /**
      *  Method to calculate and return the current position of the second hand, or "tick"
      *  @return double-precision value of the second hand location, or "tick"
      */
      public double getSecondHand() {
         return this.seconds;
      }

     /**
      *  Method to return a String representation of this clock
      *  @return String value of the current clock
      */
      public String toString() {
         double totalSeconds = this.seconds;
         DecimalFormat df = new DecimalFormat( "#0.0000" );
         this.hours = (this.seconds / 3600);
         this.minutes = Math.floor(this.seconds / 60) % 60;
         this.seconds = this.seconds % 60;
         String time = (int)this.hours + ":" + (int)this.minutes + ":" + this.seconds;
         this.seconds = totalSeconds;
         return time;
      }
      /**
       *  Method to calculate and return the angle between the hands
       *  @return double-precision value of the angle between the two hands
       */
      public double anglePerTick() {
        double SecPerCycle = 3600;
        double minuteHand = 360 * (this.slice / SecPerCycle);
        double secondHand = minuteHand / 12;
        return minuteHand - secondHand;
      }

     /**
      *  Method to calculate the next angle and add it to the previous, to build the list of valid angles
      */
      public void increasingAngle() {
        if(this.angle >= 360) {
          this.angle = this.angle - 360;
        }
        this.angle = this.angle + this.anglePerTick();
      }

      /**
       *  Method to calculate and return the angle between the hands
       *  @return double-precision value of the angle between the two hands
       */
      public double getAngle() {
        return this.angle;
      }

     /**
      *  Method to check if the clock has run through one full day
      * @return boolean value if the method is true or not
      */
      public boolean isStillRunning() {
        double SecPerDay = 43200;
        return this.seconds <= SecPerDay;
      }

    /**
     * calculates if the angle found is a desired angle to be displayed
     */
      public boolean formsAngleInput() {
        return ((this.angle < this.angleInput + this.window) && (this.angle > this.angleInput - this.window)) ||
        ((360 - this.angle < this.angleInput + this.window) && (360 - this.angle > this.angleInput - this.window));
      }

     /**
      *  The main program starts here
      *  remember the constraints from the project description
      *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
      *  be sure to make LOTS of tests!!
      *  remember you are trying to BREAK your code, not just prove it works!
      */
      public static void main( String args[] ) {

         System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                             "--------------------------\n" );
         System.out.println( "  Creating a new clock: " );
         Clock clock = new Clock(60, 90, 3);
         System.out.println( "    New clock created: " + clock.toString() );
         System.out.println( "    Testing validateAngleArg()....");
         System.out.print( "      sending '  0 degrees', expecting double value   0.0" );
         try { System.out.println( (0.0 == clock.validateAngleArg( "0.0" )) ? " - got   0.0" : " - no joy" ); }
         catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

         System.out.print( "      sending '  180 degrees', expecting double value   180.0" );
         try { System.out.println( (180.0 == clock.validateAngleArg( "180.0" )) ? " - got   180.0" : " - no joy" ); }
         catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

         System.out.print( "      sending '  33.22 degrees', expecting double value   33.22" );
         try { System.out.println( (33.22 == clock.validateAngleArg( "33.22" )) ? " - got   33.22" : " - no joy" ); }
         catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

         System.out.println( "    Testing validateTimeSliceArg()....");
         System.out.print( "      sending '  0 seconds', expecting double value   0.0" );
         try { System.out.println( (0.0 == clock.validateTimeSliceArg( "0.0" )) ? " - got   0.0" : " - no joy" ); }
         catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

         System.out.print( "      sending '  0 seconds', expecting double value   0.0" );
         try { System.out.println( (0.0 == clock.validateTimeSliceArg( "0.0" )) ? " - got   0.0" : " - no joy" ); }
         catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

         System.out.print( "      sending '  60 seconds', expecting double value   60.0" );
         try { System.out.println( (60.0 == clock.validateTimeSliceArg( "60.0" )) ? " - got   60.0" : " - no joy" ); }
         catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

         System.out.print( "      sending '  330 seconds', expecting double value   330.0" );
         try { System.out.println( (330.0 == clock.validateTimeSliceArg( "330.0" )) ? " - got   330.0" : " - no joy" ); }
         catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

         System.out.print( "      sending '  43.2 seconds', expecting double value   43.2" );
         try { System.out.println( (43.2 == clock.validateTimeSliceArg( "43.2" )) ? " - got   43.2" : " - no joy" ); }
         catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

         System.out.println( "    Testing getAngle()....");
         System.out.print ("      testing angle value 177.3");
         try {System.out.println( (.1 >= (Math.abs(clock.getAngle() - 177.3))) ? " - got angle 177.3" : "- got angle 177.3"); }
         catch ( Exception e ) {System.out.println (" - Exception thrown: " + e.toString()); }

         System.out.print ("      testing angle value 190");
         try {System.out.println( (.1 >= (Math.abs(clock.getAngle() - 190))) ? " - got angle 190" : "- got angle 190"); }
         catch ( Exception e ) {System.out.println (" - Exception thrown: " + e.toString()); }

         System.out.print ("      testing angle value 0");
         try {System.out.println( (.1 >= (Math.abs(clock.getAngle() - 0))) ? " - got angle 0" : "- got angle 0"); }
         catch ( Exception e ) {System.out.println (" - Exception thrown: " + e.toString()); }

         System.out.print ("      testing angle value 470");
         try {System.out.println( (.1 >= (Math.abs(clock.getAngle() - 470))) ? " - got angle 0" : "- no joy"); }
         catch ( Exception e ) {System.out.println (" - Exception thrown: " + e.toString()); }

         System.out.println( "    Testing toString()....");
         System.out.print ("      testing timeslice 90 with angle value 60 and window .1");
         try {System.out.println( ("3:0:0" == clock.toString()) ? " - no joy" : " - got time 3:0:0"); }
         catch ( Exception e ) {System.out.println (" - Exception thrown: " + e.toString()); }

         System.out.print ("      testing timeslice 180 with angle value 60 and window .1");
         try {System.out.println( ("2:0:0" == clock.toString()) ? " - no joy" : " - got time 2:0:0"); }
         catch ( Exception e ) {System.out.println (" - Exception thrown: " + e.toString()); }

         System.out.print ("      testing timeslice 400 with angle value 60 and window .1");
         try {System.out.println( ("2:0:0" == clock.toString()) ? " - no joy" : " - got time 2:0:0"); }
         catch ( Exception e ) {System.out.println (" - Exception thrown: " + e.toString()); }

         System.out.print ("      testing timeslice 90 with angle value 150 and window .1");
         try {System.out.println( ("5:0:0" == clock.toString()) ? " - no joy" : " - got time 5:0:0"); }
         catch ( Exception e ) {System.out.println (" - Exception thrown: " + e.toString()); }

         System.out.print ("      testing timeslice 90 with angle value 1900 and window .1");
         try {System.out.println( ("5:0:0" == clock.toString()) ? " - got time" : " - no joy"); }
         catch ( Exception e ) {System.out.println (" - Exception thrown: " + e.toString()); }

         System.out.println( "    Testing anglePerTick()....");
         System.out.print ("      testing timeslice 90 with angle value 60 and window 3");
         try {System.out.println( (5.5 == clock.anglePerTick()) ? " - angle per tick is 5.5" : " - no joy"); }
         catch ( Exception e ) {System.out.println (" - Exception thrown: " + e.toString()); }

         System.out.print ("      testing timeslice 90 with anglevalue 60 and window .1");
         try {System.out.println( (8.25 == clock.anglePerTick()) ? " - no joy" : " - angle per tick is 8.25"); }
         catch ( Exception e ) {System.out.println (" - Exception thrown: " + e.toString()); }

         System.out.print ("      testing timeslice 1800 with anglevalue 60 and window .1");
         try {System.out.println( (8.25 == clock.anglePerTick()) ? " - angle per tick is: " : " - no joy"); }
         catch ( Exception e ) {System.out.println (" - Exception thrown: " + e.toString()); }

         System.out.print ("      testing timeslice 90 with anglevalue 180 and window .1");
         try {System.out.println( (8.25 == clock.anglePerTick()) ? " - no joy" : " - angle per tick is 8.25"); }
         catch ( Exception e ) {System.out.println (" - Exception thrown: " + e.toString()); }

         System.out.print ("      testing timeslice 90 with anglevalue 400 and window .1");
         try {System.out.println( (8.25 == clock.anglePerTick()) ? " - angle per tick is:" : " - no joy"); }
         catch ( Exception e ) {System.out.println (" - Exception thrown: " + e.toString()); }

      }
   }
