import java.util.ArrayList;
/**
 * Class Delivery runs the simulation 
 *
 * @author Cameron Zurmuhl
 * @version 5/3/2017 12:04 p.m
 */
public class Delivery
{
    private Grid City;
    
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
}
