import java.util.ArrayList;
/**
 * A shop a a list of orders, a location
 * 
 * @author Emmett O'Toole 
 * @version 4-29-17
 */
public class Shop extends Facility 
{
    //Instance Variables
    private ArrayList<Cargo>orders;
    private Location shopLoc;
    /**
     * Constructor for Shop 
     * @param Location a the location of the shop
     * @param int id the unique id of the shop
     */
    public Shop(int id, Location a){
        super(id, 'S');
        this.orders=new ArrayList<Cargo>();
        this.shopLoc=a;
    }

    /**
     * Get order
     * @param the index of the order
     * @return ArrayList of a shops orders
     */
    public ArrayList<Cargo> getOrders(){
        return this.orders;
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
        return this.ID;
    }

    public String toString()
    {
        return "S" + ID;
    }

    /**
     * Add cargo method
     * @param Cargo c the cargo to be added
     */
    public void addCargo(Cargo c){
        orders.add(c);
    }

    /**
     * Decrease Cargo Method
     * @param Cargo c
     */
    public void decreaseCargo(Cargo c){
        orders.remove(c);
    }

    /**
     * Is orders Empty
     * Returns true if there are no orders left
     */
    public boolean isOrdersEmpty(){
        return orders.isEmpty();

    }
}
