package 문제모음.백준.재귀;

import java.util.*;

public class _1743_음식물피하기 {
    static int n, m, k;
    static int[][] corridor;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max;

    public void bfs(int[] start, int number){
        int sum = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        corridor[start[0]][start[1]]=number;
        sum++;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] point = queue.poll();
                int pointX = point[0];
                int pointY = point[1];

                for(int j=0; j<4; j++){
                    int nextX = pointX + dx[j];
                    int nextY = pointY + dy[j];
                    if(nextX<0 || nextX>n-1) continue;
                    if(nextY<0 || nextY>m-1) continue;
                    if(corridor[nextX][nextY] != 1) continue;

                    queue.offer(new int[]{nextX, nextY});
                    corridor[nextX][nextY]=number;
                    sum++;
                }
            }
        }

        max = Math.max(sum, max);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        corridor = new int[n][m];
        for(int i=0; i<k; i++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            corridor[r-1][c-1]=1;
        }

        _1743_음식물피하기 T = new _1743_음식물피하기();
        int number = 2;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(corridor[i][j]!=1) continue;
                T.bfs(new int[]{i, j}, number);
                number++;
            }
        }

        System.out.println(max);
    }
}