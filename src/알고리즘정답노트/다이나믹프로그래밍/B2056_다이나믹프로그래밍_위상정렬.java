package 알고리즘정답노트.다이나믹프로그래밍;

//문제: https://www.acmicpc.net/problem/2056
//설명: 선행 관계가 있는 N개의 작업을 완료하기 위해 필요한 최소 시간을 구하는 문제
//개념: 그래프, 다이나믹 프로그래밍, 위상 정렬, 방향 비순환 그래프

import java.io.*;
import java.util.*;

public class B2056_다이나믹프로그래밍_위상정렬 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
//
//        int N = Integer.parseInt(br.readLine());
//        int[] dp = new int[N + 1]; // 각각의 작업을 수행하는 데 걸리는 시간
//
//        int ans = 0;
//        for (int i = 1; i <= N; i++) {
//            st = new StringTokenizer(br.readLine());
//            int time = Integer.parseInt(st.nextToken());
//            int num = Integer.parseInt(st.nextToken());
//
//            dp[i] = time;
//            for (int j = 0; j < num; j++) {
//                int temp = Integer.parseInt(st.nextToken());
//
//                dp[i] = Math.max(dp[i], dp[temp] + time);
//            }
//
//            ans = Math.max(ans, dp[i]);
//        }
//
//        bw.write(ans + "\n");
//        bw.flush();
//        bw.close();
//        br.close();
//    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> a = new ArrayList<>();

        for(int i=0; i<=N; i++){
            a.add(new ArrayList<>());
        }

        int[] indegree = new int[N+1]; //선행해야할 업무 개수
        int[] time = new int[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            int num = Integer.parseInt(st.nextToken());
            for(int j=0; j<num; j++){
                int tmp = Integer.parseInt(st.nextToken());
                a.get(tmp).add(i);
                indegree[i]++;
            }
        }

        bw.write(topologicalSort(N, a, indegree, time) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int topologicalSort(int N, List<List<Integer>> a, int[] indegree, int[] time) {
        Queue<Integer> q = new LinkedList<>();

        int[] result = new int[N+1];
        for(int i=1; i<=N; i++){
            result[i] = time[i];

            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();

            for (int next : a.get(now)) {
                indegree[next]--;

                result[next] = Math.max(result[next], result[next] + time[next]);

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }

        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, result[i]);
        }
        return ans;
    }

}
