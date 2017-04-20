/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Fibonacci.java
 *  Purpose       :  Class for Fibonacci calculations.
 *  @see
 *  @author       :  Jared Gencarella
 *  Date written  :  2017-04-16
 *  Description   :  Program with constructor to build Fibonacci class.
 *  Notes         :  Added throughout methods in the class
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:       Reason for change/modification
 *           -----  ----------  ------------      -----------------------------------------------------------
 *  @version 1.0.0  2017-04-16  Jared Gencarella   Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

 public class Fibonacci {
    public static GinormousInt fibonacci(int number) {
       if (number <= 2) {
          return new GinormousInt("1");
       } else {
          GinormousInt num1 = new GinormousInt("0");
          GinormousInt num2 = new GinormousInt("1");
          for (int i = 2; i < number; i++) {
             GinormousInt num3 = num1.add(num2);
             System.out.println(num3);
             num1 = num2;
             num2 = num3;
          }
          return num1.add(num2);
       }
     }
     public static void main(String[] args) {
        System.out.println(fibonacci(Integer.parseInt(args[0])));
     }
 }
