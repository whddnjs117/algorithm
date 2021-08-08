import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SubSequence14002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 가장 긴 증가하는 부분 수열에서 배열출력이 추가됨
        // dp[] 가 가장 높은 값 즉 가장긴부분의 끝부분의 index 를 저장
        // 그 끝부분 부터 dp를 비교해서 작은 값들을 배열에 넣고 정렬 or 뒷부분부터 출력 시킴

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int max = -1;
        int maxIndex = 0;

        // split 사용보다 Tokenizer 사용이 조금 더 빠르다고 함
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (max < dp[i]) {
                max = dp[i];
                maxIndex = i; // 여기서 가장 높은 dp의 배열 인덱스를 저장
            }
        }

        List<Integer> resultList = new ArrayList<>();
        int count = max;

        // 가장 높은 배열의 자리부터 아래로 dp를 탐색해가며 결과리스트에 추가
        for (int i = maxIndex; i >= 0; i--) {
            if (dp[i] == count) {
                resultList.add(arr[i]);
                count--;
            }
        }

        System.out.println(max);

        // 1. 정렬없이 끝부분부터 출력하는 방법 176ms
        StringBuilder sb = new StringBuilder();
        for (int i = max - 1; i >= 0; i--) {
            sb.append(resultList.get(i)).append(" ");
        }
        System.out.println(sb);

        // 2. stream 으로 정렬 후 출력하는 방법 180ms
        // stream 사용해서 정렬 후 출력하는거나 그냥 끝부분부터 출력하는거나 비슷함
        resultList.stream()
            .sorted(Integer::compareTo)
            .forEach(e -> System.out.print(e + " "));
    }
}