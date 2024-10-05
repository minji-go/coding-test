package 알고리즘정답노트.시뮬레이션;

// 문제 링크 : https://www.acmicpc.net/problem/5212
// 문제 설명 : 50년 후에 모든 섬을 포함하는 가장 작은 직사각형 지도를 출력하는 문제
//           50년 후 인접한 세 칸 이상이 바다(".")이면, 섬("X")이 잠겨서 바다가 된다.
// 핵심 개념 : 구현, 시뮬레이션

import java.util.*;
import java.io.*;

public class B5212_시뮬레이션_구현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());	
		char[][] arr = new char[R][C];
		for(int i=0; i<R; i++){
			arr[i] = br.readLine().toCharArray();
		}
		
		int minR=R-1, maxR=0, minC=C-1, maxC=0;	//50년 후 섬의 위치(R,C)의 최소, 최대값
		int[] dr = {-1, 1, 0, 0};				//그리드에서 특정 위치(R,C)에 인접한 칸
		int[] dc = {0, 0, -1, 1};
		char[][] narr = new char[R][C];
		for(int i=0;i <R; i++){
			for(int j=0; j<C; j++){
				if(arr[i][j]=='X') {
					//50년 후 바다가 되는지 판단 (인접한 세 칸 이상이 바다인지 판단)
					int cnt = 0;
					for(int k=0; k<4; k++){
						int nr = i+dr[k];
						int nc = j+dc[k];
						if(nr<0||nr>R-1||nc<0||nc>C-1) cnt++;
						else if(arr[nr][nc]=='.') cnt++;
					}
					//50년 후 바다가 되면 .으로, 바다가 아니면 X,Y 최소,최대값 갱신
					if(cnt>=3) {
						narr[i][j]='.';
					} else {
						narr[i][j]='X';
						minR = Math.min(minR, i);
						maxR = Math.max(maxR, i);
						minC = Math.min(minC, j);
						maxC = Math.max(maxC, j);
					}
				} else {
					narr[i][j]='.';
				}
			}
		}

		//모든 섬을 포함하는 최소 직사각형 지도 출력하기
		StringBuilder sb = new StringBuilder();
		for(int i=minR; i<=maxR; i++){
			for(int j=minC; j<=maxC; j++){
				sb.append(narr[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
}