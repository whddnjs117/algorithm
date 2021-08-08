# Baekjoon

## [1912번](https://www.acmicpc.net/problem/14002) 

### 문제

n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 단, 수는 한 개 이상 선택해야 한다.

예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인 33이 정답이 된다.

### 입력

첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다. 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.

### 출력

첫째 줄에 답을 출력한다.

### 문제 풀면서 배운 점

연속되게 값을 더해서 최대값을 출력하면 되겠다라는 방식으로 접근하여 문제를 보다 쉽게 이해가 가능하였다.

### 소스코드

#### 정종원
```python


n = int(input());

lst = list(map(int,input().split()));

dp = [];
# 10 -4 3 1 5 6 -35 12 21 -1 의 최대값을 구해야함. 연속되게
# 10
# 10 -4
# 10 -4 +3
# 10 -4 +3 +1 ... 중최대값은
# dp[0] = lst[0]
# dp[1] = lst[0] + lst[1]
# dp[2] = lst[0] + lst[1] + lst[2] .... 중 최대값
# dp[2] = dp[1] + lst[2]
# dp[n] = dp[n-1] + lst[n];
# dp[n] = dp[n] + lst[n....max]


for i in range(0,n):
    dp.append(lst[i]);
    if i!=0:
        dp[i] = max(dp[i-1] +lst[i] , dp[i]);

print(max(dp));


```
#### 김형준
```java
public class ConsecutiveSum1912 {

    public static void main(String[] args) throws Exception {
        /**
         * System.in.read() 방식으로 변경
         */
        // 한 바이트씩 입력받기 때문에 한글은 X
        // 입력값을 아스키코드로 받기 떄문에 -48을 해주면 입력된 숫자와 같아짐
        // BufferedReader 는 숫자를 입력받을 수 없기 때문에 라인값을 int 로 형변환해야함
        // BufferedReader 사용으로 300ms -> read()로 변경시 160ms
        // 차이가 나는 이유는 모르겠음
        /**
         * 문제 해석
         */
        // arr = 10 -4  3  1  5  6  -35 12 21 -1
        // dp  = 10  6  9  10 15 21 -14 12 33 32
        // 타겟의 전 dp에 더한 값과 타겟 자신의 값중 큰값을 dp에 저장
        // dp[i] 에는 i의 값이 무조건 포함이 되어 있어야 한다고 접근해야 이해가 쉬움

        int N = read();

        int[] dp = new int[N];
        dp[0] = read();
        int max = dp[0];

        for (int i = 1; i < N; i++) {
            int targetValue = read();
            dp[i] = Math.max(dp[i - 1] + targetValue, targetValue);
            if (dp[i] > max) max = dp[i];
        }

        System.out.println(max);
    }

    // 누군가 구현한 소스를 끌어옴 나중에 분석을 해봐야할듯
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}
```
#### 김현선
``` java

```
#### 김영웅
``` java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A_1912 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		
		int[] seq = new int[length];
		 
		int[] sum = new int[length];
		// 입력을 받아 int배열로 형변환
		seq = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		
		//		seq 10 -4 3  1  5  6 -35 12 21 -1
		//		sum 10  6 9 10 15 21 -14 12 33 32
		//      
		
		//      이전까지의 합과 현재 값을 비교해 최대값을 찾고
		//      전 최대값과 현재 최대값을 비교해 최대값을 찾음
		//      ex) 10 + (-4) 와 -4를 비교하면 
		//			10 + (-4) 가 크므로 max에 저장
		//
		
		sum[0] = seq[0];
		
		int max = seq[0];
		for(int i=1; i<seq.length; i++) {
				// 이전까지의 합과 현재 값을 비교해 최대값을 찾아 해당 index 합 배열에 넣어줌
				sum[i] = Math.max(sum[i-1] + seq[i], seq[i]);
				// 최대값은 이전 최대값과 현재 최대값을 비교해 최대값을 찾아 max에 넣어줌
				max = Math.max(max,sum[i]);
		}
		
		System.out.println(max);
		
	}
}
```