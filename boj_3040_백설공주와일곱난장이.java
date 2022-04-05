package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_3040_백설공주와일곱난장이 {
	//조합
	
	static int[] dwarfs = new int[9];
	static int[] sel = new int[7];
	static int cnt;
	static int sum;
	static Queue<Integer> Q = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 9; i++) {
			dwarfs[i] = sc.nextInt();
		}
		
		powerset(0, 0);
		
		if(cnt == 1) { //cnt가 1일 때만 출력
     		 for(int i = 0; i < sel.length; i++) {
     			 System.out.println(Q.poll());
     		 }
     	}
	}
	
	 public static void powerset(int idx, int selIdx) {
		 //기본 파트
	     if(selIdx == sel.length) {
	    	 sum = 0;
	    	 for(int i = 0; i < sel.length; i++) {
	    		 sum += sel[i];
	    	 }
	    	 if(sum == 100) { // cnt 가 1일때만,
	    		 cnt++;
	    		 if(cnt == 1) {
	    			 for(int i = 0; i < sel.length; i++) {
	    				 Q.offer(sel[i]);
	    			 }
	    		 }
	    	 }
	    	 
	    	 return;
	     }
	     
	     //재귀 파트
	     if(idx == dwarfs.length) return;
	     
	     sel[selIdx] = dwarfs[idx]; // dwarfs의 값을real에 담기
	    
	     powerset(idx+1, selIdx+1); //현재 dwarfs를 담고 다음 real를 재귀로 채우겠다.
	     powerset(idx+1, selIdx); //현재 dwarfs을 담지 않고 현재 real의 값을 재귀로 채우겠다.
       
	 }

}
