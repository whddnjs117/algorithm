# Baekjoon

## [11502번](https://www.acmicpc.net/problem/11502) 

### 문제

요즘 민규네 동네에서는 스타트링크에서 만든 PS카드를 모으는 것이 유행이다.

PS카드는 PS(Problem Solving)분야에서 유명한 사람들의 아이디와 얼굴이 적혀있는 카드이다. 각각의 카드에는 등급을 나타내는 색이 칠해져 있고, 다음과 같이 8가지가 있다.

* 전설카드
* 레드카드
* 오렌지카드
* 퍼플카드
* 블루카드
* 청록카드
* 그린카드
* 그레이카드   

카드는 카드팩의 형태로만 구매할 수 있고, 카드팩의 종류는 카드 1개가 포함된 카드팩, 카드 2개가 포함된 카드팩, ... 카드 N개가 포함된 카드팩과 같이 총 N가지가 존재한다.

민규는 카드의 개수가 적은 팩이더라도 가격이 비싸면 높은 등급의 카드가 많이 들어있을 것이라는 미신을 믿고 있다. 따라서, 민규는 돈을 최대한 많이 지불해서 카드 N개 구매하려고 한다. 카드가 i개 포함된 카드팩의 가격은 Pi원이다.

예를 들어, 카드팩이 총 4가지 종류가 있고, P1 = 1, P2 = 5, P3 = 6, P4 = 7인 경우에 민규가 카드 4개를 갖기 위해 지불해야 하는 금액의 최댓값은 10원이다. 2개 들어있는 카드팩을 2번 사면 된다.

P1 = 5, P2 = 2, P3 = 8, P4 = 10인 경우에는 카드가 1개 들어있는 카드팩을 4번 사면 20원이고, 이 경우가 민규가 지불해야 하는 금액의 최댓값이다.

마지막으로, P1 = 3, P2 = 5, P3 = 15, P4 = 16인 경우에는 3개 들어있는 카드팩과 1개 들어있는 카드팩을 구매해 18원을 지불하는 것이 최댓값이다.

카드 팩의 가격이 주어졌을 때, N개의 카드를 구매하기 위해 민규가 지불해야 하는 금액의 최댓값을 구하는 프로그램을 작성하시오. N개보다 많은 개수의 카드를 산 다음, 나머지 카드를 버려서 N개를 만드는 것은 불가능하다. 즉, 구매한 카드팩에 포함되어 있는 카드 개수의 합은 N과 같아야 한다.

### 입력

첫째 줄에 민규가 구매하려고 하는 카드의 개수 N이 주어진다. (1 ≤ N ≤ 1,000)

둘째 줄에는 Pi가 P1부터 PN까지 순서대로 주어진다. (1 ≤ Pi ≤ 10,000)

### 출력

첫째 줄에 민규가 카드 N개를 갖기 위해 지불해야 하는 금액의 최댓값을 출력한다.

### 문제 풀면서 배운 점

문제 자체가 이해가 되질 않아 정답을 보며 문제를 이해하도록 하며, 점화식을 그리기 시작하니
눈에 익기 시작하여 점화식자체를 그리고 점화식을 만들고보니 , 이중 반복문을 필요로 함을 깨닫게 됨.

### 소스코드

