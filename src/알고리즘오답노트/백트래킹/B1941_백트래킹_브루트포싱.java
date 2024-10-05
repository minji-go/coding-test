package 알고리즘오답노트.백트래킹;

//https://www.acmicpc.net/problem/1941

import java.util.*;
import java.io.*;

public class B1941_백트래킹_브루트포싱 {
    static char map[][] = new char[5][5];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0 -1, 1};
    static int[] combX = new int[25];
    static int[] combY = new int[25];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<5; i++){
            map[i] = br.readLine().toCharArray();
        }
        for(int i=0; i<25; i++){
            combX[i]=i%5;
            combY[i]=i/5;
        }
        combination(new int[7], 0, 0);
        System.out.println(ans);
    }

    public static void combination(int[] comb, int idx, int num){
        if(idx==7){
            bfs(comb);
            return;
        }
        if(num==25) return;

        comb[idx]=num;
        combination(comb, idx+1, num+1);
        combination(comb, idx, num+1);
    }

    public static void bfs(int[] comb){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[7];

        visited[0]=true;
        q.add(comb[0]);
        int cnt=1, scnt=0;

        while(!q.isEmpty()){
            int cur = q.poll();
            if(map[combY[cur]][combX[cur]] == 'S') scnt++;

            for(int i=0; i<4; i++){
                for(int next=1; next<7; next++){
                    if(!visited[next]
                            && combX[cur]+dx[i] == combX[comb[next]]
                            && combY[cur]+dy[i]==combY[comb[next]]){
                        visited[next]=true;
                        q.add(comb[next]);
                        cnt++;
                    }
                }
            }
        }
        if(cnt == 7 && scnt >= 4) ans++;
    }
}
