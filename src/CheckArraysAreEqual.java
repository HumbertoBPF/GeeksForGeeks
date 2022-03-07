import java.util.HashMap;

public class CheckArraysAreEqual {

	public static void main(String[] args) {
		long[] A = {1,2,5};
		long[] B = {2,4,15};
		System.out.println(check(A,B,A.length));
	}

	//Function to check if two arrays are equal or not.
    public static boolean check(long A[],long B[],int N) {
        // HashMaps whose keys are a long contained in the concerned input array
    	// and the value is the number of times that this long appears.
    	HashMap<Long,Integer> mapA = new HashMap<>();
        HashMap<Long,Integer> mapB = new HashMap<>();
        // Variable holding a value of both maps
        Integer valueMapA, valueMapB;
        
        for (int i = 0;i < N;i++) {
        	// Get the value of the map corresponding to the current item of the
        	// arrays(ith item)
        	valueMapA = mapA.get(A[i]);
        	valueMapB = mapB.get(B[i]);
        	// If valueMapA is not present in the mapB as key, put it. Otherwise,
        	// increment its value.
        	if (valueMapA != null) {
        		mapA.put(A[i], valueMapA + 1);
        	}else {
        		mapA.put(A[i], 1);
        	}
        	// If valueMapB is not present in the mapA as key, put it. Otherwise,
        	// increment its value.
        	if (valueMapB != null) {
        		mapB.put(B[i], valueMapB + 1);
        	}else {
        		mapB.put(B[i], 1);
        	}
        }
        
        return mapA.equals(mapB);
    }
	
}
