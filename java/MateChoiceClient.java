/* @author Evan Frawley, MateChoiceClient
 * purpose: client used to simulate mate choices for Frazer Meacham's match choice problem
 *
 *
 */
 import java.io.*;
 import java.util.*;

public class MateChoiceClient {
   public static void main(String[] args) {
      intro();
      int i = 7;
      int[] params = new int[7];
      Scanner console = new Scanner(System.in);
      while (i > 0){
         System.out.println(getText(i));
         params[params.length - i] = console.nextInt();
         i--;
      }
      MateChoice mc = new MateChoice(params[0], params[1], params[2], params[3], params[4], params[5], params[6]);
      String user = "";
      while(!user.startsWith("q")){
         //have the client run here!
         for(int j = 0; j < 10; j++){
            mc.runTimeStep();
            System.out.println(Arrays.toString(mc.payoffs));
         }
         user = "q";
      }

   }
   //gmc + gmn + bmc + bmn + fi + fd
   public static void intro(){
      System.out.println("Welcome to the Mate Choice Generation simulator!");
      System.out.println("The purpose of this program is to . . .");
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
