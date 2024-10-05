package 문제모음.프로그래머스;

import java.util.*;

public class 합승택시요금 {

    private static ArrayList<ArrayList<Node>> graph;

    static class Node {
        int index, cost;

        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    public static int solution(int n, int s, int a, int b, int[][] fares){

        graph = new ArrayList<ArrayList<Node>>();

        //1. graph 만들기
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        //2. graph 채우기
        for (int[] fare : fares) {
            graph.get(fare[0]).add(new Node(fare[1], fare[2]));
            graph.get(fare[1]).add(new Node(fare[0], fare[2]));
        }

        //3. 각 지점에서 다른 지점까지 최소 금액 경로 구하기
        int[] costA = new int[n + 1];
        int[] costB = new int[n + 1];
        int[] costS = new int[n + 1];

        Arrays.fill(costA, Integer.MAX_VALUE);
        Arrays.fill(costB, Integer.MAX_VALUE);
        Arrays.fill(costS, Integer.MAX_VALUE);

        costA = dijkstra(a, costA);
        costB = dijkstra(b, costB);
        costS = dijkstra(s, costS);

        int answer = Integer.MAX_VALUE;

        //4. 출발지점에서 도착지점까지 최소 금액 경로 구하기
        //- (s <-> x) + (x <-> a) + (x <-> b)
        for(int i = 1; i <= n ; i ++)
            answer = Math.min(answer, costA[i] + costB[i] + costS[i]);

        return answer;
    }

    static int[] dijkstra (int start, int[] costs) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));
        costs[start] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nIndex = now.index;
            int nCost = now.cost;

            if(nCost > costs[nIndex]) continue;

            ArrayList<Node> nodes = graph.get(nIndex);

            for (Node node : nodes) {
                int cost = costs[nIndex] + node.cost;

                if (cost < costs[node.index]) {
                    costs[node.index] = cost;
                    queue.offer(new Node(node.index, cost));
                }
            }
        }

        return costs;
    }


}
