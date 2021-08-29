import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * RGB 문제
         * 1번 집 부터 N번 집까지 있고 그집을 빨강, 초록, 파랑 색으로 칠할 수 있는 비용이 주어짐
         * 모든집을 칠할때 최소 비용은? ( 같은 색이 연속 되면 안됨 )
         * 3
         * 26 40 83
         * 49 60 57
         * 13 89 99
         */

        // 일단 N = 2 일 경우의수를 전부 나열
        // cost[1][1] + cost[2][2]
        // cost[1][1] + cost[2][3]
        // cost[1][2] + cost[2][1]
        // cost[1][2] + cost[2][3]
        // cost[1][3] + cost[2][1]
        // cost[1][3] + cost[2][2]
        // 그 다음 N = 3일 경우
        // dp[3][1] += min ( dp[2][2], dp[2][3] )

        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N + 1][4];
        int[][] dp = new int[N + 1][4];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
            cost[i][3] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i][1] = cost[i][1] + Math.min(dp[i - 1][2], dp[i - 1][3]);
            dp[i][2] = cost[i][2] + Math.min(dp[i - 1][1], dp[i - 1][3]);
            dp[i][3] = cost[i][3] + Math.min(dp[i - 1][1], dp[i - 1][2]);
        }

        System.out.println(Math.min(Math.min(dp[N][1], dp[N][2]), dp[N][3]));

    }

}public class ㅁㄴㅇ {
    
}
