/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  GinormousInt.java
 *  Purpose       :  Main constructor that contains methods for GinormousInt
 *  @see
 *  @author       :  Jared Gencarella
 *  Date written  :  2017-04-05
 *  Description   :  This is the constructor that can be used for GinormmousIntTester to check the if values properly
                     get calculated through the methods. This constructor will be used to handle numbers that otherwise
                     could not be used in the terminal.
 *  Notes         :  Added throughout methods in the class
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:       Reason for change/modification
 *           -----  ----------  ------------      -----------------------------------------------------------
 *  @version 1.0.0  2017-04-05  Jared Gencarella   Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */


public class GinormousInt {

  public static final GinormousInt ZERO = new GinormousInt("0");
  public static final GinormousInt ONE = new GinormousInt("1");
  public static final GinormousInt TEN = new GinormousInt("10");
  private byte[] digits;
  private String bigString;
  private int[] ginInt;
  private int ginSign;
  private int ginSize;
  private String intString = "";


  /**
   * constructor method for GinormousInt. If the first value is one or 0, the class knows to
     change the sign. Otherwise it builds what the rest of the code is saying.
   */
  public GinormousInt (String value) {
      if (value.equals("0")) {
        ginInt = new int[1];
        ginInt[0] = 0;
        ginSize = 1;
        ginSign = 0;
        return;
      }
      if (value.equals("1")) {
        ginInt = new int[3];
        ginInt[0] = 1;
        ginSize = 1;
        ginSign = ginInt[ginInt.length - 1] = 1;
        return;
      }
      ginInt = new int[value.length() + 2];
      ginSize = ginInt.length - 2;
      ginSign = ginInt[ginInt.length - 1] = 1;
      ginInt [ginInt.length - 2] = 0;
      for (int i = 0; i <= value.length() - 1; i++) {
         if (value.charAt(value.length() - 1 - i) == '-') {
            ginSign = ginInt[ginInt.length - 1] = -1;
            break;
         }
         ginInt[i] = Integer.parseInt(value.charAt(value.length() - 1 - i) + "");
       }
   }

  /**
   * constructor for GinormousInt Array ginInt
   */
  public GinormousInt (int[] value) {
     ginInt = value;
   }

  /**
   * method to switch the sign of the number. Used throughout the class as needed
   */
  public GinormousInt changeSign() {
     ginSign = ginInt[ginInt.length - 1] = ginInt[ginInt.length - 1] * -1;
     return this;
   }

  /**
   * add method for GinormousInt. Used to add together integers that are too large for the
     program to otherwise handle. Returns a value of this plus the argument input.
   */
  public GinormousInt add( GinormousInt value ) {
    int[] solution;
    if (value.equals(ZERO)) {
       return this;
    }
      if (this.ginSize >= value.ginSize && this.ginSign + value.ginSign != 0) {
         solution = this.ginInt;
         solution[this.ginInt.length - 1] = this.ginSign;
         for (int i = 0; i < value.ginSize; i++) {
            // add a column for the array to run through
            solution[i] = solution[i] + value.ginInt[i];
            // carries the ones place while adding to the tens place
            if (solution[i] > 9) {
               solution[i] = solution[i] - 10;
               solution[i + 1] = solution[i + 1] + 1;
            }
         }
         return new GinormousInt(solution);
      } else
        if (this.compareTo(value) == -1 && this.ginSign + value.ginSign == 2) {
         return value.add(this);
        } else
            if (this.compareTo(value) == 1 && this.ginSign + value.ginSign == -2) {
              return (this.changeSign().add(value.changeSign())).changeSign();
            } else
                if (this.compareTo(value) == -1 && this.ginSign + value.ginSign == -2) {
                  return (value.changeSign().add(this.changeSign())).changeSign();
                } else
                    if (this.ginSign > value.ginSign) {
                      return this.subtract(value.changeSign());
                    } else
                        if (this.ginSign < value.ginSign) {
                          return value.subtract(this.changeSign());
                        }
   return null;
 }

  /**
   * subtract method for GinormousInt. Used to subtract integers that are too large for the
    program to otherwise handle. Returns a value of this minus the argument input.
   */
  public GinormousInt subtract(GinormousInt value) {
    if (this.compareTo(value) == 0) {
         return ZERO;
      }
      int[] solution;
      if (this.compareTo(value) == 1 && this.ginSign + value.ginSign == 2) {
         solution = this.ginInt;
         for (int i = 0; i < value.ginSize; i++) {
            if (solution[i] < value.ginInt[i]) {
               solution[i] = solution[i] + 10;
               solution[i + 1] = solution[i + 1] - 1;
            }
            solution[i] = solution[i] - value.ginInt[i];
         }
     return new GinormousInt(solution);
      } else
          if (this.compareTo(value) == -1 && this.ginSign + value.ginSign == 2) {
           return value.subtract(this).changeSign();
          } else
              if (this.compareTo(value) == 1 && this.ginSign + value.ginSign == -2) {
                return value.changeSign().subtract(this.changeSign());
              } else
                  if (this.compareTo(value) == -1 && this.ginSign + value.ginSign == -2) {
                    return (this.changeSign().subtract(value.changeSign())).changeSign();
                  } else
                      if (this.ginSign > value.ginSign) {
                        return this.add(value.changeSign());
                      } else
                          if (this.ginSign < value.ginSign) {
                            return value.add(this.changeSign());
                          }
      return null;
    }

