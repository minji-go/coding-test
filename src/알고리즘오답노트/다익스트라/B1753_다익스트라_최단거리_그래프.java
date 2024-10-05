package 알고리즘오답노트.다익스트라;

// 문제 링크 : https://www.acmicpc.net/problem/1753
// 문제 설명 : 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 문제 (방향과 가중치)
// 핵심 개념 : 그래프, 다익스트라, 최단경로
// 오답 원인: 1. 정점이 2만개, 간선이 30만개인데 2만*30만 배열에 정보를 저장해서 메모리 초과
//          2. 우선순위 큐로 정렬하여 연산횟수를 줄이지 않아서 시간초과

import java.util.*;
import java.io.*;

public class B1753_다익스트라_최단거리_그래프 {
    static List[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException{
        //1. 입력 처리하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());       //정점 개수
        int E = Integer.parseInt(st.nextToken());       //간선 개수
        int K = Integer.parseInt(br.readLine()) - 1;    //시작 정점 번호. list의 시작 인덱스가 0이므로, 시작 정점에 -1을 함

        list = new ArrayList[V];    //정점 및 간선 정보 리스트
        dist = new int[V];          //정점i 까지의 최단 거리

        for(int i = 0; i<V; i++) {
            list[i] = new ArrayList<Node>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));    //u에서 v로 가는 가중치 w인 간선 추가
        }

        //2. 다익스트라로 최단 경로 구하기
        dijkstra(K);

        //3. 결과 출력하기
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<V; i++){
            if(dist[i] == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(dist[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            int len = list[now.v].size();
            for(int i = 0; i<len; i++){
                Node next = (Node) list[now.v].get(i);

                if(dist[next.v]>now.w + next.w){
                    dist[next.v] = now.w + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
    static class Node implements Comparable<Node>{
        int v, w;

        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node n){
            return this.w - n.w;
        }
    }

}
