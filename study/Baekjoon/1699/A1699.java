import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1699 {
	/**
	   i      1
	 dp[i]    1
	  j*j    1*1
	  
	  i  dp[i]  j  j*j  dp[i] > dp[i-(j*j)]+1
	  1    1    1   1        1 > (1) (dp[1-(1)]+1 -> dp[0]+1)
	  2    2    1   1        2 > (2) (dp[2-(1)]+1 -> dp[1]+1)
	  2    2    2   4      조건 불출분 
	  3    3    1   1        3 > (3) (dp[3-(1)]+1 -> dp[2]+1)
	  3    3    2   4      조건 불출분
	  4    4    1   1        4 > 4   (dp[4-(1)]+1 -> dp[3]+1)
	  4    4    2   4        4 > (1) (dp[4-(4)]+1 -> dp[0]+1)
	  5    5    1   1        5 > 2   (dp[5-(1)]+1 -> dp[4]+1)
	  5    5    2   4        2 > (2) (dp[5-(4)]+1 -> dp[1]+1)
	  6    6    1   1        6 > 3   (dp[6-(1)]+1 -> dp[5]+1)
	  6    3    2   4        3 > 3   (dp[6-(4)]+1 -> dp[2]+1)
	  6    3    3   9      조건 불출분
	  7    7    1   1        7 > 4   (dp[7-(1)]+1 -> dp[6]+1)
	  7    4    2   4        4 > 4   (dp[7-(4)]+1 -> dp[3]+1)
	  7    4    3   9      조건 불출분
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		
		for(int i = 1; i < dp.length; i++) {	// i가 구하고자 하는 n 값이라면 
			dp[i] = i;
			System.out.println("\n[START]");
			System.out.println("dp[" + i + "] = " + dp[i]);
			
			for(int j = 1; j*j <= i; j++) {		// i는 j를 제곱한 값보다 크거나 같아야 최소항의 개수를 구할 수 있다.
				System.out.println();
				System.out.println("j * j = " + j*j);
				System.out.println(j + " * " + j + " = " + (j*j));
				System.out.println(dp[i] + " > " + (dp[i-(j*j)]+1));
				
				if(dp[i] > dp[i-(j*j)]+1) {
					dp[i] = dp[i-(j*j)]+1;
					System.out.println("[TRUE] dp[i] = " + dp[i]);
				}
			}
		}
		
		System.out.println(dp[N]);
	}

}