import java.util.Arrays;

public class RajuAndCoins {

	public static void main(String[] args) {
		int[] a = {5, 6, 7, 8};
		System.out.println(maxNumbers(a.length,25,a));
	}

	static int maxNumbers(int n, int k, int a[]){
        // Since we want to prioritize the lowest numbers in order to maximize the amount of 
		// selected numbers, we also sort the array
		Arrays.sort(a);
        
        int currentSum = 0;
        // Counter for the amount of numbers that have been selected to participate of the sum
        int counter = 0;
        // Number that is being checked in order to determine if it should participate in the sum
        int currentNumber = 1;
        // Index of the array of the first number that have not been seen yet
        int arrayIndex = 0;
        
        while (currentSum + currentNumber <= k) {
        	// If the current number is in the array, move "arrayIndex" and go to the next number
        	if ((arrayIndex < n) && (a[arrayIndex] == currentNumber)) {
        		arrayIndex++;
        	// If the current number is not in the array, add it to the sum
        	}else {
            	currentSum += currentNumber;
            	counter++;	
        	}
        	currentNumber++;
        }
        
        return counter;
    }
	
}
