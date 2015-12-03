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
   public boolean matePenalty;
   public String name;

   public Mate(String name, boolean male, boolean quality, boolean care, boolean discriminate){
      this.name = name;
      this.male = male;
      this.quality = quality;
      this.care = care;
      this.discriminate = discriminate;
      this.timesMated = 0;
      this.offspring = 0;
      this.matePenalty = false;
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
}
