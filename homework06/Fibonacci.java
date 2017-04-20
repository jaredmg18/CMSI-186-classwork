public class Fibonacci {
   public static GinormousInt Fibonacci(int n) {
      if (n <= 2) {
         return new GinormousInt("1");
      } else {
         GinormousInt n1 = new GinormousInt("0");
         GinormousInt n2 = new GinormousInt("1");
         for (int i = 2; i < n; i++) {
            GinormousInt n3 = n1.add(n2);
            System.out.println(n3);
            n1 = n2;
            n2 = n3;
         }
         return n1.add(n2);
      }
    }
    public static void main(String[] args) {
       System.out.println(Fibonacci(Integer.parseInt(args[0])));
    }
}
