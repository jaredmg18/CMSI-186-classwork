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
      *  Method to calculate and return the angle between the hands
      *  @return double-precision value of the angle between the two hands
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
         this.hours = (this.seconds / 3600);
         this.minutes = Math.floor(this.seconds / 60) % 60;
         this.seconds = this.seconds % 60;
         String time = (int)this.hours + ":" + (int)this.minutes + ":" + this.seconds;
         this.seconds = totalSeconds;
         return time;
      }

      public double anglePerTick() {
        double SecPerCycle = 3600;
        double minuteHand = 360 * (this.slice / SecPerCycle);
        double secondHand = minuteHand / 12;
        return minuteHand - secondHand;
      }

      public void increasingAngle() {
        if(this.angle >= 360) {
          this.angle = this.angle - 360;
        }
        this.angle = this.angle + this.anglePerTick();
      }

      public double getAngle() {
        return this.angle;
      }

      public boolean isStillRunning() {
        double SecPerDay = 43200;
        return this.seconds <= SecPerDay;
      }

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
      }
   }

