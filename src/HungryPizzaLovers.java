import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class HungryPizzaLovers {

	public static void main(String[] args) {
		int[][] arr = {{1,1}, {1,1}, {1,1}};
		System.out.println(permute(arr,arr.length));
	}
	
	// Function for finding maximum and value pair
    public static ArrayList<Integer> permute (int arr[][], int n) {
        PizzaOrder[] orders = new PizzaOrder[n];
    	// Create a PizzaOrder object such that the receiving time is the sum of the arrival time
        // of the order plus the time that is necessary to finalize it. Besides, we specify the 
        // index starting at 1
    	for (int i = 0;i < n;i++) {
        	orders[i] = new PizzaOrder(arr[i][0]+arr[i][1],i+1);
        }
    	// Sort orders by receiving time
    	Arrays.sort(orders,new OrderComparer());
    	// List of indices of the "orders" array
    	ArrayList<Integer> sequenceOrders = new ArrayList<>();
    	
    	for (int i = 0;i < n;i++) {
    		sequenceOrders.add(orders[i].index);
    	}
    	
    	return sequenceOrders;
    }
    // Object to represent an order whose attributes are the time when the clients are going to 
    // receive theirs orders and the index in the queue of orders
    public static class PizzaOrder {
    	public int receivingTime;
    	public int index;
    	
    	public PizzaOrder(int receivingTime, int index) {
    		this.receivingTime = receivingTime;
    		this.index = index;
    	}
    }
    // Comparator allowing to sort orders by receiving time
    public static class OrderComparer implements Comparator<PizzaOrder>{

		@Override
		public int compare(PizzaOrder o1, PizzaOrder o2) {
			if (o1.receivingTime > o2.receivingTime) {
				return 1;
			}else if (o1.receivingTime == o2.receivingTime) {
				return 0;
			}
			return -1;
		}
    	
    }

}
