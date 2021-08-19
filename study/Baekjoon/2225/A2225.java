import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2225 {
	/**
	 * N = 1
	 N  K  DP 
	 1  1  1 (1)
	 1  2  1+0, 0+1 (2)
	 1  3  0+0+1, 1+0+0, 0+1+0 (3)
	 
	 * N = 2
	 N  K  DP
	 2  1  2 (1)
	 2  2  2+0, 0+2, 1+1 (3)
	 2  3  2+0+0, 0+2+0, 0+0+2, 0+1+1, 1+0+1, 1+1+0 (6)
	 
	 * N = 3
	 N  K  DP
	 3  1  3 (1)
	 3  2  3+0, 0+3, 2+1, 1+2 (4)
	 3  3  3+0+0, 0+3+0, 0+0+3, 2+1+0, 2+0+2, 1+2+0, 1+0+2, 0+1+2, 0+2+1, 1+1+1 (10)
	 
	 N  K  DP / N  K  DP / N  K  DP
	 1  1  1    2  1  1    3  1  1  
	 1  2  2    2  2  3    3  2  4
	 1  3  3    2  3  6    3  3  10
	 
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N+1][K+1];
		
		// N == 1 일 때 초기화
		for(int i = 0; i <= K; i++) {
			dp[1][i] = i;
		}
		
		// K == 1 일 때 초기화 
		for(int i = 1; i <= N; i++) {
			dp[i][0] = 1;
			dp[i][1] = 1;
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 2; j <= K; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1] % 1000000000;
			}
		}
		
		System.out.println(dp[N][K]);
	}

}