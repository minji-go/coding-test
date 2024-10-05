package 알고리즘정답노트.다익스트라;

// 문제 링크 : https://www.acmicpc.net/problem/4485
// 문제 설명 : 테스트 케이스별 (0,0)에서 (N-1, N-1)까지 갈 때 소모되는 최소 금액을 구하는 문제
// 핵심 개념 : 다익스트라, 최단 경로, 그래프 이론, 그래프 탐색

import java.util.*;
import java.io.*;

public class B4485_다익스트라_최단거리_그래프 {
	public static int N, T;
	public static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		while((N=Integer.parseInt(br.readLine()))!=0){ //테스트 케이스의 N이 0이면 입력을 종료한다.
			T++; 					//출력에 나오는 Problem 'T'를 위해 테스트 케이스가 몇번째인지 구한다.
			arr = new int[N][N];
			for(int i=0; i<N; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}	
			bfs();
		}
		System.out.println(sb);
	}
	public static int[] dr = {1, -1, 0, 0}; //젤다의 전설 시리즈의 주인공 링크는 상하좌우로 인접한 1칸만 이동할 수 있따.
	public static int[] dc = {0, 0, 1, -1};
	public static StringBuilder sb = new StringBuilder();
	public static void bfs(){
		int[][] loss = new int[N][N];
		for(int i=0; i<N; i++) Arrays.fill(loss[i], 360000); // 절대 나올 수 없는 최소 금액으로 값을 채움 (9*200*200)

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0, 0, arr[0][0]}); //행과 열, 그리고 금액 순으로 배열을 생성하여 큐에 삽입한다.
		loss[0][0] = arr[0][0];
		
		while(!queue.isEmpty()){
			int[] cur = queue.poll();
			for(int i=0; i<4; i++){
				int nr = cur[0]+dr[i];
				int nc = cur[1]+dc[i];
				if(nr<0||nr>N-1||nc<0||nc>N-1) continue;

				int nl = cur[2]+arr[nr][nc];	//nr, nc가 유효한 index인지를 확인한 후 nl을 계산할 수 있다.
				if(nl>=loss[nr][nc]) continue;

				loss[nr][nc] = nl;											//loss배열에 최소 금액을 갱신한다.
				if(nr!=N-1 || nc!=N-1) queue.offer(new int[]{nr, nc, nl}); 	//(N-1, N-1)에 도달하면 더 이상 이동할 필요가 없다.
			}
		}
		
		sb.append("Problem ").append(T).append(": ")
			.append(loss[N-1][N-1]).append("\n");
	}
}