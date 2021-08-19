import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecompositionSum2225 {

    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /**
         * 합분해 문제
         * 0부터 N 까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.
         * 덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.
         */
        // dp[K][N]
        // dp[1][1] = 1
        // dp[1][2] = 1
        // dp[1][3] = 1
        // dp[2][1] = 2
        // dp[2][2] = 3
        // dp[2][3] = 4
        // dp[3][1] = 3
        // dp[3][2] = 6
        // dp[3][3] = 10

        //TODO 설명 추가 해야함 K = 1 경우 무조건 1, N = 1 경우 N
        // 맨 앞 숫자를 이미 선택 했다 가정하고 접근하면 점화식을 이해하기 쉬움
        // K = 3 경우 부터 점화식 dp[K][N] = dp[K - 1][N 밑으로 전부 합산]
        // ex) dp[k - 1][N] + dp[k - 1][N - 1] + dp[k - 1][N - 2] ...

        // 점화식 : dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        //                   맨앞 숫자가 0      그 나머지 값

        // [2][0] = 00
        // [2][1] = 01, 10
        // [2][2] = 02, 11, 20
        // [2][3] = 03, 12, 21, 30
        // [3][1] = 001, 010, 100

        // ex) [3][2] = ( 002, 011, 020 ), 101, 110, 200
        //              앞이 0이라고 가정함    나머지(앞이 1이라고 가정,2라고 가정)
        //              dp[i - 1][j]       [2][1], [2][0] = [3][1]

        String[] inputLine = br.readLine().split(" ");
        int N = Integer.parseInt(inputLine[0]);
        int K = Integer.parseInt(inputLine[1]);

        long[][] dp = new long[K + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i <= K; i++) {
            dp[i][1] = i;
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 2; j <= N; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }
        /* 처음 소스
        for (int i = 3; i <= K; i++) {
            for (int j = 2; j <= N; j++) {
                for (int y = 0; y <= j; y++) {
                    dp[i][j] += dp[i - 1][y] % MOD;
                }
            }
        }
         */
        System.out.println(dp[K][N] % MOD);
    }
}