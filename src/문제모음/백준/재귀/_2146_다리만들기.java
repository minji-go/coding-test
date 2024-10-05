package 문제모음.백준.재귀;

import java.util.*;

public class _2146_다리만들기 {
    static int n;
    static int min;
    static int[][] islands, visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public void bfsIsland(int number, int[] start) {
        int[][] visited = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        int startX = start[0];
        int startY = start[1];
        visited[startX][startY] = 1;
        islands[startX][startY] = number;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int pointX = point[0];
                int pointY = point[1];

                for (int j = 0; j < 4; j++) {
                    int nextX = pointX + dx[j];
                    int nextY = pointY + dy[j];
                    if (nextX < 0 || nextX > n - 1 || nextY < 0 || nextY > n - 1 || visited[nextX][nextY] == 1)
                        continue;
                    if (islands[nextX][nextY] == 0)
                        continue;

                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = 1;
                    islands[nextX][nextY] = number;
                }
            }

        }
    }

    public void bfsBridge(int[] start){
        Queue<int[]> queue = new LinkedList<>();
        int startX = start[0];
        int startY = start[1];
        int startV = islands[startX][startY];
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY]=1;

        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int pointX = point[0];
            int pointY = point[1];
            int pointN = point[2];

            for(int j=0; j<4; j++){
                int nextX = pointX+dx[j];
                int nextY = pointY+dy[j];
                if(nextX<0 || nextX>n-1 || nextY<0 || nextY>n-1) continue;
                if(islands[nextX][nextY] == startV) continue;
                if(visited[nextX][nextY]==1) continue;
                if(islands[nextX][nextY]==0) {
                    queue.offer(new int[]{nextX, nextY, pointN + 1});
                    visited[nextX][nextY] = 1;
                } else {
                    min = Math.min(min, pointN);
                    return;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        islands = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                islands[i][j] = sc.nextInt();
            }
        }

        _2146_다리만들기 T = new _2146_다리만들기();
        int number = 2;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(islands[i][j] == 1){
                    T.bfsIsland(number, new int[]{i, j});
                    number++;
                }
            }
        }
        min = Integer.MAX_VALUE;
        visited = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(islands[i][j]==0) continue;
                if(visited[i][j]==1) continue;
                T.bfsBridge(new int[]{i, j});
                visited = new int[n][n];
            }
        }
        System.out.println(min);
    }
}