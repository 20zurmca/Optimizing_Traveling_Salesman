
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ShopTest.
 *
 * @author  Emmett O'Toole
 * @version 4-29-17
 */
public class ShopTest
{
    /**
     * Test The distance from method
     */
    @Test
    public void testDistanceFrom(){
        Shop one=new Shop(1,new Location(5,10));
        Shop two=new Shop(2,new Location(20,20));
        Shop three=new Shop(3,new Location(54,35));
        Shop four=new Shop(4,new Location(76,20));
        Shop five=new Shop(5,new Location(80,80));
        Shop six=new Shop(6,new Location(95,1));
        //Distance between Shop one and two
        assertEquals(one.distanceFrom(two),25);
        assertEquals(two.distanceFrom(one),25);
        //Distance between three and four
        assertEquals(three.distanceFrom(four),37);
        assertEquals(four.distanceFrom(three),37);
        //Distance between five and six
        assertEquals(five.distanceFrom(six),94);
        assertEquals(six.distanceFrom(five),94);
    }
}
