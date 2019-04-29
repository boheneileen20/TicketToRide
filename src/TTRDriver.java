import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Driver class for the project. This code began as a
 * completely text-based version of the game, then
 * methods were added to help cooperate with GUI.
 * This class also reads in many images and creates
 * the arraylists that server as the card decks.
 * 
 * Author: Eileen Bohen Greg MacGown
 * Version: Spring 2019
 */
public class TTRDriver {
    //  ArrayLis of the player in the game
    private ArrayList<Player> players = new ArrayList<>();
    //  arraylist of locations on the board
    private ArrayList<Location> locations = new ArrayList<>();
    //  arraylist of routes on the board
    private ArrayList<Route> routes = new ArrayList<>();
    /* array of destination cards that make up the deck*/
    private ArrayList<DestinationCard> destCards =  new  ArrayList <  > ();
    /* array of transportation cards with horizontal images*/
    private ArrayList<TransportationCard> transCards =  new  ArrayList <  > ();
    /* array of transportation cards with vertical images, to be used when displaying a player's hand*/
    private ArrayList<TransportationCard> transCardsUpright =  new  ArrayList <  > ();
    /* array of transportation cards that make up the deck*/
    private ArrayList<TransportationCard> displayTransCards =  new  ArrayList <  > ();
    /* Toolkit used for grabbing Images*/
    private Toolkit toolkit;
    //  the number of players in the game
    private int numPlayers;
    //  the index of the current Player in the players AL
    private int playerTurn;
    //  true if game is over
    private boolean gameOver;

    /**
     * Constructs driver. Calls methods that initialize card decks.
     *
     * @param    number of players in the game.
     * */
    public TTRDriver(int numPlayers){
        gameOver = false;
        playerTurn = 0;
        this.numPlayers = numPlayers;

        toolkit = Toolkit.getDefaultToolkit();
        //initialize locations
        initLocations();
        //initialize routes
        initRoutes();
        //initialize card decks
        readCardImages();
        //shuffle transportation cards
        shuffleTransportCards();
        //pick trans cards to display
        pickDisplayTransCards();
        //shuffle destination cards
        shuffleDestCards();

    }

    /**
     * Changes playerTurn (index of current Player in players AL) to the next player
     * */
    public void nextPlayersTurn(){
        if(playerTurn<numPlayers-1){
            playerTurn = playerTurn +1;
        }
        else{
            playerTurn = 0;
        }
    }

    /**
     * Gets the index of the current Player in the players aL
     *
     * @return   the index (int) of the current player
     * */
    public int getPlayerTurn(){
        return playerTurn;
    }

    /**
     * Creates a new player object and adds to the players AL
     *
     * @param String player's name, int players age
     * */
    public void makePlayer(String name, int age){
        Player p = new Player(name,age);
        players.add(p);
    }

    /**
     * Sets up the players for the text based implementation of the game
     * */
    public void setUpPlayers(){
        Scanner s = new Scanner(System.in);
        for(int i = 1; i<=numPlayers; i++){
            System.out.println("Enter player " + i + "'s name: ");
            String name = s.next();
            System.out.println("Enter player " + i + "'s age: ");
            int age = s.nextInt();
            Player p = new Player(name, age);
            players.add(p);
        }
    }

