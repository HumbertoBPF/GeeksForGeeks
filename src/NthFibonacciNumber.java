import java.util.HashMap;

public class NthFibonacciNumber {
	
	public static void main(String[] args) {
		System.out.println(nthFibonacci(20));
	}

	public static long nthFibonacci(long n){
        return nthFibonacciWithMemoization(n, new HashMap<Long,Long>());
    }
	
	public static long nthFibonacciWithMemoization(long n, HashMap<Long,Long> map) {
		if (map.get(n) == null) {		// If the Fibonacci of n is not in cache
			long fn;
			
			if (n == 1 || n == 2) {		// Base case
	        	fn = 1;
	        }else {						// F(n) = F(n-1) + F(n-2)
	        	fn = nthFibonacciWithMemoization(n-1,map)+nthFibonacciWithMemoization(n-2,map);
	        }
			
			map.put(n, fn%1000000007);	// Add computed value to cache
		}
		
		return map.get(n);
	}
	
}
