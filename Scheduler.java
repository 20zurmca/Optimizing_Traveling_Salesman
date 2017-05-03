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

    public void schedule(Warehouse a,DirectedGraph grid){
        //All the facilities
        ArrayList<Facility>shops=grid.getNeighbors(a);

        //These prints help to test that the method is working
        for(Facility s:shops){
            System.out.println("Shop:"+" "+s.toString()+" Distance "+s.distanceFrom(a));
        }
        System.out.println(shops.size());

        //While the warehouse still has trucks left
        while(a.trucksLeft()){
            //Sets this truck equals to the next truck that the warehouse has
            Truck current=a.getNextTruck();
            //while the trucks weight is less than 500
            while(current.getWeight()<500){
                //Sets the shop
                Shop s=grid.nextShop(current.getPosition(),current);
                current.setPosition(s);
                ArrayList<Cargo>currentOrders=s.getOrders();
                for(int i=0;i<currentOrders.size();i++){
                    if(current.loadCargo(currentOrders.get(i))){
                        s.decreaseCargo(currentOrders.get(i));
                    }
                }
            }
            current.setPosition(a);
            totalDistance += current.getDistance();
        }
    }
}