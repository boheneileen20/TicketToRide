import javax.swing.*;
import java.util.*;
/**
 * Class which runs the game with no graphics implementation
 *
 * @author Eileen Bohen
 * @version Spring 2019
 */
public class GameDriver
{
    //boolean to check for last turns
    public boolean lessThanTwo = false;
    //boolean to make setup simpler
    public boolean init = false;
    //list of player objects
    public ArrayList <Player> players;


    /**
     * Constructor of Game Driver. Asks the user for player names and ages and creates player objects.
     * 
     * @param playerNum, the number of players in the game. This is entered by the user and can be between 2 and 4,
     * inclusive.
     * 
     */
    public GameDriver(int playerNum){
        JOptionPane jPane = new JOptionPane(); 
        players = new ArrayList<Player>();
        for (int i = 1; i <= playerNum; i++) {
            String name = jPane.showInputDialog("Please enter the player " + i + "'s name");
            int age = Integer.parseInt(jPane.showInputDialog("Please enter the player " + i + "'s age"));
            players.add(new Player(name, age));
        }
        System.out.println("num players: " + players.size());
        init = true;
    }

    /**
     * Method to draw transportation cards
     */
    public void drawTrans() {
        //full implementation to be done later

        boolean blind = true; //drawing a card from the pile is a blind draw 
        for (int i = 0; i < 2; i++){
            if (!init) return; //draw two blind cards
            else {
                //implement mouse listening for coordinates to click on cards
                //on board or the trans deck
                if (!blind) {
                    //if the card is a rainbow card
                    break;
                }
            }
        }
    }

    /**
     * Method to draw destination cards. 
     */
    public void drawDest() {
        //full implementation to be done later

        //Draw two cards, then allow user to either keep both cards or discard one of them
    }
    
    /**
     * Returns the array of players
     * 
     * @return the array of players
     */
    public ArrayList<Player> getPlayers(){
        return players;
    }



    public static void main(String[] args){
        //sort the players AL by player age

        //deal starting hand of two transportation cards to each player
        
        
        
        //allow each user to draw destination cards in order
        
        
        //begin game loop
        //during a player's turn, they choose to either:
        //  1) draw destination cards,
        //  2) draw transportation cards, or
        //  3) claim a route
        //the loop ends when a player has fewer than 3 taxis, and at that point each of the other
        //players has one more turn and the game is over.
        

        //beginning: pick 3 dest keep 1-3
        //turn: pick 3 more dest cards, or take 2 transport cards, unless you get rainbow face up
        //always 4 transport cards face up, replace every time you take
        //claim route: pay that amount of transport cards
    }
}
