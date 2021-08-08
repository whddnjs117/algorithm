import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class A_14002 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력을 받기 위함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		//  수열 배열
		long[] seq = new long[length];
		// 입력을 받아 long 배열로 형변환
		seq = Arrays.asList(br.readLine().split(" ")).stream().mapToLong(Long::parseLong).toArray();
		// 길이 배열
		int[] lengths = new int[length];
		
		Stack<String> result = new Stack<String>();
		
		lengths[0] = 1;
		int max = 0;
		// 정답 문자열을 만들기 위함
		StringBuilder answer = new StringBuilder();
		// 역추적 하기위한 임시 배열
		int[] temp = new int[length];
		for(int i=0; i<seq.length; i++) {
			lengths[i] = 1;
			temp[i] = -1;
			for(int j=0; j<i; j++) {
				// i번째 수가 j번째 수보다 크면서 i번째 길이보다 j번째 길이에 1더한 값 보다 크면
				if(seq[i]>seq[j] && lengths[i] < lengths[j]+1) {
					// i번째에 j번째 길이의 +1 한값을 넣어줌
					lengths[i] = lengths[j]+1;
					temp[i]  = j;
					
					// seq     10 20 10 30 20 50
					// lengths 1  2  1  3  2  4
					
				}
			}
		}
		//				0	1	2	3	4	5					
		// seq[i]      10	20	10	30	20	50
		// lengths[i]	1	2	1	3	2	4
		// temp[i]	   -1	0  -1	1	0	3
		
		// 수열의 가장 큰 값 부터 넣고 그 다음 temp[index] 값을 stack에 넣음
		// 계속역추적
		
		
		
		
		
		int index = 0;
		for(int i=0; i<lengths.length; i++) {
			if(max<lengths[i]) {
				max = lengths[i];
				index = i;
			
			}
		}
		
//		for(int i=0; i<=index; i++) {
//			
//			if(!result.contains(seq[i]+"")) {
//				result.add(seq[i]+"");
//			}
//		}
		
		answer.append(max).append("\n");
		while(index != -1) {
			result.push(seq[index]+"");
			index = temp[index];
		}
//		0	1	2	3	4	5					
// seq[i]      10	20	10	30	20	50
// lengths[i]	1	2	1	3	2	4
// temp[i]	   -1	0  -1	1	0	3
		

//		for(int i=result.size()-1; i>=0; i--) {
//			System.out.print(result.get(i)+" ");
//			
//			
//		}
		
		// STACK
		// FILO
		// 퍼스트인 라스트 아웃 구조니 마지막 넣은 값부터 뽑아 삭제하면서 문자열에 이어붙임
		
	
		// 10
		// 20
		// 30
		// 50
		
		// answer
		// 4
		// 10 20 30 50
		while(!result.isEmpty()) {
			answer.append(result.pop()).append(" ");
		}
		
		System.out.println(answer);
		
	}
}