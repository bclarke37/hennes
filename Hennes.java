import java.util.*;
import java.awt.*;
import java.io.*;

public class Hennes {

   public static void main(String[] args) throws FileNotFoundException, IOException{
      File view = new File("log.txt");
      Scanner console = new Scanner(System.in);
      Scanner output = new Scanner(view);
            
      getDate d = new getDate();
      
      FileWriter output = new FileWriter("c:/Users/Bruce/Documents/University of Washington (UW) Year 1/Spring Quarter/CSE142/HMprogram/log.txt", true); //Set true for append mode
      PrintWriter log = new PrintWriter(output);
      

      int[] hoursLog = new int[1];
      int[] moodLog = new int[5];
      int[] shiftCount = new int[1];
      
      log.println(d.date());
      System.out.println("Hello, Bruce. Today is " + d.date());
      System.out.println();
      System.out.println("(C)reate new entry :: (V)iew logs :: (E)nd");
      System.out.println();
      System.out.print("What would you like to do? ");
      
      String answer = console.nextLine();
      while (!answer.equalsIgnoreCase("e")) {
      
         if (answer.equalsIgnoreCase("c")) {
            create(console, log, moodLog, hoursLog, shiftCount);
         } else if (answer.equalsIgnoreCase("v")) {
            view(console, moodLog, hoursLog, shiftCount, view, output);
         }
         
         System.out.println();
         System.out.println("(C)reate new entry :: (V)iew logs :: (E)nd");
         System.out.println();
         System.out.print("What would you like to do next? ");
         answer = console.nextLine();
      }
      System.out.println();
      System.out.println("   See you next time! :D");
   }
   

   public static void create(Scanner console, PrintWriter log, int[] moodLog, int[] hoursLog, int[] shiftCount) {

      shiftCount[0] ++;
      System.out.print("How many hours did you work today? ");
      int hours = console.nextInt();
      hoursLog[0] += hours;
      log.println("     Hours: " + hours);
      
      System.out.print("What was work like today? (Enter 1-4) ");
      int mood = console.nextInt();
      while (mood < 1 || mood > 4) {
         System.out.print("Fat fingers! Enter a number between 1 and 4: ");
         mood = console.nextInt();
      }
      moodLog[mood - 1] += 1;
      log.println("      Mood: " + mood + "/4");
      
      if (mood == 1) {
         System.out.print("Man, today must have been awful, want to rant about it? ");
      } else if (mood == 2) {
         System.out.print("Aww, looks like the day didn't go too well :( What happened? ");
      } else if (mood == 3) {
         System.out.print("What made today good? ");
      } else {
         System.out.print("Wow! Today must have been awesome! What happened? ");
      }
      
      console.nextLine();
      String comment = console.nextLine();
      log.println("  Comments: " + comment);
      log.println("---");
      log.close();
   }
   
   public static int cumHours () {
      
   }
   
   public static String viewMenu(Scanner console) {
      System.out.println();
      System.out.println("What would you like to view?");
      System.out.println();
      System.out.println("(O)verall log");
      System.out.println("(M)ood log");
      System.out.println("(H)ours & Money log");
      System.out.println();
      System.out.println("(G)o back");
      
      String answer = console.nextLine();
      
      return answer;
   }
   
   
   public static void view(Scanner console, File view, Scanner output) throws FileNotFoundException {
//       double avgHours = (double) hoursLog[0] / shiftCount[0];
//       double moneyMade = (double) hoursLog[0] * 12.50;
      
      String answer = viewMenu(console);
      System.out.println();
      while (!answer.equalsIgnoreCase("g")) {
         while (!answer.equalsIgnoreCase("d")) {
         
            if (answer.equalsIgnoreCase("o")) {
               System.out.println();
               
               while (output.hasNextLine()) {
                  System.out.println(output.nextLine());
               }
               
               System.out.print("   Type 'd' when done");
               answer = console.nextLine();
               
            } else if (answer.equalsIgnoreCase("m")) {
                  System.out.println("   Mood Log");
                  System.out.println("Number of 'amazing' days: ");
                  System.out.println("Number of 'good' days: ");
                  System.out.println("Number of 'bad' days: ");
                  
                  System.out.print("   Type 'd' when done ");
                  answer = console.nextLine();
            } else {
                  System.out.println("   Hours");
                  System.out.println("Total hours: " + hoursLog[0]);
                  System.out.println("Average hours worked: " + avgHours);
                  System.out.println();
                  System.out.println("Total Money Made: $" + moneyMade);
                  
                  System.out.print("   Type 'd' when done ");
                  answer = console.nextLine();
            }
         }
         answer = viewMenu(console);
      }
   }
}