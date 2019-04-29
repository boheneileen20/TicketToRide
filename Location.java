/**
 * Information about location.
 *
 * @author Eileen Bohen
 * @version Spring 2019
 */
public class Location {
    /**
     * Name of location.
     */
    String name;
    /**
     * X coordinate of location.
     */
    int xCoord;
    /**
     * Y coordinate of location.
     */
    int yCoord;
    /**
     * Whether or not location is attraction.
     */
    boolean isTourist;

    /**
     * Constructor initializes instance variables.
     * 
     * @param name The name of the location.
     * @param xCoord The location's x coordinate.
     * @param yCoord The location's y coordinate.
     * @param isTourist Whether location is attraction.
     */
    public Location(String name, int xCoord, int yCoord, boolean isTourist){
        this.name = name;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.isTourist = isTourist;

    }

    /**
     * Returns name of location.
     * 
     * @return The name of the location.
     */
    public String getName(){
        return name;
    }

    /**
     * Returns whether location is attraction.
     * 
     * @return True if location is attraction, false otherwise.
     */
    public boolean getTourist(){
        return isTourist;
    }
}
