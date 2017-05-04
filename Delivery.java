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
     * @param file1 the first file to read in for the grid
     * @param file2 the second file to read in for the gird
     */
    public Delivery(String file1, String file2)
    {
        City = new Grid(file1,file2); //the gird the city is on 
    }
    
    public static void main(String [] args)
    {
        Delivery de = new Delivery(args[0], args[1]);
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
