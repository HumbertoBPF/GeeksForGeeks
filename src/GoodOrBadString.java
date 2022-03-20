
public class GoodOrBadString {

	public static void main(String[] args) {
		System.out.println(isGoodorBad("bcdaeiou??"));
	}
	
	static int isGoodorBad(String S) {
        int n = S.length();
		int i = 0;
		
        int numVowelsTogether = 0;
        int numConsonantsTogether = 0;
		
		while (i < n) {
			char currentChar = S.charAt(i);
			if (currentChar == 'a'||currentChar == 'e'||currentChar == 'i'||
					currentChar == 'o'||currentChar == 'u') {
				numVowelsTogether++;
				numConsonantsTogether = 0;
			}else if (currentChar == '?') {
				numVowelsTogether++;
				numConsonantsTogether++;
			}else {
				numVowelsTogether = 0;
				numConsonantsTogether++;
			}
			if (numVowelsTogether > 5 || numConsonantsTogether > 3) {
				return 0;
			}
			i++;
		}
	
		return 1;
    }
	
}
