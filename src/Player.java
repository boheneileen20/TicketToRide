import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Class that holds the necessary data for a player in the game.
 *
 * @author Greg MacGown, Eileen Bohen
 * @version 1.0
 */
public class Player {
    //the player's name
    private String name;
    //the player's age. the oldest player goes first
    private int age;
    //the number of taxis that the player has (15 to begin with)
    private int taxis;
    //the array of transportation cards that the user has
    private ArrayList<TransportationCard> transHand;
    //the array of destination cards that the user has
    private ArrayList<DestinationCard> destHand;
    //routes the player has claimed
    private ArrayList<Route> claimed;
    //  tourist attractions connected to
    private ArrayList<Location> tourist = new ArrayList<>();
    //  score for routes claimed
    private int routeScore;
    // score for dests
    private int destScore;
    //final score
    private int finalScore;
    

    /**
     * Constructor for player objects. Instantiates name and age to the user inputs, taxis to 15, their hands to empty,
     * and claimed routes to none.
     *
     * @param name, the player's name. age, the player's age.
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
     * Getter method used to check number of taxis
     *
     * @return int number of taxis player has
     */

    public int getTaxis() {
        return taxis;
    }


    /**
     * Methods used to add drawn cards to the player's hand
     *
     * @param TransportationCard c to add to the player's hand
     */
    public void addToTransHand(TransportationCard c) {
        transHand.add(c);
    }

    public void removeFromTransHand(String color) {
        boolean found = false;
        TransportationCard t = null;
        //loop through until card is found and remove
        while (!found) {
            for (int i = 0; i < transHand.size(); i++) {
                if (transHand.get(i).getColor().equalsIgnoreCase(color)) {
                    transHand.remove(i);
                    found = true;
                }
            }
        }
    }

    /**
     * Adds a destination card to the player's hand
     *
     * @param DestinationCard c, the card to add to the player's hand
     */
    public void addToDestHand(DestinationCard c) {
        destHand.add(c);
    }

    public ArrayList<TransportationCard> getTransHand() {
        return transHand;
    }

    public void printTransHand() {
        System.out.print(name + "'s transportation hand: ");
        for (TransportationCard t : transHand) {
            System.out.print(t.getColor() + " ");
        }
    }

    public void printDestHand() {
        System.out.print(name + "'s destination hand: ");
        for (DestinationCard t : destHand) {
            System.out.print(t.toString() + " ");
        }


    }

    public String getName() {
        return name;
    }

    public int getNumColor(String color) {
        int result = 0;
        for (TransportationCard t : transHand) {
            if (t.getColor().equalsIgnoreCase(color)) {
                result++;
            }
        }
        return result;

    }

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

    public ArrayList<Route> getRoutes() {

        return claimed;
    }

    public void printRoutes() {
        System.out.print(name + "'s claimed routes: ");
        for (Route r : claimed) {
            System.out.print(r.toString() + " ");
        }
    }

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

    public void deductTaxis(int num) {
        taxis = taxis - num;
    }

    public ArrayList<Location> getConTourist(){
        return tourist;
    }



    public ArrayList<DestinationCard> getDestHand() {
        return destHand;
    }


    public int getRouteScore(){
        return routeScore;
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



}
