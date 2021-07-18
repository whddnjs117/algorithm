import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 카드 구매하기 
 * https://www.acmicpc.net/problem/11052
 */
public class A11052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] pack = new int[n+1];
		int[] dp = new int[n+1];
		
		String target = br.readLine();
		StringTokenizer st = new StringTokenizer(target, " ");
		
		for(int i = 1; i <= n; i++) {
			pack[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + pack[j]);
			}
		}
		System.out.println(dp[n]);
		
		/**
		 * 카드 n장을 갖기위해 카드 1개, 2개 .. 각각의 최대값을 구한다.
		 * n-i에 저장된 각각의 최대값을 이용하여 n장의 최대값을 구한다.
		 * 
		 * 예) 카드 3개 구매 최대값 = 3개짜리 카드팩 + (3 - 1개 짜리 카드팩)
		 *
		 
		 4 / 1 5 6 7
		 dp[1] = Math.max(dp[1], pack[1] + dp[1-1]);
		 		Math.max(1, 0 + 0) 
		 	   = 1
		 
		 dp[2] = Math.max(dp[2], pack[1] + dp[2-1]);
		 		Math.max(0, 1 + 1)
		 	   = 2
		 	   = Math.max(dp[2], pack[2] + dp[2-2]);
		 	   Math.max(2, 5 + 0)
		 	   = 5
		 		
 		 dp[3] = Math.max(dp[3], pack[1] + dp[3-1]);
		 		Math.max(0, 1 + 5)
		  	   = 6
		  	   = Math.max(dp[3], pack[2] + dp[3-2]);
		 		Math.max(6, 5 + 1)
		  	   = 6
		  	   = Math.max(dp[3], pack[3] + dp[3-3]);
		 		Math.max(6, 6 + 0)
		  	   = 6
		  	   
		 		
		 */

	}

}