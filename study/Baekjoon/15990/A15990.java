import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A15990 {
	/*
	 * 1. n = 5 일 때, 주어진 1,2,3으로만 5를 표현하면 아래와 같다
		 1 + 4 = 5
		 2 + 3 = 5
		 3 + 2 = 5
	 	
		'4'를 만드는 수식 중 '1'로 끝나는 수식에 5를 만들기 위해  
		+1를 한다면 연속된 수는 쓰지 말라는 제한조건에 벗어난다.
			(1+1+1+1)+1  X 
			(1+2+1)+1    X
			(2+1+1)+1    X
			(3+1)+1      X
			
			(1+1+2)+1   O
			(2+2)+1     O
			(1+3)+1     O
		
		'3'을 만드는 수식 중 '2'로 끝나는 수식에 5를 만들기 위해 
		+2를 한다면 연속된 수는 쓰지 말라는 제한조건에 벗어난다.
			(1+2)+2    X
			
			(1+1+1)+2  O
			(2+1)+2    O
			(3)+2      O 
		
		'2'을 만드는 수식 중 '3'로 끝나는 수식에 5를 만들기 위해 
		+3를 한다면 연속된 수는 쓰지 말라는 제한조건에 벗어난다.
			(1+1)+3    O
			(2)+3      O
		(n=5일 때 2는 제한조건에 벗어나지 않아서 위와 같은 식이 도출된다) 
		 
	 * 2. 1번을 점화식으로 표현하면 아래와 같다 
	 	dp[n][1] = dp[n-1][2] + dp[n-1][3]	//1로 끝나는 경우에 또다시 1을 더해줄 필요 없기 때문에 2, 3만을 고려 
	 	dp[n][2] = dp[n-2][1] + dp[n-2][3]	//2로 끝나는 경우에 또다시 2을 더해줄 필요 없기 때문에 1, 3만을 고려
	 	dp[n][3] = dp[n-3][1] + dp[n-3][2]	//3로 끝나는 경우에 또다시 3을 더해줄 필요 없기 때문에 1, 2만을 고려
	
	 	2차 배열에 들어가있는 1,2,3은 n을 1,2,3의 합으로 나타낼 때
	 	마지막 수식이 1일 때의 방법의 수, 2일 때의 방법의 수, 3일 때의 방법의 수를 뜻한다.
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = stoi(br.readLine());
		long[][] dp = new long[100_001][4];
		
		/*
		 * 1+1, 2+2, 1+1+2, 1+2+1+1 와 같이 연속된 수는 사용할 수 없다 
		 */
		dp[1][1] = 1; // (1), 1개 
		dp[2][2] = 1; // (1+1) = X, (2) = O, 1개 
		dp[3][1] = 1; // (2+1), 1개 
		dp[3][2] = 1; // (1+2), 1개 
		dp[3][3] = 1; // (3), 1개 
		
		for(int i = 4; i <= 100_000; i++) {
			dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1_000_000_009;
			dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1_000_000_009;
			dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1_000_000_009;
		}
		
		for(int i = 0; i < n; i++) {
			int t = stoi(br.readLine());
			sb.append((dp[t][1] + dp[t][2] + dp[t][3]) % 1_000_000_009 + "\n");
		}
		
		System.out.println(sb);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}

}