    /**
     * Reads in card images  and initializes card objects
     * NEEDS FIXING: path1s for file names only work on Eileen's machine
     *
     * */
    public void readCardImages(){
        /* read in destination card images and save them in an arraylist*/
        String path1 = "fwdboardandtransport/";
        DestinationCard centralChelsea5 =  new  DestinationCard(5,
                locations.get(1), locations.get(6),
                toolkit.getImage(path1 + "central_chelsea_5.jpg"));
        DestinationCard centralChina8 =  new  DestinationCard(8,
                locations.get(1), locations.get(12),
                toolkit.getImage(path1 + "central_china_8.jpg"));
        DestinationCard centralGramercy4 =  new  DestinationCard(4,
                locations.get(1), locations.get(7),
                toolkit.getImage(path1 + "central_gramercy_4.jpg"));
        DestinationCard centralMidtown3 =  new  DestinationCard(3, 
                locations.get(1), locations.get(3),
                toolkit.getImage(path1 + "central_midtown_3.jpg"));
        DestinationCard chelseaBrooklyn8 =  new  DestinationCard(8,
                locations.get(6),locations.get(14),
                toolkit.getImage(path1 + "chelsea_brooklyn_8.jpg"));
        DestinationCard chelseaWall6 =  new  DestinationCard(6,
                locations.get(6),locations.get(13),
                toolkit.getImage(path1 + "chelsea_wall_6.jpg"));
        DestinationCard chinaGramercy4 =  new  DestinationCard(4,
                locations.get(12),locations.get(7), 
                toolkit.getImage(path1 + "china_gramercy_4.jpg"));
        DestinationCard eastSoho4 =  new  DestinationCard(4,
                locations.get(9),locations.get(10),
                toolkit.getImage(path1 + "east_soho_4.jpg"));
        DestinationCard empireBrooklyn7 =  new  DestinationCard(7,
                locations.get(5),locations.get(14),
                toolkit.getImage(path1 + "empire_brooklyn_7.jpg"));
        DestinationCard empireGreen3 =  new  DestinationCard(3,
                locations.get(5),locations.get(8),
                toolkit.getImage(path1 + "empire_green_3.jpg"));
        DestinationCard lincolnEmpire3 =  new  DestinationCard(3,
                locations.get(0), locations.get(5),
                toolkit.getImage(path1 + "lincoln_empire_3.jpg"));
        DestinationCard lincolnGreen6 =  new  DestinationCard(6,
                locations.get(0),locations.get(8),
                toolkit.getImage(path1 + "lincoln_geen_6.jpg"));
        DestinationCard lowerEastWall2 =  new  DestinationCard(2,
                locations.get(11),locations.get(13),
                toolkit.getImage(path1 + "lowerEast_wall_2.jpg"));
        DestinationCard midWestUN3 =  new  DestinationCard(3,
                locations.get(3),locations.get(4),
                toolkit.getImage(path1 + "midWest_UN_3.jpg"));
        DestinationCard timesBrooklyn8 =  new  DestinationCard(8,
                locations.get(2),locations.get(14),
                toolkit.getImage(path1 + "times_brooklyn_8.jpg"));
        DestinationCard timesEast4 =  new  DestinationCard(4,
                locations.get(2),locations.get(9),
                toolkit.getImage(path1 + "times_east_4.jpg"));
        DestinationCard timesSoho6 =  new  DestinationCard(6,
                locations.get(2),locations.get(10), toolkit.getImage(path1 + "times_soho_6.jpg"));
        DestinationCard UNWall8 =  new  DestinationCard(8, locations.get(4), 
                locations.get(13), toolkit.getImage(path1 + "UN_wall_8.jpg"));

        //  add to dest cards array (deck)
        destCards.add(centralChelsea5);
        destCards.add(centralChina8);
        destCards.add(centralGramercy4);
        destCards.add(centralMidtown3);
        destCards.add(chelseaBrooklyn8);
        destCards.add(chelseaWall6);
        destCards.add(chinaGramercy4);
        destCards.add(eastSoho4);
        destCards.add(empireBrooklyn7);
        destCards.add(empireGreen3);
        destCards.add(lincolnEmpire3);
        destCards.add(lincolnGreen6);
        destCards.add(lowerEastWall2);
        destCards.add(midWestUN3);
        destCards.add(timesBrooklyn8);
        destCards.add(timesEast4);
        destCards.add(timesSoho6);
        destCards.add(UNWall8);

        String path2 = "fwdpieces/";
        /* read in transportation card images and save them in an arraylist*/
        TransportationCard blue1 =  new  TransportationCard("BLUE", 
                toolkit.getImage(path2 + "blue_1.jpg"));
        TransportationCard blue2 =  new  TransportationCard("BLUE",
                toolkit.getImage(path2 + "blue_2.jpg"));
        TransportationCard gray1 =  new  TransportationCard("GRAY",
                toolkit.getImage(path2 + "gray_1.jpg"));
        TransportationCard gray2 =  new  TransportationCard("GRAY",
                toolkit.getImage(path2 + "gray_2.jpg"));
        TransportationCard green1 =  new  TransportationCard("GREEN",
                toolkit.getImage(path2 + "green_1.jpg"));
        TransportationCard green2 =  new  TransportationCard("GREEN",
                toolkit.getImage(path2 + "green_2.jpg"));
        TransportationCard orange1 =  new  TransportationCard("ORANGE",
                toolkit.getImage(path2 + "orange_1.jpg"));
        TransportationCard orange2 =  new  TransportationCard("ORANGE",
                toolkit.getImage(path2 + "orange_2.jpg"));
        TransportationCard pink1 =  new  TransportationCard("ORANGE",
                toolkit.getImage(path2 + "pink_1.jpg"));
        TransportationCard pink2 =  new  TransportationCard("ORANGE",
                toolkit.getImage(path2 + "pink_2.jpg"));
        TransportationCard rainbow1 =  new  TransportationCard("RAINBOW",
                toolkit.getImage(path2 + "rainbow_1.jpg"));
        TransportationCard rainbow2 =  new  TransportationCard("RAINBOW",
                toolkit.getImage(path2 + "rainbow_2.jpg"));
        TransportationCard red1 =  new  TransportationCard("RED",
                toolkit.getImage(path2 + "red_1.jpg"));
        TransportationCard red2 =  new  TransportationCard("RED",
                toolkit.getImage(path2 + "red_2.jpg"));
        /* this arraylist holds the horizontal images*/
        //there are 8 of each of the color cards
        for(int i = 0; i<6; i++) {
            transCards.add(blue1);
            transCards.add(gray1);
            transCards.add(green1);
            transCards.add(orange1);
            transCards.add(pink1);
            transCards.add(red1);
        }
        //add the 6 rainbow cards
        for(int i = 0; i<8; i++) {
            transCards.add(rainbow1);
        }
        /* this arraylist holds the vertical images*/

        transCardsUpright.add(blue2);
        transCardsUpright.add(gray2);
        transCardsUpright.add(green2);
        transCardsUpright.add(orange2);
        transCardsUpright.add(pink2);
        transCardsUpright.add(red2);
        transCardsUpright.add(rainbow2);

    }

