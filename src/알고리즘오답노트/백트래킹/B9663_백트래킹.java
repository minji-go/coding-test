package 알고리즘오답노트.백트래킹;

//https://www.acmicpc.net/problem/9663

import java.io.*;

public class B9663_백트래킹 {
    static int n, answer;
    static int[][] chess;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        chess = new int[n][n];

        B9663_백트래킹 T = new B9663_백트래킹();
        T.dfs(0);
        System.out.print(answer);
    }

    public void dfs(int depth){
        if(depth==n) answer++;

        boolean skip=true;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(chess[i][j]==depth) skip=false;
                if(skip) continue;

                if(chess[i][j]==0){
                    chess[i][j]=depth+1;
                    fill(i, j, depth+1);
                    dfs(depth+1);
                    disfill(depth+1);
                }
            }
        }
    }

    public void fill(int i, int j, int num){
        for(int k=0; k<n; k++) {
            if(chess[i][k]==0) chess[i][k]=num;
            if(chess[k][j]==0) chess[k][j]=num;
            if(j-i+k>0 && j-i+k<n && chess[k][j-i+k]==0) chess[k][j+k-i]=num;
            if(j+i-k>0 && j+i-k<n && chess[k][j+i-k]==0) chess[k][j+i-k]=num;
        }
    }

    public void disfill(int num){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(chess[i][j]==num) chess[i][j]=0;
            }
        }
    }

}