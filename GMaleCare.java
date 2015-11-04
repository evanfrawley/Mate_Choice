//
//
//test
//
import java.util.*;
import java.awt.*;
public class GMaleCare extends Critter {

    public boolean quality;
    public boolean care;
    public boolean female;
    public int offspring;
    public Random r = new Random();

    public GMaleCare(){
       quality = true;
       care = true;
       female = false;
       offspring = 0;

    }
    public boolean isFemale(){
      return female;
    }
    public boolean eat(){
        return false;
    }
    public boolean quality(){
      return quality;
    }
    public Attack fight(String opponent){
      return null;
    }
    public Color getColor(){
        return Color.GREEN;
    }
    public Direction getMove(){
        int dir = r.nextInt(4);
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
