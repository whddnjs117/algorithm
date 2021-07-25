# Baekjoon

## [15990번](https://www.acmicpc.net/problem/15990) 

### 문제

정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 3가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다. 단, 같은 수를 두 번 이상 연속해서 사용하면 안 된다.

* 1+2+1
* 1+3
* 3+1

정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

### 입력

첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 100,000보다 작거나 같다.

### 출력

각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 1,000,000,009로 나눈 나머지를 출력한다.

### 문제 풀면서 배운 점

다이나믹 프로그래밍도 이중배열을 통해 더 복잡하게 값을 저장하며 나갈수 있음을 알게되는 문제임을 느꼇다.

### 소스코드

#### 정종원
```python


# 1 일 경우
# dp[1] = (1) = 1 가지
# 2 일 경우
# dp[2] = (2) = 1 가지
# 3 일 경우
# dp[3] = (1+2) , (2+1) , (3) = 3 가지
# 4 일 경우
# dp[4] = (1+2+1) , (1+3) , (3+1) = 3 가지
# 5 일 경우
# dp[5] = (2+3) , (3+2) , (1+3+1) , (2+1+2) = 4 가지
# 6 일 경우
# dp[6] = (1+3+2) , (1+2+3) , (2+1+3) , (2+3+1) , (3+2+1) , (3+1+2) , (2+1+2+1) , (1+2+1+2)= 8 가지
# 7 일 경우
# dp[7] = (1+2+1+2+1) , (3+1+2+1) , (1+3+2+1) , (1+2+3+1) , (1+3+1+2) , (1+2+1+3) , (3+1+3) , (2+1+3+1) , (2+3+2) = 9 가지

# N             숫자 1      숫자 2      숫자 3      합계 
# 1             1           0           0          1개
# 2             0           1           0          1개
# 3             1           1           1          3개
# 4             2           0           1          3개
# 5             1           2           1          4개
# 6             3           3           2          8개
# 7             5           2           2          9개

# 예시 dp[7] = dp[7][1] + dp[7][2] + dp[7][3]
# dp[7][1] = dp[6][2] + dp[6][3]
# dp[7][2] = dp[5][1] + dp[5][3]
# dp[7][3] = dp[4][1] + dp[4][2]
# 점화식
# dp[n][1] = dp[n-1][2] + dp[n-1][3]
# dp[n][2] = dp[n-2][1] + dp[n-2][3]
# dp[n][3] = dp[n-3][1] + dp[n-3][2]
import sys
input = sys.stdin.readline;

dp = [
       [0,0,0,0]
      ,[0,1,0,0]
      ,[0,0,1,0]
      ,[0,1,1,1]
];

for n in range(4,100001):
    dp.append([0,0,0,0]);
    dp[n][1] = dp[n-1][2] + dp[n-1][3];
    dp[n][2] = dp[n-2][1] + dp[n-2][3];
    dp[n][3] = dp[n-3][1] + dp[n-3][2];
    
n = int(input());    
for n in range(0,n):
    number = int(input());
    print(dp[number][1] + dp[number][2] + dp[number][3]);


```
### 김형준
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneTwoThreeFive15990 {

    static int[][] dp = new int[100001][4];
    final static int MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i = 4; i<= 100_000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }

        int testCase = Integer.parseInt(br.readLine());
        while (testCase --> 0){
            int n = Integer.parseInt(br.readLine());
            int result = 0;
            for (int i = 1; i <= 3; i++){
                result += dp[n][i];
                result %= MOD;
            }
            sb.append(result).append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}
```
### 김현선
```
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
```
### 김영웅
```java
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
```