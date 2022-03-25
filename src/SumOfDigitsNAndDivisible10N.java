
public class SumOfDigitsNAndDivisible10N {
	
	public static void main(String[] args) {
		System.out.println(digitsNum(20));
	}
	
	public static String digitsNum(int N) {
        String output = "";
		// Making the number divisible by 10^N by adding N zeros at the end
		for (int i = 0;i < N;i++) {
        	output += "0";
        }
		// Since the zeros do not contribute for the sum of the digits, we have to handle that
		while (N > 0) {
			// We do that by adding nines to the beginning of the output string until the remaining 
			// sum is lower than 10. At this moment, we add the remaining sum to the beginning of 
			// the output string.
			if (N > 9) {
				output = "9" + output;
				N-=9;
			}else {
				output = N + output;
				N = 0;
			}
		}
		
		return output;
    }
	
}
