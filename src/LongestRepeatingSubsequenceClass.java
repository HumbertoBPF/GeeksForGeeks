import java.util.HashMap;

public class LongestRepeatingSubsequenceClass {

	public static void main(String[] args) {
		System.out.println(LongestRepeatingSubsequence("AABEBCDD"));
	}
	
	public static int LongestRepeatingSubsequence(String str) {
		// Almost the same as the Longest Common Subsequence problem, but we impose 
		// an additional condition to use the first recursive formula
		int n = str.length();
		int[][] LRSMatrix = new int[n+1][n+1];
		
		for (int i = 1;i <= n;i++) {
			for (int j = 1;j <= n;j++) {
				// The additional condition is that the similar char must be in distinct 
				// position in the Strings being compared (which are equal here)
				if (i != j && str.charAt(i-1) == str.charAt(j-1)) {
					LRSMatrix[i][j] = LRSMatrix[i-1][j-1] + 1;
				}else {
					LRSMatrix[i][j] = Math.max(LRSMatrix[i][j-1], LRSMatrix[i-1][j]);
				}
			}
		}
		
		return LRSMatrix[n][n];
    }
	
	public static int findChar(String str, char c, int initialIndex) {
		for (int i = initialIndex+1;i < str.length();i++) {
			if (str.charAt(i) == c) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static int LongestRepeatingSubsequenceDP(String str) {
        int maxLengthSubsequence = 0;
		HashMap<Character,Boolean> map = new HashMap<>();
		int strLength = str.length();
        
        for (int i = strLength-1;i >= 0;i--) {
        	if (map.get(str.charAt(i)) != null) {
        		maxLengthSubsequence++;
        		map.clear();
        	}
        	map.put(str.charAt(i), true);
        }
        
        return maxLengthSubsequence;
    }

}
