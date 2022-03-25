
public class CheckIfItIsPossibleToSurviveOnIsland {

	public static void main(String[] args) {
		System.out.println(minimumDays(7,16,15));
	}
	
	static int minimumDays(int S, int N, int M){
        // The strategy here is to buy the necessary food as soon as possible.
		double totalFoodNecessary = S*M;
		// Days that we need to buy the amount of food necessary to survive
		int nbDaysBuyingFood = (int) Math.ceil(totalFoodNecessary/N);
		// Days that we can buy food
        int nbNonSundays = S - S/7;
        // Since it is not possible to buy food on Sundays, we have to verify if
        // we have enough days to buy the necessary food
        if (nbDaysBuyingFood > nbNonSundays) {
        	return -1;
        }
        
        return nbDaysBuyingFood;
    }

}
