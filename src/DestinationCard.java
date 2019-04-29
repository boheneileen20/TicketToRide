import java.awt.*;
/**
 * Encapsulates information for transportation cards.
 *
 * @author Eileen Bohen
 * @version Spring 2019
 */
public class DestinationCard
{
    /**
     * The value on the card.
     */
    private int num;
    /**
     * One destination on the card.
     */
    private Location dest1;
    /**
     * The other destination on the card.
     */
    private Location dest2;
    /**
     * The picture of the card.
     */
    private Image picture;
    
    /**
     * Initializes instance variables.
     * 
     * @param num The value on the card.
     * @param dest1 The first destination. 
     * @param dest2 The second destination. 
     * @param picture The image of the card.
     */
    public DestinationCard(int num, Location dest1, Location dest2, Image picture){
        this.num = num;
        this.dest1 = dest1;
        this.dest2 = dest2;
        this.picture = picture;
    }
    
    /**
     * Returns the number of the card.
     * 
     * @return The number on the card.
     */
    public int getNum(){
        return num;
    }
    
    /**
     * Returns the first destination.
     * 
     * @return The first destination.
     */
    public Location getDest1(){
        return dest1;
    }
    
    /**
     * Returns the second destination.
     * 
     * @return The second destination.
     */
    public Location getDest2(){
        return dest2;
    }
    
    /**
     * Returns the card image.
     * 
     * @return The card image.
     */
    public Image getPicture(){
        return picture;
    }

    /**
     * This returns a string with destination info.
     * 
     * @return The info of the destination.
     */
    public String toString(){

        String message = dest1 + " to " + dest2;
        message += " for " + num + " points.";

        return message;

    }
    
}
