import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_15990 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 오버플로우 예외가 발생할 수 있으므로 long 자료형 사용
		long result;
		// [n][사용할 수]
		long[][] dp = new long[100001][4];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 경우의 수가 1개 이므로 1로 초기화
		dp[1][1] = dp[2][2] = dp[3][3] = 1;
		
		for(int i=1; i<dp.length; i++) {
			if(i>1) dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1000000009;
			if(i>2) dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1000000009;
			if(i>3) dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1000000009;
		}
		// 테스트 케이스 수
		int count = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<count; i++) {
			int num = Integer.parseInt(br.readLine());
			// 임의의 정수의 수식이 1로 끝나는 경우의 수 + 2 경우의수 + 3경우의수 을 1000000009 로 나눈 나머지 값
			result = (dp[num][1] + dp[num][2] + dp[num][3]) % 1000000009;
			System.out.println(result);
		}
	}
}