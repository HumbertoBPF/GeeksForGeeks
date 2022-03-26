import java.util.HashMap;

public class LongestPermutation {

	public static void main(String[] args) {
		long[] arr = {5, 4, 2, 1, 3};
		KswapPermutation(arr,arr.length,2);
	}
	
	static void KswapPermutation(long arr[] ,int n,int k) {
		// HashMap to store the one of values that we have to swap
		HashMap<Long,Boolean> valuesToShift = new HashMap<>();
		// Number of swaps performed so far
		int nbSwaps = 0;
		int i = 0;
		// While we do not reach the end of the array or while we still have swaps available
		while (i < n && nbSwaps != k) {
			// If we find an item to be swapped, do it 
			while (valuesToShift.get(arr[i]) != null) {
				long auxVar = arr[i];
				arr[i] = arr[(int) (n - auxVar)];
				arr[(int) (n - auxVar)] = auxVar;
				nbSwaps++;
			}
			// Verify if the item in the current position is what it should be(in order to get
			// the greatest lexicographic array, we have to put the greatest values at the beginning
			// such that the maximum array is the array sorted in the descending order)
			if (arr[i] != n - i && valuesToShift.size() != k) {
				// If the item is not what it should be, we have to swap the item occupying this
				// position with the item that should be here(that is n-i)
				valuesToShift.put((long) (n-i), true);
			}
			
			i++;
		}
    }

}
