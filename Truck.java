import java.util.ArrayList;
/**
 * Class Truck represents a Truck in the grid
 * A truck carries a certain amount of cargo to other shops
 * A truck originates from a Warehouse and returns to the same warehouse after delivery
 * 
 * @author Cameron Zurmuhl 
 * @version 4/23/2017 6:49 p.m
 * Revised by Cameron Zurmuhl 4/29/2017 3:27 p.m
 * Revised by Emmett O'Toole 4-30-17 9:03 p.m
 */
public class Truck
{
    //////////////////////FIELDS///////////////////////////////

    private Warehouse homeBase; //originating Warehouse

    private int cargoLimit = 500; //cargo limit for trucks

    private int currentWeight; //current weight of the truck

    private Facility currentPosition; //Facility truck is currently at

    private int distanceTravelled; //distance the truck travelled 

    private ArrayList<Facility> shopsVisited; //list of prior shops visited

    /**
     * Constructor for objects of class Truck
     * @param w the originating warehouse for the truck
     */
    public Truck(Warehouse w)
    {
        homeBase = w;
        shopsVisited = new ArrayList<>();
        currentPosition=w;
    }

    /////////////////////METHODS//////////////////////////////

    /**
     * Method loadCargo adds to this truck's weight
     * @param c cargo to add
     *@return boolean whether or not the load was successful
     */
    public boolean loadCargo(Cargo c)
    {
        if(currentWeight + c.getWeight() < cargoLimit ){ //addition of cargo must be lighter than weight limit
            currentWeight += c.getWeight();
            return true;
        }
        //System.out.println("Adding this cargo with weight " + c.getWeight() + " will make the truck too heavy");
        return false;
    }

    /**
     * Method get shopsVisited returns the list of shops visited
     * @return list of prior shops
     */
    public ArrayList<Facility> getprevShops()
    {
        return shopsVisited;
    }

    /**
     * Method gethomeBase returns this truck's originating Warehouse
     * @return the Warehouse the truck started at
     */
    public Warehouse getHomeBase()
    {
        return homeBase;
    }

    /**
     * Method setWeight sets this truck's cargo weight
     * @param w the weight to set on the truck
     */
    public void setWeight(int w)
    {
        if(w < cargoLimit && w > 0 ) //only set the weight if it's less than cargo limit but positive 
            currentWeight = w;
        return;
    }

    /**
     * Method getWeight gets this truck's cargo weight
     * @return the weight on the truck
     */
    public int getWeight()
    {
        return currentWeight;
    }

    /**
     * Method getDistance gets this trucks distance
     * @return the distance the truck went
     */
    public int getDistance()
    {
        return distanceTravelled; 
    }

    /**
     * Method setShop sets this truck's delivery shop
     * @param s the facility the truck is at
     */
    public void setPosition(Facility s)
    {
        //updates distance travelled
        distanceTravelled+=currentPosition.distanceFrom(s); 
        currentPosition = s; //this will be the new shop to deliver to 
        shopsVisited.add(s); //add shops to shops visited 
    }

    /**
     * Method planRoute plans the truck's delivery route 
     */
    public void planRoute()
    {
    }

    /**
     *Get postion method returns the facility the shop is at
     *@return Facility that the truck is at
     */
    public Facility getPosition(){
        return this.currentPosition;
    }

}