package dp_arjunarul;
import java.util.*;
public class MaximizeSum {
	
	
	public static void main(String args[]) {
		int arr[] = {1,-1,-2,-100,1};
		int dp[] =new int[arr.length+1];
		dp[1] = arr[0];
		dp[0] =0;
		for(int i = 2; i<dp.length; i++) {
			
			dp[i] = arr[i-1]+Math.max(dp[i-1], dp[i-2]);
		}
		for(int i=0; i<dp.length;i++) {
//			System.out.print(dp[i]+" ");
		}
		System.out.println(dp[dp.length-1]);
	}
}
