package 알고리즘오답노트.BFS;

//문제: https://www.acmicpc.net/problem/13549
//설명: X+1, X-1, X*2 연산으로 N에서 k로 가는 최소 시간을 구하는 문제
//개념: 그래프, 0-1BFS, 다익스트라
//오답: 우선순위 큐, 덱 등을 이용해 최소 시간을 구하는 알고리즘을 잘못 작성함 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class B13549_그래프_BFS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> visit = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});
        visit.put(n, 0);

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0]<100_000 && visit.getOrDefault(cur[0]+1, 100_000) > cur[1]+1){
                queue.add(new int[]{cur[0]+1, cur[1]+1});
                visit.put(cur[0]+1, cur[1]+1);
            }
            if(cur[0]>0 && visit.getOrDefault(cur[0]-1, 100_000) > cur[1]+1){
                queue.add(new int[]{cur[0]-1, cur[1]+1});
                visit.put(cur[0]-1, cur[1]+1);
            }
            if(cur[0]>0 && cur[0]<100_000 && visit.getOrDefault(cur[0]*2, 100_000) > cur[1]){ //>으로 하면 틀리고, >=로 하면 맞는데 이유는 모름
                queue.add(new int[]{cur[0]*2, cur[1]});
                visit.put(cur[0]*2, cur[1]);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(visit.get(k)));
        bw.close();
    }
}
