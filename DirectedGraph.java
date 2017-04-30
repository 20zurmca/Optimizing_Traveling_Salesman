import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
/**
 *A DirectedGraph class
 *@author Cameron Zurmuhl
 *@version 4/29/2017 3:59 p.m
 */
public class DirectedGraph
{
    //////////////////////////////////INNER CLASSES/////////////////////////////////////////////
    /**
     * Class DirectedGraphNode is an inner class that repersent the verticies in the graph
     */
    private static class DirectedGraphNode implements Comparable<DirectedGraphNode>
    {
        /////////////////////////////FIELDS////////////////////////////////
        Facility f ; //the node's facility 
        boolean visited = false; //boolean for traversal
        ArrayList<DirectedGraphEdge> outgoingEdges; //list of outgoing edges

        /**
         * Constructor for class DirectedGraphNode<K>
         * @param facility the facility for the node
         */
        public DirectedGraphNode(Facility f)
        {
            this.f =f;
            outgoingEdges = new ArrayList<>();
        }

        /////////////////////////////METHODS////////////////////////////////

        /**
         * Method returnClosestNeighbor returns the closest vertex to this vertex
         * Closest is in a weighted sense
         * @return the closest neighbor
         */
        public String returnClosestNeighbor()
        {
            //if the node has no closest neighbor, return null
            if(outgoingEdges.isEmpty())
            {
                return null;
            } else { //Sort the outgoing edges list and return the first entry's endingNode
                Collections.sort(outgoingEdges);
                return outgoingEdges.get(0).toString();
            }
        }

        /**
         * Method returnSortedEdges sorts the node's outgoing edges by weight
         * @return a sorted array of edges
         */
        public ArrayList<DirectedGraphEdge> returnSortedEdges()
        {
            Collections.sort(outgoingEdges);
            return outgoingEdges;
        }

        @Override
        public int compareTo(DirectedGraphNode n)
        {
            if(this.f.getID() == n.f.getID()){return 0;}
            else if (this.f.getID() < n.f.getID()) {return -1;}
            else { return 1;}
        }

        @Override
        public boolean equals(Object o) {

            // If the object is compared with itself return true  
            if (o == this) {
                return true;
            }
            //if o is not an instance of DirectedGraphNode, return false
            if (!(o instanceof DirectedGraphNode)) {
                return false;
            }
            // cast o to DirectedGraphNode to compare data members 
            DirectedGraphNode c = (DirectedGraphNode) o;
            return this.f.equals(c.f);
        }
    }

    /**
     * Class DirectedGraphEdge is an inner class that represents the edges in a graph
     */
    private static class DirectedGraphEdge implements Comparable<DirectedGraphEdge>
    {
        //////////////////////////////FIELDS/////////////////////////////////////////
        DirectedGraphNode startingNode; //starting node of the edge
        DirectedGraphNode endingNode; //ending node of the edge
        boolean traversed = false; //variable that states whether a truck has passed on this edge
        int weight; //the weight of the graph

        /**
         * Constructor for class DirectedGraphEdge
         * @param startingNode the starting node
         * @param endingNode the ending node
         * @param w the weight of the edge
         */
        public DirectedGraphEdge (DirectedGraphNode startingNode, DirectedGraphNode endingNode, int w)
        {
            this.startingNode = startingNode;
            this.endingNode = endingNode;
            weight = w;

            //add this edge to startingNode's outgoing edge list
            startingNode.outgoingEdges.add(this);
            //add this edge to endingNode's outgoing edge list
            endingNode.outgoingEdges.add(this);
        }

        @Override
        public int compareTo(DirectedGraphEdge de)
        {
            if(this.weight == de.weight) {return 0;}
            else if(this.weight < de.weight ) { return -1;}
            else { return 1;}
        }
    }

    ///////////////////////////////OUTTER ClASS////////////////////////////////////////////////////

    ///////////////////////////////////FIELDS//////////////////////////////////////////////////////

    private ArrayList<DirectedGraphNode> allNodes; //keeps track of all nodes in the graph

    /**
     * Constructor for class DirectedGraph
     */
    public DirectedGraph()
    {
        allNodes = new ArrayList<>();
    }

    ///////////////////////////////METHODS//////////////////////////////////////////////////////////////

    /**
     * Method addNode adds a node to the graph with facility f
     * Facility should be unique or node should not be added and method should return false
     * @param f the facilityh of the added node
     * @return whether insertion was successful
     */
    public boolean addNode(Facility f)
    {
        //create a new Node
        DirectedGraphNode newNode = new DirectedGraphNode(f); 
        //safe to add--binary search for the node and add where appropriate
        int i = Collections.binarySearch(allNodes, newNode); //binary search for number
        if(i < 0){
            allNodes.add(-i-1, newNode); //take negative of value and subtract 1
            return true;
        } else {
            return false; //number is in the array
        }
    }

