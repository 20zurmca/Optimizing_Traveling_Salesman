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

        ArrayList<Shop>shopTest=test.getShops();
        ArrayList<Warehouse>wareTest=test.getWares();
        for(Shop a:shopTest){
            System.out.println("Shop ID:"+" "+a.getID()+" "+a.getLocation().getX()+" "+a.getLocation().getY());
        }
        for(Warehouse a:wareTest){
            System.out.println("Ware ID:"+a.getID()+" "+a.getLocation().getX()+" "+a.getLocation().getY());
        }

        //test that the array lists are of proper size
        assertEquals(shopTest.size(), 200);
        assertEquals(wareTest.size(), 10);
    }

    @Test
    public void testEdges()
    {
        Grid test = new Grid();
        ArrayList<Shop>shopTest=test.getShops();
        ArrayList<Warehouse>wareTest=test.getWares();

        //Edge Weights should be the same as distance between facilities 
        
        //checking warehouses between shops
       
        for(int i = 0; i<wareTest.size(); i++)
        {
            for(int j = 0; j<shopTest.size(); j++)
            {
                //assertEquals(test.getGraph().getEdgeWeight(wareTest.get(i), shopTest.get(j)), wareTest.get(i).distanceFrom(shopTest.get(j)));
            }
        }
        
        
        //checking shops between shops
        
        for(int i = 0; i<shopTest.size(); i++)
        {
            for(int j = i+1; j<shopTest.size(); j++)
            {
                //assertEquals(test.getGraph().getEdgeWeight(shopTest.get(i),shopTest.get(j)), shopTest.get(i).distanceFrom(shopTest.get(j)));
            }
        }
        

        
    }
}