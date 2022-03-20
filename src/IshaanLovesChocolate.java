
public class IshaanLovesChocolate {

	public static void main(String[] args) {
		int[] arr = {5,9,2,6};
		System.out.println(chocolates(arr,arr.length));
	}
	
	// Function for finding maximum and value pair
    public static int chocolates (int arr[], int n) {
    	// Ishaan can eat only either the first or the last square
        int leftPointer = 0;
        int rightPointer = n - 1;
        // Stop when there is only one square remaining
        while (rightPointer - leftPointer > 0) {
        	// Pick the square with the greatest tastiness
        	if (arr[leftPointer] > arr[rightPointer]) {
        		leftPointer++;
        	}else {
        		rightPointer--;
        	}
        }
        
        return arr[leftPointer];
    }

}
