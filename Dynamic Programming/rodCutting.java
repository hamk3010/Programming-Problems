import java.util.ArrayList;

/*
 * Given a rod of length n and prices P[i] for i = 1,...,n
 * where P[i] is the price of a rod of length i. Find the MAXIMUM
 * total revenue you can make by cutting and selling the rod
 */
public class rodCutting {

	public static void main(String[] args) {
		ArrayList<Integer> prices = new ArrayList<>();
		prices.add(2);
		prices.add(5);
		prices.add(8);
		prices.add(9);
		prices.add(10);
		
		
		long t0 = System.nanoTime();
		System.out.println(revenue(5, prices));
		long endTime = System.nanoTime();
		long duration = (endTime - t0);
		System.out.println("Recursive Completed in:" + duration + " nanoseconds");
		
		
		long t1 = System.nanoTime();
		System.out.println(revenue_Dynamic(5, prices));
		long endTime_t1 = System.nanoTime();
		long durationt1 = (endTime_t1 - t1);
		System.out.println("Dynamic Completed in:" +   durationt1 + " nanoseconds" );
		
	}
	
	//Recursive solution:
	public static int revenue(int n, ArrayList<Integer> prices){
		if(n==0)
			return 0;
		
		int max_val = -1;
		
		for(int i=0; i<n; ++i){
			int temp = prices.get(n-i-1).intValue() + revenue(i,prices);
			if(temp > max_val){
				max_val = temp;
			}
			
		}
		return max_val;
	}

	
	//Dynamic Programming solution
	public static int revenue_Dynamic(int n, ArrayList<Integer> prices){
		ArrayList<Integer> revenue_arr = new ArrayList<>();
		revenue_arr.add(0);
		for(int i=1; i<=n; ++i){
			int max_value = Integer.MIN_VALUE;
			for(int j=1; j<=i; j++){
				int temp = prices.get(j-1) + revenue_arr.get(i-j);
				if(temp>max_value){
					max_value = temp;
				}
			}
			revenue_arr.add(max_value);
		}
		return revenue_arr.get(n);
	}
	
	
	
	
}
