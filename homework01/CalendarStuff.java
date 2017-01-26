  /**
   * A method to return a count of the total number of days between two valid dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          long   count of total number of days
   */
   public static long daysBetween( long month1, long day1, long year1, long month2, long day2, long year2 ) {
     long count = 0;
     //switch dates if date2 < date1
      long year = year1;
      long month = month1;
      long day = day1;
        while (!dateEquals(month, day, year, month2, day2, year2)) {
          //System.out.println("count" + count + "day" + day);
          //System.out.println("month" + month + "year" + year);
          //System.out.println("daysInMonth" + daysInMonth(month, year));
            if (day == daysInMonth(month, year)) {
              if (month-1 == DECEMBER) {
                month = 0;
                year++;
             }
             day = 0;
             month++;
          }
          count++;
          day++;
        }
        //System.out.println("count" + count);
        return count;
            // System.out.println("count" + count + "day" + day);
            //  if ((daysInMonth(month, year) == day) && (month < month2)) {
            //     month = month + 1;
            //     day = 1;
            //     day++;
            //     count = count + 1;
            //     System.out.println("count" + count + "day" + day + "month" + month);
        //  }
        //  if ((daysInMonth(month, year) == day) && (month == month2) && (year < year2)) {
        //    year = year + 1;
        //    month = 1;
        //    day = 1;
        //    day++;
        //    count = count + 1;
        //  }
        //  if ((daysInMonth(month, year) == day) && (month == month2) && (year == year2)) {
        //    return count;

     }
   }
