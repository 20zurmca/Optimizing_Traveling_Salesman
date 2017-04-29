

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CargoTest.
 *
 * @author  Cameron Zurmuhl 
 * @version 4/23/2017 5:48 p.m
 */
public class CargoTest
{
    @Test
    public void testGetandSet()
    {
        //create new Cargo
        
        Cargo c = new Cargo(10, "Beans", "Shop3");
        
        //get the weight and assert that it's 10
        assertEquals(c.getWeight(), 10);
        
        //change the weight
        c.setWeight(20);
        
        //assert that it changed
        assertEquals(c.getWeight(), 20);
    }
}
