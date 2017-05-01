import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DirectedGraphTest.
 *
 * @author  Emmett O'Toole
 * @version 4-30-17
 * Revised by Cameron Zurmuhl 4/20/2017 10:33 p.m
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
        //add four shops
        Shop one=new Shop(1,new Location(10,10));
        Shop two =new Shop(2,new Location(20,20));
        Shop three=new Shop(3,new Location(30,30));
        Shop four=new Shop(4,new Location(40,40));
        assertEquals(test.addNode(one),true);
        assertEquals(test.addNode(two),true);
        assertEquals(test.addNode(three),true);
        assertEquals(test.addNode(four),true);
        
        //make sure one shop cannot be added twice
        assertEquals(test.addNode(four), false);
        assertEquals(test.addNode(new Shop(1,new Location(10,10))),false);
        
        //add edges between nodes 
        assertEquals(test.addEdge(one,two,5),true);
        assertEquals(test.addEdge(one,three,2),true);
        assertEquals(test.addEdge(two,three,6),true);
        assertEquals(test.addEdge(four,two,8),true);
   
        
        //test that we can aquire a facility 
        assertEquals(test.getFacility(new Shop(12,new Location(50,50))),null); //should not return anything since this facility is not in the graph
        assertEquals(test.getFacility(one), one); //return facility one
        
        //test return closest neighbor for all nodes 
        assertEquals(test.returnClosestNeighbor(one),three);
        assertEquals(test.returnClosestNeighbor(two),one);
        assertEquals(test.returnClosestNeighbor(three), one);
        assertEquals(test.returnClosestNeighbor(four), two);
        
        //check each's node's neighborhood set size
        assertEquals(test.getNeighbors(one).size(), 2 );
        assertEquals(test.getNeighbors(two).size(), 3 );
        assertEquals(test.getNeighbors(three).size(), 2 );
        assertEquals(test.getNeighbors(four).size(), 1 );
        
        //Check that the first vertex in the neighborhood list is the closest neighbor (tests if sorting is working)
        assertEquals(test.getNeighbors(one).get(0), three);
        assertEquals(test.getNeighbors(two).get(0), one);
        assertEquals(test.getNeighbors(three).get(0), one);
        assertEquals(test.getNeighbors(four).get(0), two);
        
        //check that we can obtain each edge's weight
        assertEquals(test.getEdgeWeight(one, two), 5);
        assertEquals(test.getEdgeWeight(two, one), 5);
        assertEquals(test.getEdgeWeight(one, three), 2);
        assertEquals(test.getEdgeWeight(three, one), 2);
        assertEquals(test.getEdgeWeight(two, three), 6);
        assertEquals(test.getEdgeWeight(three, two), 6);
        assertEquals(test.getEdgeWeight(four, two), 8);
        assertEquals(test.getEdgeWeight(two, four), 8);
        assertEquals(test.getEdgeWeight(four, one), -1); //edge does not exist
        
        //do a breadthFirstClosest search
        test.breadthFirstClosest(one);
    }
}