package 알고리즘정답노트.시뮬레이션;

// 문제 링크 : https://www.acmicpc.net/problem/17140
// 문제 설명 : 1초마다 R연산 혹은 C연산을 할 때, 그래프의 특정 칸이 k가 되는 최소 시간을 구하는 문제
//			- R 연산: 배열 A의 모든 행에 대해서 정렬을 수행한다. 행의 개수 ≥ 열의 개수인 경우에 적용된다.
//			- C 연산: 배열 A의 모든 열에 대해서 정렬을 수행한다. 행의 개수 < 열의 개수인 경우에 적용된다.
//			- 정렬은 수의 등장 횟수가 커지는 순으로, 수의 등장 횟수가 같으면 수가 커지는 순으로 정렬한다
// 핵심 개념 : 구현, 시뮬레이션, 정렬

import java.util.*;
import java.io.*;

public class B17140_시뮬레이션_구현_정렬 {
	public static int[][] A = new int[100][100];	//100이 넘어가면 버리기 때문에 처음부터 배열크기를 100*100로 초기화
	public static int row, col;						//100*100크기의 배열 중 실제로 사용 중인 칸의 최대 인덱스

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken())-1; //인덱스 0부터 시작
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());

		for(int i=0; i<3; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++){
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		row = 2;
		col = 2;
		int sec = 0;
		while(A[r][c]!=k && sec<=100){	//A[r][c]가 K이거나, 시간이 100초가 넘으면 중지
			if(row>=col) calR();		//행의 크기와 열의 크기를 비교하여 연산 종류(R, C)를 결정한다.
			else calC();
			sec++;
		}

		System.out.print(sec > 100? -1 : sec);	//100초가 넘으면 -1을 출력한다.
	}

	public static void calR(){

		for(int i=0; i<=row; i++){
			Map<Integer, Integer> map = new HashMap<>(); //HashMap을 이용하여 수의 등장 횟수를 카운트한다.
			for(int j=0; j<=col; j++){
				int val = A[i][j];
				if(val!=0) map.put(val, map.getOrDefault(val, 0)+1);
			}

			List<Integer> keys = new ArrayList<>(map.keySet());	//HashMap의 Key를 정렬 기준에 따라 정렬한다.
			keys.sort((o1, o2) -> {
				if (map.get(o1) == map.get(o2)) return o1 - o2;
				else return map.get(o1) - map.get(o2);
			});

			int j=0;
			for(Integer key: keys){		//정렬된 수들을 배열 A에 다시 갱신한다.
				A[i][j++]=key;			//수를 먼저 넣는다.
				A[i][j++]=map.get(key); //수다음으로 수의 등장 횟수를 넣는다.
				if(j==100) break;
			}
			while(j<=col) {	//새로운 행의 크기가 이전보다 작을 수 있으므로, 갱신한 수 외의 수는 0으로 채워준다.
				A[i][j]=0;
				j++;
			}

			col=Math.max(col, j-1); //최대 행의 크기(즉, 열의 인덱스)를 비교하여 갱신한다.
		}
	}

	public static void calC(){

		for(int i=0; i<=col; i++){
			Map<Integer, Integer> map = new HashMap<>();
			for(int j=0; j<=row; j++){
				int val = A[j][i];
				if(val!=0) map.put(val, map.getOrDefault(val, 0)+1);
			}

			List<Integer> keys = new ArrayList<>(map.keySet());
			keys.sort((o1, o2) -> {
				if (map.get(o1) == map.get(o2)) return o1 - o2;
				else return map.get(o1) - map.get(o2);
			});

			int j=0;
			for(Integer key: keys){
				A[j++][i]=key;
				A[j++][i]=map.get(key);
				if(j==100) break;
			}

			while (j<=row) {
				A[j][i]=0;
				j++;
			}

			row=Math.max(row, j-1);
		}
	}
}