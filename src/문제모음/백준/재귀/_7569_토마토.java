package 문제모음.백준.재귀;

import java.util.*;

public class _7569_토마토 {
    static int n, m, h;
    static int[][][] tomatoes;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(tomatoes[i][j][k]==1) queue.offer(new int[]{i, j, k});
                }
            }
        }

        int days = -1;
        while(!queue.isEmpty()){
            days++;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] tomato = queue.poll();
                int curH = tomato[0];
                int curX = tomato[1];
                int curY = tomato[2];

                for (int j = 0; j < 6; j++) {
                    int nextH = curH + dh[j];
                    int nextX = curX + dx[j];
                    int nextY = curY + dy[j];

                    if (nextH <0 || nextH > h-1
                        || nextX < 0 || nextX > n-1
                        || nextY < 0 || nextY > m-1) continue;
                    if (tomatoes[nextH][nextX][nextY] != 0) continue;

                    queue.offer(new int[]{nextH, nextX, nextY});
                    tomatoes[nextH][nextX][nextY] = 1;
                }
            }
        }
        return days;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        tomatoes = new int[h][n][m];

        boolean ripe = true;
        for(int i=0; i<h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int tomato = sc.nextInt();
                    tomatoes[i][j][k] = tomato;
                    if (ripe && tomato == 0) ripe = false;
                }
            }
        }
        if(ripe) {
            System.out.println(0);
            return;
        }

        _7569_토마토 T = new _7569_토마토();
        int days = T.bfs();
        for(int i=0; i<h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(tomatoes[i][j][k]==0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(days);
    }
}