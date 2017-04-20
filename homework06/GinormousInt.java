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

  public GinormousInt (String value) {
  //   bigString = value.trim();
  //   char[] charArray = bigString.toCharArray();
  //   String sign = String.valueOf(charArray[0]);
  //   bigString = bigString.substring(1,charArray.length);
  //   String[] parts = bigString.split("");
  //   ginInt = Integer.parseInt(bigString);
  // }
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

  public GinormousInt (int[] value) {
     ginInt = value;
   }

  public GinormousInt changeSign() {
     ginSign = ginInt[ginInt.length - 1] = ginInt[ginInt.length - 1] * -1;
     return this;
   }

  public GinormousInt add( GinormousInt value ) {
    int[] solution;
    if (value.equals(ZERO)) {
       return this;
    }
      if (this.ginSize >= value.ginSize && this.ginSign + value.ginSign != 0) {
         solution = this.ginInt;
         solution[this.ginInt.length - 1] = this.ginSign;
         for (int i = 0; i < value.ginSize; i++) {
            // add column
            solution[i] = solution[i] + value.ginInt[i];
            // carry
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
   // returns a GinormousInt whose value is the sum of this plus the argument

  public GinormousInt subtract(GinormousInt value) {
    if (this.compareTo(value) == 0) {
         return ZERO;
      }
      int[] solution;
      if (this.compareTo(value) == 1 && this.ginSign + value.ginSign == 2) {
         solution = this.ginInt;
         for (int i = 0; i < value.ginSize; i++) {
            // check for carry first
            if (solution[i] < value.ginInt[i]) {
               solution[i] = solution[i] + 10;
               solution[i + 1] = solution[i + 1] - 1;
            }
            // column subtract
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
   // // returns a GinormousInt whose value is the difference of this minus the argument

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
         // carries
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
   // // returns a GinormousInt whose value is the product of this times the argument

  public GinormousInt divide(GinormousInt value) {
    throw new UnsupportedOperationException("Not working yet...");
  }

  public String toString() {
    if (this.equals(ZERO)) {
         return "0";
      }
      if (this.equals(ONE)) {
         return "1";
      }
      String s = "";
      // grab all numbers except sign
      for (int i = 0; i <= ginInt.length - 2; i++) {
         s = ginInt[i] + s;
      }
      // remove leading zeroes
      while (s.charAt(0) == '0' && s.length() - 1 > 0) {
         s = s.substring(1);
      }
      if (ginInt[ginInt.length - 1] == -1) {
         s = "-" + s;
      }
      return s;
  }

  public static GinormousInt valueOf(long value) {
    String longString;
    longString = String.valueOf(value);
    return new GinormousInt(longString);
  }

  public int compareTo(GinormousInt value) {
    if (this.ginSign > value.ginSign) {
       return 1;
    }  else {
       if (this.ginSign < value.ginSign) {
         return -1;
      }  else
        // if (this.ginSign == value.ginSign) {
        //   return 0;
        // } else
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
   // returns -1/0/1 as this GinormousInt is numerically less than/equal to/greater than the value passed as the argument

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
// returns true iff x is a GinormousInt whose value is numerically equal to this GinormousInt
}
