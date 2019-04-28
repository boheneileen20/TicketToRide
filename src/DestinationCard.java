import java.awt.*;
/**
 * Encapsulates information for transportation cards.
 *
 * @author Eileen Bohen
 * @version Spring 2019
 */
public class DestinationCard
{
    //the value on the card
    private int num;
    //one destination on the card
    private String dest1;
    //the other destination on the card
    private String dest2;
    //the picture of the card
    private Image picture;
    
    /**
     * Constructor for objects of the DestinationCard class. Initializes instance variables.
     * 
     * @param num, the value on the card. dest1, the first destination. dest2, the second destination. picture, 
     * the image of the card.
     */
    public DestinationCard(int num, String dest1, String dest2, Image picture){
        this.num = num;
        this.dest1 = dest1;
        this.dest2 = dest2;
        this.picture = picture;
    }
    
    /**
     * Returns the number of the card
     * 
     * @return the number on the card
     */
    public int getNum(){
        return num;
    }
    
    /**
     * Returns the first destination
     * 
     * @return the first destination
     */
    public String getDest1(){
        return dest1;
    }
    
    /**
     * Returns the second destination
     * 
     * @return the second destination
     */
    public String getDest2(){
        return dest2;
    }
    
    /**
     * Returns the card image
     * 
     * @return the card image
     */
    public Image getPicture(){
        return picture;
    }

    public String toString(){
        String message = dest1 + " to " + dest2 + " for " + num + " points.";
        return message;

    }
    
}
