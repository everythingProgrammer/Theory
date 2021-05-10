package dp_arjunarul;
import java.util.*;
public class TilingProblem {
	
	public static int ways(int N) {
		if(N < 0) {
			return 0;
		}
		if(N ==0) {
			return 1;
		}
		int w = 0;
		w += ways(N-1);
		w += ways(N-2);
		return w;
	}
	
	
	public static void main(String args[]) {
		System.out.println(ways(3));
	}
}
