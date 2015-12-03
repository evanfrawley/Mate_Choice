/* @author Evan Frawley, Mate
 * purpose: object of each mate used to simulate mate choices for Frazer Meacham's
 * match choice problem
 *
 *
 */

public class Mate {

   public boolean quality;
   public boolean male;
   public boolean care;
   public boolean discriminate;
   public int timesMated;
   public double offspring;
   public int matePenalty;
   public String name;

   public Mate(String name, boolean male, boolean quality, boolean care, boolean discriminate){
      this.name = name;
      this.male = male;
      this.quality = quality;
      this.care = care;
      this.discriminate = discriminate;
      this.timesMated = 0;
      this.offspring = 0;
      this.matePenalty = 0;
   }

   public String toString(){
      return name;
   }

   public boolean isMale(){
     return male;
   }

   public boolean isHQ(){
      return this.quality;
   }

   public boolean doesCare(){
      return this.care;
   }

   public void penalty(){
      this.matePenalty = 10;
   }

   public int checkPenalty(){
      return this.matePenalty;
   }

   public void decPenalty(){
      this.matePenalty -= 1;
   }

   public boolean isDis(){
      return this.discriminate;
   }

   public int index(){
      int x = 0;
      if(this.isMale()){
         if(!this.isHQ()){
            x += 2;
         }
         if(!this.doesCare()){
            x += 1;
         }
      } else {
         x += 4;
         if(this.isDis()){
            x+=1;
         }
      }
      return x;
   }

}
