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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SubSequence14002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 가장 긴 증가하는 부분 수열에서 배열출력이 추가됨
        // dp[] 가 가장 높은 값 즉 가장긴부분의 끝부분의 index 를 저장
        // 그 끝부분 부터 dp를 비교해서 작은 값들을 배열에 넣고 정렬 or 뒷부분부터 출력 시킴

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int max = -1;
        int maxIndex = 0;

        // split 사용보다 Tokenizer 사용이 조금 더 빠르다고 함
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (max < dp[i]) {
                max = dp[i];
                maxIndex = i; // 여기서 가장 높은 dp의 배열 인덱스를 저장
            }
        }

        List<Integer> resultList = new ArrayList<>();
        int count = max;

        // 가장 높은 배열의 자리부터 아래로 dp를 탐색해가며 결과리스트에 추가
        for (int i = maxIndex; i >= 0; i--) {
            if (dp[i] == count) {
                resultList.add(arr[i]);
                count--;
            }
        }

        System.out.println(max);

        // 1. 정렬없이 끝부분부터 출력하는 방법 176ms
        StringBuilder sb = new StringBuilder();
        for (int i = max - 1; i >= 0; i--) {
            sb.append(resultList.get(i)).append(" ");
        }
        System.out.println(sb);

        // 2. stream 으로 정렬 후 출력하는 방법 180ms
        // stream 사용해서 정렬 후 출력하는거나 그냥 끝부분부터 출력하는거나 비슷함
        resultList.stream()
            .sorted(Integer::compareTo)
            .forEach(e -> System.out.print(e + " "));
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
import java.util.Stack;

public class A_14002 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력을 받기 위함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		//  수열 배열
		long[] seq = new long[length];
		// 입력을 받아 long 배열로 형변환
		seq = Arrays.asList(br.readLine().split(" ")).stream().mapToLong(Long::parseLong).toArray();
		// 길이 배열
		int[] lengths = new int[length];
		
		Stack<String> result = new Stack<String>();
		
		lengths[0] = 1;
		int max = 0;
		// 정답 문자열을 만들기 위함
		StringBuilder answer = new StringBuilder();
		// 역추적 하기위한 임시 배열
		int[] temp = new int[length];
		for(int i=0; i<seq.length; i++) {
			lengths[i] = 1;
			temp[i] = -1;
			for(int j=0; j<i; j++) {
				// i번째 수가 j번째 수보다 크면서 i번째 길이보다 j번째 길이에 1더한 값 보다 크면
				if(seq[i]>seq[j] && lengths[i] < lengths[j]+1) {
					// i번째에 j번째 길이의 +1 한값을 넣어줌
					lengths[i] = lengths[j]+1;
					temp[i]  = j;
					
					// seq     10 20 10 30 20 50
					// lengths 1  2  1  3  2  4
					
				}
			}
		}
		//				0	1	2	3	4	5					
		// seq[i]      10	20	10	30	20	50
		// lengths[i]	1	2	1	3	2	4
		// temp[i]	   -1	0  -1	1	0	3
		
		// 수열의 가장 큰 값 부터 넣고 그 다음 temp[index] 값을 stack에 넣음
		// 계속역추적
		
		
		
		
		
		int index = 0;
		for(int i=0; i<lengths.length; i++) {
			if(max<lengths[i]) {
				max = lengths[i];
				index = i;
			
			}
		}
		
//		for(int i=0; i<=index; i++) {
//			
//			if(!result.contains(seq[i]+"")) {
//				result.add(seq[i]+"");
//			}
//		}
		
		answer.append(max).append("\n");
		while(index != -1) {
			result.push(seq[index]+"");
			index = temp[index];
		}
//		0	1	2	3	4	5					
// seq[i]      10	20	10	30	20	50
// lengths[i]	1	2	1	3	2	4
// temp[i]	   -1	0  -1	1	0	3
		

//		for(int i=result.size()-1; i>=0; i--) {
//			System.out.print(result.get(i)+" ");
//			
//			
//		}
		
		// STACK
		// FILO
		// 퍼스트인 라스트 아웃 구조니 마지막 넣은 값부터 뽑아 삭제하면서 문자열에 이어붙임
		
	
		// 10
		// 20
		// 30
		// 50
		
		// answer
		// 4
		// 10 20 30 50
		while(!result.isEmpty()) {
			answer.append(result.pop()).append(" ");
		}
		
		System.out.println(answer);
		
	}
}
```