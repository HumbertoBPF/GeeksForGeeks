public class SortArray012 {

	public static void main(String[] args) {
		int[] a = {0,2,1,2,0};
		sort012(a,a.length);
		for (int i: a) {
			System.out.print(i+" ");
		}
	}

	public static void sort012(int a[], int n) {
        int numberOfZeros = 0;
        int numberOfTwos = 0;
        
        for (int i = 0;i < n;i++) {
        	// When finding a zero
        	if (a[i] == 0) {
        		// Since the ith zero must be at the i-1 position when the array is sorted),
        		// we swap the items at the position 'numberOfZeros' and 'i'
        		a[i] = a[numberOfZeros];
        		a[numberOfZeros] = 0;
        		numberOfZeros++;
        	}
        }
        
        for (int i = n-1;i >= 0;i--) {
        	//When finding a two
        	if (a[i] == 2){
        		// Since the ith two must be at the i-1 position reading from the right to the left
        		// when the array is sorted), we swap the items at the position 'n-1-numberOfTwos' and 'i'
        		a[i] = a[n-1-numberOfTwos];
        		a[n-1-numberOfTwos] = 2;
        		numberOfTwos++;
        	}
        }
    }
	
}
