/*
 * Given a real number between 0 and 1 (0.72) that is passed in as a double, print the binary 
 * representation. If the number cannot be accurately printed in binary with at most 32 
 * characters print "ERROR"
 * From Cracking the Coding Interview Binary Manipulation problem 5.2
 */
public class BinaryInDecimal {

	public static void main(String[] args) {
		System.out.println(printBinary(0.875));
		System.out.println(printBinaryAlt(0.875));
		
	}
	
	public static String printBinary(double num){
		
		if(num>=1 || num<=0){
			return "ERROR";
		}
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		
		while(num>0){
			//if it can't be represented by 32 digits print "ERROR"
			if(binary.length() > 32){
				return "ERROR";
			}
			
			double r = num *2;
			if(r>=1){
				binary.append("1");
				num = r - 1; // 
			}
			else{
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}
	
	
	//Alternate way of approaching this problem
	public static String printBinaryAlt(double num){
		if(num>=1 || num<=0)
				return "ERROR";
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		double r = 0.5;
		
		
		while(num>0){
			if(binary.length() > 32){
				return "ERROR";
			}
			if(num-r>=0){
				binary.append(1);
				num -=r;
			}
			else{
				binary.append(0);
			}
			r/=2;
			
		}
		return binary.toString();
		
	}
	
	

}
