import java.util.*;
import java.awt.*;
import java.io.*;

public class Hennes {

   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      getDate d = new getDate();
      PrintStream log = new PrintStream("log.txt");
      
      int[] hoursLog = new int[1];
      int[] moodLog = new int[5];
      
      log.println(d.date());
      System.out.println("Hello, Bruce. Today is " + d.date());
      System.out.println();
      System.out.println("(C)reate new entry | (V)iew logs | (E)nd");
      System.out.print("What would you like to do? ");
      
      String answer = console.nextLine();
      while (!answer.equalsIgnoreCase("e")) {
      
         if (answer.equalsIgnoreCase("c")) {
            create(console, log, moodLog, hoursLog);
         } else if (answer.equalsIgnoreCase("v")) {
            view(console, moodLog);
         }
         
         System.out.println("(C)reate new entry | (V)iew logs | (E)nd");
         System.out.print("What would you like to do next? ");
         answer = console.nextLine();
      }
      System.out.println("See you next time! :D");
   }
   
   
   public static void create(Scanner console, PrintStream log, int[] moodLog, int[] hoursLog) {
      
      System.out.println("How many hours did you work today? ");
      int hours = console.nextInt();
      hoursLog[0] += hours;
      log.println("Hours: " + hours);
      
      System.out.print("What was work like today? (Enter 1-4) ");
      int mood = console.nextInt();
      while (mood < 1 || mood > 4) {
         System.out.print("Fat fingers! Enter a number between 1 and 4: ");
         mood = console.nextInt();
      }
      moodLog[mood - 1] += 1;
      log.println("Mood: " + mood);
      
      if (mood == 1 || mood == 2) {
         System.out.print("Aww, looks like the day didn't go too well :( What happened? ");
      } else if (mood == 3) {
         System.out.print("What made today good? ");
      } else {
         System.out.print("Wow! Today must have been awesome! What happened? ");
      }
      
      String comment = console.nextLine();
      log.println("Comments: " + comment);

   }
   
   
   public static String viewMenu(Scanner console) {
      System.out.println("What would you like to view?");
      System.out.println("(O)verall log");
      System.out.println("(M)ood log");
      System.out.println("(H)ours log");
      System.out.println();
      System.out.println("(G)o back");
      
      String answer = console.nextLine();
      
      return answer;
   }
   
   
   public static void view(Scanner console, int[] moodLog) {
      String answer = viewMenu(console);
      System.out.println();
      while (!answer.equalsIgnoreCase("g")) {
         if (answer.equalsIgnoreCase("o")) {
            Scanner output = new Scanner("log.txt");
            System.out.println();
            
            while (output.hasNextLine()) {
               System.out.println(output.nextLine());
            }
            
            System.out.println("Type 'd' when done");
            
         } else if (answer.equalsIgnoreCase("m")) {
               System.out.println("   Mood Log");
               System.out.println("Number of 'amazing' days: " + moodLog[3]);
               System.out.println("Number of 'good' days: " + moodLog[2]);
               System.out.println("Number of 'bad' days: " + moodLog[0] + moodLog[1]);
               
               System.out.print("Type 'd' when done");
         } else if (answer.equalsIgnoreCase("d")) {
               answer = viewMenu(console);

         } else {
               System.out.println("   Hours");
         }

      }
   }
}