package 알고리즘정답노트.BFS;

// 문제 링크: https://www.acmicpc.net/problem/1743
// 문제 설명: 상하좌우로 인접한 음식물끼리 뭉칠 때, 가장 큰 음식물의 크기를 구하는 문제
// 핵심 개념: 너비 우선 탐색, 깊이 우선 탐색, 그래프 이론

import java.util.*;
import java.io.*;

public class B1743_BFS_그래프 {
	public static int N, M, K;
	public static boolean[][] hall;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		hall = new boolean[N][M];
		for(int i=0; i<K; i++){
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1; //hall 배열의 인덱스(0~N-1)로 표시하기 위해 1을 뺌
			int c = Integer.parseInt(st.nextToken())-1;
			hall[r][c]=true;	//음식물이 있는 칸을 true로 표시한다.
		}

		int max = 0;
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(hall[i][j]) max = Math.max(max, bfs(i, j)); //음식물이 있는 칸을 중심으로 크기를 구한 후, 최대 크기를 업데이트한다.
			}
		}
		System.out.println(max);
	}

	public static int[] dr = {1, -1, 0, 0};
	public static int[] dc = {0, 0, 1, -1};

	public static int bfs(int i, int j){
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{i, j});
		hall[i][j]=false;

		int answer = 1;
		while(!queue.isEmpty()){
			int[] cur = queue.poll();
			for(int k=0; k<4; k++){
				int nr = cur[0]+dr[k];
				int nc = cur[1]+dc[k];
				if(nr<0||nr>N-1||nc<0||nc>M-1||!hall[nr][nc]) continue; //이때 nr과 nc의 최대 인덱스가 N-1, M-1로 다름에 주의해야한다!!!
				queue.offer(new int[]{nr, nc});
				hall[nr][nc]=false;
				answer++;
			}
		}

		return answer;
	}
}