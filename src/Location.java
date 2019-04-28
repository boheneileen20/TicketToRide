public class Location {
    //name
    String name;
    //x coord
    int xCoord;
    int yCoord;
    boolean isTourist;

    public Location(String name, int xCoord, int yCoord, boolean isTourist){
        this.name = name;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.isTourist = isTourist;

    }

    public String getName(){
        return name;
    }

    public boolean getTourist(){
        return isTourist;
    }
}
