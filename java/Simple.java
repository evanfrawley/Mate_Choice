import java.util.*;
import java.text.*;

public class Simple {
   public static void main(String[] args){
      MateChoice mc = new MateChoice(10, 10, 10, 10, 20, 20, 100);
      for(int i = 0; i < 100; i++){
         mc.runTimeStep();
      }
      System.out.println(Arrays.toString(mc.values()));

      
   }


}
