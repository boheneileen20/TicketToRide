import java.util.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * Keeps track of player score
 *
 * @author Josh Rosenthal
 * @version Spring 2019
 */
public class Score
{
    /**
     * Method which takes in a player and a destination card as an 
     * input and checks to see if the player has a connected set of
     * routes connecting the locations on the destination card.
     * 
     * @param p Player the player who's claimed routes will be checked
     * @param d DestCard to check if player has connecting routes
     * 
     * @return boolean whether the plyer has a connected path b/w
     * routes on the DestCard
     */
    public boolean isComplete(Player p,DestinationCard d) {
        ArrayList<Location> checked = new ArrayList<Location>();
        Location l1 = d.getDest1();
        Location l2 = d.getDest2();
        if (isCompleteRec(p,checked, l1, l2)){
            if (isCompleteRec(p,checked, l2, l1)) {
                return true;
            }
        } 
        return false;//p.addDestScore(-(d.getNum()));

    }
    
    /**
     * Recursive helper method which traverses from location to
     * location checking for connections to other locations with
     * a stopping case of finding location 2
     * 
     * @param p Player the player who's claimed routes will be checked
     * @param checked ArrayList of locations already checked to avoid
     * repetetive recursion
     * @param l1 Location  being checked for neighboring claimed routes
     * @param l2 Location  the location that is trying to be traversed to
     * 
     * @return boolean true if l2 is found, and false if no new paths found
     */

    public boolean isCompleteRec(Player p,ArrayList<Location> checked,
    Location l1, Location l2) {
        for (Route r: p.getRoutes()) {
            if (r.loc1.getName().equals(l2.getName())) return true;
            if (r.loc2.getName().equals(l2.getName())) return true;
            if (!contains(checked,l1)) {
                checked.add(l1);
                if (isCompleteRec(p,checked,r.loc2,l2)) return true;
            }
        }
        return false;
    }
    
    /**
     * Helper method which checks to see if the location is in the
     * checked arraylist
     * 
     * @param checked ArrayList of locations to be traversed
     * @param loc Location to be searched for in checked
     * 
     * @return boolean true if loc is found in checked false in other cases
     */
    public static boolean contains(ArrayList<Location> checked,Location loc) {
        for (Location l: checked) {
            if (l.getName().equals(loc.getName())) return true;
        }
        return false;
    }
}
