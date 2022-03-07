
public class SortingBinaryArray {

	public static void main(String[] args) {
		int[] A = {1, 0, 1, 1, 1, 1, 1, 0, 0, 0};
		binSort(A,A.length);
		for (int i : A) {
			System.out.print(i+" ");
		}
	}

	//Function to sort the binary array.
    public static void binSort(int A[], int N) {
    	int numberOfZeros = 0;
    	
        for (int i = 0;i < N;i++) {
        	// When finding a zero
        	if (A[i] == 0) {
        		// Initially put an one at this position 
        		A[i] = 1;
        		// Put a zero in the position that this zero should be(when the
        		// array is zero, the ith zero should appear at the i-1 position
        		A[numberOfZeros] = 0;
        		numberOfZeros++;
        	}
        }
    }
	
}
