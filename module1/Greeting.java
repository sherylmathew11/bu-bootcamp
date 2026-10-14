import java.util.Scanner; 
public class Greeting { 
    public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.print("What is your name? ");
      String var2 = var1.nextLine();
      System.out.print("What do you do for work? ");
      String var3 = var1.nextLine();
      System.out.println("Hello, " + var2 + "! As a " + var3 + ", you are in exactly the right place.");
      var1.close();
    } 
} 