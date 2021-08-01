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