  /**
   * mulyiply method for GinormousInt. Used to multiply together integers that are too large for the
     program to otherwise handle. Returns a value of this times the argument input.
   */
  public GinormousInt multiply(GinormousInt value) {
     if (this.equals(ZERO) || value.equals(ZERO)) {
        return ZERO;
     }
     if (this.equals(ONE)) {
         return value;
     } if (value.equals(ONE)) {
         return this;
       }
        if (this.ginSize < value.ginSize) {
          return value.multiply(this);
        }
      int[] solution = new int[this.ginSize + value.ginSize];
      solution[solution.length - 1] = this.ginSign * value.ginSign;
      for (int i = 0; i < value.ginSize; i++) {
         for (int j = 0; j < this.ginSize; j++) {
            solution[j + i] = solution[j+i] + (this.ginInt[j] * value.ginInt[i]);
         }
         for (int k = 0; k < solution.length; k++) {
            int temp = solution[k];
            if (solution[k] > 10) {
               solution[k] = solution[k] % 10;
               solution[k + 1] = solution[k + 1] + temp/10;
            }
         }
      }
      return new GinormousInt(solution);
   }

  /**
   * divide method for GinormousInt. Used to divide integers that are too large for the
     program to otherwise handle. Returns a value of this divided by the argument input.
   */
  public GinormousInt divide(GinormousInt value) {
    int newSign = this.ginSign * value.ginSign;
      if (this.ginSign == -1) {
         this.changeSign();
      }
      if (value.ginSign == -1) {
         value.changeSign();
      }
      if (this.compareTo(value) == -1) {
         return ZERO;
      } else if (this.equals(value)) {
         return ONE;
      }
      else {
         int i = 2;
         System.out.println(value.multiply(new GinormousInt(i + "")).compareTo(this));
         while (value.multiply(new GinormousInt(i + "")).compareTo(this) < 0) {
            System.out.println(i);
            i++;
         }
         i--;
         return new GinormousInt(i + "");
      }
   }

  /**
   * To String method for GinormousInt. Takes the value at each given location in the argument and puts
     it into string format.
   */
  public String toString() {
    if (this.equals(ZERO)) {
         return "0";
      }
      if (this.equals(ONE)) {
         return "1";
      }
      String s = "";
      for (int i = 0; i <= ginInt.length - 2; i++) {
         s = ginInt[i] + s;
      }
      while (s.charAt(0) == '0' && s.length() - 1 > 0) {
         s = s.substring(1);
      }
      if (ginInt[ginInt.length - 1] == -1) {
         s = "-" + s;
      }
      return s;
  }

  /**
   * Value of method for GinormousInt. Takes a long value and displays it so it can be translated
     to the int value used throughout GinormousInt.
   */
  public static GinormousInt valueOf(long value) {
    String longString;
    longString = String.valueOf(value);
    return new GinormousInt(longString);
  }

  /**
   * method that compares the values of the argument and this GinormousInt. Indicates whether the value is greater than,
     less than or equal to the GinormousInt.
   */
  public int compareTo(GinormousInt value) {
    if (this.ginSign > value.ginSign) {
       return 1;
    }  else {
       if (this.ginSign < value.ginSign) {
         return -1;
      }  else
        if (this == value) {
          return 0;
        } else
         if (this.ginSize > value.ginSize) {
            return (1 * this.ginSign);
         }  else
            if (this.ginSize < value.ginSize) {
            return (-1 * this.ginSign);
            } else {
                for (int i = ginInt.length - 2; i >= 0; i--) {
                   if (this.ginInt[i] > value.ginInt[i]) {
                     return 1 * this.ginSign;
                   }  else
                        if (this.ginInt[i] < value.ginInt[i]) {
                          return -1 * this.ginSign;
                        }
                  }
               return 0;
           }
      }
   }

   /**
    * method that determines if the two given values are equal. Returns a boolean value as an answer.
    */
  public boolean equals(Object x) {
    if (x instanceof GinormousInt) {
         GinormousInt y = (GinormousInt) x;
         if (y.ginSize != this.ginSize) {
            return false;
         }
         return this.compareTo(y) == 0;
      }
      return false;
   }
}
