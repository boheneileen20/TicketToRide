import java.util.ArrayList;
/**
 * Class to encapsulate information about the routes between adjacent locations that can be used to build a continuous
 * path between attractions.
 *
 * @author Eileen Bohen
 * @version Spring 2019
 */
public class Route
{
    //location 1
    Location loc1;
    //location 2
    Location loc2;

    //each string is formatted as "color number"
    //for example, if four pink cards are needed, 
    //the entry is "pink 4"
    String requirement;

    
    /**
     * Constructor for Route objects, initializes instance variables
     * 
     * @param the two locations, their x and y coordinates, and a requirements arraylist of strings representing
     * the cards needed to claim the route.
     */
    public Route(Location loc1, Location loc2, String requirement){
        this.loc1 = loc1;
        this.loc2 = loc2;
        this.requirement = requirement;

    }
    

    /**
     * Returns the requirements ArrayList for this route
     * 
     * @return String representing the requirements
     * Strings have the format "color number" such as "pink 4" if four pink cards are needed
     */
    public String getRequirement(){
        return requirement;
    }
    
    public String toString(){
        String result = loc1.getName() + " to " + loc2.getName() + " for " + requirement;
        return result;
    }
    public Location getLoc1(){
        return loc1;
    }

    public Location getLoc2(){
        return loc2;
    }

    public int getRecTaxis(){
        String[] recs = requirement.split(" ");
        return Integer.parseInt(recs[1]);

    }
    public String getRouteColor(){
        String[] recs = requirement.split(" ");
        return recs[0];

    }
}
