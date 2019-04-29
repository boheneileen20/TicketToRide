import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Class that holds the necessary data for a player in the game.
 *
 * @author Greg MacGown
 * @version 1.0
 */

public class Player
{
    /**
     * The player's name.
     */
    public String name;
    /**
     * The player's age. the oldest player goes first.
     */
    public int age;
    /**
     * The number of taxis that the player has (15 to begin with).
     */
    public int taxis;
    /**
     * The score counter init to 0.
     */
    private int score = 0;
    /**
     * The array of transportation cards that the user has.
     */
    public ArrayList <TransportationCard> transHand;
    /**
     * The array of destination cards that the user has.
     */
    public ArrayList <DestinationCard> destHand;
    /**
     * The routes the player has claimed.
     */
    public ArrayList<Route>  claimed;

    /**
     * Assigns claimed routes,hand, name, and age.
     * 
     * @param name The player's name.
     * @param age The player's age.

    //  tourist attractions connected to
    private ArrayList<Location> tourist = new ArrayList<>();
    //  score for routes claimed
    private int routeScore;
    // score for dests
    private int destScore;
    //final score
    private int finalScore;
     */
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        taxis = 15;
        //Initialize hand to empty
        transHand = new ArrayList<TransportationCard>();
        destHand = new ArrayList<DestinationCard>();
        //set claimed routes to none
        claimed = new ArrayList<Route>();
    }

    /**
     * Getter method used to check number of taxis.
     * 
     * @return The number of taxis player has.
     */

    public int getTaxis(){
        return taxis;
    }

    /**
     * Method used to add drawn cards to the player's hand.
     * 
     * @param c Card to add to the player's hand.
     */
    public void addToTransHand(TransportationCard c) {
        transHand.add(c);
    }

    /**
     * Returns a transportation card from hand based on color.
     * 
     * @param color Type of color card to remove from hand.
     */
    public void removeFromTransHand(String color){
        boolean found = false;
        TransportationCard t = null;
        //loop through until card is found and remove
        while(!found) {
            for (int i = 0; i < transHand.size(); i++) {
                if (transHand.get(i).getColor().equalsIgnoreCase(color)) {
                    transHand.remove(i);
                    found = true;
                }
            }
        }
    }

    /**
     * Adds a destination card to the player's hand.
     * 
     * @param c The card to add to the player's hand.
     */
    public void addToDestHand(DestinationCard c) {
        destHand.add(c);
    }

    /**
     * Returns all the transportation cards in the hand.
     * 
     * @return All the transportation cards in hand.
     */
    public ArrayList<TransportationCard> getTransHand(){
        return transHand;
    }

    /**
     * Prints all the transporation cards in hand.
     */
    public void printTransHand(){
        System.out.print(name + "'s transportation hand: ");
        for(TransportationCard t: transHand){
            System.out.print(t.getColor() + " ");
        }
    }
    
    /**
     * Prints all the destination cards in the player's hand.
     */

    public void printDestHand(){
        System.out.print(name + "'s destination hand: ");
        for(DestinationCard t: destHand){
            System.out.print(t.toString() + " ");
        }

    }
    
    /**
     * Accessor method to return name.
     * 
     * @return name Name of player.
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the number of certain color cards the player has.
     * 
     * @param color The color of card the user has.
     * 
     * @return result The amount of cards in hand from color.
     */
    public int getNumColor(String color){
        int result = 0;
        for(TransportationCard t: transHand){
            if(t.getColor().equalsIgnoreCase(color)){
                result++;
            }
        }
        return result;

    }

    /**
     * Add route to list of routes claimed by player.
     * 
     * @param r The route that the player claimed.
     */
    public void addRoute(Route r){
        claimed.add(r);
    }

    /**
     * Method to return all the routes the player has claimed.
     * 
     * @return The routes the player has claimed.
     */
    public ArrayList<Route> getRoutes(){
        return claimed;
    }

    /**
     * Method to print all the routes the player has claimed.
     * 
     */
    public void printRoutes(){
        System.out.print(name + "'s claimed routes: ");
        for(Route r: claimed){
            System.out.print(r.toString() + " ");
        }
    }

    /**
     * Method to print the player's information.
     * 
     */
    public void printStats(){
        System.out.println(name +"'s stats: ");
        System.out.println("Taxis: " + taxis);
        System.out.println("Score: " + score + " (routes only)");
        printTransHand();
        System.out.println();
        printDestHand();
        System.out.println();
        printRoutes();
        System.out.println();
    }

    /**
     * Method to deduct taxis from current amount of taxis.
     * 
     * @param num the amount of taxis to deduct.
     */
    public void deductTaxis(int num){
        taxis = taxis - num;

    }

    /**
     * Calculates the score based on the routes length.
     * 
     * @param routeLength The score based on route length.
     */
    public void claimRouteScore(int routeLength) {
        if (routeLength ==1) score++;
        if (routeLength ==2) score += 2;
        if (routeLength ==3) score += 4;
        if (routeLength ==4) score += 7;
    }

    /**
     * Method to add points to the current total score.
     * 
     * @param points Points to add to total score.
     */
    public void addScore(int points) {
        score += points;
    }
    
    public void calcFinalScore(){
        finalScore = destScore + routeScore;
    }
    
    public int getFinalScore(){
        return finalScore;
    }
    
    public int getDestScore() {
        return destScore;
    }
    
    public void addDestScore(int num) {
        destScore += num;
    }

    /**
     * Method to return current points.
     * 
     * @return score The current total score the player has.
     */
    public int getScore() {
        return score;
    }
}