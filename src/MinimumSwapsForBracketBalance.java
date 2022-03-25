
public class MinimumSwapsForBracketBalance {

	public static void main(String[] args) {
		System.out.println(minimumNumberOfSwaps("[]][]["));
	}
	
	static int minimumNumberOfSwaps(String S){
		int n = S.length();
		int nbOfSwaps = 0;
		// Difference between the number of char ']' and '[' so far
		// When it is positive, it means that there is a ']' to be balanced
		int balance = 0;
		
		for (int i = 0;i < n;i++) {
			if (S.charAt(i) == '[') {
				// When there is some ']' pending to be balanced, we balance the first unbalanced one 
				if (balance > 0) {
					nbOfSwaps += balance;
				}
				balance--;
			}else {
				balance++;
			}
		}
		
		return nbOfSwaps;
    }

}
