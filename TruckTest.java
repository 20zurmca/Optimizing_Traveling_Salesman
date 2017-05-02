

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TruckTest.
 *
 * @author  Cameron Zurmuhl
 * @version 4/23/2017 8:21 p.m
 * Revised by Cameron Zurmuhl 4/29/2017 3:23 p.m
 * Revised by Cameron Zurmuhl 4/30/2017 3:23 p.m
 */
public class TruckTest
{
    @Test
    public void testGetandSet()
    {
        Warehouse w = new Warehouse(57, new Location(23, 43),5);
        Truck t = new Truck(w);
        
        //test various get methods
        assertEquals(w, t.getHomeBase());
        assertEquals(t.getWeight(), 0);
        assertEquals(t.getDistance(), 0);
        
        //set the weight to something else
        t.setWeight(12);
        assertEquals(t.getWeight(), 12);
        
        //try to set the weight to above the capicty (should fail)
        t.setWeight(523);
        assertEquals(t.getWeight(), 12);
        
        //try to set the weight to negative (should not change)
        t.setWeight(-12);
        assertEquals(t.getWeight(), 12);
        
    }
    
    @Test
    public void testLoadCargo()
    {
        Warehouse w = new Warehouse(57, new Location(23, 43),5);
        Truck t = new Truck(w);
        
        t.loadCargo(new Cargo(50, 1, 5));
        
        //check get methods
        assertEquals(t.getWeight(), 50);
        
        //try to add above the weight and check to make sure weight stayed constant 
        t.loadCargo(new Cargo(470, 2, 4));
        assertEquals(t.getWeight(), 50);
    }
}
