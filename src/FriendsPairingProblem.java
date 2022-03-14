public class FriendsPairingProblem {

	public static void main(String[] args) {
		System.out.println(countFriendsPairings(4));
	}

	// SOLUTION PROVIDED BY THE AUTHOR OF THE QUESTION !
	// For n-th person there are two choices:
	// 	1) n-th person remains single, we use recursion for f(n - 1)
	// 	2) n-th person pairs up with any of the remaining (n-1) persons. Call (n - 1) * f(n - 2).
	public static long countFriendsPairings(int n) { 
		int m = 1000000007;
		// a = f(n-2)
		// b = f(n-1)
		// c = f(n)
		long a = 1, b = 2, c = 0; 
    	// Base case
		if (n <= 2) { 
    		return n; 
    	} 
    	
		for (int i = 3; i <= n; i++) { 
    	    // Using modular arithmentic properties
    		c = ( b%m + ( ( (i - 1)%m  *  a%m )%m ) %m )%m ; 
    		a = b; 
    		b = c; 
    	} 
    	return c; 
    }
	
}
