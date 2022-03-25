import java.util.HashMap;

public class ChooseAndSwap2 {

	public static void main(String[] args) {
		System.out.println(LexicographicallyMinimum("ab"));
	}
	
	public static String LexicographicallyMinimum(String str) {
        int n = str.length();
        // HashMap to store the characters that have been found so far
		HashMap<Character,Boolean> map = new HashMap<>();
		// Add the first char of the string to the map since it will be skipped
		map.put(str.charAt(0), true);
		
		// This variable stores the lexicographically lowest char that is out of order
        char minimumCharOutOfOrder = '?';
        
        for (int i = 1;i < n;i++) {
        	char currentChar = str.charAt(i);
        	char lastChar = str.charAt(i-1);
        	// If the current char has not been seen before
        	if (map.get(currentChar) == null) {
        		// First char out of order is found
        		if (minimumCharOutOfOrder == '?') {
        			if (currentChar < lastChar) {
        				minimumCharOutOfOrder = currentChar;
        			}
        		// A char out of order had already been found, but a lower char is found
        		}else if (minimumCharOutOfOrder > currentChar) {
        			minimumCharOutOfOrder = currentChar;
        		}
        		map.put(currentChar, true);
        	}
        }
        // If all the chars are in the lexicographically ascending order, the input string itself
        // is the lexicographically minimum
        if (minimumCharOutOfOrder == '?') {
        	return str;
        }
        // This variable stores the first char of str greater than the 'minimumCharOutOfOrder'
        char char2 = '?';
        
        for (int i = 0;i < n;i++) {
        	char2 = str.charAt(i);
        	
        	if (char2 > minimumCharOutOfOrder) {
        		break;
        	}
        }
        
        String lexicMinimumString = "";
        // Swap the chars found in the previous for loop
        for (int i = 0;i < n;i++) {
        	char currentChar = str.charAt(i); 
        	if (currentChar == minimumCharOutOfOrder) {
        		lexicMinimumString += char2;
        	}else if (currentChar == char2) {
        		lexicMinimumString += minimumCharOutOfOrder;
        	}else {
        		lexicMinimumString += currentChar;
        	}
        }
        
        return lexicMinimumString;
        
    }

}
