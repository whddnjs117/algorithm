# Baekjoon

## [11053번](https://www.acmicpc.net/problem/11053) 

### 문제

수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

### 입력

첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

### 출력

첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.

### 문제 풀면서 배운 점

LIS 란 Longest Increasing Subsequence 의 약자로 한글로는 ‘최장 증가수열’, 
또는 ‘최대 증가 부분수열’로 불린다.
LIS는 어떤 수열에서 특정 부분을 지워서 만들어낼 수 있는 증가 부분수열(increasing subsequence) 중 가장 긴 수열을 말하는데 이때 부분수열의 숫자들은 원 배열에서 위치가 이어져 있지 않아도 된다는 주요한 특징이 있다.

LIS 라는 알고리즘 형식을 알아가는 문제 인 것 같다.

### 소스코드

#### 정종원
```python

# 처음에는 정렬을 하고 정렬된 수를 뽑으면 되지않을까를 판단.

# n = int(input());

# array = list(map(int,input().split()));

# dp = [];

# for i in range(0,array.__len__(), 1):

    
#     if i == 0 :
#         dp.append(array[i]);
#     elif int(max(dp)) < array[i]:
#         dp.append(array[i]);

# print(dp);

# 그러나 문제의 의도는 그것이 아니다.
# 최대 증가 부분 수열은 
# 예를 들어 배열 1 5 3 6 7 일경우에는 최대로 증가할수잇는 배열의 수는 1 3 6 7 이므로 4이다.
# 연속적으로 증가하는 배열의 최대값을 구하는것이 문제의 의도이다.
# 각 자릿수 마다 배열의 증가하는 최대값을 구하여 배열이 완성한다.-


n = int(input());

array = list(map(int , input().split()));

# 배열의 길이만큼 생성 
# 벡준 카드 구매하기 랑 비슷한 맥락이다.
# 10 20 10 30 20 50 일경우
# 1  2  1  3  2  4
# 배열을 반복하며, 전에 숫자보다 클경우 +1을 해주는 형식

dp = [1] * array.__len__();

for i in range(0,array.__len__()):

    for j in range(0,i):
        if array[i] > array[j]:
            dp[i] = max(dp[i] , dp[j] + 1);

print(max(dp));
```
#### 김형준
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSequence11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 정답보고 이해함
        // dp[], seq[] 배열 2개를 사용
        // 나중 이분탐색공부시 이분탐색으로도 풀이 가능

        // 처음엔 단순 카운트로 생각해보고 고쳐보자 생각함
        // 10 30 10 50 20 40
        // 1  2  2  3  3  4   - > 여기서 다음으로 진도를 못나가서 정답확인
        // 1  2  1  3  2  3  이런식으로 전값보다 작으면 새롭게 카운트 하는 방법

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            // 0 ~ i 이전 원소들 탐색
            for(int j = 0; j < i; j++) {
                // j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우
                if(seq[j] < seq[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;	// j번째 원소의 +1 값이 i번째 dp가 된다.
                }
            }
        }

        // 최댓값(최대 길이) 탐색
        int max = -1;
        for(int i = 0; i < N; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(max);

    }
}
```
#### 김현선
``` java
import java.util.Scanner;

public class A11053 {
	static int[] count;
	static Integer[] dp;


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		count = new int[n];
		dp = new Integer[n];
		
		
		for(int i = 0; i < n; i++) {
			count[i] = in.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			recur(i);
		}
		
		int max = dp[0];
		for(int i = 1; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);

	}

	static int recur(int n) {
		if(dp[n] == null) {
			dp[n] = 1;	 
			 
			for(int i = n - 1; i >= 0; i--) {
				if(count[i] < count[n]) {
					dp[n] = Math.max(dp[n], recur(i) + 1);
				}
			}
		}
		return dp[n];
	}
}
```
#### 김영웅
``` java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A_11053 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int seqSize = Integer.parseInt(br.readLine());
	
		int[] seq = new int[seqSize];
		// 수열 배열  String 배열 int 배열로 형변환
		seq = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		// 길이 배열
		int[] result = new int[seqSize];
		
		int answer = 0;
	
		
		for(int i=0; i<seq.length; i++) {
			// 초기값 설정
			result[i] = 1;

			for(int j=0; j<i; j++) {
				// i번째 값이 j번째 값보다 크면서 i번째 길이가 j번째 + 1 길이보다 작은경우
				if(seq[i]>seq[j] && result[i] < result[j] + 1) {		
					result[i] = result[j]+1;
				}
			}
			
		}
		
		// 최대 길이 탐색
	        for (int i = 0; i < result.length; i++){
	        		
	        	
	        	if (result[i] > answer){
	                answer = result[i];
	            }
	        }
	        
		// 최대 값 출력
	        System.out.println(answer);
		
	
	}
	
}
```