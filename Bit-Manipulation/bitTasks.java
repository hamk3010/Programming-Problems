import java.util.Scanner;

public class bitTasks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
//		System.out.println("Here is the bit version of this:");
//		for(int i=0; i<31; i++)
		
		
		
//		Test clearBit(5,0)
		System.out.println("Here is the cleared 0-th bit version of this:");
		System.out.println(clearBit(n,0));
		
//		Test clearBitMSThroughI(5,2)
		System.out.println("Here is the cleared MS through I-th bit version of this:");
		System.out.println(clearBit(n,2));
		
//		Test clearBitIThrough0(5,2)
		System.out.println("Here is the cleared MS through I-th bit version of this:");
		System.out.println(clearBitsIthrough0(n,1));
		
//		Test UpdateBit(5,8,1)
		System.out.println("Here is the cleared MS through I-th bit version of this:");
		System.out.println(updateBit(n,8,true));
		
		
		
	}

	
	
	public static boolean getBit(int num, int i){
		return ((num & (1 << i) ) != 0);
	}
	
	public static int setBit(int num, int i){
	   /* If num = 5 = 00000000-00000000-00000000-00000101
		* and we want to set the 5th bit (remember bits are zero-indexed)
		* 00000000-00000000-00000000-00000101
		* 00000000-00000000-00000000-00100000
		* 00000000-00000000-00000000-00100101 = 37
		*/
		return num | (1<<i);
	}
	
	public static int clearBit(int num, int i){
		int mask = ~(1<<i);
		/* If num = 5 = 00000000-00000000-00000000-00000101
		* and we want to clear the 0th bit (remember bits are zero-indexed)
		*         00000000-00000000-00000000-00000101 = 5
		* mask  = 11111111-11111111-11111111-11111110
		*         00000000-00000000-00000000-00000100 = 4
		*/
		return num&mask;
	}
	
	
	/*
	 * Clear bits from Most Significant through the i-th bit (inclusive)
	 */
	public static int clearBitsMSthroughI(int num, int i){
		int mask = (1<<i) - 1;
		return num & mask;
		/* Let num = 5 =              00000000-00000000-00000000-00000101 = 5
		 * Let i = 2 (2nd bit)
		 * 1<<2 =                     00000000-00000000-00000000-00000100
		 * 
		 * (1<<2) - 1 = Mask =        00000000-00000000-00000000-00000011
		 *                       
		 *  num & mask =              00000000-00000000-00000000-00000001 = 1
		 */
		
	}
	/*
	 * Clear all bits from i (inclusive) through 0 
	 * 
	 */
	public static int clearBitsIthrough0(int num, int i){
		int mask = ~(-1 >>> (31-i) );
		return num & mask;
		
		/* num = 5                00000000-00000000-00000000-00000101 = 5
		 *                        11111111-11111111-11111111-11111111 = -1
		 * i = 1
		 * (-1 >>(31 - i) )       00000000-00000000-00000000-00000111
		 * mask =                 11111111-11111111-11111111-11111100 = 4         
		 * 
		 */
	}
	
	public static int updateBit(int num, int i, boolean bitIs1){
		int value= bitIs1 ? 1 : 0;
		int mask = ~(1<<i);
		return (num&mask) | (value << i);
		
		/*
		 * Let num = 5       00000000-00000000-00000000-00000101 = 5
		 * i = 8
		 * mask =            11111111-11111111-11111110-11111111
		 * num&mask =        00000000-00000000-00000000-00000101
		 * value<<i =        00000000-00000000-00000001-00000000
		 *          =        00000000-00000000-00000001-00000101 261
		 * 
		 */
	}
	
	
	
}
