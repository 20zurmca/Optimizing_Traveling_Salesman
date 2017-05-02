import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Reads in the files and creates the grid
 * 
 * @author Emmett O'Toole
 * @version 4-30-17 9:27 P.M
 * Additions made by Cameron Zurmuhl 5/1/2017 11:32 p.m
 */
public class Grid{

    //Instance Variables
    private DirectedGraph grid;
    private ArrayList<Shop> allShops;
    private ArrayList<Warehouse> allWare;
    /**
     * Constructor for class Grid
     */
    public Grid(){
        grid= new DirectedGraph();
        allShops=new ArrayList<Shop>();
        allWare= new ArrayList<Warehouse>();
        createShops("shops.txt");
        createWarehouse("warehouses1.txt");
        addEdges();
    }
    
    public static void main(String [] args)
    {
        Grid G = new Grid();
        G.testEdgeWeights();
    }

    /**
     * Method to create  shops by reading them from a file and adding them
     * To a graph and a list of shops
     */
    public void createShops(String fileName){
        BufferedReader reader=null;
        try{
            //Initializes the new buffered reader
            reader= new BufferedReader(new FileReader(fileName));
            //Sets a string equal to the first line
            String line=reader.readLine();
            //Loop that runs while the reader has more lines
            while((line=reader.readLine())!=null){
                //Splits the line when these characters appear
                String[]words=line.split("[\\s\\D]+");
                //Creates a shop s with the characteristics of the given line
                Shop s=new Shop(Integer.parseInt(words[0]),new Location(Integer.parseInt(words[1]),Integer.parseInt(words[2])));
                //A loop that runs through all the possible amounts of cargo
                for(int i=3;i<words.length;i++){
                    s.addCargo(new Cargo(Integer.parseInt(words[i]),Integer.parseInt(words[0]),i-2));
                }
                //Adds the shop to the list of shops
                allShops.add(s);
                //Adds the shop to the list of nodes in the graph
                grid.addNode(s);
            }
            reader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Method to create Warehouses by reading them from a file and adding them
     * To a graph and a list of shops
     */
    public void createWarehouse(String fileName){
        BufferedReader reader=null;
        try{
            //Initializes the new buffered reader
            reader= new BufferedReader(new FileReader(fileName));
            //Sets a string equal to the first line
            String line=reader.readLine();
            //Loop that runs while the reader has more lines
            while((line=reader.readLine())!=null){
                //Splits the line when these characters appear
                String[]words=line.split("[\\s\\D]+");
                //Creates a Warehouse s with the characteristics of the given line
                Warehouse w=new Warehouse(Integer.parseInt(words[0]),new Location(Integer.parseInt(words[1]),Integer.parseInt(words[2])),Integer.parseInt(words[3]));
                //Adds the Warehouse to the list of shops
                allWare.add(w);
                //Adds the Warehouse to the list of nodes in the graph
                grid.addNode(w);
            }
            reader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Method addEdges adds all the edges needed in the graph
     */
    public void addEdges()
    {
        //connect every shop to every other shop
        
        for(int i = 0; i<allShops.size(); i++)
        {
            for(int j = i+1; j<allShops.size(); j++)
            {
                grid.addEdge(allShops.get(i), allShops.get(j), allShops.get(i).distanceFrom(allShops.get(j)));
            }
        }
        
        //add an edge begween every warehouse and every shop
        
        /*
        for(int i = 0; i<allWare.size(); i++)
        {
            for(int j = 0; j<allShops.size(); j++)
            {
                 grid.addEdge(allWare.get(i), allShops.get(j), allWare.get(i).distanceFrom(allShops.get(j)));
            }
        }
        */
        
    }
    
    public void testEdgeWeights()
    {
        
        for(int i = 0; i<allShops.size(); i++)
        {
            for(int j = i+1; j<allShops.size(); j++)
            {
               if(grid.getEdgeWeight(allShops.get(i), allShops.get(j)) == allShops.get(i).distanceFrom(allShops.get(j)))
                System.out.println("same");
               else
                System.out.println("diff");
            }
        }
        
        /*
        for(int i = 0; i<allWare.size(); i++)
        {
            for(int j = 0; j<allShops.size(); j++)
            {
                 if(grid.getEdgeWeight(allWare.get(i), allShops.get(j)) == allWare.get(i).distanceFrom(allShops.get(j)))
                System.out.println("same");
               else
                System.out.println("diff");
            }
        }
        */
        
    }

    /**
     * Get All shops method
     */
    public ArrayList<Shop> getShops(){
        return this.allShops;
    }

    /**
     * Get all ware method
     */
    public ArrayList<Warehouse> getWares(){
        return this.allWare;
    }
    
    /**
     * Method getGraph
     */
    public DirectedGraph getGraph()
    {
        return grid;
    }
}
