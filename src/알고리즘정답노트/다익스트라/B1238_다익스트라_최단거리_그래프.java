package 알고리즘정답노트.다익스트라;

// 문제 링크 : https://www.acmicpc.net/problem/1238
// 문제 설명 : N개 마을의 각 학생이 최소 소요시간으로 X번 마을에 방문했다가 돌아올 때, 소요시간이 가장 큰 학생을 구하는 문제
// 핵심 개념 : 다익스트라, 최단 경로, 그래프 이론

import java.util.*;

public class B1238_다익스트라_최단거리_그래프 {
    static int N, M, X;
    static List<Node>[] link;
    static int[] time;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt();

        time = new int[N+1];
        link = new List[N+1];
        for(int i=1; i<=N; i++){
            link[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            int t = sc.nextInt();
            link[s].add(new Node(e, t));
        }

        B1238_다익스트라_최단거리_그래프 T = new B1238_다익스트라_최단거리_그래프();
        for(int i=1; i<=N; i++){
            time[i] = T.go(i, X);
        }

        int[] goBackTime = T.goBack();
        int maxTime = 0;
        for(int i=1; i<=N; i++){
            maxTime = Math.max(maxTime, time[i]+goBackTime[i]);
        }
        System.out.print(maxTime);
    }

    public int go(int s, int e){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(s);

        int[] answer = new int[N+1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[s]=0;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(Node next: link[now]){
                if(answer[next.v]>answer[now]+next.t){
                    answer[next.v]=answer[now]+next.t;
                    queue.offer(next.v);
                }
            }
        }
        return answer[e];
    }

    public int[] goBack(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(X);

        int[] answer = new int[N+1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[X]=0;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(Node next: link[now]){
                if(answer[next.v]>answer[now]+next.t){
                    answer[next.v]=answer[now]+next.t;
                    queue.offer(next.v);
                }
            }
        }
        return answer;
    }

    static class Node {
        int v;
        int t;
        Node(int v, int t){
            this.v=v;
            this.t=t;
        }
    }

}
