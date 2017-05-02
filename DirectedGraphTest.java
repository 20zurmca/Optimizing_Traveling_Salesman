
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
        Shop one=new Shop(1,new Location(10,10));
        Shop two =new Shop(2,new Location(20,20));
        Shop three=new Shop(3,new Location(30,30));
        Shop four=new Shop(4,new Location(40,40));
        assertEquals(test.addNode(one),true);
        assertEquals(test.addNode(two),true);
        assertEquals(test.addNode(three),true);
        assertEquals(test.addNode(four),true);
        assertEquals(test.addNode(new Shop(1,new Location(10,10))),false);
        assertEquals(test.addEdge(one,two,5),true);
        assertEquals(test.addEdge(one,three,2),true);
        assertEquals(test.addEdge(two,three,6),true);
        assertEquals(test.addEdge(four,two,8),true);
        assertEquals(test.getFacility(one),one);
        assertEquals(test.getFacility(new Shop(12,new Location(50,50))),null);
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
        Shop one=new Shop(1,new Location(10,10));
        Shop two =new Shop(2,new Location(20,20));
        Shop three=new Shop(3,new Location(30,30));
        Shop four=new Shop(4,new Location(40,40));
        assertEquals(test.addNode(one),true);
        assertEquals(test.addNode(two),true);
        assertEquals(test.addNode(three),true);
        assertEquals(test.addNode(four),true);
        test.createEdges();
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
}