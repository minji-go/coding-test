package 문제모음.백준.재귀;

import java.util.*;

public class _1572_번데기 {
    public int findOrderIndex(int t, int k){
        int[] arr = {0, 1, 0, 1};
        int n=2;
        int ci=0;
        int ct=0;

        while(true){
            for(int i=0; i<4; i++){
                if(k==arr[i]) ct++;
                if(ct==t) return ci;
                ci++;
            }

            for(int i=0; i<n; i++){
                if(k==0) ct++;
                if(ct==t) return ci;
                ci++;
            }
            for(int i=0; i<n; i++){
                if(k==1) ct++;
                if(ct==t) return ci;
                ci++;
            }
            n++;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int t = sc.nextInt();
        int k = sc.nextInt();

        _1572_번데기 T = new _1572_번데기();
        System.out.println(T.findOrderIndex(t, k) % a);
    }
}