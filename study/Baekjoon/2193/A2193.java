import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A2193 {
	static long[] dp2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		long[] dp = new long[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println("bottom-up");
		System.out.println(dp[n]);
		
		dp2 = new long[n+1];
		
		System.out.println("top-down");
		System.out.println(test(n));
		
	}

	public static long test(int n) {
		if(n == 1) {
			return 1;
		} else if(n == 2) {
			return 1;
		}
		
		for(int i = 3; i<= n; i++) {
			dp2[i] = test(i-1) + test(i-2);
		}
		
		return dp2[n];
	}
}