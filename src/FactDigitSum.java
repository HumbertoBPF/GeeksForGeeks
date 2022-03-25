import java.util.ArrayList;
import java.util.HashMap;

public class FactDigitSum {

	public static void main(String[] args) {
		System.out.println(FactDigit(40321));
	}

	static ArrayList<Integer> FactDigit(int N) {
		ArrayList<Integer> digits = new ArrayList<>();
		// HashMap with the factorial of all the digits from 0 to 9
		HashMap<Integer,Integer> basicFactorials = new HashMap<>();
		basicFactorials.put(1, 1);
		// Pre-compute the factorial of the digits from 0 to 9
		for (int i = 2;i < 10;i++) {
			int currentFactorial = i*basicFactorials.get(i-1);
			basicFactorials.put(i, currentFactorial);
		}
		
		int n = 9;
		// We verify for a given n if n! is lower than N
		while (N != 0) {
			int currentFactorial = basicFactorials.get(n);
			// If not, we decrement n and keep iterating
			if (currentFactorial > N) {
				n--;
			// If it is the case, it is one of the digits of the number that we are looking for 
			// and then we decrement N of n! since we have already found part of the target sum
			}else {
				// 0 and 1 have the same factorial. We usually prefer zeros since they are lower 
				// than ones, but we need to have at least one digit "1" at the last decimal place
				// in order not to have only leading zeros
				if (n == 1 && N > 1) {
					digits.add(0);
				}else {
					digits.add(n);
				}
				N -= currentFactorial;
			}
		}
		
		int lengthOutput = digits.size();
		// Reverse the digits found since we want to have the smallest number(so the lowest digits
		// must be at the greatest decimal places and vice-versa). The unique exception is the zeros
		// and ones, because we want to avoid leading zeros
		for (int i = 0;i < lengthOutput/2;i++) {
			int auxVar = digits.get(i);
			digits.set(i, digits.get(lengthOutput - 1 - i));
			digits.set(lengthOutput - 1 - i, auxVar);
		}
		
		return digits;
    }
	
}
