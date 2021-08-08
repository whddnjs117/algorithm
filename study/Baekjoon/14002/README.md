# Baekjoon

## [14002번](https://www.acmicpc.net/problem/14002) 

### 문제

수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

### 입력

첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

### 출력

첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.

둘째 줄에는 가장 긴 증가하는 부분 수열을 출력한다. 그러한 수열이 여러가지인 경우 아무거나 출력한다.

### 문제 풀면서 배운 점

LIS 란 Longest Increasing Subsequence 의 약자로 한글로는 ‘최장 증가수열’, 
또는 ‘최대 증가 부분수열’로 불린다.
LIS는 어떤 수열에서 특정 부분을 지워서 만들어낼 수 있는 증가 부분수열(increasing subsequence) 중 가장 긴 수열을 말하는데 이때 부분수열의 숫자들은 원 배열에서 위치가 이어져 있지 않아도 된다는 주요한 특징이 있다.

LIS 라는 알고리즘 형식을 알아가는 문제 인 것 같다.

### 소스코드

#### 정종원
```python

n = int(input());

array = list(map(int , input().split()));

dp = [1] * array.__len__();

for i in range(0,array.__len__()):
    for j in range(0,i):
        if array[i] > array[j]:
            dp[i] = max(dp[i] , dp[j] + 1);

print(max(dp));
# 여기까지는 11053문제를 구하는 가장긴 배열을 구하는 문제
# 배열을 이용하여 각자 자리값을 구하였으니
# 그자리값에 포함되는 숫자를 출력하면 배열에 들어가는 숫자를 구하게 된다.
# 문제   10 20 10 30 20 50
# 결과    1  2  1  3  2  4 
# 배열   10 20 30 50
# 인덱스  1  2  3  4 

order = max(dp);
lst = [];
for i in range(n-1,-1,-1):
    if dp[i] == order :
        lst.append(array[i])
        order -= 1;
# 배열을 뒤집어 주는 작업
lst.reverse();
for i in lst:
    print(i,end=' ');


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