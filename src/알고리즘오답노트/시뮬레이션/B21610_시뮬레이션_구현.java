package 알고리즘오답노트.시뮬레이션;

// 문제 링크 : https://www.acmicpc.net/problem/21610
// 문제 설명 : 새로운 마법 비바라기를 N*N 격자에서 연습하는데, 격자 칸에 있는 물바구니에 들어있는 물의 양의 합을 구하는 문제
//			1. 모든 구름이 di 방향으로 si칸 이동한다.
//			2. 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
//			3. 구름이 모두 사라진다.
//			4. 2에서 구름이 있던 칸의 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r,c)에 있는 바구니의 물이 양이 증가한다.
//			5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
// 핵심 개념 : 시뮬레이션, 구현
// 오답 원인: 이동하는 방향이 ↖ 일 때, 좌표상에서는 (x,y)가 (-1,1)이지만 그래프상에서는 (r,c)가 (-1,-1)임을 헷갈림

import java.util.*;
import java.io.*;

public class B21610_시뮬레이션_구현 {
	public static int N, M;
	public static int[][] A;
	public static int [] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};  //구름이 격자상에서 이동하는 방향(di)
	public static int [] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	public static Queue<int[]> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N+1][N+1];
		for(int i=1; i<=N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++){
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		queue = new LinkedList<>();
		queue.offer(new int[]{N, 1});
		queue.offer(new int[]{N, 2});
		queue.offer(new int[]{N-1, 1});
		queue.offer(new int[]{N-1, 2});
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int di = Integer.parseInt(st.nextToken());
			int si = Integer.parseInt(st.nextToken());
			cloud(di, si);
		}

		int sum = 0;
		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				sum += A[i][j];
			}
		}
		System.out.println(sum);

	}

	public static void cloud(int di, int si){
		//1~2.비내리기
		boolean[][] cloud = new boolean[N+1][N+1];

		int size = queue.size();
		for(int i=0; i<size; i++){
			int[] now = queue.poll();
			int nr = ((now[0]-1)+(dr[di]*si)%N+N)%N+1;	//구름을 먼저 이동시킨다.
			int nc = ((now[1]-1)+(dc[di]*si)%N+N)%N+1;	//1번 행과 N번 행을 연결했고, 1번 열과 N번 열도 연결했다.

			A[nr][nc]++;					//구름이 있는 칸에 비가 1씩 내린다.
			cloud[nr][nc]=true;				//구름이 있던 칸을 표시한다.
			queue.offer(new int[]{nr, nc});	//구름이 있던 모든 칸에 물을 1씩 증가시킨 상태에서 대각선 칸을 탐색해야 하기 때문에 다음 for문에서 대각선을 탐색한다.
		}

		//3~4.물복사버그 마법
		size = queue.size();
		for(int i=0; i<size; i++){
			int[] now = queue.poll();
			int cnt = 0;
			for(int j=2; j<=8; j=j+2){		//대각선 방향을 탐색한다.
				int nr = now[0]+ dr[j];
				int nc = now[1]+ dc[j];
				if(nr<1||nr>N||nc<1||nc>N||A[nr][nc]<1) continue;
				cnt++;						//대각선 방향에 물이 든 바구니가 있다면 cnt를 증가시킨다.
			}
			A[now[0]][now[1]]+=cnt;			//대각선 방향에 있던 물이 든 바구니의 개수만큼 더해준다.
		}

		//5.구름생성
		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				if(A[i][j]>=2 && !cloud[i][j]){		//물의 양이 2 이상이면서 구름이 생기지 않았던 곳을 탐색한다.
					A[i][j]-=2;						//물의 양을 2감소시키고
					queue.offer(new int[]{i, j});	//구름을 생성한다.
				}
			}
		}

	}
}