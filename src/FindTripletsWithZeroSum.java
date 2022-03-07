import java.util.Arrays;

public class FindTripletsWithZeroSum {

	public static void main(String[] args) {
		int[] arr = {};
		System.out.println(findTriplets(arr,arr.length));
	}
	
	public static boolean findTriplets(int arr[], int n) { 
        // To find a triplet, we need to have at least 3 integers in the array
		if (n<3) {
        	return false;
        }
		// Since we are going to apply two pointers algorithm, we need to sort
        // the array, which takes O(n.log n)
		Arrays.sort(arr);
        // 'leftPointer' and 'rightPointer' refer to two pointers algorithm
		// 'currentSum' is the currentSum that we are looking for, which 
		// corresponds to the symmetric of the item of the current iteration
        int leftPointer, rightPointer, currentSum;
        
        for (int i = 0;i<n-2;i++) {
        	// Defining the interval over which the two pointers algorithm is 
        	// going to be applied
        	leftPointer = i + 1;
        	rightPointer = n - 1;
        	// Applying two pointers algorithm in order to search for two numbers 
        	// whose sum is -arr[i]
        	while (rightPointer-leftPointer != 1) {
        		// Compute current sum
        		currentSum = arr[leftPointer] + arr[rightPointer];
        		// If the current sum is lower than the target one, we need to 
        		// increase it, so we move the left pointer to the right
        		if (currentSum < -arr[i]) {
        			leftPointer++;
        		// If we have already gotten the target sum, return true
        		}else if (currentSum == -arr[i]){
        			return true;
        		// If the current sum is greater than the target one, we need to 
        		// decrease it, so we move the right pointer to the left
        		}else {
        			rightPointer--;
        		}
        	}
        	// Since we did not verify the current sum right before moving the 
        	// pointers for the last time, we need to verify it right after leaving
        	// the while loop
        	currentSum = arr[leftPointer] + arr[rightPointer];
        	if (currentSum == -arr[i]){
    			return true;
    		}
        }
        
        return false;
    }
	
}
