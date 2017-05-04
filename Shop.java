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
    private ArrayList<Cargo>orders; //list of oders the shop has 
    /**
     * Constructor for Shop 
     * @param a the location of the shop
     * @param id the unique id of the shop
     */
    public Shop(int id, Location a){
        super(id, 'S');
        this.orders=new ArrayList<Cargo>();
        this.facilityLoc=a;
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
        return this.facilityLoc;
    }

    /**
     * Distance from method
     * Uses the distance method from location to calculate 
     * The distance between a warehouse and a given location
     * @param x the location from which the distance of the warehouse is being measured
     * @return the distance from this facility to x
     */
    public int distanceFrom(Facility x)
    {
        return facilityLoc.distance(x.getLocation());
    }

    public String toString()
    {
        return "S" + ID;
    }

    /**
     * Add cargo method
     * @param c the cargo to be added
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
    
    /**
     * Method ordersAsString returns the shop's orders as a string representation
     * @return the orders has a string
     */
    public String ordersAsString()
    {
        return orders.toString();
    }
}