    /**
     * Gets the upright trans cards array (used for GUI)
     *
     * @return the arraylist holding TransportaionCard 
     * objects that have vertical images
     * */
    public ArrayList<TransportationCard> getUprightTrans(){
        return transCardsUpright;
    }

    /**
     * Shuffles the transportation cards
     * */
    public void shuffleTransportCards(){
        Collections.shuffle(transCards);
    }

    /**
     * deals initial transportation cards by adding two cards to 
     * each player's hand
     * */
    public void dealInitialTransCards(){
        for(Player p: players){
            p.addToTransHand(transCards.get(0));
            p.addToTransHand(transCards.get(1));
            transCards.remove(0);
            transCards.remove(1);
        }
    }

    /**
     * Gets the players AL
     *
     * @return ArrayList of Players in the game
     * */
    public ArrayList<Player> getPlayers(){
        return players;
    }

    /**
     * Gets the transportation card deck
     *
     * @return ArrayList of TransportationCards that represents the deck
     * */
    public ArrayList<TransportationCard> getTransDeck(){
        return transCards;
    }

    /**
     * Picks transportation cards to display. This is important because if there
     * is ever more than 2 rainbow taxi cards on display, all 5 cards must be
     * discarded
     * */
    public void pickDisplayTransCards(){
        //  add any current display cards back into array
        for(int i = 0; i<displayTransCards.size(); i++){
            transCards.add(displayTransCards.get(i));
            displayTransCards.remove(i);
        }
        //  keep picking trans cards to display until a valid set is found
        boolean foundSet = false;
        while(!foundSet){
            Collections.shuffle(transCards);
            for(int i = 0; i<5; i++){
                TransportationCard add = transCards.get(i);
                displayTransCards.add(add);
            }
            if(validVisibleTrans()){
                foundSet = true;
                for(int i = 0; i<5; i++){
                    transCards.remove(i);
                }
            }
            else{
                //remove all from display and try again
                //add any current display cards back into array
                for(int i = 0; i<displayTransCards.size(); i++){
                    transCards.add(displayTransCards.get(i));
                    displayTransCards.remove(i);
                }
            }
        }
    }

