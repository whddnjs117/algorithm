import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A_1912 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		
		int[] seq = new int[length];
		 
		int[] sum = new int[length];
		// 입력을 받아 int배열로 형변환
		seq = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		
		//		seq 10 -4 3  1  5  6 -35 12 21 -1
		//		sum 10  6 9 10 15 21 -14 12 33 32
		//      
		
		//      이전까지의 합과 현재 값을 비교해 최대값을 찾고
		//      전 최대값과 현재 최대값을 비교해 최대값을 찾음
		//      ex) 10 + (-4) 와 -4를 비교하면 
		//			10 + (-4) 가 크므로 max에 저장
		//
		
		sum[0] = seq[0];
		
		int max = seq[0];
		for(int i=1; i<seq.length; i++) {
				// 이전까지의 합과 현재 값을 비교해 최대값을 찾아 해당 index 합 배열에 넣어줌
				sum[i] = Math.max(sum[i-1] + seq[i], seq[i]);
				// 최대값은 이전 최대값과 현재 최대값을 비교해 최대값을 찾아 max에 넣어줌
				max = Math.max(max,sum[i]);
		}
		
		System.out.println(max);
		
	}
}