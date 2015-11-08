/* @author Evan Frawley, MateChoice
 * purpose: object used to simulate mate choices for Frazer Meacham's match choice problem
 *
 *
 */

import java.util.LinkedList;
import java.util.ArrayList;

public class MateChoice {

   private final int ARRAY_SIZE;
   private Mate[] mates;

   //next class for the mate seperate chain
   private class MateSeperateChain {
      private ArrayList<Mate> femaleList;
      private ArrayList<Mate> maleList;
      private MateSeperateChain(){
         femaleList = new ArrayList<Mate>();
         maleList = new ArrayList<Mate>();
      }
      private void add(Mate indv){
          if(indv.isMale()){
            maleList.add(indv);
          } else {
            femaleList.add(indv);
          }
      }

      private boolean contains(Mate indv){
        ArrayList<Mate> temp;
        if(indv.isMale()){
           temp = maleList;
        } else {
           temp = femaleList;
        }
        for(Mate m8 : temp){
          if(m8.toString().equals(indv.toString())){
            return true;
          }
        }
        return false;
      }

      private void remove(){
         //TODO something
      }
   }

   public MateChoice(int size, int gmc, int gmn, int bmc, int bmn, int fi, int fd) {

      this.ARRAY_SIZE = size;
      int total = gmc + gmn + bmc + bmn + fi + fd;
      this.mates = new Mate[total];

      //high quality males that care
      for(int i = 0; i < gmc; i++){
         String name = "gmc" + (i + 1);
         mates[i] = new Mate(name, true, true, true, true);
      }
      //high quality makes that don't care
      for(int i = 0; i < gmn; i++){
         String name = "gmn" + (i + 1);
         mates[i + gmc] = new Mate(name, true, true, false, true);
      }
      //low quality males that care
      for(int i = 0; i < bmc; i++){
         String name = "bmc" + (i + 1);
         mates[i + gmc + gmn] = new Mate(name, true, false, true, true);
      }
      //low quality males that don't care
      for(int i = 0; i < bmn; i++){
         String name = "bmn" + (i + 1);
         mates[i + gmc + gmn + bmc] = new Mate(name, true, false, false, true);
      }
      //indiscriminate females
      for(int i = 0; i < fi; i++){
         String name = "fi" + (i + 1);
         mates[i + gmc + gmn + bmc + bmn] = new Mate(name, false, true, true, false);
      }
      //discriminate femals
      for(int i = 0; i < fd; i++){
         String name = "fd" + (i + 1);
         mates[i + gmc + gmn + bmc + bmn + fi] = new Mate(name, false, true, true, true);
      }

   }
   //end of constructor

   //runs the generation
   public double[] runGeneration(){
      //TODO runs the generation of a population
      double[] temp = new double[6];
      return temp;
   }

   public void makeIndividuals(){
      //TODO runs the for loops to make the number of individuals
      //
   }

   public void giveData(){
      //TODO gives the data of the run so far
   }


}