#### 정종원
```python
n = int(input())
card = [0]
card += list(map(int, input().split()))

# 카드의 길이만큼 배열생성
dp = [0] * card.__len__();
# 카드팩 1개 사기
# dp[1] = card[1]
# 카드팩 2개 사기
# dp[2] = card[2] , card[1] * 2
# 카드팩 3개 사기
# dp[3] = card[3] , card[2] + card[1] , card[1] * 3
# 카드팩 4개 사기
# dp[4] = card[4] , card[3] + card[1] , card[2] + card[2] , card[1] * 4
# 식정리
# dp[n] = card[n] , card[n-1] + card[1] , card[n-2] + card[2] ,card[n-3] + card[3] .... = dp[n] , dp[n-i]+dp[i]


for i in range(1,n+1):
    # dp[n] = card[n] 의 값을 저장한다. 카드팩 n개를 구매하기위해 card[n]값을 지불을 위해 
    dp[i] = card[i];
    for j in range(1,i):
        dp[i] = max(dp[i] , dp[i-j] + dp[j]);

print(dp[n]);
```
#### 김형준
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card11052 {

    public static void main(String[] args) throws IOException {
        /**
         * 정답보고 점화식을 이해함
         * 카드팩을 사는 갯수랑 카드팩의 갯수가 같다는 걸 모르고 있어서
         * 이해조차 오래걸림ㅎ
         * 164ms
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        List<Integer> cardPackList =
            Stream.of(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        /**
         * 여기서 i 가 카드를 선택하는 장수임
         * 만약 i = 1 이면 1장을 뽑는 경우의 수를 전부 찾아서 그중에 높은 값을 저장
         * 2로 넘어가서 2장을 선택하는 경우의 수를 전부 찾아서 높은 값을 저장
         * ex) 5장을 뽑는데 최대값은 4장뽑는 최대값에 1번카드팩 더하기,3장뽑는 최대값에 2번카드팩 더하기...
         */
        for(int i = 1; i < N + 1; i++)
            for (int j = 1; j <= i; j++)
                if (dp[i] < dp[i - j] + cardPackList.get(j - 1))
                    dp[i] = dp[i - j] + cardPackList.get(j - 1);

        System.out.println(dp[N]);
    }
}
```
#### 김현선
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 카드 구매하기 
 * https://www.acmicpc.net/problem/11052
 */
public class A11052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] pack = new int[n+1];
		int[] dp = new int[n+1];
		
		String target = br.readLine();
		StringTokenizer st = new StringTokenizer(target, " ");
		
		for(int i = 1; i <= n; i++) {
			pack[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + pack[j]);
			}
		}
		System.out.println(dp[n]);
		
		/**
		 * 카드 n장을 갖기위해 카드 1개, 2개 .. 각각의 최대값을 구한다.
		 * n-i에 저장된 각각의 최대값을 이용하여 n장의 최대값을 구한다.
		 * 
		 * 예) 카드 3개 구매 최대값 = 3개짜리 카드팩 + (3 - 1개 짜리 카드팩)
		 *
		 
		 4 / 1 5 6 7
		 dp[1] = Math.max(dp[1], pack[1] + dp[1-1]);
		 		Math.max(1, 0 + 0) 
		 	   = 1
		 
		 dp[2] = Math.max(dp[2], pack[1] + dp[2-1]);
		 		Math.max(0, 1 + 1)
		 	   = 2
		 	   = Math.max(dp[2], pack[2] + dp[2-2]);
		 	   Math.max(2, 5 + 0)
		 	   = 5
		 		
 		 dp[3] = Math.max(dp[3], pack[1] + dp[3-1]);
		 		Math.max(0, 1 + 5)
		  	   = 6
		  	   = Math.max(dp[3], pack[2] + dp[3-2]);
		 		Math.max(6, 5 + 1)
		  	   = 6
		  	   = Math.max(dp[3], pack[3] + dp[3-3]);
		 		Math.max(6, 6 + 0)
		  	   = 6
		  	   
		 		
		 */

	}

}
```
#### 김영웅
``` java
import java.io.IOException;
import java.util.Scanner;

public class A11052 {
   public static void main(String[] args) throws NumberFormatException, IOException {
         Scanner sc = new Scanner(System.in);
         
         int n = sc.nextInt();
         
         // n개의 카드팩배열 초기화
         int[] cardpack = new int[n+1];
         // 가격 배열
         int[] maxprice = new int[n+1];
         for(int i=1; i<cardpack.length; i++) {
            cardpack[i] = sc.nextInt();
         }
         
         
         // 3장을 예로 들면
         
         
         // 0번 배열엔 아무것도 있지않음
         
         // 카드팩 1장짜리 가격 + 2장을 사기위한 최대값
         // 카드팩 2장짜리 가격 + 1장을 사기위한 최대값
         // 카드팩 3장가격
         
         // 비교해서 최대값 배열에 넣어준다
         
           for(int i = 1; i <=n; i++) {
               for(int j = 1; j <=i; j++) {
                   maxprice[i] = Math.max(maxprice[i],cardpack[j]+maxprice[i-j]);
               }
           }
           System.out.println(maxprice[n]);
       }
         
               
   }
```