
public class TheSpiderSteps {

	public static void main(String[] args) {
		System.out.println(minStep(100,3,1));
	}
	
	// The trick here is to think how would we solve using a greedy algorithm, i.e. building the solution step by step.
	// We would do it by the following iterative algorithm:
	// 
	// - Checking if it would be possible to get out of the well with a regular step(without slipping). If it is the case,
	// add the regular step and stop. Else, add a step with slipping.
	//
	// Hence, we conclude that the last step is always a regular step since we always verify if it is possible to get out
	// of the well with a step of height U before adding a slipping step. That is why we decrement U from H below. The rest
	// of the reasoning become then more intuitive.
	static int minStep(int H, int U, int D){
		// The last step is always a regular step, so we decrement it from H
		H -= U;
		// If all the well was climbed with the regular step, only one step is necessary
		if (H < 0) {
			return 1;
		}
		// Otherwise, we need two steps(regular step+step to get out of the well+steps with slipping contained in
		// the height necessary to reach the top)
		return 2 + H/(U-D);
    }

}
