
public class MergeSort {

	public static void main(String[] args) {
		int[] nums = {6,5,3,1,8,7,2,4};
		for (int i:nums) {
			System.out.print(i+" ");	
		}
		System.out.println();
		mergeSort(nums,0,nums.length-1);
		for (int i: nums) {
			System.out.print(i+" ");	
		}
	}
	
	public static void merge(int arr[], int l, int m, int r) {
		int i = l;		// Pointer for the left array
		int j = m+1;	// Pointer for the right array
		
		// Copy of the input array. We need it, because we are going to apply
		// the merge sort algorithm in-place. Hence, a backup of the original
		// array is necessary in order to have reference of its original appearance.
		int[] leftArray = new int[m-l+1];
		int[] rightArray = new int[r-m];
		
		for (int k=0;k<Math.min(leftArray.length,rightArray.length);k++) {
			leftArray[k] = arr[l+k];
			rightArray[k] = arr[m+1+k];
		}
		// Being sure that the whole left and right array were copied (when their 
		// sizes are not the same)
		leftArray[m-l] = arr[m];
		rightArray[r-m-1] = arr[r];
		
		// Comparing the current item of both sub-arrays in order to merge them
		// and at the same time place the items sorted. The comparisons stop when
		// some of the pointers has checked all its sub-array.
		while ((i <= m) && (j <= r)) {
			if (leftArray[i-l] <= rightArray[j-(m+1)]) {
				arr[i+j-(m+1)] = leftArray[i-l];
				i++;
			}else {
				arr[i+j-(m+1)] = rightArray[j-(m+1)];
				j++;
			}
		}	
		// Add the remaining items of the array that was not completely checked.
		while (i <= m) {
			arr[i+j-(m+1)] = leftArray[i-l];
			i++;
		}
    }
	
	public static void mergeSort(int arr[], int l, int r) {
		int m = (l+r)/2;
		// The recursion stops when r = l, because it means that we have a single item array
		if (r != l) {
    		mergeSort(arr,l,m);		// Gets the left sub-array
    		mergeSort(arr,m+1,r);	// Gets the right sub-array
    		merge(arr,l,m,r);		// Merges the sub-arrays while sorting its items
		}
    }

}
