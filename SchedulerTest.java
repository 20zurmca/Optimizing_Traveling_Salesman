
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
/**
 * The test class SchedulerTest.
 *
 * @author  Emmett O'Toole
 * @version 5-2-17 3:30 P.M
 */
public class SchedulerTest
{
    /**
     * Tests the schedule method
     */
    @Test
    public void scheduleTest(){
        Grid test=new Grid("shops.txt","warehouses1.txt");
        ArrayList<Warehouse> ware=test.getWares();
        ArrayList<Shop> shop=test.getShops();
        Scheduler.schedule(ware.get(1),test.getGraph());

    }
}
