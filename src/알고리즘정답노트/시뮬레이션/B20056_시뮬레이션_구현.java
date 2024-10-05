package 알고리즘정답노트.시뮬레이션;

// 문제 링크 : https://www.acmicpc.net/problem/20056
// 문제 설명 : 질량, 방향, 속력을 가진 파이어볼이 K번 이동하였을 때, 남아있는 질량을 구하는 문제
// 핵심 개념 : 구현, 시뮬레이션

import java.util.*;
import java.io.*;

public class B20056_시뮬레이션_구현 {
	public static class Fire {
		public int ri, ci, mi, si, di;
		Fire(int ri, int ci, int mi, int si, int di){
			this.ri=ri;
			this.ci=ci;
			this.mi=mi; //질량
			this.si=si; //속력
			this.di=di; //방향
		}
	}

	public static int N, M, K;
	public static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}; //행 방향으로 이동
	public static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1}; //열 방향으로 이동
	public static Queue<Fire> queue = new LinkedList<>(); //남아있는 파이어볼을 담는 큐

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int ri = Integer.parseInt(st.nextToken())-1;	//격자의 위치라고 생각하여 인덱스 0부터 시작하도록 수정
			int ci = Integer.parseInt(st.nextToken())-1;
			int mi = Integer.parseInt(st.nextToken());
			int si = Integer.parseInt(st.nextToken());
			int di = Integer.parseInt(st.nextToken());
			queue.offer(new Fire(ri, ci, mi, si, di));
		}

		for(int i=0; i<K; i++){ //모든 파이어볼 이동을 K번 반복한다.
			moveFire();
		}

		int sum = 0;
		while(!queue.isEmpty()){
			sum+= queue.poll().mi;
		}
		System.out.println(sum);
	}

	private static void moveFire() {
		//파이어볼 이동
		int[][][] arr = new int[N][N][4]; //arr[r][c]의 배열은 cnt, mi, si, di 순서로 담는다.
		int size = queue.size();
		for(int j=0; j<size; j++){
			Fire fire = queue.poll();
			int nr = fire.ri = (fire.ri + (dr[fire.di]*fire.si)%N + N)%N; //파이어볼이 이동한 행
			int nc = fire.ci = (fire.ci + (dc[fire.di]*fire.si)%N + N)%N; //파이어볼이 이동한 열
			queue.offer(fire);

			arr[nr][nc][0]++;
			arr[nr][nc][1]+=fire.mi;
			arr[nr][nc][2]+=fire.si;

			if(arr[nr][nc][3]==0) arr[nr][nc][3]=(fire.di%2==0?2:1);	 //파이어볼의 방향이 모두 짝수라면 2, 혹은 모두 홀수라면 1을 삽입
			else if(arr[nr][nc][3]==1 && fire.di%2!=1) arr[nr][nc][3]=3; //이전 파이어볼 방향이 홀수였는데, 이번 파이어볼 방향이 짝수이면 3을 삽입
			else if(arr[nr][nc][3]==2 && fire.di%2!=0) arr[nr][nc][3]=3; //이전 파이어볼 방향이 짝수였는데, 이번 파이어볼 방향이 홀수이면 3을 삽입
		}
		//합쳐질 파이어볼 삭제
		for(int j=0; j<size; j++){
			Fire fire = queue.poll();
			if(arr[fire.ri][fire.ci][0]<2) queue.offer(fire);	//해당 위치의 파이어볼 개수가 2개 미만이면 합치지 않음
		}
		//파이어볼 나누기
		for(int j=0; j<N; j++){
			for(int k=0; k<N; k++){
				if(arr[j][k][0]<2) continue;
				int mi = arr[j][k][1]/5;				//질량은 모든 파이어볼 질량의 합/5
				int si = arr[j][k][2]/arr[j][k][0]; 	//속력은 모든 파이어볼 속력의 합/모든 파이어볼의 개수
				if(mi==0) continue;
				int di = (arr[j][k][3]==3?1:0);			//모든 파이어볼이 홀수 혹은 짝수일 때는 0, 2, 4, 6 방향의 파이어볼 4개 생성
				for(int l=di; l<8; l+=2){				//모든 파이어볼이 홀수 혹은 짝수로 통일되지 않으면, 1, 3, 5, 7 방향의 파이어볼 4개 생성
					queue.offer(new Fire(j, k, mi, si, l));
				}
			}
		}
	}
}