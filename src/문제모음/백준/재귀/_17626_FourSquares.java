package 문제모음.백준.재귀;

import java.util.*;

public class _17626_FourSquares {
    static int n, logN;
    static int min;
    static int[] square;
    public void dfs(int cnt, int sum){
        if(sum>n || cnt>4) return;
        if(sum==n) min=Math.min(cnt,min);

        for(int i=223; i>=0; i--){
            dfs(cnt+1, sum+square[i]);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        min = 4;
        square = new int[224];
        for(int i=1; i<224; i++){
            square[i]=i*i;
        }

        _17626_FourSquares T = new _17626_FourSquares();
        T.dfs(0, 0);
        System.out.println(min);
    }
}