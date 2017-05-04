import java.util.Stack;
/**
 * A warehouse has a stack of trucks
 * 
 * @author Emmett O'Toole 
 * @version 4-23-17
 */
public class Warehouse extends Facility
{
    //A stack of trucks
    private Stack<Truck>trucks;
    /**
     * Constructor for objects of class Warehouse
     * @param int id the unique id of the warehous
     * @param Location a the location of the warehouse
     * @param int the number of trucks
     */
    public Warehouse(int id,Location a,int numberOfTrucks)
    {
        super(id, 'W');
        this.facilityLoc=a;
        //Initializes the stack of trucks
        this.trucks=new Stack<Truck>();
        //Adds empty trucks to the stack
        for(int i=0;i<numberOfTrucks;i++){
            trucks.push(new Truck(this));
        }
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
        return facilityLoc.distance(x.getLocation());
    }

    /**
     * Get id method
     * @return int the unique id of the warehouse
     */
    public int getID(){
        return this.ID;
    }

    /**
     * Get location method
     * @return Location the location of the warehouse
     */
    public Location getLocation(){
        return this.facilityLoc;
    }
    
    /**
     * Get next truck method returns a truck from the top of the stack
     * @return Truck the truck from the top of the stack
     */
    public Truck getNextTruck(){
        //Pops the truck and returns it
        return trucks.pop();
    }
    
    public String toString()
    {
        return "W" + ID;
        
    }
    
    public boolean trucksLeft(){
        return !this.trucks.isEmpty();
    }
}