import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StairsNumber10844 {
    final static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][10];

        for (int i = 1; i < 10; i++){
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++){
            for (int j = 1; j < 9; j++){
                dp[i][j] = (dp[i - 1][j -1] + dp[i - 1][j + 1]) % MOD;
            }
            dp[i][0] = dp[i - 1][1] % MOD;
            dp[i][9] = dp[i - 1][8] % MOD;
        }
        long result = 0;
        for (int i = 0; i < 10; i++){
            result += dp[N][i];
        }
        System.out.println(result % MOD);
    }
}