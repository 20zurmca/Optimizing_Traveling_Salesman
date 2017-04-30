import java.util.ArrayList;
/**
 * A shop a a list of orders, a location
 * 
 * @author Emmett O'Toole 
 * @version 4-29-17
 */
public class Shop implements Facility 
{
    //Instance Variables
    private ArrayList<Cargo>orders;
    private Location shopLoc;
    private int id;
    /**
     * Constructor for Shop 
     * @param Location a the location of the shop
     * @param int id the unique id of the shop
     */
    public Shop(int id, Location a){
        this.orders=new ArrayList<Cargo>();
        this.shopLoc=a;
    }

    /**
     * Get order
     * @param the index of the order
     * @return Cargo the cargo at that index in the list
     */
    public Cargo getOrder(int index){
        return orders.get(index);
    }

    /**
     * Get location
     * @return the shop location
     */
    public Location getLocation(){
        return this.shopLoc;
    }

    /**
     * Distance from method
     * Uses the distance method from location to calculate 
     * The distance between a warehouse and a given location
     * @param  Location x the location from which the distance of the warehouse is being measured
     * @return  int the distance
     */
    public int distanceFrom(Facility x)
    {
        return shopLoc.distance(x.getLocation());
    }

    /**
     * Get id method
     * @return int the unique id of the warehouse
     */
    public int getID(){
        return this.id;
    }
    
    public String toString()
    {
        return "S" + id;
    }
}