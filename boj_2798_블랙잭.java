package BOJ;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_2798_블랙잭 {
	static int blackjack;
	static int sum;
	static int max;
	static boolean[] sel;
	static int[] deck;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		blackjack = sc.nextInt();
		
		deck = new int[N];
		for(int i = 0; i < N; i++) {
			deck[i] = sc.nextInt();
		}
		sel = new boolean[N];
		max = Integer.MIN_VALUE;
//		find(0);
//		System.out.println(max);
		
		for(int i = 0; i < N-2; i++) {
			for(int j = i+1; j < N-1; j++) {
				for(int k = j+1; k < N; k++) {
					sum = deck[i]+deck[j]+deck[k];
//					System.out.println(sum);
					if(sum <= blackjack) {
						if(sum > max) {
							max = sum;
						}
					}
				}
			}
		}
		System.out.println(max);
	}
	
}
