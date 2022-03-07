
public class PunishTheStudents {

	public static void main(String[] args) {
		int[] roll = {3, 2, 4, 1, 5};
		int[] marks = {50, 67, 89, 79, 58};
		int n = 5;
		double avg = 68;
		System.out.println(shouldPunish(roll,marks,n,avg));
	}

	public static int shouldPunish (int roll[], int marks[], int n, double avg) {
        int nbSwaps = 0;
        int auxVar;
        // Variable to store the sum of the marks. It is initialized with the 
        // value of the first mark since the others will be iteratively summed
        // during the bubble sort iterations
        double sumMarks = marks[0];
        // The window [roll[j],roll[j+1]] iterates n-2 times, because when there
        // is only one item to be sorted, it is already in the correct position
        for (int i = n-1;i > 0;i--) {
        	// Incrementing the sum of the marks 
        	sumMarks += marks[i];
        	// The window [roll[j],roll[j+1]] goes until the last greatest item
        	// that was placed at the good position
        	for (int j = 0;j < i;j++) {
        		// Swapping if necessary
        		if (roll[j] > roll[j+1]) {
        			auxVar = roll[j];
        			roll[j] = roll[j+1];
        			roll[j+1] = auxVar;
        			nbSwaps++;
        		}
        	}
        }
        
        // Checking if the average is greater or equal than the imposed limit
        if ((sumMarks - 2*nbSwaps)/n >= avg) {
        	return 1;
        }
        
        return 0;
    }
	
}
