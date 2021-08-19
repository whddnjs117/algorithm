# Baekjoon

## [2225번](https://www.acmicpc.net/problem/2225) 

### 문제

0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.

덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.

### 입력

첫째 줄에 두 정수 N(1 ≤ N ≤ 200), K(1 ≤ K ≤ 200)가 주어진다.

### 출력

첫째 줄에 답을 1,000,000,000으로 나눈 나머지를 출력한다.

### 문제 풀면서 배운 점

다이나믹 프로그래밍으로 처음부터 증가한다고 생각하면 규칙을 찾아 문제를 풀도록 하였습니다.

### 소스코드

#### 정종원
```python
# 0 부터 20까지 정수를 2개를 더해서 20을 만드는 가짓수
#  1, 1
# 1
# 1 , 2
# 2
# 1, 3
# 3

# 2 , 1
# 1
# 2 , 2
# 3
# 2 , 3
# 6

# 3 , 1
# 1
# 3 , 2
# 4
# 3 , 3
# 10

# 4 , 1
# 1 
# 4 , 2
# 5
# 4 , 3
# 15

# [0 0 0 0 0 ..]
# [0 1 2 3]
# [0 1 3 6]
# [0 1 4 10]
# [0 1 5 15]

# dp[n][k] = dp[n-1][k] + dp[n][k-1]
n , k = map(int ,input().split());

dp = [[0] * (k+1) for _ in range(n+1)];


dp[0][0] = 1;
for i in range(0,n+1):
    
    for j in range(1,k+1):
        dp[i][j] = dp[i-1][j] + dp[i][j-1];

print(dp[n][k]);


```
### 김형준
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecompositionSum2225 {

    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /**
         * 합분해 문제
         * 0부터 N 까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.
         * 덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.
         */
        // dp[K][N]
        // dp[1][1] = 1
        // dp[1][2] = 1
        // dp[1][3] = 1
        // dp[2][1] = 2
        // dp[2][2] = 3
        // dp[2][3] = 4
        // dp[3][1] = 3
        // dp[3][2] = 6
        // dp[3][3] = 10

        //TODO 설명 추가 해야함 K = 1 경우 무조건 1, N = 1 경우 N
        // 맨 앞 숫자를 이미 선택 했다 가정하고 접근하면 점화식을 이해하기 쉬움
        // K = 3 경우 부터 점화식 dp[K][N] = dp[K - 1][N 밑으로 전부 합산]
        // ex) dp[k - 1][N] + dp[k - 1][N - 1] + dp[k - 1][N - 2] ...

        // 점화식 : dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        //                   맨앞 숫자가 0      그 나머지 값

        // [2][0] = 00
        // [2][1] = 01, 10
        // [2][2] = 02, 11, 20
        // [2][3] = 03, 12, 21, 30
        // [3][1] = 001, 010, 100

        // ex) [3][2] = ( 002, 011, 020 ), 101, 110, 200
        //              앞이 0이라고 가정함    나머지(앞이 1이라고 가정,2라고 가정)
        //              dp[i - 1][j]       [2][1], [2][0] = [3][1]

        String[] inputLine = br.readLine().split(" ");
        int N = Integer.parseInt(inputLine[0]);
        int K = Integer.parseInt(inputLine[1]);

        long[][] dp = new long[K + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i <= K; i++) {
            dp[i][1] = i;
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 2; j <= N; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }
        /* 처음 소스
        for (int i = 3; i <= K; i++) {
            for (int j = 2; j <= N; j++) {
                for (int y = 0; y <= j; y++) {
                    dp[i][j] += dp[i - 1][y] % MOD;
                }
            }
        }
         */
        System.out.println(dp[K][N] % MOD);
    }
}
```
### 김현선
```java
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
```
### 김영웅
```java
import java.util.Scanner;

public class A_2225 {

	public static void main(String[] args) {
		
		/* (합)(갯수)      
		 * 	n	k 경우의수   n	k 경우의수
		 *  1	1	1	 2	1	1
		 *  1   2   2	 2	2	3
		 *  1   3   3    2	3	6
		 *  1	4	4	 2	4	10
		 *  
		 *  		
		 *  dp[n][k] = dp[n-1][k] + dp[n][k-1]
		 *  
		 *  만약 n이 2이고 k가 4라면
		 *  dp[2][4] = dp[1][4] + dp[2][3]
		 *  
		 *  dp[n-1][k]에는 + 1 
		 *  dp[n][k-1]에는 마지막에 + 0 
		 *  
		 *  dp[1][4]	dp[2][3] 
		 *  0+0+0+1		2+0+0
		 *  0+0+1+0		0+2+0
		 *  0+1+0+0		1+1+0
		 *  1+0+0+0		0+0+2
		 *  			0+1+1
		 *  			0+0+2
		 *
		 * 
		 * dp[2][4] 
		 * 
		 * 0+0+0+2		2+0+0+0
		 * 0+0+1+1		0+2+0+0
		 * 0+1+0+1		1+1+0+0
		 * 1+0+0+1		0+0+2+0
		 * 				0+1+1+0
		 * 				0+0+2+0
		 */ 			
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		int k = sc.nextInt(); 
		
		// n과 k는 200이하 이므로 201 로 초기화
		int[][] dp = new int[201][201]; 
		
		
		for(int i=1;i<=k;i++) {
			dp[i][0]=1;
		}
		for(int i=1;i<=k;i++) {
			for(int j=1;j<=n;j++) {
				dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000000; // 1000000000으로 나누는 걸 출력할 때 주면 틀렸다고 뜸.
			}
		}
		System.out.println(dp[k][n]);
	}

}
```