    /**
     * Checks if the displayTransCards array is valid (no more than 2 taxis)
     *
     * @return boolean if display cards contain fewer than 2 taxis
     * */
    public boolean validVisibleTrans(){
        int count = 0;
        for(TransportationCard t: displayTransCards){
            if(t.getColor().equals("RAINBOW")){
                count++;
            }
        }
        if(count<3){
            return true;
        }
        return false;
    }

    /**
     * Gets array of transportation cards to display
     *
     * @return AL of TransportaitonCard objects that are 
     * to be displayed face up
     * */
    public ArrayList<TransportationCard> getDisplayTransCards(){
        return displayTransCards;
    }

    /**
     * Shuffles the deck of destination cards
     * */
    public void shuffleDestCards(){
        Collections.shuffle(destCards);
    }

    /*
     * Draws to destination cards from the top of the pile
     *
     * @return ArrayList of destination card objects that were drawn
     * */
    public ArrayList<DestinationCard> drawTwoDest(){
        DestinationCard choice1 = destCards.get(0);
        DestinationCard choice2 = destCards.get(1);
        ArrayList<DestinationCard> result = new ArrayList<>();
        result.add(choice1);
        result.add(choice2);
        destCards.remove(0);
        destCards.remove(1);
        return result;
    }

    /**
     * Method to assist GUI in dealing destination cards. Takes the player's 
     * choice, the cards they were given to choose from, and the Player in 
     * question, and adds to appropriate ArrayLists
     *
     * @param String playersChoice is "1" if the chose the first card,
     * "2" for the second card, or "both" for both cards. ArrayList of 
     * DestinationCard objects they chose from, and the Player 
     * choosing the card
     * */
    public void dealInitialDestCardsGUI(String playersChoice, 
    ArrayList<DestinationCard> choices, Player p){
        if(playersChoice.equals("1")){
            //add card to hand, remove that card from deck
            p.addToDestHand(choices.get(0));
            //add the other card back into the deck
            destCards.add(choices.get(1));
            //reshuffle
            Collections.shuffle(destCards);
        }
        else if(playersChoice.equals("2")){
            p.addToDestHand(choices.get(1));
            //add other card back into deck
            destCards.add(choices.get(0));
            Collections.shuffle(destCards);
        }
        else if(playersChoice.equals("both")){
            p.addToDestHand(choices.get(0));
            p.addToDestHand(choices.get(1));
            Collections.shuffle(destCards);
        }
    }

    /**
     * deals initial destination cards in original text-based implementation
     * */
    public void dealInitialDestCards(){
        Scanner s = new Scanner(System.in);
        for(Player p: players){
            System.out.println("You may pick one or both of these cards: ");
            DestinationCard choice1 = destCards.get(0);
            DestinationCard choice2 = destCards.get(1);
            System.out.println("Choice 1: " + choice1.toString());
            System.out.println("Choice 2: " + choice2.toString());
            String output = "Enter \"1\" for choice 1, \"2\" for choice 2,";
            output += "or \"both\" for both";
            System.out.println(output);
            String playersChoice = s.next();
            if(playersChoice.equals("1")){
                //add card to hand, remove that card from deck
                p.addToDestHand(choice1);
                //remove then re-add discarded card to bottom the card
                destCards.remove(1);
                destCards.add(choice2);
                //remove chosen card from deck
                destCards.remove(0);
            }
            else if(playersChoice.equals("2")){
                p.addToDestHand(choice2);
                //remove chosen card from deck
                destCards.remove(1);
                //remove the re-add discarded card
                destCards.remove(0);
                destCards.add(choice1);
            }
            else if(playersChoice.equals("both")){
                p.addToDestHand(choice1);
                p.addToDestHand(choice2);
                destCards.remove(0);
                destCards.remove(1);
            }

        }
    }

