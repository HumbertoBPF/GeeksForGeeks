
public class PrintNFirstFibonacciNumbers {

	public static void main(String[] args) {
		for (long number:printFibb(7)) {
			System.out.println(number);
		}
	}

	//Function to return list containing first n Fibonacci numbers.
    public static long[] printFibb(int n) {
    	long[] nFirstFib = new long[n];
    	// First Fibonacci number
    	nFirstFib[0] = 1;
    	if (n == 1) {
    		return nFirstFib;
    	}
    	// Second Fibonacci number
    	nFirstFib[1] = 1;
    	if (n == 2) {
    		return nFirstFib;
    	}
    	// Compute all the Fibonacci numbers until the nth
    	for (int i = 2;i < n;i++) {
    		nFirstFib[i] = nFirstFib[i-1] + nFirstFib[i-2];
    	}
    	
    	return nFirstFib;
    }
    
}
