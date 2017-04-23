

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LocationTest.
 *
 * @author  Emmett O'Toole
 * @version 4-23-17
 */
public class LocationTest
{
    /**
     * Tests the distance method for location
     */
    @Test
    public void distanceTest(){
        Location one=new Location(1,1);
        Location two=new Location(100,100);
        Location three=new Location(50,50);
        Location four=new Location(23,35);
        Location five=new Location(73,31);
        Location six=new Location(6,7);
        //Distance Between one and two
        assertEquals(one.distance(two),198);
        assertEquals(two.distance(one),198);
        //Distance Between three and four
        assertEquals(three.distance(four),42);
        assertEquals(four.distance(three),42);
        //Distance between five and six
        assertEquals(five.distance(six),91);
        assertEquals(six.distance(five),91);
    }
}