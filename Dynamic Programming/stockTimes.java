import java.util.ArrayList;
import java.util.Collections;

/*
 * You have an array for which the i-th element is the price of
 * a given stock on day i
 * 
 * If you were only permitted to complete at most one transaction
 * (i.e. buy one and sell one share of the stock), design an 
 * algorithm to find the maximum profit
 * 
 * Examples:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * If we buy the stock on the 2nd (for $1) day and sell it on 
 * the 5th day (for $6) our max difference will be 6-1 = 5
 * 
 * Input: [7,6,4,3,1]
 * Output: 0
 * In this case there is no transaction since all transactions
 * lead to a loss
 * 
 * Problem adopted from Udemy course on Dynamic Programming
 */
public class stockTimes {

	public static void main(String[] args) {
		Integer[] p = {7,1,5,3,6,4};
		Integer[] p2 = {7,6,4,3,1};
		ArrayList<Integer> P2 = new ArrayList<>();
		ArrayList<Integer> P1 = new ArrayList<>();
		Collections.addAll(P1, p);
		Collections.addAll(P2,p2);
		
		System.out.println(maximumProfit_recursive(6,P1));
		System.out.println(maximumProfit_recursive(5,P2));
		
		System.out.println(maximumProfit_memoized(P1));
		System.out.println(maximumProfit_memoized(P2));
		
		
		}

	
	
	/*
	 * Idea is to take each element of the list starting from the end
	 * and checking if we can make a profit by comparing with prices in the 
	 * days prior to it. We try to find the maximum amount we can get
	 * O(n^2)
	 */
	public static int maximumProfit_recursive(int i, ArrayList<Integer> P){
		
		if(i==0){
			return 0;
		}
		int max_val = maximumProfit_recursive(i-1, P);
		for(int j=1; j<=i; ++j){
			max_val= Math.max(max_val, P.get(i-1) - P.get(j-1) );
		}
		return max_val;
	}
	
	
	/*
	 * Memoized solution gives optimization O(n)
	 */
	public static int maximumProfit_memoized(ArrayList<Integer>P){
		ArrayList<Integer> R = new ArrayList<>();
		R.add(0);
		int min_value = P.get(0);
		
		for(int i = 1; i<P.size(); i++){
			min_value = Math.min(min_value, P.get(i) );
			int prev = R.get(R.size()-1) ;
			int myMax = Math.max(prev,P.get(i) - min_value) ;
			if(myMax!=prev)
				R.add(myMax );
		}
		return R.get(R.size()-1);
	}
	
	
	
	
	

}
