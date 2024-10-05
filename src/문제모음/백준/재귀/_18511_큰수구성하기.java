package 문제모음.백준.재귀;

import java.util.*;

public class _18511_큰수구성하기 {
    static int n, k;
    static int[] elements;
    static int max;

    public void dfs(int x){
        if(x>n) return;
        max=Math.max(x,max);
        for(int i=0; i<elements.length; i++){
            dfs(10*x+elements[i]);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        elements = new int[k];
        for(int i=0; i<k; i++){
            elements[i] = sc.nextInt();
        }
        Arrays.sort(elements);

        _18511_큰수구성하기 T = new _18511_큰수구성하기();
        T.dfs(0);
        System.out.println(max);
    }
}