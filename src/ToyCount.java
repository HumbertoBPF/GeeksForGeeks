import java.util.Arrays;

public class ToyCount {

	public static void main(String[] args) {
		int arr[] = {20, 30, 50};
		System.out.println(toyCount(arr.length,100,arr));
	}

	static int toyCount(int N, int K, int arr[]) {
        // Sort the toys by price
		Arrays.sort(arr);
        
        int spentMoney = 0;
        int numberOfToysBought = 0;
        // Buy a toy still there are no toys available anymore or until there is no enough budget 
        while (numberOfToysBought < N && spentMoney+arr[numberOfToysBought] <= K) {
        	spentMoney += arr[numberOfToysBought];
        	numberOfToysBought++;
        }
        
        return numberOfToysBought;
    }
	
}
