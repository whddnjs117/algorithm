import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A_11053 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int seqSize = Integer.parseInt(br.readLine());
	
		int[] seq = new int[seqSize];
		// 수열 배열  String 배열 int 배열로 형변환
		seq = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		// 길이 배열
		int[] result = new int[seqSize];
		
		int answer = 0;
	
		
		for(int i=0; i<seq.length; i++) {
			// 초기값 설정
			result[i] = 1;

			for(int j=0; j<i; j++) {
				// i번째 값이 j번째 값보다 크면서 i번째 길이가 j번째 + 1 길이보다 작은경우
				if(seq[i]>seq[j] && result[i] < result[j] + 1) {		
					result[i] = result[j]+1;
				}
			}
			
		}
		
		// 최대 길이 탐색
	        for (int i = 0; i < result.length; i++){
	        		
	        	
	        	if (result[i] > answer){
	                answer = result[i];
	            }
	        }
	        
		// 최대 값 출력
	        System.out.println(answer);
		
	
	}
	
}