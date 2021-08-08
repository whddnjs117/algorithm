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

```
#### 김현선
``` java

```
#### 김영웅
``` java

```