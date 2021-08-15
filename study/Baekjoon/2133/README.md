# Baekjoon

## [2133번](https://www.acmicpc.net/problem/2133) 

### 문제

3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.

### 입력

첫째 줄에 N(1 ≤ N ≤ 30)이 주어진다.

### 출력

첫째 줄에 경우의 수를 출력한다.

### 문제 풀면서 배운 점



### 소스코드

#### 정종원
```python
# 
# dp[2] = 3
# dp[4] = dp[2] * 3 + 2;
# dp[6] = dp[4] * 3 + dp[2] * 2 + 2
# dp[8] = dp[6] * 3 + dp[4] * 2 + dp[2] * 2 + 2

n = int(input());

dp = [0 for _ in range(31)];
dp[2] = 3;

for i in range(4,31,2):
    dp[i] = dp[i-2] * 3 + 2;
    for j in range(4,i,2):
        dp[i] += dp[i-j] * 2;

print(dp[n]);
```
### 김형준
```java
```
### 김현선
```java
```
### 김영웅
```java
```