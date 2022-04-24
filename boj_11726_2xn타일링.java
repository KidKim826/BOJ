package BOJ;

import java.util.Scanner;

public class boj_11726_2xn타일링 {
	
	static int[] dp;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		dp = new int[10007];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i < n+1; i++ ) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		
		ans = dp[n];
		
		System.out.println(ans%10007);
	}
	
	public static void find() {
		
		
	}
	
}
