
/**
 * Class Truck represents a Truck in the grid
 * A truck carries a certain amount of cargo to other shops
 * A truck originates from a Warehouse and returns to the same warehouse after delivery
 * 
 * @author Cameron Zurmuhl 
 * @version 4/23/2017 6:49 p.m
 */
public class Truck
{
    //////////////////////FIELDS///////////////////////////////

    private Warehouse homeBase; //originating Warehouse

    private int cargoLimit = 500; //cargo limit for trucks

    private int currentWeight; //current weight of the truck

    private Shop shopToDeliver; //shop to deliver to 

    private int distanceTravelled; //distance the truck travelled 
    
    private int numCargo; //number of cargo pieces on the truck

    /**
     * Constructor for objects of class Truck
     * @param w the originating warehouse for the truck
     */
    public Truck(Warehouse w)
    {
        homeBase = w;
    }

    /////////////////////METHODS//////////////////////////////

    /**
     * Method loadCargo adds to this truck's weight
     * @param c cargo to add
     */
    public void loadCargo(Cargo c)
    {
        if(currentWeight + c.getWeight() < cargoLimit ) //addition of cargo must be lighter than weight limit
            currentWeight += c.getWeight();
        numCargo++; //update cargo count
    }
    
    /**
     * Method getCargoCount returns how many pieces of cargo are on the truck
     * @return numCargo
     */
    public int getCargoCount()
    {
        return numCargo;
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
        if(w < cargoLimit ) //only set the weight if it's less than cargo limit
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
     * Method setDistance sets this trucks distance
     * @param d the distance the truck went
     */
    public void setDistance(int d )
    {
        distanceTravelled = d;
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
     * Method getShop gets this truck's delivery shop
     * @return this truck's shop its going to 
     */
    public Shop getShop()
    {
        return shopToDeliver;

    }
    
    /**
     * Method setShop sets this truck's delivery shop
     * @param s the shop to deliver to 
     */
    public void setShop(Shop s)
    {
        shopToDeliver = s;
    }
}
