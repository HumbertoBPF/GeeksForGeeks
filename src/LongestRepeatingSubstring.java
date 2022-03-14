
public class LongestRepeatingSubstring {

	public static void main(String[] args) {
		String S1 = "ABC";
		String S2 = "ACB";
		System.out.println(longestCommonSubstr(S1,S2,S1.length(),S2.length()));
	}
	
	public static int longestCommonSubstr(String S1, String S2, int n, int m) {
		int maxLength = 0;
        String currentSubstring = "";
        
        for (int i = 0;i < n;i++) {
        	// When a common char is found, we start to verify the following chars so as to verify
        	// the longest common substring starting from this common char
        	for (int k = 0;k < n-i;k++) {
        		// We add the current char of the input String
            	currentSubstring+=S1.charAt(i+k);
            	int currentSubstringLength = currentSubstring.length();
            	// Flag to indicate if the current substring is present twice in the input String
            	boolean isRepeated = false;
            	// A sliding window is used to check if the current substring is repeated
        		for (int j = 0;j <= m-currentSubstringLength;j++) {
            		if (S2.substring(j, j+currentSubstringLength).equals(currentSubstring)) {
            			System.out.println(currentSubstring);
            			isRepeated = true;
            			break;
            		}
            	}
        		// If it is not repeated, we reset the currentSubstring and restart the
        		// search from the next char
            	if (!isRepeated) {
            		currentSubstring = "";
            		break;
            	// If it is repeated, we check if it is necessary to update the maxLength
            	}else if (currentSubstringLength > maxLength){
            		maxLength = currentSubstringLength;
            	}
        	}
        }
        
        return maxLength;
    }

}
