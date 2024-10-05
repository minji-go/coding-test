package 알고리즘오답노트.백트래킹;

//https://www.acmicpc.net/problem/15649

import java.util.*;
import java.io.*;

public class B15649_백트래킹 {
  static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        B15649_백트래킹 T = new B15649_백트래킹();
        visited = new boolean[n];
        arr = new int[m];
        T.dfs(0);
        System.out.println(sb);
    }

    public void dfs(int depth){
        if(depth==m){
            for(int a : arr) sb.append(a).append(" ");
            sb.append("\n");
            return;
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth]=i+1;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}