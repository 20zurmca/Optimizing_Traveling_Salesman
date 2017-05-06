import java.util.ArrayList;
/**
 * Class Delivery runs the simulation 
 *
 * @author Cameron Zurmuhl
 * @version 5/3/2017 12:04 p.m
 */
public class Delivery
{
    private Grid City; //the city of operations

    /**
     * Constructor for class Delivery 
     * @param file1 the first file to read in for the grid (warehouses)
     * @param file2 the second file to read in for the gird (shops)
     */
    public Delivery(String file1, String file2)
    {
        City = new Grid(file1,file2); //the grid the city is on 
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
        ArrayList <Warehouse> allWares = City.getWares(); //get all the warehouses 
        while(City.mainTrucksAvailable()){ //while warehouses 1-9 have trucks, dispatch one truck at a time, per warehouse  
           for(int i = 0; i<allWares.size();i++)
            {
                if(allWares.get(i).trucksLeft()){ //dispatch trucks from those warehouses, alternating one at a time per warehouse 
                    sc.schedule(allWares.get(i), City);
                }
            }
        }
       
        
        while(!City.shopsSatisfied()) //only use master warehouse when all other trucks have been exaughsted 
        {
            sc.schedule(allWares.get(allWares.size()-1), City);
        }
        System.out.println("-----------------------------------RESULTS----------------------------------------");
        System.out.println("The total distance travelled by all the trucks is: " + sc.getDistance()); //total distance 
    }

    public Grid getCity()
    {
        return City;
    }
}
