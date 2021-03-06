# Baekjoon

## [10844번](https://www.acmicpc.net/problem/10844) 

### 문제

45656이란 수를 보자.

이 수는 인접한 모든 자리수의 차이가 1이 난다. 이런 수를 계단 수라고 한다.

세준이는 수의 길이가 N인 계단 수가 몇 개 있는지 궁금해졌다.

N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. (0으로 시작하는 수는 없다.)

### 입력

첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.

### 출력

첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.

### 문제 풀면서 배운 점

15990번 문제를 통해 이중배열을 사용할 수 있음을 느끼고 배열을 그려 점화식이 어떤게 있는지 눈으로 파악할려고 하였으나, 아직은 눈에 확들어오질않아
그림은 그렷으나 점화식 구현하는데 어려움을 느꼈다.

### 소스코드

#### 정종원
```python
# 인접한 수 의 차이 값을 구하기

# 1 = 9
# 2 = 17

# 1 의 가짓수
# 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9
# 2 의 가짓수
# 10 , 12 , 21 , 23 , 32 , 34 , 43 , 45 , 54 , 56 , 65 , 67 , 76 , 78 , 87 , 89 , 98
# 3 의 가짓수
# 101 , 121 , 123 , 212 , 210 ,232 , 323 , 321 , 343 , 434 , 432 , 454 , 545 , 543 , 565 , 656 , 654 , 676 , 767 , 765 , 787 , 878 , 876 , 898 , 989 , 987 
# 4 의 가짓수
# 1010 , 1210 , 1232 , 1234 , 1012 , 1212 // 2101 , 2121 , 2123 , 2321 , 2343 , 2345 
# 9876 , 9878 

# number    1   2   3   4   5   6   7   8   9   
# 1         1   1   1   1   1   1   1   1   1
# 2         2   2   2   2   2   2   2   2   1
# 3         3   3   3   3   3   3   3   3   2
# 4         6   6                           2

# 점화식
# dp[4][1] = dp[3][1] + dp[2][1] + dp[1][1]
# dp[n][1] = dp[n-1][1] + dp[n-2][1] + dp[n-3][1];

# -------------------------------------위에 방식은 잘못됨 앞에 자릿수로 점화식으로 잡히질않음.
# 뒷자리로 정리
# 1 의 가짓수
# 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9
# 2 의 가짓수
# 10 , 21 , 12 , 32 , 23 , 43 , 34 , 54 , 45 , 65 , 56 , 76 , 67 , 87 , 78 , 98 , 89  
# 3 의 가짓수
# 210 , 321 , 121 , 101 , 432 , 232 , 212 , 543 , 343 , 323 , 123 .... 987 , 787 , 767 , 567 , 898 , 878 , 678 , 789 , 989
# 4 의 가짓수
# 0 : 3210 , 1210 , 1010  9 : 6789 , 8789 , 8989 
 
# number    0   1   2   3   4   5   6   7   8   9
# 1         0   1   1   1   1   1   1   1   1   1   
# 2         1   1   2   2   2   2   2   2   2   1
# 3         1   3   3   4   ............4   3   2
# 4         3                                   3

# dp[n][0] = dp[n-1][1]
# dp[n][9] = dp[n-1][8]

dp = [
     [0,0,0,0,0,0,0,0,0,0]
    ,[0,1,1,1,1,1,1,1,1,1]
    ,[1,1,2,2,2,2,2,2,2,1]
];

for i in range(3,101):
    dp.append([0,0,0,0,0,0,0,0,0,0]);

    for j in range(0,10):
        if j==0:
            dp[i][0] = dp[i-1][1];
        elif j==9:
            dp[i][9] = dp[i-1][8];
        else:
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
n = int(input());

print(sum(dp[n]) % 1000000000);
```
### 김형준
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StairsNumber10844 {
    final static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][10];

        for (int i = 1; i < 10; i++){
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++){
            for (int j = 1; j < 9; j++){
                dp[i][j] = (dp[i - 1][j -1] + dp[i - 1][j + 1]) % MOD;
            }
            dp[i][0] = dp[i - 1][1] % MOD;
            dp[i][9] = dp[i - 1][8] % MOD;
        }
        long result = 0;
        for (int i = 0; i < 10; i++){
            result += dp[N][i];
        }
        System.out.println(result % MOD);
    }
}
```
### 김현선
```java
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
```
### 김영웅
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_10844 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[n+1][10];
		
		for(int i=1; i<10; i++) {
			dp[1][i] = 1;
			
		}
		// 두번째 자릿수 부터 n까지 탐색
		// 자연수는 오른쪽에서 왼쪽으로 자릿수 증가
		for(int i=2; i<=n; i++) {
			// 0~ 9 탐색
			for(int j=0; j<10; j++) {
				if(j == 0) {
					dp[i][0] = dp[i-1][1] % 1000000000;
				}else if(j == 9) {
					dp[i][9] = dp[i-1][8] % 1000000000;
				}else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
				}
				
			}
		}
		long result = 0;
		for(int i=0; i<10; i++) {
			result += dp[n][i];
		}
		
		System.out.println(result % 1000000000);
	}
}
```