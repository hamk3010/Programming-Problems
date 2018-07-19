import java.util.ArrayList;

/*
 * You have an integer and you can flip exactly one bit from a 0 to a 1
 * Write code to find the length of the longest sequence of 1s you could create.
 * 
 * Problem adopted from Cracking the Coding Interview 5.3
 */


public class flipBit {

	public static void main(String[] args) {
		System.out.println(longestSequence(1775));
		

	}

	public static int longestSequence(int n){
		if(n==-1)
			return Integer.BYTES*8;
		ArrayList<Integer> sequences = getAlternatingSequences(n);
		return findLongestSequence(sequences);
	}
	
	/*
	 * Here we will return a list of the sizes of the sequences.
	 * The sequence starts off with the number of 0s
	 * and then alternates with he counts of each value
	 */
	public static ArrayList<Integer> getAlternatingSequences(int n){
		ArrayList<Integer> sequences = new ArrayList<Integer>();
		
		int searchingFor =0;
		int counter = 0;
		
		for(int i = 0; i<Integer.BYTES*8; i++){
			if( (n&1)!= searchingFor) {
				sequences.add(counter);
				searchingFor = n&1;
				counter = 0;
			}
			counter++;
			n>>>=1;
		}
		
		sequences.add(counter);
		return sequences;
	}
	
	/*
	 * Given the lengths of alternating sequences of 0s and 1s, find the longest
	 * one we can build
	 */
	public static int findLongestSequence(ArrayList<Integer> seq){
		int maxSeq = 1;
		
		for(int i =0; i< seq.size(); i +=2){
			int zerosSeq = seq.get(i);
			int onesSeqRight = i - 1 >= 0 ? seq.get(i-1) : 0;
			int onesSeqLeft = i + 1 < seq.size() ? seq.get(i+1) : 0;
			
			int thisSeq = 0;
			if(zerosSeq == 1){
				thisSeq = onesSeqLeft + 1 + onesSeqRight;
			}if(zerosSeq > 1 ){
				thisSeq = 1 + Math.max(onesSeqRight, onesSeqLeft);
			}
			else if(zerosSeq == 0){
				thisSeq = Math.max(onesSeqRight, onesSeqLeft);
			}
			maxSeq = Math.max(thisSeq, maxSeq);
		}
		return maxSeq;
	}
	
	
}
