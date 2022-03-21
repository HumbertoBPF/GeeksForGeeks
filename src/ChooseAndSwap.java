import java.util.HashMap;

public class ChooseAndSwap {

	public static void main(String[] args) {
		System.out.println(chooseandswap("abba"));
	}

	public static String chooseandswap(String A){
		int n = A.length();
		char lowestCharOutOfOrder = '?';
		char lastGreaterChar = A.charAt(0);
		// Map to store the chars seen so far
		HashMap<Character,Boolean> map = new HashMap<>();
		map.put(lastGreaterChar, true);
		// Find the lowest lexicographically char out of order 
		for (int i = 1;i < n;i++) {
			char currentChar = A.charAt(i);
			
			if (map.get(currentChar) == null) {
				map.put(currentChar, true);
				
				boolean isLowerThanPreviousChar = lowestCharOutOfOrder == '?' && lastGreaterChar > currentChar;
				boolean isLowerThanPreviousMin = lowestCharOutOfOrder != '?' && lowestCharOutOfOrder > currentChar;
				
				if (isLowerThanPreviousChar ||  isLowerThanPreviousMin) {
					lowestCharOutOfOrder = currentChar;
				}
				
				lastGreaterChar = currentChar;
			}
		}
		// If we do not find a char out of order, the current String is the smallest lexicographically
		if (lowestCharOutOfOrder == '?') {
			return A;
		}
		// Find the first char lexicographically greater than the char out of order
		char charToComeAfter = A.charAt(0);
		int i = 0;
		
		while (charToComeAfter <= lowestCharOutOfOrder) {
			i++;
			charToComeAfter = A.charAt(i);
		}
		// Swapping the two characters found ('charToComeAfter' and 'lowestCharOutOfOrder')
		// We use '?' as placeholder character for that
		A = A.replace(lowestCharOutOfOrder, '?');
		A = A.replace(charToComeAfter, lowestCharOutOfOrder);
		
		return A.replace('?',charToComeAfter);
    }
	
}
