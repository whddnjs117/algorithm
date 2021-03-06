# Baekjoon

## [15988번](https://www.acmicpc.net/problem/15988) 

### 문제

정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

### 입력

첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 1,000,000보다 작거나 같다.

### 출력

각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 1,000,000,009로 나눈 나머지를 출력한다.

### 문제 풀면서 배운 점

1 부터 5 까지의 결과를 산출하여 규칙을 찾아내는 형식으로 문제풀이를 완료하엿습니다.

### 소스코드

#### 정종원
```python
# 1
# 1

# 2
# 2

# 3
# 4

# 4
# 7

# 5
# 1 + 1 + 1 + 1 + 1 
# 1 + 1 + 1 + 2
# 1 + 1 + 2 + 1
# 1 + 2 + 1 + 1
# 2 + 1 + 1 + 1
# 2 + 1 + 2 
# 2 + 2 + 1
# 1 + 2 + 2
# 1 + 1 + 3
# 1 + 3 + 1
# 3 + 1 + 1
# 3 + 2 
# 2 + 3
# 13

# dp[n] = dp[n-1] + dp[n-2] + dp[n-3];

n = int(input());

dp = [0] * 4;
dp[1] = 1;
dp[2] = 2;
dp[3] = 4;
for i in range(n):
    number = int(input());
    if number+1 > dp.__len__():
        for j in range(dp.__len__(),number+1):
            dp.append(0);
            dp[j] = (dp[j-1] + dp[j-2] + dp[j-3])% 1000000009;
    print(dp[number]);
```
### 김형준
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OneTwoThree15988 {
    private static final int maxIndex = 1_000_000;
    private static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /**
         * 1,2,3 더하기 3
         * 정수를 1,2,3 을 더해 나타낼수있는 방법의 수, 수는 1개 이상을 사용해야함
         */

        // dp[1] = 1 = 1
        // dp[2] = 1 + 1, 2 = 2
        // dp[3] = 1 + 1 + 1, 1 + 2, 2 + 1, 3  = 4
        // dp[4] = dp[3] dp[2] dp[1]

        // dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4]

        // 이문제도 맨 앞이 1이라고 가정하면서 접근함
        // dp[4] 의 맨 앞이 1인 경우가 1 + dp[3]
        // 맨앞이 2인 경우가 2 + dp[2]
        // 3인경우 dp[1]
        // 결국 dp[4] = dp[1] + dp[2] + dp[3]
        // dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]

        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[maxIndex + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= maxIndex; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
        }

        while (T --> 0){
            int N = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(dp[N] % MOD));
            bw.write('\n');
        }
        bw.flush();
        bw.close();
    }
}
```
### 김현선
```java

```