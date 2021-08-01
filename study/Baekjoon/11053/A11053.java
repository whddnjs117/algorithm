import java.util.Scanner;

public class A11053 {
	static int[] count;
	static Integer[] dp;


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		count = new int[n];
		dp = new Integer[n];
		
		
		for(int i = 0; i < n; i++) {
			count[i] = in.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			recur(i);
		}
		
		int max = dp[0];
		for(int i = 1; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);

	}

	static int recur(int n) {
		if(dp[n] == null) {
			dp[n] = 1;	 
			 
			for(int i = n - 1; i >= 0; i--) {
				if(count[i] < count[n]) {
					dp[n] = Math.max(dp[n], recur(i) + 1);
				}
			}
		}
		return dp[n];
	}
}