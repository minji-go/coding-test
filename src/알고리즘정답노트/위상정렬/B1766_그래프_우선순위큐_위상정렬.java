package 알고리즘정답노트.위상정렬;
//문제: https://www.acmicpc.net/problem/1766
//설명: 먼저 푸는 것이 좋은 문제가 있는 문제는 먼저 풀고, 가능하면 가장 쉬운 문제부터 풀 때 N개의 문제를 푸는 순서를 구하는 문제
//개념: 그래프, 우선순위 큐, 위상 정렬, 방향 비순환 그래프

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1766_그래프_우선순위큐_위상정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] indegree = new int[n+1];
        List<List<Integer>> edges = new ArrayList<>();
        for(int i=0; i<=n; i++){
            edges.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            indegree[b]++;
            edges.get(a).add(b);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(); //가능한 쉬운 문제부터 풀도록 정렬
        for(int i=1; i<=n; i++){
            if(indegree[i]==0) queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            Integer cur = queue.poll();
            sb.append(cur).append(" ");
            for (Integer next : edges.get(cur)) {
                if (--indegree[next] == 0) queue.add(next);
            }
        }

        System.out.println(sb);
    }
}
