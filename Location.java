/**
 * A location has an x and y coordinate
 * It serves as a tuple representing the location on the 100 X 100 grid
 * 
 * @author Emmett O'Toole 
 * @version 4-23-17
 */
public class Location
{
    // instance variables 
    private int x; //x locationn
    private int y; //y location

    /**
     * Constructor for objects of class Location
     * @param x the x coordinate 
     * @param y the y coordinate
     */
    public Location(int x,int y)
    {
        this.x = x;
        this.y= y;
    }

    /**
     * Get x method
     * @return the x coordinate
     */
    public int getX()
    {
        return this.x;
    }

    /**
     * Get y method
     * @return the y coordinate
     */
    public int getY()
    {
        return this.y;
    }

    /**
     * Calculate Distance between two locations method
     * @param a the location to be compared to this location
     * @return the distance between two locations
     */
    public int distance(Location a){
        int xDist=Math.abs(this.x-a.getX());
        int yDist=Math.abs(this.y-a.getY());
        return xDist+yDist;
    }
}