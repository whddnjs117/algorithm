import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 카드 구매하기 2
 * https://www.acmicpc.net/problem/11052
 */
public class A16194 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] pack = new int[n+1];
		int[] dp = new int[n+1];
		
		String target = br.readLine();
		StringTokenizer st = new StringTokenizer(target, " ");
		
		for(int i = 1; i <= n; i++) {
			pack[i] = Integer.parseInt(st.nextToken());
			dp[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 1; i <= n; i++) {
			System.out.println(i + "개 카드");
			for(int j = 1; j <= i; j++) {
				//System.out.println("i: " + i + ", j: " + j);
				System.out.println(dp[i] + ", " + dp[i-j] + "+" + pack[j]);
				
				dp[i] = Math.min(dp[i], dp[i-j] + pack[j]);
			}
			//System.out.println("dp[i]: " + dp[i]);
			System.out.println();
		}
		System.out.println(dp[n]);

	}

}