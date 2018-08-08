package cool_tricks;

import java.util.Arrays;

public class nextClosestTime {

	/** 
     * find the next bigger digit which is no more than upperLimit. 
     * If no such digit exists in digits[], return the minimum one i.e. digits[0]
     * @param current the current digit
     * @param upperLimit the maximum possible value for current digit
     * @param digits[] the sorted digits array
     * @return 
     */
    public static char findNext(char current, char upperLimit, char[] digits) {
        //System.out.println(current);
        if(current == upperLimit) {
            return digits[0];
        }
        int pos = Arrays.binarySearch(digits, current) + 1;
        while(pos < 4 && (digits[pos] > upperLimit || digits[pos] == current)) { // traverse one by one to find next greater digit
            pos++;
        }
        return pos == 4 ? digits[0] : digits[pos];
    }
    
    public static String nextClosestTime(String time) {
    	char[] timeArr = time.toCharArray();
    	char[] digits = {timeArr[0], timeArr[1], timeArr[3], timeArr[4]};
    	Arrays.sort(digits);
    	
    	//Now we find the next HH:M_
    	timeArr[4] = findNext(timeArr[4], (char)('9' + 1), digits );
    	if(timeArr[4] > time.charAt(4)){
    		return String.valueOf(timeArr); //23:43 -> 23:44
    	}
    	
    	timeArr[3] = findNext(timeArr[3], '5', digits);
    	if(timeArr[3] > time.charAt(3) ){
    		return String.valueOf(timeArr); //14:29 -> 14:41
    	}
    	
    	timeArr[1] = timeArr[0]=='2' ? findNext(timeArr[1], '3' ,digits) : findNext(timeArr[1], '2', digits);
    	if(timeArr[1]> time.charAt(1)){
    		return String.valueOf(timeArr); //02:37 --> 03:00
    	}
    	
    	timeArr[0] = findNext(timeArr[0], '2', digits);
        return String.valueOf(timeArr); //19:59 --> 11:11
    	
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nextClosestTime("19:59"));

	}
	
	
}
