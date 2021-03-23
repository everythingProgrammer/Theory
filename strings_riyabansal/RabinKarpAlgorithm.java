package strings_riyabansal;
import java.util.*;

/*Average / Best case - O(m+n)
 * Worst case - all characters of pattern and text are same 
 * 
 * eg pattern "AAA" , text "AAAAAAAAAA"
 * 
 * 
 * */


public class RabinKarpAlgorithm {
	
	public static void search(String pat , String text , int q) {
		
		int M = pat.length();
		int N = text.length();
		int i , j; 
		
		//hash value of pattern
		int p = 0;
		
		
		// hash value of the text
		int t = 0;
		
		
		int h = 1;
		int d = 256; // for 256 characters 
		// h-> pow(d,M-1)%q
		for( i = 0 ; i<M-1; i++) {
			h = (h*d)%q;
		}
		
		
		// calculate the hash value of pattern and first window of text
		for(i = 0 ; i<M ; i++) {
			p =   (d*p +pat.charAt(i))%q;
			t =   (d*t+text.charAt(i))%q;
		}
		
		//slide the pattern over the text character by character
		for(i = 0 ; i<=N -M; i++) {
			// check the value of current window of text and pattern
			if(p == t) {
				// then there is a possibility of match
				// and to avoid collision , we will match character by character
				for(j = 0 ; j<M ; j++) {
					if(text.charAt(i+j) != pat.charAt(j)) {
						break;
					}
				}
				if(j == M) {
					System.out.println(i);
				}
			}
			// calculate hash value of next window of the text
			// remove the first digit and add the new one at the end,
			
			// now t-> previous hash value
			if(i<N-M) {
				t = (d*(t - text.charAt(i) * h) + text.charAt(i+M))%q;
				
				// there might be a case when the hash value comes out to be negative
				if(t<0) {
					t = (t+q);
				}
			}
		}
		
		
		
	}
	
	public static void main(String args[]) {
		
		String text = "aabaaabdscadaaba";
		String pat = "aaba";
		int q = 101;
		search(pat,text, q);
		
	}	
}
