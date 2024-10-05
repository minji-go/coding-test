package 문제모음.백준.재귀;

import java.util.*;

public class _2667_단지번호붙이기 {
    public class House{
        private int row;
        private int col;
        public House(int row, int col){
            this.row=row;
            this.col=col;
        }
        public int getRow(){
            return row;
        }
        public int getCol(){
            return col;
        }
    }

    public static int n;
    public static int[][] houses;

    public void complex(House house, int num){
        Queue<House> queue = new LinkedList<>();
        queue.offer(house);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                House cur = queue.poll();
                int curRow = cur.getRow();
                int curCol = cur.getCol();
                houses[curRow][curCol] = num;
                if(curRow+1<n && houses[curRow+1][curCol]==1){
                    queue.offer(new House(curRow+1, curCol));
                }
                if(curRow>0 && houses[curRow-1][curCol]==1){
                    queue.offer(new House(curRow-1, curCol));
                }
                if(curCol+1<n && houses[curRow][curCol+1]==1){
                    queue.offer(new House(curRow, curCol+1));
                }
                if(curCol>0 && houses[curRow][curCol-1]==1){
                    queue.offer(new House(curRow, curCol-1));
                }
            }
        }
    }

    public int solution(int n){
        int num=2;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(houses[i][j]==1) {
                    complex(new House(i,j), num);
                    num++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        houses = new int[n][n];
        for(int i=0; i<n; i++){
            String nLine = sc.next();
            for(int j=0; j<n; j++){
                houses[i][j]=Integer.parseInt(nLine.substring(j, j+1));
            }
        }

        _2667_단지번호붙이기 T = new _2667_단지번호붙이기();
        int complexCount = T.solution(n);
        int[] answer = new int[complexCount];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                answer[houses[i][j]]++;
            }
        }
        System.out.println(answer.length-2);
        answer[0]=0;
        Arrays.sort(answer);
        for(int i=2; i<answer.length; i++){
            System.out.println(answer[i]);
        }
    }
}