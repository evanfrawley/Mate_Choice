//
//
//
//
import java.util.*;
import java.awt.*;
public class DFemale extends Critter {
    public boolean discriminate;
    public boolean female;
    public int offspring;
    public Random r = new Random();
    public boolean quality;

    public DFemale(){
        discriminate = true;
        offspring = 0;
        female = true;
        quality = true;
    }
    public boolean eat(){
      return false;
    }
    public boolean isFemale(){
      return female;
    }
    public Attack fight(String opponent){
      return null;
    }
    public boolean quality(){
      return quality;
    }
    public Color getColor(){
      return Color.ORANGE;
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
    //    return Direction.CENTER;
    }
    public String toString(){
      return "" + offspring;
    }
    public boolean isPicky(){
      return discriminate;
    }
    public void mate(){
      offspring++;
    }

    public int getOffspring(){
      return this.offspring;
    }
}
