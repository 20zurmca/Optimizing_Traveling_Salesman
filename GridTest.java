
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
/**
 * The test class GridTest.
 *
 * @author  Emmett O'Toole and Cameron Zurmuhl
 * @version 5-1-17 8:57 P.M
 */
public class GridTest
{
    /**
     * Test for the createShops method
     */
    @Test
    public void testCreateShops(){
        Grid test=new Grid();
        test.createShops("shops.txt");
        test.createWarehouse("warehouses1.txt");
        ArrayList<Shop>shopTest=test.getShops();
        ArrayList<Warehouse>wareTest=test.getWares();
        for(Shop a:shopTest){
            System.out.println("Shop ID:"+" "+a.getID()+" "+a.getLocation().getX()+" "+a.getLocation().getY());

        }
        for(Warehouse a:wareTest){
            System.out.println("Ware ID:"+a.getID()+" "+a.getLocation().getX()+" "+a.getLocation().getY());

        }
    }
}