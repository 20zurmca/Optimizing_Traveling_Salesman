
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WarehouseTest.
 *
 * @author  Emmett O'Toole
 * @version 4-23-17
 */
public class WarehouseTest
{
    /**
     * Test The distance from method
     */
    @Test
    public void testDistanceFrom(){
        Warehouse one=new Warehouse(1,new Location(5,10),5);
        Warehouse two=new Warehouse(2,new Location(20,20),10);
        Warehouse three=new Warehouse(3,new Location(54,35),8);
        Warehouse four=new Warehouse(4,new Location(76,20),5);
        Warehouse five=new Warehouse(5,new Location(80,80),16);
        Warehouse six=new Warehouse(6,new Location(95,1),3);
        //Distance between warehouse one and two
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