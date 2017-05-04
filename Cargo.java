
/**
 * A class that represents a piece of cargo 
 *
 * @author Cameron Zurmuhl 
 * @version 4/23/2017 5:38 p.m
 * Revised by Cameron Zurmuhl 4/29/2017 3:21 p.m
 * Revised by Cameron Zurmuhl 4/30/2017 12:34 p.m
 */
public class Cargo implements Comparable <Cargo>
{
    ///////////////FIELDS/////////////////////

    private int weight; //the weight of the cargo

    private int shopID; //the ID the cargo must go to 

    private int cargoID; //the ID of the cargo

    /**
     * Constructor for class Cargo 
     * @param w the weight of the cargo
     * @param shopID the ID of the shop
     * @param cargoID the ID of the cargo
     */
    public Cargo(int w, int shopID, int cargoID)
    {
        this.weight = w;
        this.shopID = shopID;
        this.cargoID = cargoID;
    }

    //////////////METHODS//////////////////

    /**
     * Method getWeight returns this Cargo's weight 
     * @return this cargo's weight
     */
    public int getWeight()
    {
        return weight;
    }

    /**
     * Method setWeight sets this Cargo's weight
     * @param w this cargo's new weight
     */
    public void setWeight(int w)
    {
        weight = w;
    }

    /**
     * Method getShopID returns the cargo's shop ID
     * @return this cargo's shop ID
     */
    public int getShopID()
    {
        return shopID;
    }

    /**
     * Method getCargoID returns the cargo's ID
     * @return this cargo's ID
     */
    public int getCargoID()
    {
        return cargoID;
    }

    @Override
    public String toString()
    {
        return String.valueOf(weight);
    }

    /**
     *Method Compare to compares two cargos
     *@return int the value based on the comparison
     */
    @Override
    public int compareTo(Cargo c){
        if(this.weight>c.getWeight()){
            return 1;
        }
        else if(this.weight<c.getWeight()){
            return -1;
        }
        else {
            return 0;
        }

    }
}