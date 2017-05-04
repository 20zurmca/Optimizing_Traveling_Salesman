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
    private DirectedGraph grid; //the directed graph 

    private ArrayList<Shop> allShops; //all the shops in the graph

    private ArrayList<Warehouse> allWare; //all the warehouses in the graph 
    /**
     * Constructor for class Grid
     * @param shopFile the file containing the shops
     * @param wareFile the file containing the wareHouses
     */
    public Grid(String shopFile,String wareFile){
        grid= new DirectedGraph();
        allShops=new ArrayList<Shop>();
        allWare= new ArrayList<Warehouse>();
        createShops(shopFile);
        createWarehouse(wareFile);
        grid.createEdges();
    }

    /**
     * Method to create  shops by reading them from a file and adding them
     * To a graph and a list of shops
     * @param fileName the name of the file containing the shop information
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
            //Sorts all the lists of cargo for every shop
            for(int i=0;i<allShops.size();i++){
                allShops.get(i).sortOrders();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Method to create Warehouses by reading them from a file and adding them too a graph and a list of shops
     * @param fileName the name of the file to read from  
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
     * Get All shops method
     * @return all the shops on the grid 
     */
    public ArrayList<Shop> getShops(){
        return this.allShops;
    }

    /**
     * Get all ware method
     * @return the list of all warehouses 
     */
    public ArrayList<Warehouse> getWares(){
        return this.allWare;
    }

    /**
     * Method getGraph
     * @return the connected grid 
     */
    public DirectedGraph getGraph()
    {
        return grid;
    }

    /**
     * Method shopsSatisfied returns whether all the shops have had their orders fullfilled
     * @return whether all the shops have 0 entries for cargo 
     */
    public boolean shopsSatisfied()
    {
        int countEmptyShops = 0;
        for(Shop shop: allShops)
        {
            if(shop.isOrdersEmpty())
            {
                countEmptyShops++;
            }
        }
        return countEmptyShops == allShops.size() ? true: false;
    }

    /**
     * Method mainTrucksAvailable returns whether there are trucks in warehouses 1-9
     */
    public boolean mainTrucksAvailable()
    {
        int countWares = 0;
        for(int i = 0; i<allWare.size()-1; i++) //go through the list of warehouses and count those that still have available trucks
        {
            if(allWare.get(i).trucksLeft())
            {
                countWares++;
            }
        }
        return countWares != 0 ? true: false; 
    }
}