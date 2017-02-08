public class StringStuffProgram {
  public static void main (String [] args) {
    StringStuff ss = new StringStuff();
    String s = new String();
    if (ss.containsVowel(s)) {
      System.out.println("This string contains vowels");
    } else {
      System.out.println("This string contains no vowels");
    }
    if (ss.isPalindrome(s)) {
      System.out.println("This string is a palindrome");
    } else {
      System.out.println("This string is not a palindrome");
    }
    String t = new String (ss.evensOnly(s));
    System.out.println("The even letters in this string are" + t);
    String u = new String (ss.oddsOnly(s));
    System.out.println("The odd letters in this string are" + u);
    String v = new String (ss.evensOnlyNoDupes(s));
    System.out.println("The even letters in this string (not duplicated) are" + u);
    String w = new String (ss.oddsOnlyNoDupes(s));
    System.out.println("The odd letters in this string (not duplicated) are" + v);
    String x = new String (ss.reverse(s));
    System.out.println("The reverse of this string is" + x);
  }
}
