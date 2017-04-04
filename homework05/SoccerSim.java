/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  Main program that runs the Soccer Simulation program.
 *  @see
 *  @author       :  Jared Gencarella
 *  Date written  :  2017-03-30
 *  Description   :  This program uses its own methods, as well as Timer.java and Ball.java to create a simulation where soccer balls are "kicked".
                     The program is built to notify a user when either A) when and where a collision occurs between objects in the "field", or B) when all the balls
                     have either left the field or have stopped moving, meaning a collision is impossible.
 *  Notes         :  Added throughout methods in the class
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:       Reason for change/modification
 *           -----  ----------  ------------      -----------------------------------------------------------
 *  @version 1.0.0  2017-03-30  Jared Gencarella   Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.lang.*;
import java.text.DecimalFormat;

public class SoccerSim {

  DecimalFormat df = new DecimalFormat("####.####");

  private static double numBalls;
  private Ball[] ballArray = null;
  private Timer t;
  private double timeSlice;
  static double defaultTimeSlice = 1;
  public boolean[] isStillRunning;

 /**
  * constructor method for Soccer Simulation
  */
  public SoccerSim() {
    numBalls = 0;
    timeSlice = 0;
    ballArray = null;
  }

 /**
  * method that tells the program what to do with the arguments the user inputs
  */
  public void handleInitialArguments(String args[]) {
    System.out.println("\n Hello World! Welcome to Soccer Simulation \n");
    System.out.println(" Arguments work as follows: ");
    System.out.println(" First argument is the X coordinate you want your first ball to start in ");
    System.out.println(" Second argument is the Y coordinate you want your first ball to start in ");
    System.out.println(" Third argument is the speed along the X-axis you want the ball to start travel in ");
    System.out.println(" Fourth argument is the speed along the Y-axis you want the ball to start travel in ");
    System.out.println(" \n You can have as many balls as you like, and if you wish to have more you insert them as follows (after your 4th argument):");
    System.out.println(" X coordinate, Y coordinate, X speed, Y speed (all for one ball)");
    System.out.println(" Repeat until you have inserted information for all desired balls");
    System.out.println(" There is a Flagpole at coordinates (100,50) ");
    System.out.println(" The time slice is set at 1 second and cannot be changed ");
    if (4 > args.length ) {
      System.out.println("\n Sorry, you must specify at least the following arguments:");
      System.out.println("X coordinate of a ball, Y coordinate of a ball, speed on x-axis, speed on y-axis");
      System.exit(-1);
    }
    if ((args.length) % 4 != 0) {
      System.out.println("\n You must have the folowing arguments:");
      System.out.println(" 4 arguments per ball you wish to 'kick'");
      System.exit(-1);
    }
    if (4 <= args.length) {
      System.out.println("\n Program begin:");
      numBalls = Math.floor(args.length / 4);
      System.out.println(" numBalls = " + numBalls);
      ballArray = new Ball[(int)numBalls];
      t = new Timer(1);
      System.out.println(" Starting positions: ");
      int j = 0; // tracks balls in the ballArray
      for (int i = 0; i < args.length; i += 4) {
        double xposBall = Double.parseDouble(args[0 + i]);
        double yposBall = Double.parseDouble(args[1 + i]);
        double deltaxBall = Double.parseDouble(args[2 + i]);
        double deltayBall = Double.parseDouble(args[3 + i]);
        ballArray[j] = new Ball(xposBall, yposBall, deltaxBall, deltayBall);
        ballArray[j].updatePos();
        ballArray[j].updateSpeed();
        System.out.println("Ball " + j + " position: [" + ballArray[j].posToString() + "] and velocity: [" + ballArray[j].speedToString() + "]");
        System.out.println("at " + t.toString());
        j++;
        }
      }
    }

  /**
   * method that updates the position and speeds of all the balls used in the simulation
   */
  public void updateBalls() {
    for (int i = 0; i < ballArray.length; i++) {
      ballArray[i].updatePos();
      ballArray[i].updateSpeed();
    }
  }

  /**
   * method that gets the position and speeds of all the balls used in the simulation
   */
  public void getBalls() {
    for (int i = 0; i < ballArray.length; i++) {
      ballArray[i].getPos();
      ballArray[i].getSpeed();
      System.out.println("Ball " + i + " position: " + ballArray[i].posToString() + " and velocity: " + ballArray[i].speedToString());
      System.out.println("at " + t.toString());
    }
  }

  /**
   * method that checks if the balls are still moving in the simulation
   */
   public boolean isStillRunning() {
     for (int i = 0; i < ballArray.length; i++)
       if ((ballArray[i].getPos()[0] < 200) && (ballArray[i].getPos()[0] > -200) && (ballArray[i].getPos()[1] < 200) && (ballArray[i].getPos()[1] > -200) &&
       (ballArray[i].getSpeed()[0] > (1/12)) && (ballArray[i].getSpeed()[0] > (1/12)) && (ballArray[i].getSpeed()[1] > (1/12) && (ballArray[i].getSpeed()[1] > (1/12)))) {
         return true;
     }
     System.out.println("No possible collision, all balls are either out of bounds or have stopped moving");
     return false;
 }

  /**
   * method that checks if a collision has occured in the simulation
   */
  public boolean ballCollision() {
    for (int i = 0; i <= (ballArray.length - 2); i++) {
      for (int j = i + 1; j <= (ballArray.length - 1); j++) {
        double distance = Math.sqrt((Math.pow((ballArray[j].getPos()[0] - ballArray[i].getPos()[0]), 2)) + (Math.pow((ballArray[j].getPos()[1] - ballArray[i].getPos()[1]), 2)));
        if (distance <= (8.9/12)) {
          System.out.println("Collision between ball" + j + " [" + ballArray[j].posToString() + "] and ball" + i + "[" + ballArray[i].posToString() + "]");
          System.out.println("at " + t.toString());
          return true;
        }
        return false;
      }
      return false;
  }
  return false;
 }

 /**
  * method that checks if a ball has collided with the set pole
  */
  public boolean poleCollision() {
    for (int i = 0; i < ballArray.length; i++) {
      double distance = Math.sqrt((Math.pow(ballArray[i].getPos()[0] - 100, 2) + (Math.pow(ballArray[i].getPos()[1] - 50, 2))));
      if (distance <= (8.9/12)) {
        System.out.println("Collision between ball" + i + " " + ballArray[i].posToString() + " and the pole [100, 50]");
        System.out.println("at " + t.toString());
        return true;
      }
      return false;
    }
    return false;
  }


  /**
   * main method for the Soccer Simulation program
   */
  public static void main(String args[]) {
    SoccerSim s = new SoccerSim();
    Timer timer = new Timer(1);
    s.handleInitialArguments(args);
    timer.tick();
    if (s.ballCollision() == true) {
      System.exit(-1);
    }
    if (s.poleCollision() == true) {
      System.exit(-1);
    }
    while (s.isStillRunning()) {
      timer.tick();
      s.updateBalls();
      s.getBalls();
      if (s.ballCollision() == true) {
        break;
      }
      if (s.poleCollision() == true) {
        break;
      } else {
        continue;
      }
    }
  }
}
