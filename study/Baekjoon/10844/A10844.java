import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A10844 {
	/**
	 1. 소수가 아닌 자연수의 자릿수 개념 
	    1. 소수는 오른쪽으로 자릿수가 늘어난다
	        ```
	        숫자 : 0.146902
	        자릿수:   123456
	        ```
	    2. 자연수는 왼쪽으로 자릿수가 늘어난다
	        ```
	        숫자 : 146902
	        자릿수: 654321
	        ```
	2. 1 <= N < 100
	3. 0으로 시작하지 않는다  
	4. +1 또는 -1씩차이 난다
	    1. N번째 자릿수 값이 0인 경우 : 다음 자릿수 값으로 1밖에 올 수 없다
	    2. N번째 자릿수 값이 9인 경우 : 다음 자릿수 값으로 8밖에 올 수 없다
	    3. 2에서 10이 온다면 : 0 다음으로 올 수 있는 자릿수 값은 1
	    4. 즉 0, 9를 제외한 2 ~ 8은 +1, -1의 값을 다음 자릿수 값으로 가질 수 있다
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		/**
		 * 배열은 0부터 시작하니 사람이 인지하기 편하도록 +1
		 * [x] : 1 ~ n 까지의 자릿수 (자릿수는 0부터 시작하지 않는다)
		 * [][x] : 자릿값   
		 */
		long[][] dp = new long[n+1][10];

		// 자연수의 1번째 자리는 오른쪽 맨 끝자리이므로 경우의 수가 1개 뿐이다.
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		// 2번째 자릿수 ~ n번째 자릿수 
		for(int i = 2; i <= n; i++) {
			//i번째 자릿수의 자릿값들
			for(int j = 0; j < 10; j++) {
				//자릿값이 0이라면 이전 자릿수의 1번째 자릿값만 가능 
				if(j == 0) {	
					dp[i][j] = (dp[i-1][j+1]) % 1000000000;
				} 
				//자릿값이 9이라면 이전 자릿수의 8번째 자릿값만 가능
				else if(j == 9) {
					dp[i][j] = (dp[i-1][j-1]) % 1000000000;
				} 
				//2 ~ 8
				else {	
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
				}
			}
		}
		
		long result = 0;
		for(int i = 0; i < 10; i++) {
			result += dp[n][i];
		}
		
		System.out.println(result % 1000000000);
		
	}

}