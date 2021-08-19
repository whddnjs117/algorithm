# Baekjoon

## [1699번](https://www.acmicpc.net/problem/1699) 

### 문제

어떤 자연수 N은 그보다 작거나 같은 제곱수들의 합으로 나타낼 수 있다. 예를 들어 11=32+12+12(3개 항)이다. 이런 표현방법은 여러 가지가 될 수 있는데, 11의 경우 11=22+22+12+12+12(5개 항)도 가능하다. 이 경우, 수학자 숌크라테스는 “11은 3개 항의 제곱수 합으로 표현할 수 있다.”라고 말한다. 또한 11은 그보다 적은 항의 제곱수 합으로 표현할 수 없으므로, 11을 그 합으로써 표현할 수 있는 제곱수 항의 최소 개수는 3이다.

주어진 자연수 N을 이렇게 제곱수들의 합으로 표현할 때에 그 항의 최소개수를 구하는 프로그램을 작성하시오.

### 입력

첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 100,000)

### 출력

주어진 자연수를 제곱수의 합으로 나타낼 때에 그 제곱수 항의 최소 개수를 출력한다.

### 문제 풀면서 배운 점

사실 지금 도 어떻게 점화식을 산출했는지 정확히는 이해하지는 않았다. 그리고 수학식도 어느정도는 지식수준이 필요하다고 느끼며 수학관련 공식을 제대로 알게된다면 점화식 산출하는데 있어서
더 쉽게 나올 것 같다는걸 느꼇다.

### 소스코드

