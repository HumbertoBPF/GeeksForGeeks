
public class CountNumbersCountaining4 {

	public static void main(String[] args) {
		System.out.println(countNumberswith4(14));
	}

	public static int countNumberswith4(int N) {
		// Number of numbers from 1 to N that contain 4 as digit
        int counterNumbersWith4 = 0;
        // Number that is being verified
        int currentNumber = 1;
        // For each number from 1 to N, verify if there is "4"
		while (currentNumber <= N) {
			if (contains4(currentNumber)) {
				counterNumbersWith4++;
			}
			currentNumber++;
		}
		
		return counterNumbersWith4;
    }
	
	public static boolean contains4(int n) {
		// Initially, take the digit of the last decimal place
		int currentDigit = n%10;
		// While there are decimal places to iterate over
		while (n != 0) {
			// If the digit of the current decimal place is a 4, return true
			if (currentDigit == 4) {
				return true;
			}
			// Go to the decimal place on the left
			n = n/10;
			currentDigit = n%10;
		}
		
		return false;
	}
	
}
