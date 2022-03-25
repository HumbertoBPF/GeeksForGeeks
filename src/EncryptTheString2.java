
public class EncryptTheString2 {

	public static void main(String[] args) {
		System.out.println(encryptString("abc"));
	}
	
	static String encryptString(String S){
        int n = S.length();
        String encryptedString = "";
        char currentChar = S.charAt(n-1);
        int nbOccurrences = 1;
        int index = n-2;
        
		while (index >= 0) {
			// When we do not have a repeated char
			if (S.charAt(index) != currentChar) {
				// Convert the number of occurrences of the last char into an hexadecimal and append it to the encrypted string
				encryptedString += Integer.toString(nbOccurrences, 16);
				// Append the current char to the encrypted string
				encryptedString += currentChar;
				// Start counting the occurrences of the current char
				nbOccurrences = 1;
				currentChar = S.charAt(index);
			// If the current char is the same as the last char, it is one more occurrence of a repeated char
			}else {
				nbOccurrences++;
			}
			
			index--;
		}
		// Take into account the last repeated char in the encrypted string
		encryptedString += Integer.toString(nbOccurrences, 16);
		encryptedString += currentChar;
		
		return encryptedString;
    }

}
