import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinaryNumber2193 {
    static long[][] dp = new long[91][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // f(1) = 1
        // f(2) = 10
        // f(3) = 101, 100
        // f(4) = 1000, 1010, 1001
        // f(5) = 10000, 10100, 10101, 10010, 10001

        // 끝자리가 0일 경우 끝자리가 1일 경우
        //        n = 1   2   3   4   5
        // dp[n][0] = 0   1   1   2   3
        // dp[n][1] = 1   0   1   1   2
        // dp[n][0] = dp[n - 1][0] + dp[n - 2][0]
        // dp[n][1] = dp[n - 1][1] + dp[n - 2][1]
        // dp[n] = dp[n][0] + dp[n][1]

        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[3][0] = 1;
        dp[3][1] = 1;

        for (int i = 4; i <= 90; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n][0] + dp[n][1]);

        br.close();
    }
}