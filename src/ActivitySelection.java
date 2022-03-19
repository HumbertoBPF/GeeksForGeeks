import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

	public static void main(String[] args) {
		int start[] = {2, 1};
		int end[] = {2, 2};
		
		System.out.println(activitySelection(start,end,start.length));
	}
	
	//Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n) {
    	Activity[] activities = new Activity[n];
    	// We are always going to start picking the first activity
    	int maxActivities = 1;
    	// Last activity of the activities picked
    	int lastActivityPicked = 0;
    	// Convert the integer arrays into Activity objects
    	for (int i = 0;i < n;i++) {
    		activities[i] = new Activity(start[i],end[i]);
    	}
    	// Sort the activity array based on their end day
    	Arrays.sort(activities, new ActivityComparator());
    	// We pick an activity if its starting day is after the end day of all the previous activities
    	// (we just need to compare to the last activity) and if the end day comes after the end day of the
    	// previous activities(no need to verify that due to the sort performed above)
    	for (int i = 1;i < n;i++) {
    		if (activities[lastActivityPicked].end < activities[i].start) {
    			maxActivities++;
    			lastActivityPicked = i;
    		}
    	}
    	
    	return maxActivities;
    }
    
    // Object to represent an activity
    public static class Activity {
    	
    	public int start;
    	public int end;
    	
    	public Activity(int start, int end) {
    		this.start = start;
    		this.end = end;
    	}
    	
    }
    
    // creates the comparator for comparing activities based on their end day
    public static class ActivityComparator implements Comparator<Activity> {
      
        // override the compare() method
        public int compare(Activity a1, Activity a2)
        {
            if (a1.end == a2.end) {
                return 0;
        	}else if (a1.end > a2.end) {
                return 1;
            }
            else {
            	return -1;
            }
        }
    }

}
