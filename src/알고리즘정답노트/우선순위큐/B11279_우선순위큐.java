package 알고리즘정답노트.우선순위큐;
//https://www.acmicpc.net/problem/11279

import java.util.*;
import java.io.*;

public class B11279_우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>((o1, o2) -> -Long.compare(o1, o2));
        for(int i=0; i<n; i++){
            long x = Long.parseLong(br.readLine());
            if(x==0 && pq.isEmpty()) bw.write(0+"\n");
            else if(x==0) bw.write(pq.poll()+"\n");
            else pq.offer(x);
        }

        bw.flush();
        bw.close();
    }
}