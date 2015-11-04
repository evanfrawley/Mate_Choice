//
//
//
//
import java.util.*;
import java.awt.*;
public class BMaleCare extends Critter {
    public boolean quality;
    public boolean care;
    public Random r = new Random();
    public boolean female;
    public int offspring;
    public int count;
    public BMaleCare(){
       quality = false;
       care = true;
       female = false;
       count = 0;
       offspring = 0;
    }
    public boolean eat(){
      return false;
    }

    public boolean quality(){
      return quality;
    }
    public boolean isFemale(){
      return female;
    }
    public Attack fight(String opponent){
      return null;
    }
    public Color getColor(){
      return Color.RED;
    }
    public Direction getMove(){
      int dir = r.nextInt(4);
      /*count++;
      if(count%65 == 0){
        return Direction.SOUTH;
      } else {
        return Direction.EAST;
      }*/

      if(dir == 0){
        return Direction.NORTH;
      } else if (dir == 1) {
        return Direction.WEST;
      } else if (dir ==2){
        return Direction.SOUTH;
      } else {
        return Direction.EAST;
      }
    }
    public String toString(){
      if(care){
        return "C";
      } else {
        return "N";
      }
    }
}
