# Baekjoon

## [2193번](https://www.acmicpc.net/problem/2193) 

### 문제

0과 1로만 이루어진 수를 이진수라 한다. 이러한 이진수 중 특별한 성질을 갖는 것들이 있는데, 이들을 이친수(pinary number)라 한다. 이친수는 다음의 성질을 만족한다.

1. 이친수는 0으로 시작하지 않는다.
2. 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.

예를 들면 1, 10, 100, 101, 1000, 1001 등이 이친수가 된다. 하지만 0010101이나 101101은 각각 1, 2번 규칙에 위배되므로 이친수가 아니다.

N(1 ≤ N ≤ 90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.

### 입력

첫째 줄에 N이 주어진다.

### 출력

첫째 줄에 N자리 이친수의 개수를 출력한다.

### 문제 풀면서 배운 점



### 소스코드

#### 정종원
```python
# 이천수

# 1 
# 1 = 1가지
# 2 
# 10 = 1가지
# 3 
# 101,100 = 2가지
# 4
# 1000 , 1001 , 1010 = 3가지
# 5
# 10000 , 10001 , 10010 , 10100 , 10101 = 5가지
# 6
# 100000 , 100001 , 100010 , 100100 , 101000 , 101001 , 101010 , 100101 

# dp[n] = dp[n-1] + dp[n-2];

n = int(input());

dp = [0,1,1,2];

for i in range(4,91):
    dp.append(0);
    dp[i] = dp[i-1] + dp[i-2];

print(dp[n]);
```
### 김형준
``` java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinaryNumber2193 {
    static long[][] dp = new long[91][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // f(1) = 1
        // f(2) = 10
        // f(3) = 101, 100
        // f(4) = 1000, 1010, 1001
        // f(5) = 10000, 10100, 10101, 10010, 10001

        // 끝자리가 0일 경우 끝자리가 1일 경우
        //        n = 1   2   3   4   5
        // dp[n][0] = 0   1   1   2   3
        // dp[n][1] = 1   0   1   1   2
        // dp[n][0] = dp[n - 1][0] + dp[n - 2][0]
        // dp[n][1] = dp[n - 1][1] + dp[n - 2][1]
        // dp[n] = dp[n][0] + dp[n][1]

        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[3][0] = 1;
        dp[3][1] = 1;

        for (int i = 4; i <= 90; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n][0] + dp[n][1]);

        br.close();
    }
}
```
### 김현선
``` java
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
```
### 김영웅
``` java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_2193 {
	public static void main(String[] args) throws IOException {
		// 해당 문제를 동적 프로그래밍 방식으로 해결
		// 메모하며 작은문제 부터 큰 규모의 문제를 해결
		// 이친수의 자릿수를 n이라고 가정
		 
		
		// n(1) = 1  (1개)
		// n(2) = 10 (1개)
		// n(3) = 100,101 (2개)
		// n(4) = 1000,1001,1010 (3개)
		// n(5) = 10000,10101,10100,10010,10001 (5개)
		// n(6) = 100000,101000,101010,100100,100101,100010,100001,101001 (8개)
		
		// 규칙은 n = n-1 + n-2;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int n = Integer.parseInt(br.readLine());
		// int 범위를 초과할수도 있으니 long자료형 사용
        long[] dp = new long[n+1];
			
		if(n==1) {
			dp[1] = 1;            					
		}else if(n==2) {
			dp[2] = 1;    				
		}else if(n > 2){
			dp[1] = 1;            					        	 
			dp[2] = 1;    				
        
			for(int i=3; i<n+1; i++) {
				dp[i] = dp[i-1] + dp[i-2];
				//dp[n] = dp[n-1] + dp[n-2]
			}   
        }
            
        
		
		
		
		System.out.println(dp[n]);
		
		
		
		
	}
}
```