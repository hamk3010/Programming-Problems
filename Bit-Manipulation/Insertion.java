/* You are given 2 32-bit numbers, N and M, and two bit positions i and j. Write a method to insert
 * M into N such that M start at bit j and ends at bit i. 
 * 
 * If M =10011, you can assume that there are at least five bits between j and i
 * 
 * Input = N = 10000000000 , M = 10011, i = 2, j = 6
 * Output = N= 10001001100
 * (This one is from Cracking the Coding Interview Bit Manipulation problem)
*/
public class Insertion {

	public static void main(String[] args) {
		int N = Integer.parseInt("10000000000",2);
		int M = Integer.parseInt("10011",2);
		
		String insertedString = Integer.toBinaryString(insert(N,M,2,6 ));
		
		System.out.println(insertedString);

	}
	
	
	public static int insert(int N, int M, int i, int j){
		// N = 100-00000000 ->       00000000-00000000-00000100-00000000
		// M = 10011       ->        00000000-00000000-00000000-00010011
		//let j = 6
		//left i = 2
		int newN = 0;
		
		int allOnes = ~0; //          11111111-11111111-11111111-11111111
		int left = allOnes<<(j+1); // 11111111-11111111-11111111-10000000
		int right = ((1<<i) - 1); //  00000000-00000000-00000000-00000011
		/* Mask will have zeros only 
		*where M is 
		*supposed to be inserted
		*/
		int mask = right|left;    //  11111111-11111111-11111111-10000011
		int n_cleared = N&mask;   //  00000000-00000000-00000100-00000000
		int m_shifted = M<<i;	  //  00000000-00000000-00000000-01001100
		newN = n_cleared|m_shifted;// 00000000-00000000-00000100-01001100
								
		
		return newN;
	}

}
