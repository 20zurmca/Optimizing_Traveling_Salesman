import java.util.Stack;
/**
 * A warehouse has a stack of trucks
 * 
 * @author Emmett O'Toole 
 * @version 4-23-17
 */
public class Warehouse implements Facility 
{
    // instance variables 
    private int id;
    //The location of the warehouse
    private Location position;
    //A stack of trucks
    private Stack<Truck>trucks;
    //The number of trucks in the stack
    private int numOfTrucks;
    /**
     * Constructor for objects of class Warehouse
     * @param int id the unique id of the warehous
     * @param Location a the location of the warehouse
     */
    public Warehouse(int id,Location a,int numberOfTrucks)
    {
        this.id=id;
        this.position=a;
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
        return position.distance(x.getLocation());
    }

    /**
     * Get id method
     * @return int the unique id of the warehouse
     */
    public int getID(){
        return this.id;
    }

    /**
     * Get location method
     * @return Location the location of the warehouse
     */
    public Location getLocation(){
        return this.position;
    }

    /**
     * Get number of trucks method
     * @return int the number of trucks in the stack
     */
    public int  getNumOfTrucks(){
        return this.numOfTrucks;
    }
    
    /**
     * Get next truck method returns a truck from the top of the stack
     * @return Truck the truck from the top of the stack
     */
    public Truck getNextTruck(){
        //Updates the number of trucks
        numOfTrucks--;
        //Pops the truck and returns it
        return trucks.pop();
    }
    
    public String toString()
    {
        return "W" + id;
        
    }
}