package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj_2961_도영이가만든맛있는음식 {
	
	static int[] sour;
	static int[] bitter;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i =0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			sour[i] = Integer.parseInt(str[0]); // 신맛 담아주고
			bitter[i] = Integer.parseInt(str[1]); // 쓴맛 담아주고
		}
		
		System.out.println(Arrays.toString(sour));
		System.out.println(Arrays.toString(bitter));
	}
}
