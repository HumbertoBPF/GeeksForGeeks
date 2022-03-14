
public class SticklerThief {

	public static void main(String[] args) {
		int arr[] = {100,5,1,250,500,100};
		System.out.println(FindMaxSum(arr,arr.length));
	}
	
	//Function to find the maximum money the thief can get.
    public static int FindMaxSum(int arr[], int n) {
    	// maxSums[i] = max sum considering the array from the index 0 to i-1 (max sum for n = i+1)
        int[] maxSums = new int[n];
        // When n = 1, we have only one choice
        maxSums[0] = arr[0];
        // Base case 1
        if (n == 1) {
        	return maxSums[0];
        }
        // If n = 2, we simply pick the greatest item
        maxSums[1] = (arr[1]>arr[0])?arr[1]:arr[0];
        // Base case 2
        if (n == 2) {
        	return maxSums[1];
        }
        // For n = i + 1 such that i > 2, we have two options:
        // 	1) Ignore the item arr[i-1], then the max sum is maxSum[i-1]
        //  2) Consider the item arr[i-1], so we skip the item arr[n-2]. Hence, the max sum is 
        //	maxSum[i-2]+arr[i] (max sum for the subarray from index 0 to i-2 plus the last item of the
        //  input array).
        for (int i = 2;i < n;i++) {
        	maxSums[i] = (maxSums[i-2] + arr[i] > maxSums[i-1])?maxSums[i-2] + arr[i]:maxSums[i-1];
        }
        
        return maxSums[n-1];
    }
	
}
