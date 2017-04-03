/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  Ball class that defines a ball, which will be used for the Soccer Simulation program
 *  @see
 *  @author       :  Jared Gencarella
 *  Date written  :  2017-03-14
 *  Description   :  This class provides methods to construct a ball that will be used to be "kicked" in the Soccer Simulation program. 
 *  Notes         :  Added throughout methods in the class
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:       Reason for change/modification
 *           -----  ----------  ------------      -----------------------------------------------------------
 *  @version 1.0.0  2017-03-14  Jared Gencarella   Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.lang.*;

public class Ball {

  private static final double bRadius = 4.45; // radius of each ball in inches
  private static final double bWeight = 1; // weight of each ball in pounds
  private static final double timeSlice = 1; //default timeSlice in seconds
  private double xpos;
  private double ypos;
  private double deltax;
  private double deltay;
  private double totalSeconds = 0;
  private double angle = 0;
  private double Max_Speed = 131; // this is in miles per hour!!
  private Timer t;
  private double[] bPosition = new double[2];
  private double[] deltaV = new double[2];

  public Ball(double x, double y, double dx, double dy) {
    xpos = x;
    ypos = y;
    deltax = dx;
    deltay = dy;
  }

  public void validatePosition(double xpos, double ypos) {
    if (xpos < 200 && xpos > -200) {
      xpos = xpos;
    } else {
      throw new IllegalArgumentException("both starting coordinates for the ball must be between 200 and -200");
    }
    if (ypos < 200 && ypos > -200) {
      ypos = ypos;
    } else {
      throw new IllegalArgumentException("both starting coordinates for the ball must be between 200 and -200");
    }
  }

  public double[] updateSpeed() {
    deltaV[0] = deltax;
    deltaV[1] = deltay;
    deltax = .99 * deltax;
    deltay = .99 * deltay;
    return deltaV;
    }

    public double[] updatePos() {
      bPosition[0] = xpos + deltaV[0];
      bPosition[1] = ypos + deltaV[1];
      return bPosition;
    }

    public String posToString() {
      return "[" + bPosition[0] + "," + bPosition[1] + "]";
    }

    public String speedToString() {
      return "[" + deltaV[0] + "," + deltaV[1] + "]";
    }

    public boolean isMoving() {
      if((xpos < -200) || (xpos > 200)) {
        return false;
      }
      if ((ypos < -200) || (ypos > 200)) {
        return false;
      }
      if((deltax <= (1/12)) && (deltay <= (1/12))) {
        return false;
      }
      return true;
    }

  public static void main (String args[] ) {
    Timer timer1 = new Timer(1);
    System.out.println("Testing position with x value of 10 and y value of 30");
    System.out.println("Testing velocity with x speed of 2 and y speed of 3");
    System.out.println("Testing with a time increment of 1 second");
    Ball b = new Ball(10, 30, 2, 3);
    System.out.println("Time: " + timer1.toString());
    b.updatePos();
    System.out.println("Position: " + b.posToString());
    b.updateSpeed();
    System.out.println("Speed: " + b.speedToString());

   timer1.tick();
   System.out.println("Time: " + timer1.toString());
   b.updatePos();
   System.out.println("Position: " + b.posToString());
   b.updateSpeed();
   System.out.println("Speed: " + b.speedToString());

   timer1.tick();
   System.out.println("Time: " + timer1.toString());
   b.updatePos();
   System.out.println("Position: " + b.posToString());
   b.updateSpeed();
   System.out.println("Speed: " + b.speedToString());

   Timer timer2 = new Timer(10);
   System.out.println("Testing position with x value of 10 and y value of 30");
   System.out.println("Testing velocity with x speed of 2 and y speed of 3");
   System.out.println("Testing with a time increment of 10 seconds");
   Ball b2 = new Ball(10, 30, 2, 3);
   System.out.println("Time: " + timer2.toString());
   b.updatePos();
   System.out.println("Position: " + b.posToString());
   b.updateSpeed();
   System.out.println("Speed: " + b.speedToString());

   timer2.tick();
   System.out.println("Time: " + timer2.toString());
   b.updatePos();
   System.out.println("Position: " + b.posToString());
   b.updateSpeed();
   System.out.println("Speed: " + b.speedToString());
  }
}
