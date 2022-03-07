package BOJ;

import java.util.Scanner;

public class boj_10250_ACM호텔 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			
//			int[][] hotel = new int[H][W];
				
			int floor = 0;
			int room = 0;
			if(N%H == 0) {
				room = N/H;
				floor = H*100;
			}else {
				room = (N/H)+1;
				floor = N%H*100;
			}
//			System.out.println(room);
//			System.out.println(floor);
			System.out.println(floor+room);
			
		}
	}
}
