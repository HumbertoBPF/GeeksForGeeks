import java.util.Arrays;
import java.util.Comparator;

public class TheftAtWorldBank {

	public static void main(String[] args) {
		long[] w = {4, 5, 7};
		long[] p = {8, 5, 4};
		System.out.println(maximumProfit(3,10,w,p));
	}

	public static double maximumProfit(int N, long C, long w[], long p[]) {
        BlockGold[] blocks = new BlockGold[N];
        long sackWeight = 0;
        double totalProfit = 0;
		// Create a BlockGold object for each pair of items of the input arrays
		for (int i = 0;i < N;i++) {
        	blocks[i] = new BlockGold(w[i],((double) p[i])/((double) w[i]));
        }
		// Sort blocks by unit price
		Arrays.sort(blocks,new PriceComparator());
		
		for (int i = 0;i < N;i++) {
			// If the weight that the theft can carry in the sack was reached, get out of the loop
			if (sackWeight >= C) {
				break;
			}
			// Pick the block with the greatest unit price that has not been picked yet
			BlockGold currentBlock = blocks[N-1-i];
			long sqrtW = (long) Math.sqrt(currentBlock.weight);
        	// Steal the content of a block only when its weight is not a perfect square
        	if (sqrtW*sqrtW != currentBlock.weight) {
        		// Check if the whole block can go inside the sack
        		if (sackWeight+currentBlock.weight < C) {
        			sackWeight += currentBlock.weight;
        			totalProfit += currentBlock.weight*currentBlock.unitPrice;
        		// Else, we pick just a part of the block correspondent to the weight available in the sack
        		}else {
        			double availableWeight = (C - sackWeight);
        			sackWeight += availableWeight;
        			totalProfit += availableWeight*currentBlock.unitPrice;
        		}
        	}
		}
		
		return totalProfit;
    }
	// Object to represent the total weight of a block of gold and the price of a unit of weight
	public static class BlockGold {
		public long weight;
		public double unitPrice;
		
		public BlockGold(long weight, double unitPrice) {
			this.weight = weight;
			this.unitPrice = unitPrice;
		}
	}
	// Comparator allowing to sort the BlockGold objects by unit price since we want to prioritize the most
	// valuable blocks of gold
	public static class PriceComparator implements Comparator<BlockGold>{

		@Override
		public int compare(BlockGold o1, BlockGold o2) {
			if (o1.unitPrice > o2.unitPrice) {
				return 1;
			}else if (o1.unitPrice == o2.unitPrice) {
				return 0;
			}
			
			return -1;
		}
		
	}
	
}
