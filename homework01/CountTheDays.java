public class CountTheDays {
  public static void main (String[] args) {
    if (args.length == 6) {
    CalendarStuff cs = new CalendarStuff();
    long dayCount = cs.daysBetween(3,2,2001,4,2,2002);
    //   month1 = Long.parseLong(args[0]);
    // System.out.println("month1 = " + month1);
    // month2 = Long.parseLong(args[0]);
    // System.out.println("month2 = " + month2);
    // day1 = Long.parseLong(args[0]);
    // System.out.println("day1 = " + day1);
    // day2 = Long.parseLong(args[0]);
    // System.out.println("day2 = " + day2);
    // year1 = Long.parseLong(args[0]);
    // System.out.printl("year1 = " + year1);
    // year2 = Long.parseLong(args[0]);
    // System.out.println("year2 = " + year2);
} else {
  System.out.println("Not enough args");
  System.exit(1);
}
}
}