    /**
     * trans card drawing method for text-based implementation
     * */
    public void drawTransCards(){
        //player may make a blind draw or draw from the displayed cards
        //if the player takes a face up rainbow taxi card, they may not 
        //take another card that turn
        //player may not take a face up taxi card as their second card either
        String blind = "Enter \"blind\" to draw from the top of the ";
        blind += "transportation deck";
        System.out.println(blind);
        String face = "Enter \"face\" to draw a face up card. You may only ";
        face += "draw once if you take a taxi card";
        String userIn = "Enter 1,2,3,4, or 5 to indicate your choice ";
        System.out.println(face);
        Scanner s = new Scanner(System.in);
        String choice = s.next();

        if(choice.equals("blind")){
            TransportationCard t = transCards.get(0);
            System.out.println("You have drawn a " + t.getColor() + " card.");
            players.get(playerTurn).addToTransHand(t);
            transCards.remove(0);

        }

        else if(choice.equals("face")){
            System.out.println("You may choose from these cards: ");
            for(TransportationCard t: getDisplayTransCards()){
                System.out.print(t.getColor() + " ");
            }
            System.out.println(userIn);
            int faceChoice = s.nextInt() - 1;
            //add choice to player hand and remove from display, 
            //replacing with top card on deck
            TransportationCard t = displayTransCards.get(faceChoice);
            players.get(playerTurn).addToTransHand(t);
            //replace taken card with top card in deck,
            //remove top card from deck
            displayTransCards.set(faceChoice, transCards.get(0));
            transCards.remove(0);

            //check that five cards don't contain more than 3 rainbow cards
            while(!validVisibleTrans()){
                pickDisplayTransCards();
            }

            //if player chose a taxi, return
            if(t.getColor().equals("RAINBOW")){
                System.out.println("Your turn is over");
                return;
            }
        }

        //repeat for second card
        System.out.println(blind);
        System.out.println(face);
        choice = s.next();

        if(choice.equals("blind")){
            TransportationCard t = transCards.get(0);
            System.out.println("You have drawn a " + t.getColor() + " card.");
            players.get(playerTurn).addToTransHand(t);
            transCards.remove(0);

        }

        else if(choice.equals("face")){
            boolean validPick = false;
            int faceChoice = -1;
            while(!validPick) {
                System.out.println("You may choose from these cards: ");
                for (TransportationCard t : getDisplayTransCards()) {
                    System.out.print(t.getColor() + " ");
                }
                System.out.println(userIn);
                faceChoice = s.nextInt() - 1;
                //add choice to player hand and remove from display, 
                //replacing with top card on deck
                TransportationCard t = displayTransCards.get(faceChoice);
                //if player chose a taxi, return
                if (t.getColor().equals("RAINBOW")) {
                    String noRain = "You are not allowed to take a rainbow ";
                    noRain += "taxi, pick again";
                    System.out.println(noRain);
                }
                else{validPick = true;}
            }

            //add to player hand
            players.get(playerTurn).addToTransHand(
                displayTransCards.get(faceChoice));
            //replace taken card with top card in deck,remove top from deck
            displayTransCards.set(faceChoice, transCards.get(0));
            transCards.remove(0);

            //check that five cards don't contain more than 3 rainbow cards
            while(!validVisibleTrans()){
                pickDisplayTransCards();
            }

        }
    }

    /**
     * Replaces one of the face up cards with the top card 
     * in the face down pile
     *
     * @param int index of the element to replace, card to replace it with
     * */
    public void setDisplayTransCards(int index, TransportationCard t){
        displayTransCards.set(index, transCards.get(0));

    }

