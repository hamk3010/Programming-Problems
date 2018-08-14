package cool_tricks;

public class inPlaceSwitch {
	
	public static void swap(int[] M, int[] N){
		int m = M[0];
		int n = N[0];
		m = m^n;
		n = m^n;
		m = m^n;
		M[0] = m;
		N[0] = n;
	}
	

	public static void main(String[] args) {
		int[] M = {5};
		int[] N = {6};
		System.out.println("M = " +M[0] + " N = " + N[0] );
		swap(M,N);
		System.out.println("M = " +M[0] + " N = " + N[0] );
	}

}
