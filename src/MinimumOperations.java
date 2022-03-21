
public class MinimumOperations {

	public static void main(String[] args) {
		System.out.println(minOperation(62));
	}

	public static int minOperation(int n) {
        // Since n is greater or equal than 1, we need at least one operation in order to reach the number 1
		int nbOperations = 1;
        // We are interested in using multiplication as many times as we can, since it avoids to have
		// to perform repeated additions. But we also want to avoid to exceed the target value.
        while (n != 1) {
        	// If the number is even, we need one operation to obtain it from its half (multiply by 2)
        	if (n%2 == 0) {
        		nbOperations++;
        	// If the number is odd, we need two operations to obtain it from its integer half (multiply by 2
        	// and then add 1)
        	}else {
        		nbOperations+=2;
        	}
        	// We want to know in the next iteration how many operations are necessary to have the integer
        	// half of the number
        	n /= 2;
        }
        
        return nbOperations;
    }
	
}