    /**
     * Sets the player turn to the Player at the given index
     *
     * @param the playerIndex to set playerTurn to
     * */
    public void setPlayerTurn(int playerIndex){
        playerTurn = playerIndex;
    }

    /**
     * Removes the card at the given index
     *
     * @param    index of card to remove
     * */
    public void removeFromTransDeck(int index){
        transCards.remove(index);
    }

    /**
     * Draw dest card method for text-based implementation
     * */
    public void drawDestCards(){
        //player chooses 2 destination cards and may keep one or both of them
        //if there is only one card left, they must take that card
        if(destCards.size()>1){
            DestinationCard d = destCards.get(0);
            DestinationCard d2 = destCards.get(1);
            System.out.println("You have drawn these cards: " + d.toString() 
                + " and " + d2.toString());
            String opt = "Enter 1 to keep the first card, 2 to keep the ";
            opt += "second card, or \"both\" to keep both cards";
            System.out.println(opt);
            Scanner s = new Scanner(System.in);
            String choice = s.next();
            if(choice.equals("1")){
                //add to player hand
                players.get(playerTurn).addToDestHand(d);
                //put the discarded card at the bottom of the deck
                destCards.remove(1);
                destCards.add(d2);
                //add the chosen card to player's hand and remove from deck
                destCards.remove(0);
            }
            else if(choice.equals("2")){
                //add to player hand
                players.get(playerTurn).addToDestHand(d2);
                //remove that card from the deck
                destCards.remove(1);
                //put the discarded card at the bottom of the deck
                destCards.remove(0);
                destCards.add(d);
            }
            else if(choice.equals("both")){
                //add cards to player hand
                players.get(playerTurn).addToDestHand(d);
                players.get(playerTurn).addToDestHand(d2);
                //remove both cards from deck
                destCards.remove(0);
                destCards.remove(1);

            }
        }
        else if(destCards.size() ==1){
            DestinationCard d = destCards.get(0);
            System.out.println("You have drawn this card: " + d.toString());
            //add to player hand and remove from deck
            players.get(playerTurn).addToDestHand(d);
            destCards.remove(0);

        }

    }

    /**
     * Returns a string with the available routes
     *
     * @return String of all available routes (unclaimed)
     * */
    public String getAvailableRoutes(){
        String result = "These routes are available: ";
        for(int i = 1; i<= routes.size(); i++){
            result = result + "\n";
            result = result + (i + ": " + routes.get(i-1).toString());
        }
        return result;
    }

    /**
     * Print route method used in text-based implementation
     * */
    public void printAvailableRoutes(){
        System.out.println("These routes are available: ");
        for(int i = 1; i<= routes.size(); i++){
            System.out.println(i + ": " + routes.get(i-1).toString());
        }
    }

    /**
     * Returns true if a Player has enough taxis to claim a route
     *
     * @param Route, the route they want to claim, Player the player claiming
     * @return boolean, true if they have enough taxis
     * */
    public boolean enoughTaxis(Route r, Player p){

        String[] recs = r.getRequirement().split(" "); //route requirements
        int taxisRequired = Integer.parseInt(recs[1]); //the taxis needed 
        int taxisHeld = p.getTaxis();   //  taxis player has
        if(taxisHeld>= taxisRequired){
            return true;
        }
        return false;
    }

    /**
     * removes route from list of available routes.called when user 
     * claims a route
     *
     * @param Route to remove from array
     * */
    public void removeRoute(Route r){
        routes.remove(r);

    }

