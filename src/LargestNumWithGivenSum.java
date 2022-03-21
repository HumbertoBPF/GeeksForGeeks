
public class LargestNumWithGivenSum {

	public static void main(String[] args) {
		System.out.println(largestNumber(5,12));
	}
	
	//Function to return the largest possible number of n digits with sum equal to given sum.
    static String largestNumber(int n, int sum) {
        // The greatest sum that can be reached corresponds to a n-digit number such that all 
    	// the digits are 9. Hence, we verify if a sum greater than that is asked.
    	if (sum > n*9) {
        	return "-1";
        }
    	
    	String largestNumber = "";
    	// Here the variable 'sum' retains the value that we still need to reach the target sum 
    	for (int i = 0;i < n;i++) {
    		// If the remaining value is lower than 9, append it to the output string
    		if (sum < 10) {
    			largestNumber+=sum;
    			sum = 0;
    		// If the remaining value is greater than 9, append "9" to the string since we want the 
    		// decimal places on the left to have the greatest digits as possible
    		}else {
    			largestNumber+="9";
    			sum -= 9;
    		}
    	}
    	
    	return largestNumber;
    }

}
