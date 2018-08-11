package cool_tricks;

//This function finds the max repetition of numbers in an array.
// Constraints on this problem are:
// - The value of the elements within the array are less than the size of the array.
public class maxRepetition {
	
	public static int getMaxRepetition(int [] a){
		int k = a.length;
		//Iterate through input array, for every element a[i]
		// increase all elements a[a[i]%k] by k
		for(int i = 0; i<a.length; i++){
			a[a[i]%k] += k;
		}
		int maxr = a[0], result =0;
		for(int i = 0; i<a.length; i++){
			if(a[i]>maxr){
				maxr = a[i];
				result = i;
			}	
		}
		for(int element: a){
			System.out.print(element+",");
		}
		System.out.println();
		return result;
	}
	

	public static void main(String[] args) {
		int[] arr = {2,3,4,2,5,2,1};
		System.out.println(getMaxRepetition(arr) );
	}
	
}
