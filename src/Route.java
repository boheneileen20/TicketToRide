import java.util.ArrayList;
/**
 * Encapsulate information about the routes to build a path.
 *
 * @author Eileen Bohen
 * @version Spring 2019
 */
public class Route
{
    /**
     * The first location.
     */
    Location loc1;
    /**
     * The second location.
     */
    Location loc2;
    /**
     * Each string is formatted as "color number".
     */
    String requirement;

    /**
     * Initializes instance variables.
     * 
     * @param loc1 The first location.
     * @param loc2 The second location.
     * @param requirement The card's color and number.
     */
    public Route(Location loc1, Location loc2, String requirement){
        this.loc1 = loc1;
        this.loc2 = loc2;
        this.requirement = requirement;

    }

    /**
     * Returns the requirements for this route.
     * 
     * @return String representing the requirements.
     * 
     */
    public String getRequirement(){
        return requirement;
    }

    /**
     * Returns the string requirement of the route.
     * 
     * @return String representing the requirements
     * 
     */
    public String toString(){
        String result = loc1.getName() + " to "
        + loc2.getName() + " for " + requirement;
        return result;
    }

    /**
     * Returns the string of the first location.
     * 
     * @return String representing the location
     * 
     */
    public Location getLoc1(){
        return loc1;
    }

    /**
     * Returns the string of the second location.
     * 
     * @return String representing the location
     * 
     */
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
