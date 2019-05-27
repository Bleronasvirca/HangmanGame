import java.util.*;
public class EnteryExit {
   private Scanner sc;
   public EnteryExit() {
      sc = new Scanner(System.in);
   }
   public char readTheLetter() throws Exception {
      System.out.print("Type a letter: ");
      String line = sc.nextLine();
      if (line != null && line.length() > 0) {
         return line.charAt(0);
      } else {
         throw new Exception("Error!!!");
      }
   }
   
  
   public boolean playAgain() throws Exception {
      System.out.print("Do you want to play again? (Y/N)");
      String line = sc.nextLine();
      if (line != null && line.length() > 0) {
         String temp = line.substring(0, 1);
         return temp.equalsIgnoreCase("Y");
      } else {
         throw new Exception("Error!!!");
      }
   }
   public void displayWinLoss(boolean theSolutionWasDescovered) {
      if (theSolutionWasDescovered) {
         System.out.println("Congratulations, you solved it!");
      } else {
         System.out.println("Try again!!");
      }
   }
   public void display(String s) {
      System.out.println(s);
   }
}