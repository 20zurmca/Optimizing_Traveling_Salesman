
/**
 *Experiment controller tests the delivery in different cases
 * 
 * @author Emmett O'Toole 
 * @version 5-6-17
 */
public class EmmettExperimentController
{
    public static void main(String[]args){
        EmmettExperimentController e= new EmmettExperimentController();
        e.run();
    }

    public void run(){
        //Test 1
        //Tests the case where there is a single warehouse and 5 shops
        //Each needing one cargo of weight 500
        //This is the simplest case
        Delivery test1=new Delivery("shopsTest1.txt","warehouseTest1.txt");
        test1.simulate();
        System.out.println("Expected Value: 480");
        //Test 2
        //This test checks what would happen if two warehouses
        //Had a cluster of shops around them
        //The method should have these two warehouses only satisfy the shops
        //Around them
        Delivery test2=new Delivery("shopsTest2.txt","warehouseTest2.txt");
        test2.simulate();
        System.out.println("Expected Value: 126");
        //Test 3
        //Tests to make sure that trucks are not being popped and then not used
        //Also tests that the warehouse very close to a cluster of shops
        //Fulfills these shops as much as possible before
        //A warehouse far away from this begins to fulfill them
        Delivery test3=new Delivery("shopsTest3.txt","warehouseTest3.txt");
        test3.simulate();
        System.out.println("Expected Value: 800");
    }
}
