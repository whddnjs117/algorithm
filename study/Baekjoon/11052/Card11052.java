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