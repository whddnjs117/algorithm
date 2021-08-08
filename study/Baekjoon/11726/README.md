# Baekjoon

## [11726번](https://www.acmicpc.net/problem/11726) 

### 문제

2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.

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

array = [0,1,2,3];

for i in range(3,n+1):
    array.append(i)
    array[i] = array[i-1] + array[i-2]

print(array[n] % 10007);

```
#### 김형준
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tiling11726 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        System.out.println(dp[N]);
    }
}
```
#### 김현선
```java
```
#### 김영웅
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_11726 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		// 1ºÎÅÍ ½ÃÀÛÇÏ±â¿¡ +1
		int[] arr = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			if(i==1) {
				arr[i] = 1;
			}else if(i==2) {
				arr[i] = 2;
			}else {
				arr[i] = (arr[i-2] + arr[i-1]) % 10007;
			}
		}
		System.out.println(arr[n]);
	}
	

}
```