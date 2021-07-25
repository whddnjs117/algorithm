import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneTwoThreeFive15990 {

    static int[][] dp = new int[100001][4];
    final static int MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i = 4; i<= 100_000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }

        int testCase = Integer.parseInt(br.readLine());
        while (testCase --> 0){
            int n = Integer.parseInt(br.readLine());
            int result = 0;
            for (int i = 1; i <= 3; i++){
                result += dp[n][i];
                result %= MOD;
            }
            sb.append(result).append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}