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

  public String toString() {
    if(totalSeconds < 60) {
      seconds = totalSeconds;
      minutes = 0;
      hours = 0;
      return "Timer: " + hours + ":" + minutes + ":" + seconds;
    }
    if((totalSeconds >= 60) && (totalSeconds < 3600)) {
      seconds = totalSeconds % 60;
      minutes = Math.floor(totalSeconds/60);
      hours = 0;
      return "Timer: " + hours + ":" + minutes + ":" + seconds;
    }
    if ((totalSeconds >= 3600) && (totalSeconds <= 43200)) {
      seconds = totalSeconds % 60;
      minutes = ((Math.floor(totalSeconds/60)) % 60);
      hours = (Math.floor(Math.floor(totalSeconds/60)/60));
      return "Timer: " + hours + ":" + minutes + ":" + seconds;
    }
    if (totalSeconds > 43200) {
      return "Time has gone past an entire day";
    }
    return "Timer: " + hours + ":" + minutes + ":" + seconds;
  }

  public static void main (String args[]) {
    System.out.println("Testing timer with time slice 1 second");
    Timer t = new Timer(1);
    t.tick();
    System.out.println("" + t.toString());
    t.tick();
    System.out.println("" + t.toString());

    System.out.println("Testing timer with time slice 30 seconds");
    Timer t2 = new Timer(30);
    t2.tick();
    System.out.println("" + t2.toString());
    t2.tick();
    System.out.println("" + t2.toString());
    t2.tick();
    System.out.println("" + t2.toString());
    t2.tick();
    System.out.println("" + t2.toString());
    t2.tick();
    System.out.println("" + t2.toString());

    System.out.println("Testing timer with time slice 60 seconds");
    Timer t3 = new Timer(60);
    t3.tick();
    System.out.println("" + t3.toString());
    t3.tick();
    System.out.println("" + t3.toString());
    t3.tick();
    System.out.println("" + t3.toString());

    System.out.println("Testing timer with time slice 10 seconds");
    Timer t4 = new Timer(10);
    t4.tick();
    System.out.println("" + t4.toString());
    t4.tick();
    System.out.println("" + t4.toString());
    t4.tick();
    System.out.println("" + t4.toString());
    t4.tick();
    System.out.println("" + t4.toString());
    t4.tick();
    System.out.println("" + t4.toString());
    t4.tick();
    System.out.println("" + t4.toString());
    t4.tick();
    System.out.println("" + t4.toString());
  }
}