#### 정종원
```python

n = int(input());

# dp[1] = 1²                                           / 1     
# dp[2] = 1² + 1²                                      / 2
# dp[3] = 1² + 1² + 1²                                 / 3
# dp[4] = 2² // 1² + 1² + 1² + 1²                      / 1 4
# dp[5] = 2² + 1² // 1² + 1² + 1² + 1² + 1²            / 2 5
# dp[6] = 2² + 1² + 1² // 1² * 6                       / 3 6
# dp[7] = 2² + 1² + 1² + 1² // 1² * 7                  / 4 7
# dp[8] = 2² + 2² // 2² + 1² + 1² + 1² + 1² // 1² * 8  / 2 5 8
# dp[9] = 3² // 2² + 2² + 1² // 2² + 1² + 1² + 1² + 1² + 1² // 1² *9 

# dp[1] = 1
# dp[2] = dp[1] + 1
# dp[3] = dp[2] + 1
# dp[4] = dp[3] + 1 , 1
# dp[5] = dp[4] + 1
# dp[6] = dp[5] + 1
# dp[7] = dp[6] + 1
# dp[8] = dp[7] + 1 , dp[4] + 1
# dp[9] = 1
# dp[n] = dp[n-i*i] + 1



dp = [0];

for i in range(1,n+1):
    dp.append(i);
    for j in range(1,i):
        if j*j>i:
            break;
        
        if dp[i] > dp[i-j*j] + 1:
            dp[i] = dp[i-j*j] + 1;

print(dp[n]);

```
### 김형준
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfSquareNumber1699 {

    public static void main(String[] args) throws IOException {
        /**
         * 제곱수의 합
         * 어떤 자연수 N은 그보다 작거나 같은 제곱수들의 합으로 나타낼 수 있다. 예를 들어 11=3^+1^+1^(3개 항)이다.
         * 주어진 자연수 N을 이렇게 제곱수들의 합으로 표현할 때에 그 항의 최소개수를 구하는 프로그램을 작성하시오.
         */
        // dp[1] = 1^
        // dp[2] = 1^ + 1^
        // dp[3] = 1^ + 1^ + 1^
        // dp[4] = 2^
        // dp[5] = 2^ + 1^
        // dp[6] = 2^ + 1^ + 1^
        // dp[7] = 2^ + 1^ + 1^ + 1^
        // dp[8] = 2^ + 2^
        // dp[9] = 3^

        // dp[9] = 1^ + 2^ + 2^
        // dp[9] = 2^ + 2^ + 1^
        // dp[9] = 3^

        // dp[12] = 1^ + dp[11]
        // dp[12] = 2^ + dp[8]
        // dp[12] = 3^ + dp[3]


        // 점화식 : Math.min(dp[i], dp[i - j*j] + 1)
        // ex) dp[12] 일 경우 dp[11] + 1, dp[8] + 1, dp[3] + 1, dp[1] * 12
        // 위에 j*j 가 위쪽 dp 부분의 제일 앞단임
        // dp[12] = (2^) + 2^ + 2^ -> 앞의 괄호가 j*j 부분 2^ 라고 가정하고 접근함
        //           +1     dp[8]

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = i; // 처음 dp[i]에 1^로만 들어가는 수를 넣음(가장 많은 수)
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}
```
### 김현선
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1699 {
	/**
	   i      1
	 dp[i]    1
	  j*j    1*1
	  
	  i  dp[i]  j  j*j  dp[i] > dp[i-(j*j)]+1
	  1    1    1   1        1 > (1) (dp[1-(1)]+1 -> dp[0]+1)
	  2    2    1   1        2 > (2) (dp[2-(1)]+1 -> dp[1]+1)
	  2    2    2   4      조건 불출분 
	  3    3    1   1        3 > (3) (dp[3-(1)]+1 -> dp[2]+1)
	  3    3    2   4      조건 불출분
	  4    4    1   1        4 > 4   (dp[4-(1)]+1 -> dp[3]+1)
	  4    4    2   4        4 > (1) (dp[4-(4)]+1 -> dp[0]+1)
	  5    5    1   1        5 > 2   (dp[5-(1)]+1 -> dp[4]+1)
	  5    5    2   4        2 > (2) (dp[5-(4)]+1 -> dp[1]+1)
	  6    6    1   1        6 > 3   (dp[6-(1)]+1 -> dp[5]+1)
	  6    3    2   4        3 > 3   (dp[6-(4)]+1 -> dp[2]+1)
	  6    3    3   9      조건 불출분
	  7    7    1   1        7 > 4   (dp[7-(1)]+1 -> dp[6]+1)
	  7    4    2   4        4 > 4   (dp[7-(4)]+1 -> dp[3]+1)
	  7    4    3   9      조건 불출분
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		
		for(int i = 1; i < dp.length; i++) {	// i가 구하고자 하는 n 값이라면 
			dp[i] = i;
			System.out.println("\n[START]");
			System.out.println("dp[" + i + "] = " + dp[i]);
			
			for(int j = 1; j*j <= i; j++) {		// i는 j를 제곱한 값보다 크거나 같아야 최소항의 개수를 구할 수 있다.
				System.out.println();
				System.out.println("j * j = " + j*j);
				System.out.println(j + " * " + j + " = " + (j*j));
				System.out.println(dp[i] + " > " + (dp[i-(j*j)]+1));
				
				if(dp[i] > dp[i-(j*j)]+1) {
					dp[i] = dp[i-(j*j)]+1;
					System.out.println("[TRUE] dp[i] = " + dp[i]);
				}
			}
		}
		
		System.out.println(dp[N]);
	}

}
```
### 김영웅
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_1699 {
	public static void main(String[] args) throws NumberFormatException, IOException {


		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int dp[]=new int[n+1];
		
		for (int i=1;i<=n;i++) {
			dp[i]=i;
			for (int j=1;j*j<=i;j++)
				// i에서 j*j를 뺀 수의 최소 개수 에 1을 더한 값 과 dp[i]를 비교해 최소값 구하기
				if (dp[i]>dp[i-j*j]+1)
					dp[i]=dp[i-j*j]+1;
		}
		System.out.println(dp[n]);
		
		

		
		
		
		
		
		
		
		// 혼자 푼 방식 N이 만약 12라면 12보다 작으면서 가장 큰 제곱수 9를 빼고
		// 3을 더해주는 방식
		// dp[12] = dp[9](1) + dp[3](3) = 4
		// 하지만 정답은 dp[12] = dp[4]+dp[4]+dp[4] = 3
		// 
		
		
		//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		long[] squareNumbers = new long[100001];
//		
//		for(int i=1; i<squareNumbers.length; i++) {
//			squareNumbers[i] = i*i;
//		}
//		
//		int n = Integer.parseInt(br.readLine());
//		int count = 0;
//		
//		if(n==1) {
//			System.out.println(1);
//			System.exit(0);
//		}else if(n==2) {
//			System.out.println(2);
//			System.exit(0);
//
//		}else if(n==3) {
//			System.out.println(3);
//			System.exit(0);
//
//		}else if(n==4) {
//			System.out.println(1);
//			System.exit(0);
//
//		}else if(n==5) {
//			System.out.println(2);
//			System.exit(0);
//
//		}
//		
//		while(true) {
//			for(int i=3; i<=n; i++) {
//				if(squareNumbers[i] > n) {
//					n = (int) (n-squareNumbers[i-1]);
//					count++;
//					break;
//				}else if(squareNumbers[i] == n) {
//					count++;
//					
//					System.out.println(count);
//					System.exit(0);
//				}
//			}
//			
//			
//			for(int i=1; i<=n; i++) {
//				if(squareNumbers[i] > n ) {
//					n = (int)(n-squareNumbers[i-1]);
//					count++;
//					break;
//				}else if(squareNumbers[i] == n) {
//					count++;
//					
//			
//					System.out.println(count);
//					System.exit(0);
//				}
//			}
//			
//			for(int i=1; i<=n; i++) {
//				if(squareNumbers[i] > n ) {
//					n = (int)(n-squareNumbers[i-1]);
//					count++;
//					break;
//				}else if(squareNumbers[i] == n) {
//					count++;
//					
//			
//					System.out.println(count);
//					System.exit(0);
//				}
//			}
//			break;
//			
//			
//		}
//					
//			System.out.println(count+n);
//		
//		
//		
	}
}
```