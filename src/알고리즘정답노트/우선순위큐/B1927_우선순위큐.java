package 알고리즘정답노트.우선순위큐;

//https://www.acmicpc.net/problem/1927

import java.io.*;
import java.util.*;

public class B1927_우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            long x = Long.parseLong(br.readLine());
            if(x==0 && pq.isEmpty()) bw.write(0+"\n");
            else if(x==0) bw.write(pq.poll()+"\n");
            else pq.offer(x);
        }

        bw.flush();
        bw.close();
    }
}