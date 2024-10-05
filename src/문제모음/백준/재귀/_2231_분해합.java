package 문제모음.백준.재귀;

import java.util.*;

public class _2231_분해합 {
    public int solution(int n){

        for(int i=Math.min(54, n); i>0; i--){
            int target = n-i;
            int sum = target;
            while(target!=0){
                sum+=target%10;
                target/=10;
            }
            if(sum==n) return n-i;
        }
        return 0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        _2231_분해합 T = new _2231_분해합();
        System.out.println(T.solution(n));
    }
}