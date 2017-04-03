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
  double hours;
  double minutes;
  double seconds;
  double timeIncrement;  // this increment will always be in seconds
  double totalSeconds;
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
    Timer t = new Timer(1);
    System.out.println("hello");
  }
}
