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

public class SoccerSim {

  private static double numBalls;
  private Ball[] ballArray;
  private Timer t;
  private double timeSlice;
  static double defaultTimeSlice = 1;

  public SoccerSim() {
    numBalls = 0;
    timeSlice = 0;
    ballArray = null;
  }

  public void handleInitialArguments(String args[]) {
    System.out.println("\n Hello World! Welcome to Soccer Simulation \n");
    System.out.println(" Arguments work as follows: ");
    System.out.println(" First argument is the time slice you want to use ");
    System.out.println(" Second argument is the X coordinate you want your first ball to start in ");
    System.out.println(" Third argument is the Y coordinate you want your first ball to start in ");
    System.out.println(" Fourth argument is the speed along the X-axis you want the ball to start travel in ");
    System.out.println(" Fifth argument is the speed along the Y-axis you want the ball to start travel in ");
    System.out.println(" \n You can have as many balls as you like, and if you wish to have more you insert them as follows (after your 6th argument): \n ");
    System.out.println(" X coordinate, Y coordinate, X speed, Y speed (all for one ball) ");
    System.out.println(" Repeat this until you have inserted the information for the number of balls desired ");
    System.out.println(" There is a Flagpole at coordinates (100,50) ");
    if (5 > args.length ) {
      System.out.println("\n Sorry, you must specify at least the following arguments: \n");
      System.out.println(" Time slice, X coordinate of a ball, Y coordinate of a ball, speed on x-axis, speed on y-axis ");
      System.exit(-1);
    }
    if ((args.length - 1) % 4 != 0) {
      System.out.println("\n You must have the folowing arguments: \n");
      System.out.println(" 1 argument for the time slice");
      System.out.println(" 4 arguments per ball you wish to 'kick'");
      System.exit(-1);
    }
    if (5 <= args.length) {
      numBalls = Math.floor((args.length - 1) / 4);
      ballArray = new Ball[(int)numBalls];
      t = new Timer(Double.parseDouble(args[0]));
      System.out.println("Starting positions: ");
      for (int i = 0; i < numBalls; i += 4) {
        double xposBall = Double.parseDouble(args[1 + i]);
        double yposBall = Double.parseDouble(args[2 + i]);
        double deltaxBall = Double.parseDouble(args[3 + i]);
        double deltayBall = Double.parseDouble(args[4 + i]);
        ballArray[i] = new Ball(xposBall, yposBall, deltaxBall, deltayBall);
        ballArray[i].updatePos();
        ballArray[i].updateSpeed();
        System.out.println("Ball " + i + " position: [" + ballArray[i].posToString() + "] and velocity: [" + ballArray[i].speedToString() + "]");
        }
      }
    }

  public void updateBalls() {
    for (int i = 0; i < numBalls; i++) {
      ballArray[i].updatePos();
      ballArray[i].updateSpeed();
      System.out.println("Ball " + i + " position: [" + ballArray[i].posToString() + "] and velocity: [" + ballArray[i].speedToString() + "]");
    }
  }

  public boolean isStillRunning() {
    for (int i = 0; i < numBalls; i++)
      if (ballArray[i].isMoving()) {
        return true;
    }
    System.out.println("No possible collision, all balls are either out of bounds or have stopped moving");
    return false;
  }

  public boolean ballCollision() {
    for (int i = 0; i <= (numBalls - 2); i++) {
      for (int j = i + 1; j <= (numBalls - 1); j++) {
        double distance = Math.sqrt((Math.pow(ballArray[j].updatePos()[0] - ballArray[i].updatePos()[0], 2)) + (Math.pow(ballArray[j].updatePos()[1] - ballArray[i].updatePos()[1], 2)));
        if (distance <= (8.9/12)) {
          System.out.println("Collision between ball" + j + " [" + ballArray[j].posToString() + "] and ball" + i + "[" + ballArray[i].posToString() + "] at " + t.toString());
          return true;
        }
        return false;
      }
      return false;
  }
  return false;
 }

  public boolean poleCollision() {
    return false;
  }

  public static void main(String args[]) {
    SoccerSim s = new SoccerSim();
    Timer t = new Timer(Double.parseDouble(args[0]));
    s.handleInitialArguments(args);
    while (s.isStillRunning()) {
      t.tick();
      s.updateBalls();
      if (s.ballCollision()) {
        break;
      }
      if (s.poleCollision()) {
        break;
      } else {
        continue;
      }
    }
  }
}
