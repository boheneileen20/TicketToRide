import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Class that holds the necessary data for a player in the game.
 *
 * @author Greg MacGown, Eileen Bohen
 * @version 1.0
 */
public class Player {

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
     * Tourist attractions connected to.
     */
    private ArrayList<Location> tourist = new ArrayList<>();
    //  score for routes claimed
    /**
     * The score for routes claimed.
     */
    private int routeScore;
    /**
     * The score for the destinations.
     */
    private int destScore;
    /**
     * The final score.
     */
    private int finalScore;

    /**
     * Assigns claimed routes,hand, name, and age.
     * 
     * @param name The player's name.
     * @param age The player's age.
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
     * @return Number of taxis player has.
     */

    public int getTaxis() {
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
    public void removeFromTransHand(String color) {
        boolean found = false;
        TransportationCard t = null;
        //loop through until card is found and remove
        while (!found) {
            for (int i = 0; i < transHand.size(); i++) {
                if (transHand.get(i).getColor().equalsIgnoreCase(color) 
                && !found) {
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
    public ArrayList<TransportationCard> getTransHand() {
        return transHand;
    }

    /**
     * Prints all the transporation cards in hand.
     */
    public void printTransHand() {
        System.out.print(name + "'s transportation hand: ");
        for (TransportationCard t : transHand) {
            System.out.print(t.getColor() + " ");
        }
    }

    /**
     * Prints all the destination cards in the player's hand.
     */
    public void printDestHand() {
        System.out.print(name + "'s destination hand: ");
        for (DestinationCard t : destHand) {
            System.out.print(t.toString() + " ");
        }

    }
    /**
     * Accessor method to return name.
     * 
     * @return name Name of player.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of certain color cards the player has.
     * 
     * @param color The color of card the user has.
     * 
     * @return result The amount of cards in hand from color.
     */
    public int getNumColor(String color) {
        int result = 0;
        for (TransportationCard t : transHand) {
            if (t.getColor().equalsIgnoreCase(color)) {
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
    public void addRoute(Route r) {
        claimed.add(r);
        //  if the route contains a tourist attraction the
        //  player has not already connected to, add it
        Location loc1 = r.getLoc1();
        Location loc2 = r.getLoc2();
        if(loc1.getTourist()){
            if(!tourist.contains(loc1)){
                tourist.add(loc1);
            }
        }
        if(loc2.getTourist()){
            if(!tourist.contains(loc2)){
                tourist.add(loc2);
            }
        }

        //  lastly, increment score. 1 point for 1 taxi route,
        //  2 for 2 taxis, 4 for 3 taxis, 7 for 4 taxis
        int taxisUsed = r.getRecTaxis();
        if(taxisUsed == 1){
            routeScore = routeScore + 1;
        }
        else if(taxisUsed == 2){
            routeScore = routeScore + 2;
        }
        else if(taxisUsed == 3){
            routeScore = routeScore + 4;
        }
        else if(taxisUsed == 4){
            routeScore = routeScore + 7;
        }

    }

    /**
     * Method to return all the routes the player has claimed.
     * 
     * @return The routes the player has claimed.
     */
    public ArrayList<Route> getRoutes() {

        return claimed;
    }

    /**
     * Method to print all the routes the player has claimed.
     * 
     */
    public void printRoutes() {
        System.out.print(name + "'s claimed routes: ");
        for (Route r : claimed) {
            System.out.print(r.toString() + " ");
        }
    }

    /**
     * Method to print the player's information.
     * 
     */
    public void printStats() {
        System.out.println(name + "'s stats: ");
        System.out.println("Taxis: " + taxis);
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
    public void deductTaxis(int num) {
        taxis = taxis - num;
    }

    /**
     * Returns list of tourist attractions .
     * 
     * @return The list of attractions player has.
     */
    public ArrayList<Location> getConTourist(){
        return tourist;
    }

    /**
     * Method to return current destination cards.
     * 
     * @return The list of destination cards.
     */
    public ArrayList<DestinationCard> getDestHand() {
        return destHand;
    }

    /**
     * Method to get current route score.
     * 
     * @return The current score from routes.
     */
    public int getRouteScore(){
        return routeScore;
    }

    /**
     * Method to calculate final score.
     * 
     */
    public void calcFinalScore(){
        finalScore = destScore + routeScore;
    }

    /**
     * Method to get final score.
     * 
     * @return The final value of the score.
     */
    public int getFinalScore(){
        return finalScore;
    }

    /**
     * Method to get score from desination cards.
     * 
     * @return The score from destination cards.
     */
    public int getDestScore() {
        return destScore;
    }

    /**
     * Method to add to destination score.
     * 
     * @param num The points added to Destination score.
     */
    public void addDestScore(int num) {
        destScore += num;
    }


}
