/**
 **
 * The interface facility can represent any building
 * For this project this will mean a warehouse or a shop
 * 
 * @author Emmett O'Toole 
 * @version (4-23-17)
 * Revised by Cameron Zurmuhl 4/30/2017 4:27
 */
public abstract class Facility implements Comparable <Facility>
{
    protected int ID; //numerical id for the facility 
    
    protected Character letter; //character ID (W or S)
    
    protected Location facilityLoc; //location of facility 
    /**
     * Constructor for class Facility
     * @param ID the ID for the Facility
     * @param identifier the character identifier 
     */
    public Facility(int id, Character identifier)
    {
        this.ID = id;
        letter = identifier;
    }
    
    /**
     * Distance from method
     * 
     * @param any A facility from which to calculate the distance
     * @return the distance between the two facilities
     */
    public abstract int distanceFrom(Facility any);

    /**
     * Get id method
     * Every facility must be able to get a unique id for that facility
     * @return the numberical ID of the facility 
     */
    public int getID()
    {
        return ID;
    }

    /**
     * Get location method
     * Every facility must be able to get it's location
     * @return the location of the facility
     */
    public abstract Location getLocation();

    @Override
    public int compareTo(Facility l)
    {
        if(this.letter.compareTo(l.letter) == 0){
            if(this.ID < l.ID){
                return -1;
            } else if (this.ID > l.ID){
                return 1;
            } else {
                return 0;
            }
        } else{
            if(this.ID < l.ID){
                return -1;
            } else if (this.ID > l.ID){
                return 1;
            } else {
                return this.letter.compareTo(l.letter);
            }
        }
    }
    
    /**
     * Get char method
     * Returns the char for a facility
     * @return the letter that represents either a warehouse or a shop
     */
    public Character getChar(){
        return this.letter;
    }
}