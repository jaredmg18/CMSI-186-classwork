public class SoccerSim {

  private static double numBalls;
  private Ball[] ballArray = null;

  public static void main (String args[]) {
    System.out.println("\n Hello World! Welcome to Soccer Simulation \n");
    System.out.println(" Arguments work as follows: ");
    System.out.println(" First argument is how many balls you want to kick ");
    System.out.println(" Second argument is the X coordinate you want your first ball to start in ");
    System.out.println(" Third argument is the Y coordinate you want your first ball to start in ");
    System.out.println(" Fourth argument is the speed along the X-axis you want the ball to start travel in ");
    System.out.println(" Fifth argument is the speed along the Y-axis you want the ball to start travel in ");
    System.out.println(" Sixth argument is the time increment, which specifies how often you want the program updating you (this is measured in seconds) ");
    System.out.println(" \n You can have as many balls as you like, and if you wish to have more you insert them as follows (after your 6th argument): \n ");
    System.out.println(" X coordinate, Y coordinate, X speed, Y speed (all for one ball) ");
    System.out.println(" Repeat this until you have inserted the information for the number of balls desired ");
    Flagpole pole = new Flagpole(100, 50);
    Ball[] ballArray = new Ball[numBalls];
    numBalls = Double.parseDouble(args[0]);
    xpos = Double.parseDouble(args[1]);
    ypos = Double.parseDouble(args[2]);
    deltax = Double.parseDouble(args[3]);
    deltay = Double.parseDouble(args[4]);
    timeIncrement = Double.parseDouble(args[5]);

    // System.out.println("\n    Testing the Ball class.... ");
    // Position p1 = new Position(23.0, 23.0 );
    // Position p2 = new Position(5.0, 5.0);
    // Position p3 = new Position(-14.5, -20.9);
    // Position p4 = new Position(-1.0, -1.0);
    // Position [] posRA = new Position[4];
    // posRA[0] = p1;
    // posRA[2] = p2;
    // posRA[3] = p3;
    // posRA[4] = p4;
    // Ball b1 = new Ball(p1, 0.0, 0.0);
    // Ball b2 = new Ball(p2, 0.0, 0.0);
    // Ball b3 = new Ball(p3, 0.0, 0.0);
    // Ball b4 = new Ball(p4, 0.0, 0.0);
    // System.out.println( "Ball b1: " + b1.toString());
    // System.out.println( "Ball b2: " + b2.toString());
    // System.out.println( "Ball b3: " + b3.toString());
    // System.out.println( "Ball b4: " + b4.toString());
    // Ball[] ballRA = new Ball[4];
    // for (int i = 0; i < ballRA.length; i++) {
    //   ballRA[i] = new Ball( posRA[i], (7.0 + (10.0 * i)), (7.0 + (10.0 * i)) );
    // }
    // for (int i = 0; i < ballRA.length; i++) {
    //   System.out.println( "Ball " + i + " is: " + ballRA[i].toString());
    // }
  }
}
