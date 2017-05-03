import java.util.ArrayList;
/**
 * Write a description of class Scheduler here.
 * 
 * @author Emmett O'Toole 
 * @version 3:06 P.M 5-2-17
 */
public class Scheduler
{
    private int totalDistance; //total distance of all trucks
    
    /**
     * Constructor for class Scheduler
     */
    public Scheduler() {}
    
    /**
     * Method schedule schedules a truck's route for a warehouse on the grid
     * @param a the Warehouse with trucks
     * @param grid the graph the warehouse is on
     */
    public void schedule(Warehouse a,Grid grid){
        //All the neighboring facilities from a
        ArrayList<Facility>shops=grid.getGraph().getNeighbors(a);

        //These prints help to test that the method is working
        /*
        for(Facility s:shops){
            System.out.println("Shop:"+" "+s.toString()+" Distance "+s.distanceFrom(a));
        }
        System.out.println(shops.size());
        */

        //While the warehouse still has trucks left
        while(a.trucksLeft()){
            //Set current truck to the next truck that the warehouse has
            Truck current=a.getNextTruck();
            //while the trucks weight is less than 500 or it has visited more than 150 shops 
            while(current.getWeight()<500){
                Shop s=grid.getGraph().nextShop(current.getPosition(),current);//get the closest shop to the truck's position 
                if(s == null )
                {
                    break;
                }
                current.setPosition(s); //that is the truck's new position 
                ArrayList<Cargo>currentOrders=s.getOrders();
                for(int i=0;i<currentOrders.size();i++){
                    if(current.loadCargo(currentOrders.get(i))){ //load up all possible cargo 
                        s.decreaseCargo(currentOrders.get(i));
                    }
                }
            }
            current.setPosition(a);
            this.totalDistance += current.getDistance();
        }
    }
    
    /**
     * Method get distance returns the total distance
     * @return total distance travelled by trucks
     */
    public int getDistance()
    {
        return totalDistance;
    }
}