    /**
     * Method addEdge adds an edge from the node with facility one to the node with facility two and weight w.
     * Edge should not be added if either nodes do not exist.
     * If edge already exists, simply change its weight
     * @param one the key of the starting node
     * @param two the key of the second node
     * @param w the weight of the edge
     * @returns true if the edge is successfully added. 
     */
    public boolean addEdge(Facility one, Facility two, int w )
    {
        //check if both vertices are in the node's list
        DirectedGraphNode startingNode = getVertex(one);
        DirectedGraphNode endingNode = getVertex(two);

        if(startingNode == null || endingNode == null )
        {
            return false;
        }

        //check if there is an existent edge between the vertices.  If there is, change the weight
        DirectedGraphEdge potentialEdge = getEdge(one, two);
        if(potentialEdge != null)
        {
            potentialEdge.weight = w; //change the weight
            return true; 
        }

        //last case: no edge between the vertices, create new edge
        DirectedGraphEdge newEdge = new DirectedGraphEdge(startingNode, endingNode, w);
        return true;
    }

    /**
     * Method getNeighbors returns an arrayList of Facilities containing all the neighbors f can reach in one hop
     * @return the list of neighbors 
     */
    public ArrayList<String> getNeighbors(Facility f)
    {
        DirectedGraphNode startingNode = getVertex(f); //get the starting vertex 
        ArrayList<DirectedGraphEdge> neighborEdges = startingNode.returnSortedEdges();
        ArrayList<String> neighbors = new ArrayList<String>();
        for(DirectedGraphEdge edge : neighborEdges)
        {
            neighbors.add(edge.endingNode.f.toString());
        }
        return neighbors;
    }

    /**
     * Method breadthFirstClosest
     * prints out the closest neighbor each node in the graph can reach in one hop, using breadth first order
     * @param f the facility of the vertex to start at
     */
    public void breadthFirstClosest(Facility f)
    {
        //set all node instance variables to false so I can call method multiple times
        for(DirectedGraphNode  node : allNodes)
        {
            if(node.visited)
            {
                node.visited = false;
            }
        }

        //obtain the vertex, if applicable
        DirectedGraphNode startingVertex = getVertex(f);
        if(startingVertex == null ) {return;} //can't traverse 

        //initialize queue
        Queue <DirectedGraphNode> q = new LinkedList<>();
        q.add(startingVertex);
        startingVertex.visited = true;

        //start enqueue/dequeue process
        while(!q.isEmpty())
        {
            DirectedGraphNode u = q.poll();
            System.out.println(u.f.toString() + " " + u.returnClosestNeighbor()); //print closest neighbor 
            //enqueue all neighbors, if not already enqueued 
            for(DirectedGraphEdge edge: u.outgoingEdges) //for every outgoing edge
            {
                if(!edge.endingNode.visited) //if the ending node is not already visited
                {
                    edge.endingNode.visited = true;
                    q.add(edge.endingNode); //enqueue 
                }
            }
        }
    }

    /**
     * Method getVertex searches the allNodes ArrayList via binary search for the node with a given key
     * @param f the facility of the node to search for
     * @return the node with that facility (null if non existent)
     */
    private DirectedGraphNode getVertex(Facility f)
    {
        int i = Collections.binarySearch(allNodes, new DirectedGraphNode(f));
        return i < 0 ? null : allNodes.get(i);
    }

    /**
     * Method getEdge returns the edge that connects two vertices, or null if there is none
     * @param f1 the key of the starting node
     * @param f2 the key of the second node
     * @return the edge connecting them
     */
    public DirectedGraphEdge getEdge(Facility f1, Facility f2)
    {
        //check if both vertices exit
        DirectedGraphNode startingVertex = getVertex(f1);
        DirectedGraphNode  endingVertex = getVertex(f2);
        if(startingVertex == null || endingVertex == null )
        {
            return null; //one or more vertex does not exist -- cannot have an edge
        }

        //Case 2: Find the edge that connects the starting vertex to the ending vertex 
        for(DirectedGraphEdge edge : startingVertex.outgoingEdges )
        {
            if(edge.endingNode.equals(endingVertex))
            {
                return edge;
            }
        }
        return null; //no edge connects them 
    }

    /**
     * Method getEdgeWeight returns and edge's weight
     * @param edge the edge to examine
     * @return its weight
     */
    public int getEdgeWeight(Facility one, Facility two)
    {
        return getEdge(one,two).weight;
    }

    /**
     * Method returnClosestNeighbor returns the closest vertex to the passed paramater
     * Closest is in a weighted sense
     * @param f the facility of the vertex to examine
     * @return the closest neighbor to key
     */
    public String returnClosestNeighbor(Facility f)
    {
        DirectedGraphNode node = getVertex(f); //get the node that goes with the key
        return node.outgoingEdges.size() == 0 ? null: node.returnClosestNeighbor(); //return null, if applicable, or that node's closes neighbor's key
    }
}
