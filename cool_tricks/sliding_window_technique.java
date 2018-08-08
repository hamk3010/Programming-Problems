package cool_tricks;

//sliding_window_techinique finds the maximum sum of k elements in an array, and it reduces for multiple for loops
// to one for loop, hence bringing down the complexity of the problem from O(kn) to O(n).
public class sliding_window_technique {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
        System.out.println(maxSumSlidingWindow(arr, n, k));

	}
	
	//Naive O(n) implementation from GeekforGeeks (source: https://www.geeksforgeeks.org/window-sliding-technique/)
	static int maxSum(int arr[], int n, int k)
    {
        // Initialize result
        int max_sum = Integer.MIN_VALUE ;
     
        // Consider all blocks starting with i.
        for (int i = 0; i < n - k + 1; i++)
        {
            int current_sum = 0;
            for (int j = 0; j < k; j++)
                current_sum = current_sum + arr[i + j];
     
            // Update result if required.
            max_sum = Math.max(current_sum , max_sum );
        }
     
        return max_sum;
    }
	
	static int maxSumSlidingWindow(int arr[], int n, int k){
		int max_sum = 0;
//		compute the sum of the first k elements
		for(int i=0; i<k; i++){
			max_sum+=arr[i];
		}
//		now slide across the array adding the last element and subtracting by the first element
		int temp_sum = max_sum;
		for(int i=k; i<n; i++){
			temp_sum -= arr[i-k];
			temp_sum += arr[i];
			max_sum = Math.max(max_sum, temp_sum);
		}
		return max_sum;
	}

}
