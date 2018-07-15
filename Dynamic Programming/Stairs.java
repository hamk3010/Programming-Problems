// Use dynamic programming to count how many ways there are to climb n stairs
// constraints are:
// You can climb stairs in 2 ways:
// 1. 1 Stair at a time
// 2. 2 stairs at a time


public class Stairs {

	public static void main(String args[]){
		long t0 = System.nanoTime();
		System.out.println(stairs_recursive(20));
		long endTime = System.nanoTime();
		long duration = (endTime - t0);
		System.out.println("Recursive Completed in:" + duration + " nanoseconds");
		long t1 = System.nanoTime();
		System.out.println(stairs(20));
		long endTime_t1 = System.nanoTime();
		long durationt1 = (endTime_t1 - t1);
		System.out.println("Dynamic Completed in:" +   durationt1 + " nanoseconds" );
	}

	// Recursive approach:
	public static int stairs_recursive(int n){
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		return stairs_recursive(n-1) + stairs_recursive(n-2);
	}

	//Dynamic Programming
	public static int stairs(int n){
		int[] S = new int[n+1];
		S[1] = 1;
		S[2] = 2;
		for(int i = 3; i<=n; i++){
			S[i] = S[i-1] + S[i-2];
		}
		return S[n];
	}
}