    /**
     * Initializes Location objects
     *
     * */
    public void initLocations(){
        Location lincolnCenter = new Location("Lincoln Center", 308
            , 31, false);
        Location centralPark = new Location("Central Park", 456, 21, true);
        Location timesSquare = new Location("Times Square", 392, 159, true);
        Location midtownWest = new Location("Midtown West", 283,184, false);
        Location unitedNations = new Location("United Nations", 589,
                152, true);
        Location empireStateBldg = new Location("Empire State Building", 451,
                251, true);
        Location chelsea = new Location("Chelsea", 517, 328, true);
        Location gramercyPark = new Location("Gramercy Park", 517,
                328, false);
        Location greenwichVillage = new Location("Greenwich Village", 485,
                464, true);
        Location eastVillage = new Location("East Village", 642, 459, false);
        Location soho = new Location("Soho", 392, 594, false);
        Location lowerEastSide = new Location("Lower East Side", 623,
                557, false);
        Location chinatown = new Location("Chinatown", 526, 616, true);
        Location wallStreet = new Location("Wall Street", 480, 723, true);
        Location brooklyn = new Location("Brooklyn", 689, 741, true);

        locations.add(lincolnCenter);
        locations.add(centralPark);
        locations.add(timesSquare);
        locations.add(midtownWest);
        locations.add(unitedNations);
        locations.add(empireStateBldg);
        locations.add(chelsea);
        locations.add(gramercyPark);
        locations.add(greenwichVillage);
        locations.add(eastVillage);
        locations.add(soho);
        locations.add(lowerEastSide);
        locations.add(chinatown);
        locations.add(wallStreet);
        locations.add(brooklyn);

    }

