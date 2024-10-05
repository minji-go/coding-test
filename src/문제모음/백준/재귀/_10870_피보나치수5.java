package 문제모음.백준.재귀;

import java.util.*;

public class _10870_피보나치수5 {
    static Integer[] fn;

    public int dfs(int n){
        if(fn[n]!=null) return fn[n];
        else return fn[n]=dfs(n-1)+dfs(n-2);
    }

    public static void main(String[] args){
        _10870_피보나치수5 T = new _10870_피보나치수5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fn = new Integer[n+2];
        fn[0]=0;
        fn[1]=1;
        System.out.println(T.dfs(n));
    }
}