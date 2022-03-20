
public class SmallestNumber {

	public static void main(String[] args) {
		System.out.println(smallestNumber(20,2));
	}
	
	static String smallestNumber(int S, int D){
		// Number of digits of the output that have been set so far
		int i = 1;
		// Power of 10 correspondent to the current decimal
		long powerOfTen = 1;
		long smallestNumber = 0;
		
		while (i <= D) {
			if (S > 9) {
				// If the sum is still greater than 9 and we are not in the last decimal place, we set a 9 to the
				// current decimal place
				if (i < D) {
					smallestNumber += 9*powerOfTen;
					S-=9;
				}
				// If the sum is greater than 9 and we are in the last decimal place, it is impossible to fulfill
				// the requirements
				else {
					return "-1";
				}
			}else if (S <= 9) {
				// If the sum is lower than 9 and we are not in the last decimal place, we put the greatest value 
				// that we can in the current decimal place(that is S-1 since we do not want to have leading zeros)
				if (i < D) {
					smallestNumber += (S-1)*powerOfTen;
					S-=(S-1);
				// If the sum is lower than 9 and we are in the last decimal place, we set this decimal place as the
				// value of the sum
				}else if(i == D) {
					smallestNumber += S*powerOfTen;
					S-=S;	
				}
			}
			// Go to the next decimal place
			i++;
			powerOfTen *= 10;
		}
		
		return String.valueOf(smallestNumber);
    }
	
}
