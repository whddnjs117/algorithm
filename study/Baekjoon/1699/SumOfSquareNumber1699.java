import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfSquareNumber1699 {

    public static void main(String[] args) throws IOException {
        /**
         * 제곱수의 합
         * 어떤 자연수 N은 그보다 작거나 같은 제곱수들의 합으로 나타낼 수 있다. 예를 들어 11=3^+1^+1^(3개 항)이다.
         * 주어진 자연수 N을 이렇게 제곱수들의 합으로 표현할 때에 그 항의 최소개수를 구하는 프로그램을 작성하시오.
         */
        // dp[1] = 1^
        // dp[2] = 1^ + 1^
        // dp[3] = 1^ + 1^ + 1^
        // dp[4] = 2^
        // dp[5] = 2^ + 1^
        // dp[6] = 2^ + 1^ + 1^
        // dp[7] = 2^ + 1^ + 1^ + 1^
        // dp[8] = 2^ + 2^
        // dp[9] = 3^

        // dp[9] = 1^ + 2^ + 2^
        // dp[9] = 2^ + 2^ + 1^
        // dp[9] = 3^

        // dp[12] = 1^ + dp[11]
        // dp[12] = 2^ + dp[8]
        // dp[12] = 3^ + dp[3]


        // 점화식 : Math.min(dp[i], dp[i - j*j] + 1)
        // ex) dp[12] 일 경우 dp[11] + 1, dp[8] + 1, dp[3] + 1, dp[1] * 12
        // 위에 j*j 가 위쪽 dp 부분의 제일 앞단임
        // dp[12] = (2^) + 2^ + 2^ -> 앞의 괄호가 j*j 부분 2^ 라고 가정하고 접근함
        //           +1     dp[8]

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = i; // 처음 dp[i]에 1^로만 들어가는 수를 넣음(가장 많은 수)
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}