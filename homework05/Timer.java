/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Timer.java
 *  Purpose       :  Timer class that will be used for the Soccer Simulation program
 *  @see
 *  @author       :  Jared Gencarella
 *  Date written  :  2017-03-28
 *  Description   :  This class provides a timer that will be used as a tick to mark how often the Soccer
                     Simulation program updates itself and keeps track of how much time has passed while the program runs.
 *  Notes         :  Added throughout methods in the class
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:       Reason for change/modification
 *           -----  ----------  ------------      -----------------------------------------------------------
 *  @version 1.0.0  2017-03-28  Jared Gencarella   Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class Timer {
  static double hours;
  static double minutes;
  double seconds;
  double timeIncrement;  // this increment will always be in seconds
  static double totalSeconds;
  double newSeconds;

  public Timer(double timeSlice) {
    seconds = 0;
    minutes = 0;
    hours = 0;
    timeIncrement = timeSlice;
    totalSeconds = 0;
  }

  public double tick() {
    totalSeconds += timeIncrement;
    return totalSeconds;
  }

  public double getSeconds() {
    if(totalSeconds % 60 == 0) {
      return 0;
    }
    if(totalSeconds < 60) {
      return totalSeconds;
    }
    if((seconds > 60) && (seconds%60 != 0)) {
      totalSeconds = totalSeconds % 60;
      return totalSeconds;
    }
    return totalSeconds;
  }

  public double getMinutes() {
    if(totalSeconds < 60) {
      return 0;
    }
    if((totalSeconds % 60 == 0) && (totalSeconds >= 60)) {
      minutes = totalSeconds / 60;
      return minutes;
    }
    if((totalSeconds % 60 != 0) && (totalSeconds > 60)) {
      double leftSeconds = totalSeconds % 60;
      double ns = totalSeconds - leftSeconds;
      minutes = ns / 60;
      return minutes;
    }
    return minutes;
  }

  public double getHours() {
    if(minutes < 60) {
      return 0;
    }
    if((minutes % 60 == 0) && (minutes >= 60)) {
      hours = minutes / 60;
      return hours;
    }
    if((minutes % 60 != 0) && (minutes > 60)) {
      double leftMinutes = minutes % 60;
      double nm = minutes - leftMinutes;
      hours = nm / 60;
      return hours;
    }
    return hours;
  }

  public String toString() {
    return "Timer: [" + hours + ":" + minutes + ":" + totalSeconds + "]";
  }

  public static void main (String args[]) {
    System.out.println("Testing timer with time slice 1 second");
    Timer t = new Timer(1);
    t.tick();
    t.toString();
    System.out.println("Timer: [" + t.getHours() + ":" + t.getMinutes() + ":" + t.getSeconds() + "]");
    t.tick();
    t.toString();
    System.out.println("Timer: [" + t.getHours() + ":" + t.getMinutes() + ":" + t.getSeconds() + "]");

    System.out.println("Testing timer with time slice 30 seconds");
    Timer t2 = new Timer(30);
    t2.tick();
    t2.toString();
    System.out.println("Timer: [" + t2.getHours() + ":" + t2.getMinutes() + ":" + t2.getSeconds() + "]");
    t2.tick();
    t2.toString();
    System.out.println("Timer: [" + t2.getHours() + ":" + t2.getMinutes() + ":" + t2.getSeconds() + "]");
    t2.tick();
    t2.toString();
    System.out.println("Timer: [" + t2.getHours() + ":" + t2.getMinutes() + ":" + t2.getSeconds() + "]");

    System.out.println("Testing timer with time slice 60 seconds");
    Timer t3 = new Timer(60);
    t3.tick();
    t3.toString();
    System.out.println("Timer: [" + t3.getHours() + ":" + t3.getMinutes() + ":" + t3.getSeconds() + "]");
    t3.tick();
    t3.toString();
    System.out.println("Timer: [" + t3.getHours() + ":" + t3.getMinutes() + ":" + t3.getSeconds() + "]");
    t3.tick();
    t3.toString();
    System.out.println("Timer: [" + t3.getHours() + ":" + t3.getMinutes() + ":" + t3.getSeconds() + "]");
  }
}
