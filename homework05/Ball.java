import java.lang.*;

public class Ball {

  private static final double bRadius = 4.45; // radius of each ball in inches
  private static final double bWeight = 1; // weight of each ball in pounds
  private static final double timeSlice = 1; //default timeSlice in seconds
  private double xpos = 0.0;
  private double ypos = 0.0;
  private double deltax = 0.0;
  private double deltay = 0.0;
  private double totalSeconds = 0;
  private double angle = 0;
  private double Max_Speed = 131; // this is in miles per hour!!

  public Ball(double x, double y, double deltax, double deltay) {
    xpos = x;
    ypos = y;
    deltax = deltax;
    deltay = deltay;
  }

  public void validatePosition(double xpos, double ypos) {
    if (xpos < 300 && xpos > -300) {
      xpos = xpos;
    } else {
      throw new IllegalArgumentException("both starting coordinates for the ball must be between 300 and -300");
    }
    if (ypos < 300 && ypos > -300) {
      ypos = ypos;
    } else {
      throw new IllegalArgumentException("both starting coordinates for the ball must be between 300 and -300");
    }
  }

  public double updateXPosition() {
    xpos += deltax;
    deltax *= .99;
    return xpos;
      // double velocity = Math.sqrt((dx * dx) + (dy * dy));
      // double nv = velocity * Math.pow(.99, this.totalSeconds);
    }

    public double updateYPosition() {
      ypos += deltay;
      deltay *= .99;
      return ypos;
    }

    public double getXPos() {
      return this.xpos;
    }

    public double getYPos() {
      return this.ypos;
    }

    public String toString() {
      return "[" + xpos + "," + ypos + "]";
    }

    public boolean isMoving() {
      if((xpos < -300) || (xpos > 300)) {
        return false;
      }
      if ((ypos < -300) || (ypos > 300)) {
        return false;
      }
      if((deltax <= .084) && (deltay <= .084)) {
        return false;
      }
      return true;
    }

  public static void main (String args[] ) {
    // Position p1 = new Position (0.0, 0.0);
    // Position p2 = new Position (1.0, 1.0);
    // Position p3 = new Position (2.0, -3.0);
    // System.out.println( "Testing Position creation: ");
    // System.out.println( "Position p1 is: " + p1.toString());
    // System.out.println( "Position p2 is: " + p2.toString());
    // System.out.println( "Position p3 is: " + p3.toString());

    System.out.println( "Testing position with x value of 10 and y value of 30");
  }
}