    /**
     * Initializes route objects
     * */
    public void initRoutes(){
        Route lincolnCentral = new Route(locations.get(0),
                locations.get(1), "orange 2");
        Route lincolnTimes = new Route(locations.get(0),
                locations.get(2), "green 2");
        Route lincolnTimes2 = new Route(locations.get(0),
                locations.get(2), "blue 2");
        Route lincolnMidtown = new Route(locations.get(0),
                locations.get(3), "red 2");
        Route centralTimes = new Route(locations.get(1),
                locations.get(2), "gray 2");
        Route centralTimes2 = new Route(locations.get(1),
                locations.get(2), "red 2");
        Route centralUN = new Route(locations.get(1),
                locations.get(4), "pink 3");
        Route timesUN = new Route(locations.get(2),
                locations.get(4), "white 2");
        Route timesEmpire = new Route(locations.get(2),
                locations.get(5), "orange 1");
        Route timesEmpire2 = new Route(locations.get(2), 
                locations.get(5), "pink 1");
        Route midtownTimes = new Route(locations.get(3),
                locations.get(2), "white 1");
        Route midtownEmpire = new Route(locations.get(3),
                locations.get(5), "gray 2");
        Route midtownChelsea = new Route(locations.get(3),
                locations.get(6), "blue 2");
        Route unEmpire = new Route(locations.get(4), 
                locations.get(5), "gray 2");
        Route unGramercy = new Route(locations.get(4), 
                locations.get(7), "green 3");
        Route chelseaEmpire = new Route(locations.get(6),
                locations.get(5), "white 2");
        Route chelseaEmpire2 = new Route(locations.get(6),
                locations.get(5), "white 2");
        Route chelseaGramercy = new Route(locations.get(6),
                locations.get(7), "orange 2");
        Route chelseaGreenwhich = new Route(locations.get(6),
                locations.get(8), "green 3");
        Route chelseaGreenwhich2 = new Route(locations.get(6),
                locations.get(8), "red 3");
        Route chelseaSoho = new Route(locations.get(6),
                locations.get(10), "pink 4");
        Route gramercyEmpire = new Route(locations.get(7),
                locations.get(5), "red 1");
        Route gramercyEmpire2 = new Route(locations.get(7),
                locations.get(5), "blue 1");
        Route gramercyEast = new Route(locations.get(7),
                locations.get(9), "white 2");
        Route gramercyGreen = new Route(locations.get(7),
                locations.get(8), "gray 2");
        Route gramercyGreen2 = new Route(locations.get(7),
                locations.get(8), "pink 2");
        Route greenEastVill = new Route(locations.get(8),
                locations.get(9), "blue 2");
        Route greenSoho = new Route(locations.get(8),
                locations.get(10), "orange 2");
        Route greenChina = new Route(locations.get(8),
                locations.get(12), "white 2");
        Route greenChina2 = new Route(locations.get(8),
                locations.get(12), "white 2");
        Route greenLowerEast = new Route(locations.get(8),
                locations.get(11), "white 2");
        Route eastVillLowerEast = new Route(locations.get(9),
                locations.get(11), "gray 1");
        Route sohoWall = new Route(locations.get(10),
                locations.get(13), "white 2");
        Route lowerEastBrooklyn = new Route(locations.get(11),
                locations.get(14), "white 3");
        Route lowerEastChina = new Route(locations.get(11),
                locations.get(12), "blue 1");
        Route chinaWall = new Route(locations.get(12),
                locations.get(13), "green 1");
        Route chinaWall2 = new Route(locations.get(12),
                locations.get(13), "pink 1");
        Route chinaBrooklyn  = new Route(locations.get(12),
                locations.get(14), "orange 3");
        Route chinaBrooklyn2  = new Route(locations.get(12),
                locations.get(14), "red 3");
        Route wallBrooklyn = new Route(locations.get(13),
                locations.get(14), "gray 3");
        Route wallBrooklyn2 = new Route(locations.get(13),
                locations.get(14), "blue 3");

        routes.add(lincolnCentral);
        routes.add(lincolnMidtown);
        routes.add(lincolnTimes);
        routes.add(lincolnTimes2);
        routes.add(centralTimes);
        routes.add(centralTimes2);
        routes.add(centralUN);
        routes.add(midtownChelsea);
        routes.add(midtownEmpire);
        routes.add(midtownTimes);
        routes.add(timesUN);
        routes.add(timesEmpire);
        routes.add(timesEmpire2);
        routes.add(unEmpire);
        routes.add(unGramercy);
        routes.add(chelseaEmpire);
        routes.add(chelseaEmpire2);
        routes.add(chelseaGramercy);
        routes.add(chelseaGreenwhich);
        routes.add(chelseaGreenwhich2);
        routes.add(chelseaSoho);
        routes.add(gramercyEmpire);
        routes.add(gramercyEmpire2);
        routes.add(gramercyEast);
        routes.add(gramercyGreen);
        routes.add(gramercyGreen2);
        routes.add(greenSoho);
        routes.add(greenChina);
        routes.add(greenChina2);
        routes.add(greenLowerEast);
        routes.add(greenEastVill);
        routes.add(eastVillLowerEast);
        routes.add(sohoWall);
        routes.add(lowerEastBrooklyn);
        routes.add(lowerEastChina);
        routes.add(chinaWall);
        routes.add(chinaWall2);
        routes.add(chinaBrooklyn);
        routes.add(chinaBrooklyn2);
        routes.add(wallBrooklyn);
        routes.add(wallBrooklyn2);

    }

    /**
     * gets the routes array
     *
     * @return ArrayList of Route objects (all routes on board)
     * */
    public ArrayList<Route> getRoutes(){
        return routes;
    }

    /**
     * main method to run text-based implementation
     * */
    public static void main(String[] args) {
        System.out.println("Enter the number of players");
        Scanner s = new Scanner(System.in);
        int numPlayers = s.nextInt();
        TTRDriver ttr = new TTRDriver(numPlayers);

        //TEST: is trans card deck set up? YES
        for(TransportationCard t: ttr.getTransDeck()){
            System.out.print(t.getColor() + " ");
        }
        System.out.println();

        //TEST: are trans cards added to hands? YES
        for(Player p: ttr.getPlayers()){
            p.printTransHand();
        }
        System.out.println();

        //TEST: are display trans cards correct? YES
        System.out.println("Face up transportation cards: ");
        for(TransportationCard t: ttr.getDisplayTransCards()){
            System.out.print(t.getColor() + " ");
        }

        System.out.println();

        //TEST: are dest cards added to player's hands?
        for(Player p : ttr.getPlayers()){
            p.printDestHand();
            System.out.println();
        }

    }

}
