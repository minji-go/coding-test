package 알고리즘정답노트.BFS;

// 문제 링크 : https://www.acmicpc.net/problem/16234
// 문제 설명 : 인구수 차이가 L과 R사이인 인접한 국가 간에 인구 이동이 일어나 인구수가 같아질 때, 총 인구 이동이 발생하는 일수를 구하는 문제
// 핵심 개념 : 구현, 시뮬레이션, 그래프 이론, 그래프 탐색, 너비 우선 탐색

import java.util.*;
import java.io.*;
public class B16234_BFS_그래프_시뮬레이션 {
	public static int N, L, R;
	public static int[][] A;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		A = new int[N][N];

		for(int r=0; r<N; r++){
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++){
				A[r][c]=Integer.parseInt(st.nextToken());
			}				
		}
		
		int day=0;
		while(isOpen()) day++; 	// 국가 간 인구 이동이 발생하면 DAY+1
		System.out.println(day);
	}

	public static int[][] visited;
	public static boolean isOpen(){
		visited = new int[N][N];	//하루 동안 국경이 열렸는지 아닌지 방문하여 탐색
		boolean isopen = false;		//국경이 열린 곳이 있는지 여부
		
		//하루 동안의 연합국별 인구이동
		int n = 1;
		for(int r=0; r<N; r++){
			for(int c=0; c<N; c++){
				if(visited[r][c]==0) {
					boolean result = bfs(r, c, n); //n번째 연합국 탐색
					if(!isopen) isopen=result;
					n++;
				}
			}				
		}
	
		return isopen;
	}
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static boolean bfs(int r, int c, int n){
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{r, c});
		visited[r][c]=n;
		int sum = A[r][c];	//연합의 총 인구수
		int cnt = 1;		//연합을 이루고 있는 국가 수
		
		//하나의 연합 인구수와 연합국 개수 연산
		while(!queue.isEmpty()){
			int[] cur = queue.poll();
			int cr = cur[0];
			int cc = cur[1];
			for(int i=0; i<4; i++){
				int nr = cr+dy[i];
				int nc = cc+dx[i];
				if(nr<0 || nr>N-1 || nc<0 || nc>N-1 || visited[nr][nc]!=0) continue;
				
				int diff = Math.abs(A[cr][cc]-A[nr][nc]);
				if(diff>=L && diff<=R){					//국가 간 인구 수 차이가 L과 R 사이로, 국경이 열리는지 여부 확인
					queue.offer(new int[]{nr, nc});		//국경이 열렸다면, 연합 국가수와 인구수 카운트하고 방문 여부 체크.
					visited[nr][nc]=n;
					sum+=A[nr][nc];
					cnt++;
				}
			}
		}
		
		//하나의 연합 내 인구 이동
		int num = sum/cnt;
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(visited[i][j]==n) A[i][j]=num;
			}				
		}
		
		return cnt != 1;	//연합이 아닐 경우 인구 이동이 발생하지 않아서 false 반환
	}
	
}