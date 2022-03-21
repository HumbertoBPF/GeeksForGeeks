import java.util.ArrayList;
import java.util.Arrays;

public class ShopInCandyStore {

	public static void main(String[] args) {
		int[] candies = {3,2,1,4,5};
		System.out.println(candyStore(candies,candies.length,0));
	}
	
	static ArrayList<Integer> candyStore(int candies[],int N,int K){
		ArrayList<Integer> minimumAndMaximumSpents = new ArrayList<>();
		Arrays.sort(candies);

		int minimumSpent = 0;
		int maximumSpent = 0;
		
		int leftPointer = 0;
		int rightPointer = N - 1;
		
		while (rightPointer - leftPointer >= 0) {
			// For the minimum spent, we want to buy the cheapest candies and to get the most expensive ones for free
			minimumSpent += candies[leftPointer];
			// For the minimum spent, we want to buy the most expensive candies and to get the cheapest ones for free
			maximumSpent += candies[N - 1 - leftPointer];
			// Increment of one unit leftPointer since it represents the candy bought
			leftPointer++;
			// Decrement of K units rightPointer since it represents the candy gotten for free
			rightPointer-=K;
		}
		
		minimumAndMaximumSpents.add(minimumSpent);
		minimumAndMaximumSpents.add(maximumSpent);
		
		return minimumAndMaximumSpents;
    }

}
