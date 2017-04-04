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
import java.text.DecimalFormat;

public class Ball {

  DecimalFormat df = new DecimalFormat("####.####");

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

  /**
   * main constructor for the Ball class
   * @param x double value x coordinate of the ball
   * @param y double value y coordinate of the ball
   * @param dx double value speed the ball is traveling on the X-axis
   * @param dy double value speed the ball is traveling
   */
  public Ball(double x, double y, double dx, double dy) {
    xpos = x;
    ypos = y;
    deltax = dx;
    deltay = dy;
  }

  /**
   * method that checks if thes and y positions are within the field
   * any value between -200 and 200 for both x and y is considered within the field
   * @param xpos double value x position taken from the constructor method
   * @param ypos double value y position taken from the constructor method
   */
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

  /**
   * method that updates the speeds for the ball in the x and y directions
   */
  public double[] updateSpeed() {
    deltaV[0] = Double.parseDouble(df.format(deltax));
    deltaV[1] = Double.parseDouble(df.format(deltay));
    if (isMoving() == true) {
      deltax = .99 * deltax;
      deltay = .99 * deltay;
      return deltaV;
    }
    return deltaV;
  }

    /**
     * method that updates the position for the ball in the x and y coordinates
     */
    public double[] updatePos() {
      bPosition[0] = Double.parseDouble(df.format(xpos));
      bPosition[1] = Double.parseDouble(df.format(ypos));
      if(isMoving() == true) {
        xpos = xpos + deltax;
        ypos = ypos + deltay;
        return bPosition;
      }
      return bPosition;
    }

    public double getXpos() {
      return xpos;
    }

    public double getYpos() {
      return ypos;
    }

    public double[] getPos() {
      bPosition[0] = Double.parseDouble(df.format(xpos));
      bPosition[1] = Double.parseDouble(df.format(ypos));
      return bPosition;
      }

    public double[] getSpeed() {
      deltaV[0] = Double.parseDouble(df.format(deltax));
      deltaV[1] = Double.parseDouble(df.format(deltay));
      return deltaV;
      }

    /**
     * method that takes the updated positions and turns them into a string
     */
    public String posToString() {
      return "[" + bPosition[0] + "," + bPosition[1] + "]";
    }

    /**
     * method that takes the updated speeds and turns them into a string
     */
    public String speedToString() {
      return "[" + deltaV[0] + "," + deltaV[1] + "]";
    }

    /**
     * method that checks if the ball is still considered to be moving.
     */
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

  /**
   * tests for the Ball class
   */
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
   b2.updatePos();
   System.out.println("Position: " + b2.posToString());
   b2.updateSpeed();
   System.out.println("Speed: " + b2.speedToString());

   timer2.tick();
   System.out.println("Time: " + timer2.toString());
   b2.updatePos();
   System.out.println("Position: " + b2.posToString());
   b2.updateSpeed();
   System.out.println("Speed: " + b2.speedToString());

   timer2.tick();
   System.out.println("Time: " + timer2.toString());
   b2.updatePos();
   System.out.println("Position: " + b2.posToString());
   b2.updateSpeed();
   System.out.println("Speed: " + b2.speedToString());

   timer2.tick();
   System.out.println("Time: " + timer2.toString());
   b2.updatePos();
   System.out.println("Position: " + b2.posToString());
   b2.updateSpeed();
   System.out.println("Speed: " + b2.speedToString());
  }
}
