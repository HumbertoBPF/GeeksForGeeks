import java.util.Arrays;

public class SwapAndMaximize {

	public static void main(String[] args) {
		long[] arr = {10,12,1};
		System.out.println(maxSum(arr,arr.length));
	}
	
	static long maxSum(long arr[] ,int n) {
		// The optimal solution is an array such that :
		// 	- The subarray of the items with even indices is composed of the greatest items of the input array in 
		// decreasing order.
		// 	- The subarray of items with odd indices is composed of the lowest items of the input array in increasing 
		// order.
		long maxSum = 0;
		Arrays.sort(arr);
        // Computing the absolute difference between the items of the optimal array.
		for (int i = 0;i < n;i++) {
			if (i%2 == 0) {
				maxSum += (arr[n-1-(i/2)] - arr[i/2]);
			}else {
				maxSum += (arr[n-1-(i/2)] - arr[i/2+1]);
			}
		}
		// Computing the absolute difference between the last item and the first item of the optimal array.
		maxSum += (arr[n/2] - arr[0]);
		
		return maxSum;
    }

}
