/* @author Evan Frawley, MateChoice
 * purpose: object used to simulate mate choices for Frazer Meacham's match choice problem
 *
 *
 */

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;


public class MateChoice {

   private final int ARRAY_SIZE;
   private Mate[] mates;
   private MateSeperateChain[] world;
   private Random r;
   public double[] payoffs;
   private int worldSize;
   private int total;


   //nested class for the mate seperate chain
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

      private boolean isListEmpty(){
         return maleList.isEmpty() && femaleList.isEmpty();
      }

      private int min(){
         return Math.min(maleList.size(), femaleList.size());
      }
   }


   public MateChoice(int gmc, int gmn, int bmc, int bmn, int fi, int fd, int size) {

      this.ARRAY_SIZE = size;
      this.total = gmc + gmn + bmc + bmn + fi + fd;
      this.mates = new Mate[total];
      this.payoffs = new double[6];
      this.worldSize = size;

      //the series of forloops creates all of the mates that are in the generation
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
   //returns the offspring values of each of the classes
   public boolean runTimeStep(){
      //TODO runs the generation of a population
      double[] temp = new double[6];
      r = new Random();
      //add all of the mates to a random section of a new array,
      world = new MateSeperateChain[this.worldSize];
      for(Mate mate : this.mates){
         int n = r.nextInt(this.world.length);
         if(world[n] == null){
            world[n] = new MateSeperateChain();
         }
         mate.decPenalty();
         world[n].add(mate);
      }
      runAnalysis(world);
      return true;
   }


   //get payoff values
   // 0 - high quality males that care
   // 1 - high quality males that dont care
   // 2 - low quality males that care
   // 3 - low quality dont care
   // 4 - indiscriminate females
   // 5 - discriminate males

   //calculates what the offspring value is for two makes that intersect
   private double offspringValue(Mate mate){
      if(mate.isHQ()){
         if(mate.doesCare()){
            return 2.5;
         } else {
            return 1.5;
         }
      } else {
         if(mate.doesCare()){
            return (double) 4/3;
         } else {
            return 1.0;
         }
      }
   }

   //changes the mate's penalty to on, otherwise decrements
   //calls offspringvalue to increment payoffs
   public void runAnalysis(MateSeperateChain[] world){
      //TODO gives the data of the run so far

      for(MateSeperateChain msc : world){
         if(msc != null){
            if(!msc.isListEmpty()){
               int min = msc.min();
               for(int i = 0; i < min; i++){
                  Mate temp1 = msc.maleList.get(i);
                  Mate temp2 = msc.femaleList.get(i);
                  if(willMate(temp1, temp2)){
                     this.payoffs[temp1.index()] += offspringValue(temp1);
                     this.payoffs[temp2.index()] += offspringValue(temp2);
                     if(temp1.doesCare()){
                        temp1.penalty();
                     }
                     temp2.penalty();
                  }
               }
            }
         }
      }
   }

   //need to add something that will make it such that it has a constant number of males and demales per generation




   //
   //returns whether or not the two mates passed in will mate with each other
   private boolean willMate(Mate m1, Mate m2){

      if(m1.checkPenalty() > 0 || m2.checkPenalty() > 0){
         return false;
      }

      if(m2.isDis()){
         if(!m1.isHQ()){
            return false;
         }
      }
      return true;
   }



   //need to be able to iterate through and get the relative values RIP
   public int[] values(){
      int[] val = new int[4];
      int t = 0;
      for(int i = 0; i < 6; i++){
         t += payoffs[i];
      }
      for(int i = 0; i < 6; i++){
         val[i] = (int) (payoffs[i] / t * total);
      }

      //only grab high and low qual mates, and then the females

      val[0] = payoffs[0] + payoffs[1];
      //test

      return val;



   }



}
