public class ConsecutiveSum1912 {

    public static void main(String[] args) throws Exception {
        /**
         * System.in.read() 방식으로 변경
         */
        // 한 바이트씩 입력받기 때문에 한글은 X
        // 입력값을 아스키코드로 받기 떄문에 -48을 해주면 입력된 숫자와 같아짐
        // BufferedReader 는 숫자를 입력받을 수 없기 때문에 라인값을 int 로 형변환해야함
        // BufferedReader 사용으로 300ms -> read()로 변경시 160ms
        // 차이가 나는 이유는 모르겠음
        /**
         * 문제 해석
         */
        // arr = 10 -4  3  1  5  6  -35 12 21 -1
        // dp  = 10  6  9  10 15 21 -14 12 33 32
        // 타겟의 전 dp에 더한 값과 타겟 자신의 값중 큰값을 dp에 저장
        // dp[i] 에는 i의 값이 무조건 포함이 되어 있어야 한다고 접근해야 이해가 쉬움

        int N = read();

        int[] dp = new int[N];
        dp[0] = read();
        int max = dp[0];

        for (int i = 1; i < N; i++) {
            int targetValue = read();
            dp[i] = Math.max(dp[i - 1] + targetValue, targetValue);
            if (dp[i] > max) max = dp[i];
        }

        System.out.println(max);
    }

    // 누군가 구현한 소스를 끌어옴 나중에 분석을 해봐야할듯
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}