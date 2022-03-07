import java.util.Arrays;

public class MaximizeSumArrayTimesIndex {

	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1};
		System.out.println(Maximize(arr,arr.length));
	}

	public static int Maximize(int arr[], int n) {
		// The array is sorted in order to maximize the sum is maximized
		Arrays.sort(arr);
		// The value to be returned is sum%(10^9+7). So 10^9+7 is the upper bound 
		// for the returned value
		long upperBound = (long) (Math.pow(10, 9)+7);
		// Variable to hold the maximal sum
        long maximalSum = 0;
        // Compute the maximal sum
        for (int i = 1;i < n;i++) {
        	// We cast the variables before performing the calculations in order 
        	// not to have calculations problems due to the limits of int data type
        	maximalSum += (((long) i)*((long) arr[i])) % upperBound;
        }
        
        return (int) (maximalSum%upperBound);
    }
	
}
