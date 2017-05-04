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

        //While the warehouse still has trucks left
        while(a.trucksLeft()){
            System.out.println();
            //Set current truck to the next truck that the warehouse has
            Truck current=a.getNextTruck();
            while(current.getWeight()<500){ //traverse grid as long as weight is less than 500
                Shop s=grid.getGraph().nextShop(current.getPosition(),current);//get the closest shop to the truck's position (see DirectedGraph class for more details)
                if(s == null )
                {
                    System.out.println("The Truck cannot go to a shop and must return.  The distance travelled of the truck is: " + current.getDistance());
                    break;
                }

                ArrayList<Cargo>currentOrders=s.getOrders();
                current.checkFacility(s); //add the facility to the truck's prior checked facilities 

                System.out.println("Truck from location " + current.getPosition().toString() + " is checking shop " + s.toString() + ".  The shop is distance: " + current.getPosition().distanceFrom(s) + " and has orders: " + s.ordersAsString());
                for(int i=0;i<currentOrders.size();){ //check if any of the orders can be added to the truck
                    if(current.loadCargo(currentOrders.get(i))){ //checking if any cargo an be added
                        System.out.println("The Truck can go to shop and pick up the cargo order with weight " + currentOrders.get(i) + ", and now has weight: " + current.getWeight());

                        s.decreaseCargo(currentOrders.get(i));
                        i = 0; //restart the loop to the beginning to continue checking orders 
                        current.updateDistance(s); //update the truck's travelling distance to the shop since this shop can be satisfied  
                        System.out.println("Total Distance Travelled by this truck so far: " + current.getDistance());
                    } else {
                        i++; //progress through the cargo list to search for acceptable cargo
                        if(i == currentOrders.size()){
                            System.out.println("No orders can be fullfilled");
                        }
                    }
                }
            }
            current.updateDistance(a); //returns back to homeBase
            System.out.println("This truck's total distance is " + current.getDistance() + " after returning back to base");
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