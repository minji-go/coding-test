package 알고리즘정답노트.위상정렬;

//문제: https://www.acmicpc.net/problem/2252
//설명: 일부 학생들의 키를 비교한 결과가 주어졌을 때, 줄을 세우는 문제
//개념: 그래프, 위상 정렬, 방향 비순환 그래프

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B2252_그래프_위상정렬 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> students = new ArrayList<>();
        students.add(new ArrayList<>());
        for(int i=1; i<=n; i++){
            students.add(new ArrayList<>());
            students.get(i).add(i);
        }

        int[] indegree = new int[n+1]; //앞선사람명수
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            students.get(a).add(b);
            indegree[b]++;
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(indegree[i]==0) queue.add(students.get(i));
        }
        while(!queue.isEmpty()){
            List<Integer> cur = queue.poll();
            System.out.print(cur.get(0)+" ");
            for(int i=1; i<cur.size(); i++){
                indegree[cur.get(i)]--;
                if(indegree[cur.get(i)]==0) {
                    queue.add(students.get(cur.get(i)));
                }
            }
        }
    }
}
