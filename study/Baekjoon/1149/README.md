# Baekjoon

## [1149번](https://www.acmicpc.net/problem/1149) 

### 문제

RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

* 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
* N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
* i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

### 입력

첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.

### 출력

첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.

### 문제 풀면서 배운 점

이게 왜 다이나믹 프로그래밍 문제인가 생각이 들었지만 문제풀이를 혼자 풀이하기보다 정답을 보고나서 다이나믹 프로그래밍이 맞구나라고 생각이 바뀌었다.

### 소스코드

#### 정종원
```python
# 3
# 26 40 83
# 49 60 57
# 13 89 99

# 26 + 57 + 96
# 96

# 26 + 60 + 13
# lst[0][0] + lst[1][1] + lst[2][0]
# 26 + 60 + 99
# lst[0][0] + lst[1][1] + lst[2][2]

# 26 + 57 = 13
# lst[0][0] + lst[1][2] + lst[2][0]
# 26 + 57 + 89
# lst[0][0] + lst[1][2] + lst[2][1]

# 40 + 49 + 89
# lst[0][1] + lst[1][0] + lst[2][1]
# 40 + 49 +99
# lst[0][1] + lst[1][0] + lst[2][2]

# 40 + 57 + 13
# lst[0][1] + lst[1][2] + lst[2][0]
# 40 + 57 + 89
# lst[0][1] + lst[1][2] + lst[2][1]



# lst[0][0] + lst[1][1] + lst[2][0]
# lst[0][0] + lst[1][1] + lst[2][2]
# lst[0][0] + lst[1][2] + lst[2][0]
# lst[0][0] + lst[1][2] + lst[2][1]


# lst[0][1] + lst[1][0] + lst[2][1]
# lst[0][1] + lst[1][0] + lst[2][2]
# lst[0][1] + lst[1][2] + lst[2][0]
# lst[0][1] + lst[1][2] + lst[2][1]

# lst[0][2] + lst[1][0] + lst[2][1]
# lst[0][2] + lst[1][0] + lst[2][2]
# lst[0][2] + lst[1][1] + lst[2][0]
# lst[0][2] + lst[1][1] + lst[2][2]

n = int(input());

lst = [list(map(int,input().split())) for _ in range(n)]


for i in range(1,n):
    lst[i][0] = lst[i][0] + min(lst[i-1][1] ,lst[i-2][2])
    lst[i][1] = lst[i][1] + min(lst[i-1][0] ,lst[i-2][2])
    lst[i][2] = lst[i][2] + min(lst[i-1][1] ,lst[i-2][0])

print(lst);


```
### 김형준
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * RGB 문제
         * 1번 집 부터 N번 집까지 있고 그집을 빨강, 초록, 파랑 색으로 칠할 수 있는 비용이 주어짐
         * 모든집을 칠할때 최소 비용은? ( 같은 색이 연속 되면 안됨 )
         * 3
         * 26 40 83
         * 49 60 57
         * 13 89 99
         */

        // 일단 N = 2 일 경우의수를 전부 나열
        // cost[1][1] + cost[2][2]
        // cost[1][1] + cost[2][3]
        // cost[1][2] + cost[2][1]
        // cost[1][2] + cost[2][3]
        // cost[1][3] + cost[2][1]
        // cost[1][3] + cost[2][2]
        // 그 다음 N = 3일 경우
        // dp[3][1] += min ( dp[2][2], dp[2][3] )

        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N + 1][4];
        int[][] dp = new int[N + 1][4];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
            cost[i][3] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i][1] = cost[i][1] + Math.min(dp[i - 1][2], dp[i - 1][3]);
            dp[i][2] = cost[i][2] + Math.min(dp[i - 1][1], dp[i - 1][3]);
            dp[i][3] = cost[i][3] + Math.min(dp[i - 1][1], dp[i - 1][2]);
        }

        System.out.println(Math.min(Math.min(dp[N][1], dp[N][2]), dp[N][3]));

    }

}public class ㅁㄴㅇ {
    
}

```
### 김현선
```java

```