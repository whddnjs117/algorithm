import java.util.Scanner;

public class A_2225 {

	public static void main(String[] args) {
		
		/* (합)(갯수)      
		 * 	n	k 경우의수   n	k 경우의수
		 *  1	1	1	 2	1	1
		 *  1   2   2	 2	2	3
		 *  1   3   3    2	3	6
		 *  1	4	4	 2	4	10
		 *  
		 *  		
		 *  dp[n][k] = dp[n-1][k] + dp[n][k-1]
		 *  
		 *  만약 n이 2이고 k가 4라면
		 *  dp[2][4] = dp[1][4] + dp[2][3]
		 *  
		 *  dp[n-1][k]에는 + 1 
		 *  dp[n][k-1]에는 마지막에 + 0 
		 *  
		 *  dp[1][4]	dp[2][3] 
		 *  0+0+0+1		2+0+0
		 *  0+0+1+0		0+2+0
		 *  0+1+0+0		1+1+0
		 *  1+0+0+0		0+0+2
		 *  			0+1+1
		 *  			0+0+2
		 *
		 * 
		 * dp[2][4] 
		 * 
		 * 0+0+0+2		2+0+0+0
		 * 0+0+1+1		0+2+0+0
		 * 0+1+0+1		1+1+0+0
		 * 1+0+0+1		0+0+2+0
		 * 				0+1+1+0
		 * 				0+0+2+0
		 */ 			
		
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		int k = sc.nextInt(); 
		
		// n과 k는 200이하 이므로 201 로 초기화
		int[][] dp = new int[201][201]; 
		
		
		for(int i=1;i<=k;i++) {
			dp[i][0]=1;
		}
		for(int i=1;i<=k;i++) {
			for(int j=1;j<=n;j++) {
				dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000000; // 1000000000으로 나누는 걸 출력할 때 주면 틀렸다고 뜸.
			}
		}
		System.out.println(dp[k][n]);
	}

}