import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardTwo16194 {

    public static void main(String[] args) throws IOException {
        /**
         * 카드구매하기1번 문제와 거의 같음
         * 최대값과 다르게 j가 1일경우 dp[i]가 0이라 최소값으로 잡아버려서
         * j가 1일 경우에만 값을 넣고 2부터 비교해서 최소값을 찾음
         * 164ms
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        List<Integer> cardPackList =
            Stream.of(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        dp[1] = cardPackList.get(0);
        for(int i = 1; i < N + 1; i++)
            for (int j = 1; j <= i; j++)
                if (j == 1)
                    dp[i] = dp[i - j] + cardPackList.get(0);
                else if (dp[i] > dp[i - j] + cardPackList.get(j - 1))
                    dp[i] = dp[i - j] + cardPackList.get(j - 1);

        System.out.println(dp[N]);
    }
}