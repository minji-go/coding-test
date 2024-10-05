package 알고리즘정답노트.시뮬레이션;

// 문제 링크 : https://www.acmicpc.net/problem/1913
// 문제 설명 : 1부터 N^2까지의 자연수를 달팽이 모양으로 N*N 행렬에 채우고, 특정 수의 위치를 출력하는 문제
// 핵심 개념 : 구현

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1913_구현 {

    static int[] dr = new int[]{-1,0,1,0};
    static int[] dc = new int[]{0,1,0,-1};

    public static void main(String[] args) throws Exception {
    //인덱스가 1부터 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        int nr=N/2, nc=N/2, nd=0, num=0;
        for(int i=1; i<N*2; i++){
            for(int j=0; j<(i+1)/2; j++){
                if(num==N*N) break;
                arr[nr][nc]=++num;
                nr+=dr[nd];
                nc+=dc[nd];
            }
            nd=(nd+1)%4;
        }

        int[] answer = new int[2];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j]==T) {
                    answer[0]=i+1;
                    answer[1]=j+1;
                }
                bw.write(arr[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.write(answer[0]+" "+answer[1]);
        bw.close();
    }
}
