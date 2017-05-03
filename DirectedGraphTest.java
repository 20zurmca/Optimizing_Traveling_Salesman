import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DirectedGraphTest.
 *
 * @author  Emmett O'Toole
 * @version 4-30-17
 * Additions Emmett O'Toole 2:48 P.M 5-2-17
 */
public class DirectedGraphTest
{
    /**
     * Tests the add Node, add Edge and getNeighbors method
     * 
     */
    @Test
    public void graphTest(){
        DirectedGraph test= new DirectedGraph();

        //create shops and add to nodes list
        Shop one=new Shop(1,new Location(10,10));
        Shop two =new Shop(2,new Location(20,20));
        Shop three=new Shop(3,new Location(30,30));
        Shop four=new Shop(4,new Location(40,40));
        assertEquals(test.addNode(one),true);
        assertEquals(test.addNode(two),true);
        assertEquals(test.addNode(three),true);
        assertEquals(test.addNode(four),true);

        //try to add a duplicate
        assertEquals(test.addNode(new Shop(1,new Location(10,10))),false);

        //add edge
        assertEquals(test.addEdge(one,two,5),true);
        assertEquals(test.addEdge(one,three,2),true);
        assertEquals(test.addEdge(two,three,6),true);
        assertEquals(test.addEdge(four,two,8),true);

        //obtain a facility from the graph
        assertEquals(test.getFacility(one),one);

        //try to obtain a non-existent facility 
        assertEquals(test.getFacility(new Shop(12,new Location(50,50))),null);

        //test closest neighbor 
        assertEquals(test.returnClosestNeighbor(one),three);
        assertEquals(test.returnClosestNeighbor(two),one);
    }

    /**
     * Tests create edges method
     * 
     */
    @Test
    public void edgesTest(){
        DirectedGraph test= new DirectedGraph();
        //create new shops 
        Shop one=new Shop(1,new Location(10,10));
        Shop two =new Shop(2,new Location(20,20));
        Shop three=new Shop(3,new Location(30,30));
        Shop four=new Shop(4,new Location(40,40));

        //add them as nodes
        assertEquals(test.addNode(one),true);
        assertEquals(test.addNode(two),true);
        assertEquals(test.addNode(three),true);
        assertEquals(test.addNode(four),true);
        //create edges 
        test.createEdges();

        //make sure everyone is connected properly 
        assertEquals(test.getEdgeWeight(one,two),20);
        assertEquals(test.getEdgeWeight(one,three),40);
        assertEquals(test.getEdgeWeight(one,four),60);
        assertEquals(test.getEdgeWeight(two,one),20);
        assertEquals(test.getEdgeWeight(two,three),20);
        assertEquals(test.getEdgeWeight(two,four),40);
        assertEquals(test.getEdgeWeight(three,one),40);
        assertEquals(test.getEdgeWeight(three,two),20);
        assertEquals(test.getEdgeWeight(three,four),20);
        assertEquals(test.getEdgeWeight(four,one),60);
        assertEquals(test.getEdgeWeight(four,two),40);
        assertEquals(test.getEdgeWeight(four,three),20);
    }

    /**
     * Test next shop
     */
    @Test
    public void nextShopTest(){
        DirectedGraph test= new DirectedGraph();
        //create new shops 
        Shop one=new Shop(1,new Location(10,10));
        Shop two =new Shop(2,new Location(20,20));
        Shop three=new Shop(3,new Location(30,30));
        Shop four=new Shop(4,new Location(40,40));
        //Add nodes
        test.addNode(one);
        test.addNode(two);
        test.addNode(three);
        test.addNode(four);
        //Adds cargo to all but four
        one.addCargo(new Cargo(10,one.getID(),1));
        two.addCargo(new Cargo(15,two.getID(),2));
        three.addCargo(new Cargo(20,three.getID(),3));
        //Adds edges
        test.addEdge(one,two,1);
        test.addEdge(one,three,2);
        test.addEdge(one,four,3);
        test.addEdge(two,three,4);
        test.addEdge(two,four,5);
        test.addEdge(three,four,6);
        //Creates warehouse and adds edges
        Warehouse a=new Warehouse(4,new Location(80,20),4);
        test.addNode(a);
        test.addEdge(a,one,1);
        test.addEdge(a,two,2);
        test.addEdge(a,three,3);
        test.addEdge(a,four,0);
        Truck testTruck=a.getNextTruck();
        //From warehouse to closest shop
        assertEquals(test.nextShop(a, testTruck),one);
        System.out.println(test.nextShop(a, testTruck));
        testTruck.setPosition(one);
        //Closest shop from the first shop
        assertEquals(test.nextShop(one,testTruck),two);
        System.out.println(test.nextShop(one,testTruck));
        testTruck.setPosition(two);
        //Closest shop from the  second shop
        assertEquals(test.nextShop(two,testTruck),three);
        System.out.println(test.nextShop(three,testTruck));
        testTruck.setPosition(three);

    }
}