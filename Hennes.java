import java.util.*;
import java.awt.*;
import java.io.*;

public class Hennes {

   public static void main(String[] args) throws FileNotFoundException, IOException{
      File f = new File("log.txt");
      File g = new File("log.txt");
      Scanner hour = new Scanner(f);
      Scanner mood = new Scanner(f);
      Scanner console = new Scanner(System.in);
            
      getDate d = new getDate();
      
      FileWriter output = new FileWriter("C:/Users/Bruce/Documents/University of Washington (UW) Year 1/Spring Quarter/CSE142/HMprogram/log.txt", true); //Set true for append mode
      PrintWriter log = new PrintWriter(output);
      
      int[] moodLog = moodArray(mood);
      int[] shiftCount = new int[1];
      int cumHours = cumHours(shiftCount, hour);
      
      log.println(d.date());
      System.out.println("Hello, Bruce. Today is " + d.date());
      System.out.println();
      System.out.println("(C)reate new entry :: (V)iew logs :: (E)nd");
      System.out.println();
      System.out.print("What would you like to do? ");
      
      String answer = console.nextLine();
      while (!answer.equalsIgnoreCase("e")) {
      
         if (answer.equalsIgnoreCase("c")) {
            create(console, log, cumHours);
         } else if (answer.equalsIgnoreCase("v")) {
            view(console, cumHours, moodLog, shiftCount);
         }
         System.out.println();
         System.out.println("(C)reate new entry :: (V)iew logs :: (E)nd");
         System.out.println();
         System.out.print("What would you like to do next? ");
      
         answer = console.nextLine();
      }
      
      System.out.println();
      System.out.println();
      System.out.println("   See you next time! :D");
   }
   

   public static void create(Scanner console, PrintWriter log, int cumHours) {

      System.out.print("How many hours did you work today? ");
      int hoursWorkedToday = console.nextInt();
      log.println("     Hours: " + hoursWorkedToday + " (" + (cumHours + hoursWorkedToday) + " total)");
      
      System.out.print("What was work like today? (Enter 1-4) ");
      int mood = console.nextInt();
      while (mood < 1 || mood > 4) {
         System.out.print("Fat fingers! Enter a number between 1 and 4: ");
         mood = console.nextInt();
      }
      
      if (mood == 1) {
         log.println("      Mood: Terrible...");
         System.out.print("Man, today must have been awful, want to rant about it? ");
      } else if (mood == 2) {
         log.println("      Mood: Meh :(");
         System.out.print("Aww, looks like the day didn't go too well :( What happened? ");
      } else if (mood == 3) {
         log.println("      Mood: Good!");
         System.out.print("What do you want to say about today? ");
      } else {
         log.println("      Mood: Amazing!");
         System.out.print("Wow! Today must have been awesome! What happened? ");
      }
      
      console.nextLine();
      String comment = console.nextLine();
      log.println("  Comments: " + comment);
      log.println("---");
      log.close();
      System.out.println("Entry recorded, thank you!");
   }
   
   public static int cumHours(int[] shiftCount, Scanner hour) {
      int cumHours = 0;
      
      while (hour.hasNext()) {
         if (hour.next().equals("Hours:")) {
            cumHours += hour.nextInt();
            shiftCount[0]++;
         }
      }
      return cumHours;
   }
   
   public static int[] moodArray(Scanner mood) {
      int[] moodLog = new int[4];
   
      while (mood.hasNext()) {
         if (mood.next().equals("Mood:")) {
            String moodValue = mood.next();
            if (moodValue.equals("Amazing!")) {
               moodLog[0]++;
            } else if (moodValue.equals("Good!")) {
               moodLog[1]++;
            } else if (moodValue.equals("Meh")) {
               moodLog[2]++;
            } else { // (moodValue.equals("Terrible..."))
               moodLog[3]++;
            }
         }
      }
      return moodLog;
   }
   
   public static String viewMenu(Scanner console) {
      System.out.println();
      System.out.println("What would you like to view?");
      System.out.println();
      System.out.println(" (M)ood log");
      System.out.println(" (H)ours & Money log");
      System.out.println();
      System.out.println();
      System.out.println("(G)o back to main menu");
      
      String answer = console.nextLine();
      return answer;
   }
   
   
   public static void view(Scanner console, int cumHours, int[] moodLog, int[] shiftCount) throws FileNotFoundException {
      
      String answer = viewMenu(console);
      System.out.println();
      
      while (!answer.equalsIgnoreCase("g")) {
         while (!answer.equalsIgnoreCase("d")) {
         
            if (answer.equalsIgnoreCase("m")) {
                  System.out.println("  Mood Log");
                  System.out.println("Number of 'amazing' days: " + moodLog[0]);
                  System.out.println("Number of 'good' days: " + moodLog[1]);
                  System.out.println("Number of 'meh' days: " + moodLog[2]);
                  System.out.println("Number of 'bad' days: " + moodLog[3]);
                  System.out.println();
                  System.out.print("   Type 'd' when done: ");
                  answer = console.nextLine();
            } else if (answer.equalsIgnoreCase("h")) {
                  System.out.println("  Hours");
                  System.out.println(" Total hours worked: " + cumHours);
                  System.out.println("Total shifts worked: " + shiftCount[0]);
                  System.out.println("Average hours worked per shift: " + (double) cumHours / shiftCount[0]);
                  System.out.println();
                  System.out.println("Total Money Made: $" + cumHours * 12.50);
                  System.out.println();
                  System.out.print("   Type 'd' when done: ");
                  answer = console.nextLine();
            } else {
               System.out.print("Please type either 'm', 'h', or 'g': ");
               answer = console.nextLine();
            }
         }
         answer = viewMenu(console);
      }
   }
   
}