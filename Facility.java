
/**
 * The interface facility can represent any building
 * For this project this will mean a warehouse or a shop
 * 
 * @author Emmett O'Toole 
 * @version (4-23-17
 */
public interface Facility
{
    /**
     * Distance from method
     * 
     * @param  Facility any    A facility from which to calculate the distance
     * @return  int   The distance between the two facilities
     */
    int distanceFrom(Facility any);
    
    /**
     * Get id method
     * Every facility must be able to get a unique id for that facility
     * @return int    The id of the facility 
     */
    int getID();
    
    /**
     * Get location method
     * Every facility must be able to get it's location
     * @return Location     The location of the facility
     */
    Location getLocation();
}
