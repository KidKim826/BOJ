package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import jdk.internal.util.xml.impl.Pair;

public class boj_7576_토마토 {
	
	//시작지점이 여러개인 미로 같은 느낌
	
	static String[][] tomato;
	static boolean[][] visited;
	static int M;
	static int N;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = { 0, 0, -1, 1};
	static int datejust;
	static Queue<Pos> Q = new LinkedList<>();
	
	public static class Pos {
		int r;
		int c;
		
		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		//토마토 상자배열
		tomato = new String[N][M];
		visited = new boolean[N][M];
		//토마토 상자에 담아준다.
		for(int i = 0; i < N; i++) {
			tomato[i] = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				if(tomato[i][j] == "1") { //익은 토마토 자리를 발견하면 그걸 넣어줘.
					Q.offer(new Pos(i, j));
					visited[i][j] = true;
				}
			}
		}
		//토마토야 잘 들어갔니
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(tomato[i][j]);
//			}
//			System.out.println();
//		}
		//1이면 담아줘
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				if(tomato[i][j] == "1") {
//					Q.offer(new Pos(i, j));
//					visited[i][j] = true;
//				}
//			}
//		}
		bfs();
		
		for(int i = 0; i < N; i++) {
			for( int j = 0; j < M; j++) {
				if(tomato[i][j] == "0") {
					System.out.println(-1);
				}else {
					System.out.println(datejust);
				}
			}
		}
		
	}
	
	public static void bfs() { //bfs
		while(!Q.isEmpty()) {
			// Q에 있는 건 익은 토마토가 든 자리.
			Pos first = Q.remove(); //Q를 하나씩 지워가면서  Q에 들어잇는게 없어질때까지 반복스
			datejust++; //날짜 늘려주고
			
			for(int i = 0; i < 4; i++) { //4방 탐색 할건데
				int nr = dr[i] + first.r; //시작점은 Pos의 r
				int nc = dc[i] + first.c; // 그리고 Pos의 c
				
				//범위를 벗어나면 패스
				if( nr < 0 || nr >= N || nc < 0 || nc >= M) {
					continue;
				}
				
				// 익은 토마토 or 비어있으면 패스
				if(tomato[nr][nc] != "0") {
					continue;
				}
				
				// 토마토 익혀주기
				if(tomato[nr][nc] == "0" && visited[nr][nc] == false) { // 토마토가 0인부분을
					tomato[nr][nc] = "1"; // 1로 바꿔줘,
					Q.offer(new Pos(nr, nc)); // Q에 pos(idx) 넣어주고
					visited[nr][nc] = true; // 방문처리.
				}
			}
			
		}
		
	}
	
}
