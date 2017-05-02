import java.util.ArrayList;
/**
 * Write a description of class Scheduler here.
 * 
 * @author Emmett O'Toole 
 * @version 3:06 P.M 5-2-17
 */
public class Scheduler
{
    public static void schedule(Warehouse a,DirectedGraph grid){
        //All the facilities
        ArrayList<Facility>allF=grid.getNeighbors(a);
        ArrayList<Facility> shops=new ArrayList<Facility>();
        //Loop puts all shops into separate arrayList
        for(int i=0;i<allF.size();i++){
            if(allF.get(i).getChar().equals('S')){
                shops.add(allF.get(i));
            }
        }
        for(Facility s:shops){
            
            System.out.println("Shop:"+" "+s.toString()+" Distance "+s.distanceFrom(a));
        }
        for(Facility s:allF){
            System.out.println("Facilities"+" "+s.toString());
        }
        System.out.println(shops.size());
        System.out.println(allF.size());
    }
}
