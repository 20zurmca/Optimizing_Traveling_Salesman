import java.util.ArrayList;
/**
 * Class Delivery runs the simulation 
 *
 * @author Cameron Zurmuhl
 * @version 5/3/2017 12:04 p.m
 */
public class Delivery
{
    private Grid City; //the city of operation s
    
    /**
     * Constructor for class Delivery 
     */
    public Delivery()
    {
        City = new Grid("shops.txt","warehouses2.txt"); //the gird the city is on 
    }
    
    public static void main(String [] args)
    {
        Delivery de = new Delivery();
        de.simulate();
        if(de.getCity().shopsSatisfied()){
            System.out.println("All shops have been satisfied");
        }
    }
    
    public void simulate()
    {
        Scheduler sc = new Scheduler();
        ArrayList <Warehouse> allWares = City.getWares();
        for(int i = 0; i<allWares.size(); i++)
        {
            sc.schedule(allWares.get(i), City);
        }
        System.out.println(sc.getDistance());
    }
    
    private Grid getCity()
    {
        return City;
    }
}
