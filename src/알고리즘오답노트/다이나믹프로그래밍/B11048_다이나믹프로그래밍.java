package 알고리즘오답노트.다이나믹프로그래밍;

// 문제 링크 : https://www.acmicpc.net/problem/11048
// 문제 설명 : (1,1)에서 (N,M)으로 이동할 때 가져갈 수 있는 최대 사탕의 개수를 구하는 문제
// 핵심 개념 : 다이나믹 프로그래밍
// 오답 원인: DP로 풀어야 할 문제를 BFS로 풀어서 메모리 초과

// Q. 문제 접근을 dp, bfs 어떤걸로 하는지 무엇을 보고 결정하나요?
// A. BFS는 그래프에서 간선의 가중치가 모두 같을 때의 최단 경로를 구하는 알고리즘입니다.
//	  DP는 부분 문제를 해결하는것으로 더 큰 문제를 해결할 수 있을 때 사용하는 알고리즘입니다.
//	  이 문제는 정점 사이의 거리는 1이지만, 구하려는 답은 최단 경로가 아니므로 BFS를 적용하기 좋은 문제는 아닌 것 같습니다.

import java.util.*;
import java.io.*;

public class B11048_다이나믹프로그래밍 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dp(N, M ,arr));
	}

	public static int[] dr = {1, 0, 1};
	public static int[] dc = {0, 1, 1};

	public static int dp(int N, int M, int[][] arr){
		int[][] candy = new int[N][M];
		for(int r=0; r<N; r++){
			for(int c=0; c<M; c++){
				int max = 0;
				for(int k=0; k<3; k++) {// 해당 칸에 오기 직전의 칸을 탐색하며 최대 사탕의 개수를 구한다.
					int nr = r-dr[k]; 	// 움직인 거리만큼을 빼준다.
					int nc = c-dc[k];
					if (nr<0 || nc<0) continue;
					max = Math.max(max, candy[nr][nc]);
				}
				candy[r][c]=max+arr[r][c];	// 직전 칸의 최대 사탕의 개수에 현재 칸의 사탕 개수를 더한다.
			}
		}
		return candy[N-1][M-1];
	}
}