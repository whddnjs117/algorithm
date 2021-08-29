import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OneTwoThree15988 {
    private static final int maxIndex = 1_000_000;
    private static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /**
         * 1,2,3 더하기 3
         * 정수를 1,2,3 을 더해 나타낼수있는 방법의 수, 수는 1개 이상을 사용해야함
         */

        // dp[1] = 1 = 1
        // dp[2] = 1 + 1, 2 = 2
        // dp[3] = 1 + 1 + 1, 1 + 2, 2 + 1, 3  = 4
        // dp[4] = dp[3] dp[2] dp[1]

        // dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4]

        // 이문제도 맨 앞이 1이라고 가정하면서 접근함
        // dp[4] 의 맨 앞이 1인 경우가 1 + dp[3]
        // 맨앞이 2인 경우가 2 + dp[2]
        // 3인경우 dp[1]
        // 결국 dp[4] = dp[1] + dp[2] + dp[3]
        // dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]

        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[maxIndex + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= maxIndex; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
        }

        while (T --> 0){
            int N = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(dp[N] % MOD));
            bw.write('\n');
        }
        bw.flush();
        bw.close();
    }
}