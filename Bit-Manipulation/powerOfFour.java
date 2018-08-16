
public class powerOfFour {
	
	public static boolean isPowerOfFour(int num){
		int isPowerofTwo = 0;
		int position = 1;
		
		for(int i = 0; i<32; i++){
			//shift num left by 1
			if( ( (num>>i) & 1 )== 1){
				isPowerofTwo ++;
				position = i;
			}
		}
		if(isPowerofTwo!=1)
			return false;
		//check if it is only a power of 2 or 4
		return position%2 ==0;
	}
	
	public static void main(String args[]){
		System.out.println(isPowerOfFour(128));
		System.out.println(isPowerOfFour(262144));
		
	}
}
