import java.util.Arrays;

public class MinimizeTheSumOfProduct {

	public static void main(String[] args) {
		long[] a = {6, 1, 9, 5, 4};
		long[] b = {3, 4, 8, 2, 4};
		System.out.println(minValue(a,b,a.length));
	}

	//  Let us suppose that we have the two input arrays sorted. Let us suppose that
	// we decide to sum them like a[0]*b[n-1]+a[1]*b[n-2]+...+a[n-1]*b[0] (each term)
	// of the sum is the ith lowest item of 'a' times the ith greatest item of 'b'.
	// We can prove that any other possibility of sum of product is greater than this 
	// one.
	//  Imagine that we decide to swap two 'a' items in the sum above. Hence, two terms
	// will be changed such that before we had a[i]*b[q] + a[j]*b[p] where i<j and 
	// p<q (remember that the arrays are sorted). Now we swapped the items of 'a', then
	// we have a[i]*b[p] + a[j]*b[q]. We are going to prove that the second sum minus the
	// first one is greater than zero.
	//		a[i]*b[p] + a[j]*b[q] - (a[i]*b[q] + a[j]*b[p]) 
	//		= a[i]*(b[p]-b[q]) - a[j]*(b[p]-b[q])
	//      = (a[i]-a[j])*(b[p]-b[q]) > 0, because a[i] < a[j] and b[p] < b[q]
	//  As a consequence we conclude that a[i]*b[p] + a[j]*b[q] > a[i]*b[q] + a[j]*b[p] and
	// then any swapping increases the sum of product.
	public static long minValue(long a[], long b[], long n) {
        long minSumOfProduct = 0;
		
		Arrays.sort(a);
        Arrays.sort(b);
        
        for (int i = 0;i < n;i++) {
        	minSumOfProduct += a[i]*b[(int) (n-1-i)];
        }
        
        return minSumOfProduct;
    }
	
}
