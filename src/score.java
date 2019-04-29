import java.util.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * Write a description of class DestComplete here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class score
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class DestComplete
     */
    public score()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * Method which takes in a player and a destination card as an 
     * input and checks to see if the player has a connected set of
     * routes connecting the locations on the destination card
     * 
     * @param p Player the player who's claimed routes will be checked
     * @param d DestCard to check if player has connecting routes
     * 
     * @return boolean whether the plyer has a connected path b/w
     * routes on the DestCard
     */
    public boolean isComplete(Player p,DestinationCard d) {
        ArrayList<Location> checked = new ArrayList<Location>();
        Location l1 = d.getDest1();
        Location l2 = d.getDest2();
        if (isCompleteRec(p,checked, l1, l2)){
            if (isCompleteRec(p,checked, l2, l1)) {
                return true;
            }
        } 
        return false;//p.addDestScore(-(d.getNum()));

    }
    /**
     * Recursive helper method which traverses from location to
     * location checking for connections to other locations with
     * a stopping case of finding location 2
     * 
     * @param p Player the player who's claimed routes will be checked
     * @param checked ArrayList of locations already checked to avoid
     * repetetive recursion
     * @param l1 Location  being checked for neighboring claimed routes
     * @param l2 Location  the location that is trying to be traversed to
     * 
     * @return boolean true if l2 is found, and false if no new paths found
     */

    public boolean isCompleteRec(Player p,ArrayList<Location> checked,
    Location l1, Location l2) {
        for (Route r: p.getRoutes()) {
            if (r.loc1.getName().equals(l2.getName())) return true;
            if (r.loc2.getName().equals(l2.getName())) return true;
            if (!contains(checked,l1)) {
                checked.add(l1);
                if (isCompleteRec(p,checked,r.loc2,l2)) return true;
            }
        }
        return false;
    }
    
    /**
     * Helper method which checks to see if the location is in the
     * checked arraylist
     * 
     * @param checked ArrayList of locations to be traversed
     * @param loc Location to be searched for in checked
     * 
     * @return boolean true if loc is found in checked false in other cases
     */
    public static boolean contains(ArrayList<Location> checked,Location loc) {
        for (Location l: checked) {
            if (l.getName().equals(loc.getName())) return true;
        }
        return false;
    }

    public static void main (String args[]) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        ArrayList<Location> locations = new ArrayList<>();
        Location lincolnCenter = new Location("Lincoln Center", 308, 31, false);
        Location centralPark = new Location("Central Park", 456, 21, true);
        Location timesSquare = new Location("Times Square", 392, 159, true);
        Location midtownWest = new Location("Midtown West", 283,184, false);
        Location unitedNations = new Location("United Nations", 589, 152, true);
        Location empireStateBldg = new Location("Empire State Building",
                451, 251, true);
        Location chelsea = new Location("Chelsea", 517, 328, true);
        Location gramercyPark = new Location("Gramercy Park", 517, 328, false);
        Location greenwichVillage = new Location("Greenwich Village", 485, 464, true);
        Location eastVillage = new Location("East Village", 642, 459, false);
        Location soho = new Location("Soho", 392, 594, false);
        Location lowerEastSide = new Location("Lower East Side", 623,557, false);
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

        ArrayList<Route> routes = new ArrayList<>();
        Route lincolnCentral = new Route(locations.get(0), locations.get(1), "orange 2");
        Route lincolnTimes = new Route(locations.get(0), locations.get(2), "green 2");
        Route lincolnTimes2 = new Route(locations.get(0), locations.get(2), "blue 2");
        Route lincolnMidtown = new Route(locations.get(0), locations.get(3), "red 2");
        Route centralTimes = new Route(locations.get(1), locations.get(2), "gray 2");
        Route centralTimes2 = new Route(locations.get(1), locations.get(2), "red 2");
        Route centralUN = new Route(locations.get(1), locations.get(4), "pink 3");
        Route timesUN = new Route(locations.get(2), locations.get(4), "white 2");
        Route timesEmpire = new Route(locations.get(2), locations.get(5), "orange 1");
        Route timesEmpire2 = new Route(locations.get(2), locations.get(5), "pink 1");
        Route midtownTimes = new Route(locations.get(3), locations.get(2), "white 1");
        Route midtownEmpire = new Route(locations.get(3), locations.get(5), "gray 2");
        Route midtownChelsea = new Route(locations.get(3), locations.get(6), "blue 2");
        Route unEmpire = new Route(locations.get(4), locations.get(5), "gray 2");
        Route unGramercy = new Route(locations.get(4), locations.get(7), "green 3");
        Route chelseaEmpire = new Route(locations.get(6), locations.get(5), "white 2");
        Route chelseaEmpire2 = new Route(locations.get(6), locations.get(5), "white 2");
        Route chelseaGramercy = new Route(locations.get(6), locations.get(7), "orange 2");
        Route chelseaGreenwhich = new Route(locations.get(6), locations.get(8), "green 3");
        Route chelseaGreenwhich2 = new Route(locations.get(6), locations.get(8), "red 3");
        Route chelseaSoho = new Route(locations.get(6), locations.get(10), "pink 4");
        Route gramercyEmpire = new Route(locations.get(7), locations.get(5), "red 1");
        Route gramercyEmpire2 = new Route(locations.get(7), locations.get(5), "blue 1");
        Route gramercyEast = new Route(locations.get(7), locations.get(9), "white 2");
        Route gramercyGreen = new Route(locations.get(7), locations.get(8), "gray 2");
        Route gramercyGreen2 = new Route(locations.get(7), locations.get(8), "pink 2");
        Route greenEastVill = new Route(locations.get(8), locations.get(9), "blue 2");
        Route greenSoho = new Route(locations.get(8),locations.get(10), "orange 2");
        Route greenChina = new Route(locations.get(8), locations.get(12), "white 2");
        Route greenChina2 = new Route(locations.get(8), locations.get(12), "white 2");
        Route greenLowerEast = new Route(locations.get(8), locations.get(11), "white 2");
        Route eastVillLowerEast = new Route(locations.get(9), locations.get(11), "gray 1");
        Route sohoWall = new Route(locations.get(10), locations.get(13), "white 2");
        Route lowerEastBrooklyn = new Route(locations.get(11), locations.get(14), "white 3");
        Route lowerEastChina = new Route(locations.get(11), locations.get(12), "blue 1");
        Route chinaWall = new Route(locations.get(12), locations.get(13), "green 1");
        Route chinaWall2 = new Route(locations.get(12), locations.get(13), "pink 1");
        Route chinaBrooklyn  = new Route(locations.get(12), locations.get(14), "orange 3");
        Route chinaBrooklyn2  = new Route(locations.get(12), locations.get(14), "red 3");
        Route wallBrooklyn = new Route(locations.get(13), locations.get(14), "gray 3");
        Route wallBrooklyn2 = new Route(locations.get(13), locations.get(14), "blue 3");

        routes.add(lincolnCentral);//0
        routes.add(lincolnMidtown);
        routes.add(lincolnTimes);
        routes.add(lincolnTimes2);
        routes.add(centralTimes);
        routes.add(centralTimes2);//5
        routes.add(centralUN);
        routes.add(midtownChelsea);
        routes.add(midtownEmpire);
        routes.add(midtownTimes);
        routes.add(timesUN);//10
        routes.add(timesEmpire);
        routes.add(timesEmpire2);
        routes.add(unEmpire);
        routes.add(unGramercy);
        routes.add(chelseaEmpire);//15
        routes.add(chelseaEmpire2);
        routes.add(chelseaGramercy);
        routes.add(chelseaGreenwhich);
        routes.add(chelseaGreenwhich2);
        routes.add(chelseaSoho);//20
        routes.add(gramercyEmpire);
        routes.add(gramercyEmpire2);
        routes.add(gramercyEast);
        routes.add(gramercyGreen);
        routes.add(gramercyGreen2);//25
        routes.add(greenSoho);
        routes.add(greenChina);
        routes.add(greenChina2);
        routes.add(greenLowerEast);
        routes.add(greenEastVill);//30
        routes.add(eastVillLowerEast);
        routes.add(sohoWall);
        routes.add(lowerEastBrooklyn);
        routes.add(lowerEastChina);
        routes.add(chinaWall);//35
        routes.add(chinaWall2);
        routes.add(chinaBrooklyn);
        routes.add(chinaBrooklyn2);
        routes.add(wallBrooklyn);
        routes.add(wallBrooklyn2);//40

        DestinationCard lincolnEmpire3 =  new  DestinationCard(3, locations.get(0), locations.get(5), toolkit.getImage("fwdboardandtransport/lincoln_empire_3.jpg"));
        DestinationCard centralGramercy4 =  new  DestinationCard(4, locations.get(1), locations.get(7), toolkit.getImage("fwdboardandtransport/central_gramercy_4.jpg"));
        DestinationCard timesBrooklyn8 =  new  DestinationCard(8, locations.get(2), locations.get(14), toolkit.getImage("fwdboardandtransport/times_brooklyn_8.jpg"));
        Player test = new Player("Greg", 12);
        test.addRoute(routes.get(1));
        test.addRoute(routes.get(8));
        test.addRoute(routes.get(10));
        test.addRoute(routes.get(14));
        test.addRoute(routes.get(17));
        test.addRoute(routes.get(18));
        test.addRoute(routes.get(29));
        test.addRoute(routes.get(38));
        
        //test methods reverted from static for usage
        System.out.println(isComplete(test,lincolnEmpire3));
        System.out.println(isComplete(test,centralGramercy4));
        System.out.println(isComplete(test,timesBrooklyn8));

    }
}
