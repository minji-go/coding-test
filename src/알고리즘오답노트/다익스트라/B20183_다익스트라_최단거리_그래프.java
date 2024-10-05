package 알고리즘오답노트.다익스트라;

//https://www.acmicpc.net/problem/20183
import java.util.*;


public class B20183_다익스트라_최단거리_그래프 {
    static class Point implements Comparable<Point>{
        long cost;
        int point;

        public Point(long cost, int point) {
            this.cost = cost;
            this.point = point;
        }

        @Override
        public int compareTo(Point p) {
            return Long.compare(this.cost, p.cost);
        }
    }
    static StringBuilder sb = new StringBuilder();

    static int N, M, A, B;
    static long C;
    static ArrayList<Point>[] lists;

    static long[] Dijkstra(long max_cost) {
        long[] arr = new long[N+1];
        boolean[] visit = new boolean[N+1];
        for(int i = 1;i<N+1;i++) arr[i] = Long.MIN_VALUE;

        arr[A] = 0;
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(0, A));

        while(!queue.isEmpty()) {
            Point point = queue.poll();

            if(visit[point.point]) continue;
            // 이미 방문하여 cost를 update한 지점. 갱신 과정 불필요

            visit[point.point] = true;
            // 이번 while문 실행 때 cost를 갱신할 것이므로 방문 여부 체크

            for(Point tmp:lists[point.point]) {
                if(tmp.cost>max_cost) {
                // 우리는 max_cost보다 큰 통행료를 내는 길은 갈 수 없다
                // 따라서 이 경우는 무시해준다
                    continue;
                }

                long sum =  arr[point.point]+tmp.cost;
                // A -> point.point -> tmp.point로 이동하는 cost
              // (arr[point.point]) (tmp.cost)
                if(!visit[tmp.point]
                            && sum <= C && arr[tmp.point] < sum) {
                // tmp.point를 방문하지 않았으며, 전체 cost가 보유 자금인
                // C 이하이며 A -> tmp.point cost로 저장되어 있는 값보다
                // sum이 작을 경우에 우선순위 큐에 넣어줌
                    arr[tmp.point] = sum;
                    queue.add(new Point(tmp.cost, tmp.point));
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextLong();

        lists = new ArrayList[N+1];

        for(int i =1;i<N+1;i++) {
            lists[i] = new ArrayList<>();
        }

        long max = Long.MIN_VALUE;

        for(int i =0;i<M;i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            long c = sc.nextLong();

            max = Math.max(max, c);

            lists[s].add(new Point(c, e));
            lists[e].add(new Point(c, s));
        }

        long left = 0;
        long right = max; // 골목 통행료 중 최댓값
        long ans = -1;

        while(left <= right) {
            long max_cost = (left+right)/2;
            // 내가 설정할 낼 수 있는 골목 통행료 중 최댓값

            long[] arr = Dijkstra(max_cost);

            if(arr[B]==Long.MIN_VALUE) {
            // A -> B로 가는 경로가 존재하지 않는 경우
            // max_cost를 증가시켜야 하므로 left = max_cost + 1 시킴
                left = max_cost + 1;
            } else {
            // A -> B로 가는 경로가 존재하는 경우
            // 답의 후보가 될 수 있으므로 ans에 max_cost를 저장한다.
            // 또한, 이보다 더 작은 max_cost가 존재할 수도 있으므로
            // right = max_cost - 1으로 다시 이분 탐색을 실시한다.
                right = max_cost - 1;
                ans = max_cost;
            }
        }

        System.out.println(ans);
    }
}