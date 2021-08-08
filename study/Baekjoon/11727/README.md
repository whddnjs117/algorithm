# Baekjoon

## [11727번](https://www.acmicpc.net/problem/11727) 

### 문제

2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

아래 그림은 2×17 직사각형을 채운 한가지 예이다.

### 입력

첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

### 출력

첫째 줄에 2xn 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

### 문제 풀면서 배운 점
Memoization(메모이제이션) 기법 알게 되어 주어진 입력값에 대한 결과를 저장하여 함수를 한번
실행하는 형식으로 이해하여 문제를 해결 하였습니다.

### 소스코드

#### 정종원
```python

n = int(input());

array = [0,1,3];

for i in range(3,n+1):
    array.append(i)
    array[i] = array[i-1] + array[i-2] * 2;

print(array[n] % 10007);

```
#### 김형준
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TilingTwo11727 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }
        System.out.println(dp[N]);
    }
}
```