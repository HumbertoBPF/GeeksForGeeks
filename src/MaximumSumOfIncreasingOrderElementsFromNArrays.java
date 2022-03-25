
public class MaximumSumOfIncreasingOrderElementsFromNArrays {

	public static void main(String[] args) {
		int arr[][] = {{9,8,7}, {6,5,4}, {3,2,1}};
		System.out.println(maximumSum(3,3,arr));
	}

	// Function for finding maximum and value pair
    public static int maximumSum (int n, int m, int arr[][]) {
        int maxSum = 0;
        // Minimum value selected from the arrays so far(all the next selected values have to be lower)
        int minSoFar = Integer.MAX_VALUE;
        // Try to pick the greatest value of the input arrays such that max_arr(i) > max_arr(i-1)
        for (int i = n-1;i >= 0;i--) {
        	Integer maxCurrentArray = null;
        	
        	for (int j = 0;j < m;j++) {
        		int currentItem = arr[i][j];
        		
        		if (maxCurrentArray == null) {			// Initialize the variable maxCurrentArray if the constraint 
        												// max_arr(i) > max_arr(i-1) is respected
        			if (currentItem < minSoFar) {
            			maxCurrentArray = currentItem;	
        			}
        		}else if (maxCurrentArray < currentItem	// Checking if the current item is the greatest item of this array
        				&& currentItem < minSoFar) {	// Checking the constraint max_arr(i) > max_arr(i-1)
        			maxCurrentArray = currentItem;	
        		}
        	}
        	// If the variable maxCurrentArray has not been initialized, that means that there is not a combination of
        	// items respecting the constraint max_arr(i) > max_arr(i-1)
        	if (maxCurrentArray == null) {
        		return 0;
        	}
        	// Add the maximum item of current array respecting the problem constraint to the sum and make this item to be 
        	// the minimum value selected so far
        	maxSum += maxCurrentArray;
        	minSoFar = maxCurrentArray;
        }
        
        return maxSum;
    }
	
}
