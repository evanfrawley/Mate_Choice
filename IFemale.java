//
//
//
//
import java.util.*;
import java.awt.*;

public class IFemale extends Critter {

    public boolean discriminate;
    public boolean female;
    public int offspring;
    public boolean quality;
    public Random r = new Random();

    public IFemale(){

       discriminate = false;
       offspring = 0;
       female = true;
       quality = true;
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
      return Color.BLUE;
    }

    public boolean isFemale(){
      return female;
    }
    public boolean isPicky(){
      return discriminate;
    }
    public Direction getMove(){
      int dir = r.nextInt(4);
    //  return Direction.CENTER;
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
      return "" + offspring;
    }
    public void mate(){
      offspring++;
    }
    public int getOffspring(){
      return this.offspring;
    }
}
