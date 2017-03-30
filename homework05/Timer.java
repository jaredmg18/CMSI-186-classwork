public class Timer {
  double hours;
  double minutes;
  double seconds;
  double timeIncrement;  // this increment will always be in seconds
  double totalSeconds;
  double newSeconds;
  double leftSeconds;

  public Timer(double timeIncrement) {
    seconds = 0;
    minutes = 0;
    hours = 0;
    timeIncrement = timeIncrement;
    leftSeconds = 0;
  }

  public void tick() {
    seconds += timeIncrement;
  }

  public double getSeconds() {
    if(seconds % 60 == 0) {
      return 0;
    }
    if(seconds < 60) {
      return seconds;
    }
    if((seconds > 60) && (seconds%60 != 0)) {
      leftSeconds = seconds % 60;
      return leftSeconds;
    }
    return seconds;
  }

  public double getMinutes() {
    if(seconds < 60) {
      return 0;
    }
    if((seconds % 60 == 0) && (seconds >= 60)) {
      minutes = seconds / 60;
      return minutes;
    }
    if((seconds % 60 != 0) && (seconds > 60)) {
      double ns = seconds - leftSeconds;
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

  public static void main (String args[]) {
    Timer t = new Timer(10);
    System.out.println("hello");
  }
}
