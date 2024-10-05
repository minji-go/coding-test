package 문제모음.백준.재귀;

import java.util.*;

public class _2178_미로탐색 {
    public int solution(int n, int m, int[][] maze) {
        int[][] escape = maze.clone();

        Queue<Visit> queue = new LinkedList<>();
        queue.offer(new Visit(0, 0));
        escape[0][0] = 0;
        int level = 0;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Visit visit = queue.poll();
                int tmpN = visit.getN();
                int tmpM = visit.getM();
                if (tmpN == n-1 && tmpM == m-1) return level;

                if (tmpN + 1 < n && escape[tmpN + 1][tmpM] == 1) {
                    queue.offer(new Visit(tmpN+1, tmpM));
                    escape[tmpN + 1][tmpM] = 0;
                }
                if(tmpN > 0 && escape[tmpN - 1][tmpM] == 1) {
                    queue.offer(new Visit(tmpN - 1, tmpM));
                    escape[tmpN - 1][tmpM] = 0;
                }
                if (tmpM + 1 < m && escape[tmpN][tmpM + 1] == 1) {
                    queue.offer(new Visit(tmpN, tmpM+1));
                    escape[tmpN][tmpM + 1] = 0;
                }
                if (tmpM > 0 && escape[tmpN][tmpM - 1] == 1) {
                    queue.offer(new Visit(tmpN, tmpM-1));
                    escape[tmpN][tmpM-1] = 0;
                }

            }
        }

        return 0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maze = new int[n][m];
        for(int i=0; i<n; i++){
            String nm = sc.next();
            for(int j=0; j<m; j++){
                maze[i][j] = Integer.parseInt(nm.substring(j, j+1));
            }
        }

        _2178_미로탐색 T = new _2178_미로탐색();
        System.out.println(T.solution(n, m, maze));
    }

    public class Visit {
        private int n;
        private int m;

        public Visit(int n, int m) {
            this.n=n;
            this.m=m;
        }

        public int getN(){
            return n;
        }

        public int getM(){
            return m;
        }
    }

}