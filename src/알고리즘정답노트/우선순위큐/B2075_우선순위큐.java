package 알고리즘정답노트.우선순위큐;

//https://www.acmicpc.net/problem/2075

import java.util.*;
import java.io.*;

public class B2075_우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                pq.offer(Long.parseLong(st.nextToken()));
            }
        }

        for(int i=1; i<n; i++) pq.poll();
        System.out.println(pq.poll());
    }
}