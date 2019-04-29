/**
 * Encapsulate information about the location.
 *
 * @author Eileen Bohen
 * @version Spring 2019
 */
public class Location {
    /**
     * The name of the location.
     */
    String name;
    /**
     * The x coordinate of the location.
     */
    int xCoord;
    /**
     * The y coordinate of the location.
     */
    int yCoord;
    /**
     * Whether or not the location is an attraction.
     */
    boolean attraction;

    /**
     * Initializes name, coordinates, and attraction.
     * 
     * @param name The name of the location.
     * @param xCoord The x coordinate of the location.
     * @param yCoord The y coordinate of the location.
     * @param attration Whether it is an attraction or not.
     */
    public Location(String name, int xCoord, 
    int yCoord,boolean isTouristAttraction){
        this.name = name;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        attraction = isTouristAttraction;
    }
    
    /**
     * Returns the name of the location
     * 
     * @return The name of the attraction.
     */
    public String getName(){
        return name;
    }
    
    /**
     * Initializes name, coordinates, and attraction.
     * 
     * @return True if location is an attraction, false otherwise.
     */
    public boolean isAttraction() 
    { 
        return attraction;
    }
}