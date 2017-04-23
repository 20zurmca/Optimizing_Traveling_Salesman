
/**
 * A class that represents a piece of cargo 
 *
 * @author Cameron Zurmuhl 
 * @version 4/23/2017 5:38 p.m
 */
public class Cargo
{
    ///////////////FIELDS/////////////////////
    
    private int weight; //the weight of the cargo
    
    /**
     * Constructor for class Cargo 
     * @param w the weight of the cargo
     */
    public Cargo(int w)
    {
        this.weight = w;
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
}
