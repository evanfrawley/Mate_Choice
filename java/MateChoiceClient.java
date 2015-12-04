/* @author Evan Frawley, MateChoiceClient
 * purpose: client used to simulate mate choices for Frazer Meacham's match choice problem
 *
 *
 */
 import java.io.*;
 import java.util.*;
 import java.text.*;

public class MateChoiceClient {
   public static void main(String[] args) throws FileNotFoundException {

      intro();
      int i = 7;
      int[] params = new int[7];
      Scanner console = new Scanner(System.in);
      while (i > 0){
         System.out.println(getText(i));
         params[params.length - i] = console.nextInt();
         i--;
      }
      int[] mcval = new int[6];
      for(int y = 0; y < 6; y++){
         mcval[i] = params[i];
      }
      MateChoice mc = new MateChoice(params[0], params[1], params[2], params[3], params[4], params[5], params[6]);
      String user = "";
      while(!user.startsWith("q")){
         //have the client run here!
         System.out.println("Would you like to run the simulation? Press \"q\" to quit");
         String string = console.next();
         if(!x.startsWith("q")){
            System.out.println("How many generations would you like to run?");
            int gen = console.nextInt();
            System.out.println("How many timesteps would you like in each generation?");
            int ts = console.nextInt();


            for(int k = 0; k < gen; k++){
               mc = new MateChoice(mcval[0], mcval[1], mcval[2], mcval[3], mcval[4], mcval[5], params[6]);
               for(int l = 0; l < ts; l++){
                  mc.runTimeStep();
               }
               mcval = mc.values();
            }
            for()
         }

         user = "q";
      }

      //run 100 times or however much,and then snag the payoff values, calculate ratios
      //
      //
      //
      //

   }
   //gmc + gmn + bmc + bmn + fi + fd
   public static void intro(){
      System.out.println("Welcome to the Mate Choice Generation simulator!");
      System.out.println("The purpose of this program is to . . .");
   }

   public PrintStream initFile(){
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
      Date d = new Date();
      String str = df.format(d);
      File f = new File(str + "-run.csv");
      PrintStream s = new PrintStream(f);
      return s;
   }

   public static String getText(int n){
      String type = "";
      if(n == 7){
         type = "HIGH QUALITY MALES THAT CARE";
      } else if (n == 6){
         type = "HIGH QUALITY MALES THAT DO NOT CARE";
      } else if (n == 5){
         type = "LOW QUALITY MALES THAT CARE";
      } else if (n == 4){
         type = "LOW QUALITY MALES THAT DO NOT CARE";
      } else if (n == 3){
         type = "FEMALES THAT ARE INDISCRIMINATE";
      } else if (n == 2){
         type = "FEMALES THAT ARE DISCRIMINATE";
      } else if (n == 1){
         type = "THE SIZE OF THE ENVIRONMENT";
      }
      return "Please give me the number of " + type + " that you would like.";
   }
}
