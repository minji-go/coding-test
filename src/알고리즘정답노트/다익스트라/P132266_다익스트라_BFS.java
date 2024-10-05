package 알고리즘정답노트.다익스트라;

// 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/132266
// 문제 설명 : 강철부대의 각 부대원이 특수 임무를 수행한 지역로 부터 특정 지역으로 복귀하는데 걸리는 최소 시간을 구하는 문제
// 핵심 개념 : 다익스트라, BFS

import java.util.*;

public class P132266_다익스트라_BFS {
    private static List<List<Integer>> graph;
    private static int[] dis;
    private static final int MAX = 1_000_000_000;

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {

        graph = new ArrayList<>(); //메모리 초과 방지를 위해 2차원 배열이 아닌 인접리스트로 처리한다.
        for(int i=0; i<n+1; i++) graph.add(new ArrayList<>());

        for (int[] road : roads) {
            int s = road[0];
            int e = road[1];

            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        dis = new int[n+1];
        Arrays.fill(dis, MAX);
        dijkstra(destination);  // 무방향 그래프이기에, 하나의 목적지에서 여러 출발지까지의 최소 시간을 구하는 것과 동일하다.

        int[] ans = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            ans[i] = (dis[sources[i]] < MAX) ? dis[sources[i]] : -1;
        }
        return ans;
    }

    private static void dijkstra(int destination) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(destination);
        dis[destination] = 0;

        while (!qu.isEmpty()){
            int cn = qu.poll();

            for(int i=0; i<graph.get(cn).size(); i++){
                int nn = graph.get(cn).get(i);
                if(dis[nn] > dis[cn]+1){ //기존에 계산한 시간보다 더 빠르게 도착할 수 있는 경우
                    dis[nn] = dis[cn]+1;
                    qu.add(nn);
                }
            }
        }
    }
}
