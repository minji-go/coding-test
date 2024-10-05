package 알고리즘오답노트.BFS;

//문제: https://www.acmicpc.net/problem/14226
//설명: 복사, 붙여넣기, 삭제연산으로 이모티콘 S개를 화면에 만드는데 걸리는 최소 시간을 구하는 문제
//개념: 그래프, BFS, 다이나믹 프로그래밍
//오답: 메모리 초과

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class B14226_그래프_BFS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0, 0}); //화면, 클립보드, 시간

        boolean[][] visited = new boolean[2000][2000];  //같은걸 반복해서 돌지 않도록 해야함!
        visited[1][0] = true;

        int answer = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0]+cur[1] == s || cur[0]-1 == s) {
                answer = cur[2]+1;
                break;
            }

            //1.복사
            if (!visited[cur[0]][cur[0]]) {
                queue.add(new int[]{cur[0], cur[0], cur[2]+1});
                visited[cur[0]][cur[0]] = true;
            }
            //2.붙여넣기
            if (cur[0]+cur[1]<2000 && !visited[cur[0]+cur[1]][cur[1]]) {
                queue.add(new int[]{cur[0] + cur[1], cur[1], cur[2] + 1});
                visited[cur[0] + cur[1]][cur[1]] = true;
            }
            //3.삭제
            if (cur[0]>0 && !visited[cur[0] - 1][cur[1]]) {
                queue.add(new int[]{cur[0] - 1, cur[1], cur[2] + 1});
                visited[cur[0] - 1][cur[1]] = true;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.close();
    }

    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());

        int[] dp = new int[2000];
        
        for(int i=2;i<=1000;i++){
            dp[i]=i;
        }
        for(int i=2;i<=1000;i++){       //클립보드
            for(int j=2;i*j<=1000;j++){ 
                dp[i*j]=Math.min(dp[i*j],dp[i]+j);
            }
            for(int j=1000;j>=2;j--){
                dp[j]=Math.min(dp[j],dp[j+1]+1);
            }
        }

        System.out.println(dp[s]);
    }
}
