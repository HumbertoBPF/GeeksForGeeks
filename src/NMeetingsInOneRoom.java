import java.util.Arrays;
import java.util.Comparator;

public class NMeetingsInOneRoom {

	public static void main(String[] args) {
		int start[] = {1,3,0,5,8,5};
		int end[] =  {2,4,6,7,9,9};
		
		System.out.println(maxMeetings(start,end,start.length));
	}
	
	//Function to find the maximum number of meetings that can be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n) {
        Activity[] activities = new Activity[n];
        // Converting each pair (start,end) into an Activity object
        for (int i = 0;i < n;i++) {
        	activities[i] = new Activity(start[i],end[i]);
        }
        // Sorting activities by end time
        Arrays.sort(activities, new ActivityComparator());
        // An activity must be picked when its starting and ending time are greater than the ending time of 
        // the last activity
        int maxActivities = 1;
        int lastIndexAdded = 0;
        
        for (int i = 1;i < n;i++) {
        	if (activities[lastIndexAdded].end < activities[i].start) {
        		lastIndexAdded = i;
        		maxActivities++;
        	}
        }
        
        return maxActivities;
    }
    // Class to represent an activity, which has a starting time and a ending time
    public static class Activity {
    	public int start;
    	public int end;
    	
    	public Activity(int start, int end) {
    		this.start = start;
    		this.end = end;
    	}
    }
    // Object to allow to compare and to sort activities
    public static class ActivityComparator implements Comparator<Activity>{

		@Override
		public int compare(NMeetingsInOneRoom.Activity a1, NMeetingsInOneRoom.Activity a2) {
			if (a1.end > a2.end) {
				return 1;
			}else if (a1.end == a2.end) {
				return 0;
			}else {
				return -1;
			}
		}
    	
    }

}
