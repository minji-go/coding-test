package 알고리즘정답노트.백트래킹;

//https://www.acmicpc.net/problem/16987

import java.util.*;
import java.io.*;

public class B16987_백트래킹_브루트포싱 {
    static int n;
    static int[][] egg;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        egg = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            egg[i]=new int[]{s,w};
        }

        int lt=0;
        int rt=n;
        int answer=0;
        while(lt<=rt){
            sum = 0;
            mid = (lt+rt)/2;
            if(dfs(0)) {
                answer=mid;
                lt=mid+1;
            } else rt=mid-1;
        }

        System.out.print(answer);
    }

    static int mid, sum;
    public static boolean dfs(int i){
        if(sum>=mid) return true;
        if(i==n) return false;
        if(egg[i][0]<=0) return dfs(i+1);

        for(int j=0; j<n; j++){
            if(egg[j][0]<=0 || j==i) continue;
            egg[i][0]-=egg[j][1];
            egg[j][0]-=egg[i][1];
            if(egg[i][0]<=0) sum++;
            if(egg[j][0]<=0) sum++;

            if(dfs(i+1)) {
                egg[i][0]+=egg[j][1];
                egg[j][0]+=egg[i][1];
                return true;
            }

            if(egg[i][0]<=0) sum--;
            if(egg[j][0]<=0) sum--;
            egg[i][0]+=egg[j][1];
            egg[j][0]+=egg[i][1];
        }
        return false;
    }
}